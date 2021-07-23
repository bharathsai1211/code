package com.example.awsassignment;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.event.S3EventNotification;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import software.amazon.awssdk.utils.StringUtils;
import sun.nio.cs.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.util.regex.*;

import java.util.List;
import java.util.stream.Collectors;

public class Assignment implements RequestHandler<S3Event, String> {
    @Override
    public String handleRequest(S3Event s3event, Context context) {
        S3EventNotification.S3EventNotificationRecord record = s3event.getRecords().get(0);
        String srcBucket = record.getS3().getBucket().getName();
        String srcKey = record.getS3().getObject().getUrlDecodedKey();
        System.out.println("srcKey:" + srcKey);
        List<String> dataLines = null;
        try {
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard().build();
            S3Object s3Object = s3Client.getObject(new GetObjectRequest(srcBucket, srcKey));
            try (InputStream objectData = s3Object.getObjectContent();) {
                dataLines = new BufferedReader(new InputStreamReader(objectData, StandardCharsets.UTF_8)).lines()
                        .collect(Collectors.toList());
            }

            if (dataLines != null) {
                Integer totalLines = dataLines.size();
                if (totalLines > 2) {
                    String trailerLine = dataLines.get(totalLines - 1);
                    System.out.println("Total Number of Lines - " + totalLines);
                    Integer trailerCount = getTrailerRecordCount(trailerLine);
                    System.out.println("Trailer Record Count - " + trailerCount);
                    if (trailerCount == (totalLines - 2)) {
                        for (int i = 1; i < totalLines - 1; i++) {
                            validateDetailLine(dataLines.get(i), (i + 1));
                        }
                    } else {
                        System.out.println("Mismatch: The file contains " + (totalLines - 2)
                                + "lines but trailer specifies it as " + trailerCount + " lines");
                    }
                }
            }
            return "Sucess";
        } catch (AmazonServiceException e) {
            return "error";
        } catch (SdkClientException e) {
            return "error";
        } catch (IOException e) {
            return "error";
        }
    }

    private Integer getTrailerRecordCount(String trailerLine) {
        if (trailerLine.length() >= 5) {
            String count = trailerLine.substring(0, 5);
            if (count.matches("[0-9]{5}")) {
                return Integer.parseInt(count);
            } else {
                System.out.println("Trailer Record Count : " + count + " is incorrect");
            }
        } else {
            System.out.println("Trailer Record Count Is Missing");
        }
        return null;
    }

    private void validateDetailLine(String detailLine, Integer lineNumber) {
        System.out.println("Processing Line:" + lineNumber);
        boolean isGreaterThan200 = false;
        if (StringUtils.isBlank(detailLine)) {
            isGreaterThan200 = true;
        }
        String dateValue = null;
        if (detailLine.length() >= 8) {
            dateValue = detailLine.substring(detailLine.length()8, detailLine.length() - 1);
        }
        if (dateValue != null && !validateDetailLine(dateValue,"mmddyyyy")) {
            if (isGreaterThan200) {
                System.out.println("Line Number : " + lineNumber
                        + " is greater than 200 and does not follow the required date format");
            } else {
                System.out.println("Line Number : " + lineNumber + " does not follow the required date format");
            }
        } else {
            if (isGreaterThan200) {
                System.out.println("Line Number : " + lineNumber +" is greater than 200");
            }
        }
    }

public boolean validateDateFormat(String date, String dateFormat) {
    SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormat);
    dateFormat.setLenient(false);
    try {
        dateFormat.parse(date);
        return true;
    } catch (ParseException e) {
        return false;
    }
  }
}

