package com.mw.vo;

public class Lnglat {

	private double startlng;
	private double startlat;
	private double endlng;
	private double endlat;
	public Lnglat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Lnglat(double startLng, double startLat, double endLng, double endLat) {
		super();
		this.startlng = startLng;
		this.startlat = startLat;
		this.endlat = endLat;
		this.endlng = endLng;
	}
	
	
	
	public double getStartlng() {
		return startlng;
	}
	public void setStartlng(double startLng) {
		this.startlng = startLng;
	}
	public double getStartlat() {
		return startlat;
	}
	public void setStartlat(double startLat) {
		this.startlat = startLat;
	}
	public double getEndlat() {
		return endlat;
	}
	public void setEndlat(double endLat) {
		this.endlat = endLat;
	}
	public double getEndlng() {
		return endlng;
	}
	public void setEndlng(double endLng) {
		this.endlng = endLng;
	}
	
	
	
	
}
