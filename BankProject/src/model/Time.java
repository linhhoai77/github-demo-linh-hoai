package model;

public class Time {
	private int phut, gio, ngay, thang, nam;
	// date constructor
	public Time(int ngay, int thang, int nam) {
		this.ngay = ngay;
		this.thang = thang;
		this.nam = nam;
	}
	// display date of time
	public String xemNgay() {
        return ngay + "/" + thang + "/" + nam;
    }
	// time constructor
	public Time(int phut, int gio, int ngay, int thang, int nam) {
		this.phut = phut;
		this.gio = gio;
		this.ngay = ngay;
		this.thang = thang;
		this.nam = nam;
	}
	// display time 
	 public String xemThoiGian() {
	        return gio + ":" + phut + ", " + ngay + "/" + thang + "/" + nam;
	    }
	 // all getter and setter method
	public int getPhut() {
		return phut;
	}
	public void setPhut(int phut) {
		this.phut = phut;
	}
	public int getGio() {
		return gio;
	}
	public void setGio(int gio) {
		this.gio = gio;
	}
	public int getNgay() {
		return ngay;
	}
	public void setNgay(int ngay) {
		this.ngay = ngay;
	}
	public int getThang() {
		return thang;
	}
	public void setThang(int thang) {
		this.thang = thang;
	}
	public int getNam() {
		return nam;
	}
	public void setNam(int nam) {
		this.nam = nam;
	}
	 
}
