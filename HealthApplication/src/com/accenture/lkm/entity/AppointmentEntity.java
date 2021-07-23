package com.accenture.lkm.entity;

import java.util.Date;

public class AppointmentEntity {
private  int appointmentId;
private String patientName;
private Date visitDate;
private int doctorId;
public int getAppointmentId() {
	return appointmentId;
}
public void setAppointmentId(int appointmentId) {
	this.appointmentId = appointmentId;
}
public String getPatientName() {
	return patientName;
}
public void setPatientName(String patientName) {
	this.patientName = patientName;
}
public Date getVisitDate() {
	return visitDate;
}
public void setVisitDate(Date visitDate) {
	this.visitDate = visitDate;
}
public int getDoctorId() {
	return doctorId;
}
public void setDoctorId(int doctorId) {
	this.doctorId = doctorId;
}
@Override
public String toString() {
	return "AppointmentEntity [appointmentId=" + appointmentId + ", patientName=" + patientName + ", visitDate="
			+ visitDate + ", doctorId=" + doctorId + "]";
}


}
