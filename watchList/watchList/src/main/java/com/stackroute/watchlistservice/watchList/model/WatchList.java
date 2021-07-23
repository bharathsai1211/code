package com.stackroute.watchlistservice.watchList.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Document(collection="watchlist")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WatchList {

    private String userName;
    private List<Map> watchListArray = new ArrayList<Map>();
    private LocalDateTime createdAt;


}
