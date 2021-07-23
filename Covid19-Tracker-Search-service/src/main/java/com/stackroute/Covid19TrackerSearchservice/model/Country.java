package com.stackroute.Covid19TrackerSearchservice.model;

public class Country {
//	"ID": "0f597a20-2525-494b-88a0-cca77c9acd36",
//    "Country": "India",
//    "CountryCode": "IN",
//    "Province": "Kerala",
//    "City": "",
//    "CityCode": "",
//    "Lat": "10.45",
//    "Lon": "76.41",
//    "Confirmed": 825769,
//    "Deaths": 3373,
//    "Recovered": 756817,
//    "Active": 65579,
//    "Date": "2021-01-14T00:00:00Z"
    	private String country;
    	private String province;
    	private String confirmed;
    	private int deaths;
    	private int recovered;
    	private int active;
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getProvince() {
			return province;
		}
		public void setProvince(String province) {
			this.province = province;
		}
		public String getConfirmed() {
			return confirmed;
		}
		public void setConfirmed(String confirmed) {
			this.confirmed = confirmed;
		}
		public int getDeaths() {
			return deaths;
		}
		public void setDeaths(int deaths) {
			this.deaths = deaths;
		}
		public int getRecovered() {
			return recovered;
		}
		public void setRecovered(int recovered) {
			this.recovered = recovered;
		}
		public int getActive() {
			return active;
		}
		public void setActive(int active) {
			this.active = active;
		}

}
