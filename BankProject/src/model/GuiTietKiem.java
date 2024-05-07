package model;

import java.time.LocalDate;
import java.time.Period;

public class GuiTietKiem {
	private int soTienGui;
	private int soThangGui;
	private Time ngayGui;
	private String noiDungGui;
	private boolean coKyHan;
	private double laiSuat;
	private LocalDate now = LocalDate.now();

	// constructor method
	public GuiTietKiem(int soTienGui, int soThangGui, Time ngayGui, String noiDungGui, boolean coKyHan) {
		this.soTienGui = soTienGui;
		this.soThangGui = soThangGui;
		this.ngayGui = new Time(now.getDayOfMonth(), now.getMonthValue(), now.getYear());
		this.noiDungGui = noiDungGui;
		this.coKyHan = coKyHan;
	}
	// xác đinh lãi suất dựa vào số tháng gửi và loại gửi
	public String xacDinhLaiSuat() {
		if(!coKyHan) {
			laiSuat = 0.1;
			return "Lãi suất không kỳ hạn là 0.1%";
		} else {
			switch(soThangGui) {
			case 1, 2: laiSuat =  1.7; break;
			case 3,5: laiSuat =  2.0; break;
			case 6,9: laiSuat = 3.0; break;
			case 12,13,15,18,24,36: laiSuat = 4.7; break;
			default : laiSuat = 0.0; return "Chỉ chọn một trong các danh sách tháng";
			}
			return "Số tháng gửi là: "+soThangGui+" và lãi suất là: "+laiSuat; 
		}
	}
	// hàm tính số tháng và rút
	public int tinhSoThangVaRut() {
		// get time now
		LocalDate dateNow = LocalDate.now();
		// get time save
		LocalDate dateSave = LocalDate.of(ngayGui.getNam(), ngayGui.getThang(), ngayGui.getNgay());
		// calculate month of dateNow and dateSave
		Period khoangCach = Period.between(dateSave, dateNow);
		int thang = khoangCach.getYears()*12 + khoangCach.getMonths();
		if(!coKyHan) {
			return thang; // chỉ cần tính số tháng 
		}else {
			if(thang>=soThangGui) {
				return soThangGui; // đủ tháng để rút 
			}else {
				return 0; // chưa đủ tháng để rút tiền tiết kiệm
			}
		}
	}
	public int getSoTienGui() {
		return soTienGui;
	}
	public void setSoTienGui(int soTienGui) {
		this.soTienGui = soTienGui;
	}
	public int getSoThangGui() {
		return soThangGui;
	}
	public void setSoThangGui(int soThangGui) {
		this.soThangGui = soThangGui;
	}
	public Time getNgayGui() {
		return ngayGui;
	}
	public void setNgayGui(Time ngayGui) {
		this.ngayGui = ngayGui;
	}
	public String getNoiDungGui() {
		return noiDungGui;
	}
	public void setNoiDungGui(String noiDungGui) {
		this.noiDungGui = noiDungGui;
	}
	public boolean getCoKyHan() {
		return coKyHan;
	}
	public void setCoKyHan(boolean coKyHan) {
		this.coKyHan = coKyHan;
	}
	public double getLaiSuat() {
		return laiSuat;
	}
	public void setLaiSuat(double laiSuat) {
		this.laiSuat = laiSuat;
	}
	public LocalDate getNow() {
		return now;
	}
	public void setNow(LocalDate now) {
		this.now = now;
	}
	// hiển thị thông tin vay tiền
	@Override
	public String toString() {
	    return "Số tiền gửi: " + soTienGui + "\t" +
	           "Số tháng gửi: " + soThangGui + "\t" +
	           "Ngày gửi: " + ngayGui + "\t" +
	           "Nội dung gửi: " + noiDungGui + "\t" +
	           "Có kỳ hạn: " + coKyHan + "\t" +
	           "Lãi suất: " + laiSuat;
	}

}
