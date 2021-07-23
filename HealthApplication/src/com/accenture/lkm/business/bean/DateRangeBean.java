package com.accenture.lkm.business.bean;

import java.util.Date;

public class DateRangeBean {
	private Date fromDate;
	private Date toDate;
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	@Override
	public String toString() {
		return "DateRangeBean [fromDate=" + fromDate + ", toDate=" + toDate + "]";
	}
	
	

}
