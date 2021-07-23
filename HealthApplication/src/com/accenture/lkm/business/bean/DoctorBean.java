package com.accenture.lkm.business.bean;

import javax.validation.constraints.NotNull;

public class DoctorBean {
	private int doctorId;
	@NotNull(message="select doctor name")
	private String doctorName;
	private String speciality;
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	@Override
	public String toString() {
		return "DoctorBean [doctorId=" + doctorId + ", doctorName=" + doctorName + ", speciality=" + speciality + "]";
	}
	
	

}
