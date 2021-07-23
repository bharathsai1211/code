package com.accenture.lkm.business.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class AppointmentBean {
	
	private  int appointmentId;
	@NotNull(message="patient name is required")
	private String patientName;
	@NotNull(message="Visit Date Must be future")
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
		return "AppointmentBean [appointmentId=" + appointmentId + ", patientName=" + patientName + ", visitDate="
				+ visitDate + ", doctorId=" + doctorId + "]";
	}
	
	
}
