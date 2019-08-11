package com.spark;

public class HivePracticeData {
	private String stationId = null;
	private String name = null;
	private double lat = 0;
	private double lng = 0;
	private int dockCount = 0;
	private String landmark = null;
	private String installation = null;
	
	public HivePracticeData() {
		super();
	}
	
	public HivePracticeData(String stationId, String name, double lat, double lng, int dockCount, String landmark,
			String installation) {
		super();
		this.stationId = stationId;
		this.name = name;
		this.lat = lat;
		this.lng = lng;
		this.dockCount = dockCount;
		this.landmark = landmark;
		this.installation = installation;
	}

	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	
	public int getDockCount() {
		return dockCount;
	}

	public void setDockCount(int dockCount) {
		this.dockCount = dockCount;
	}

	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getInstallation() {
		return installation;
	}
	public void setInstallation(String installation) {
		this.installation = installation;
	}
	
	
}
