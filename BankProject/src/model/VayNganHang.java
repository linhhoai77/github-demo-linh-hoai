package model;

public class VayNganHang {
	private int soTienVay;
	private int soNamVay;
	private Time ngayVay;
	private String thongTinTaiChinh;
	private String mucDichVay;
	private Time ngayTraNo;
	private String cCCD;
	private double laiSuatVayMoiThang;
	// costructor khởi tạo vay tiền
	public VayNganHang(int soTienVay, int soNamVay, Time ngayVay, String thongTinTaiChinh, String mucDichVay, String cCCD) {
		this.soTienVay = soTienVay;
		this.soNamVay = soNamVay;
		this.ngayVay = ngayVay;
		this.thongTinTaiChinh = thongTinTaiChinh;
		this.mucDichVay = mucDichVay;
		this.ngayTraNo.setNam(ngayTraNo.getNam()+1);
		this.cCCD = cCCD;
		this.laiSuatVayMoiThang = 0.649; // lãi suất theo năm
	}
	// tính số tiền của khách hàng phải trả
	public double tinhTienPhaiTra() {
		return soTienVay + soTienVay*0.649;
	}
	// hiển thị thông tin
	@Override
	public String toString() {
	    return "Số tiền vay: " + soTienVay + "\t" +
	           "Số năm vay: " + soNamVay + "\t" +
	           "Ngày vay: " + ngayVay + "\t" +
	           "Thông tin tài chính: " + thongTinTaiChinh + "\t" +
	           "Mục đích vay: " + mucDichVay + "\t" +
	           "Ngày trả nợ: " + ngayTraNo + "\t" +
	           "CCCD: " + cCCD + "\t" +
	           "Lãi suất vay mỗi tháng: " + laiSuatVayMoiThang;
	}

	public int getSoTienVay() {
		return soTienVay;
	}
	public void setSoTienVay(int soTienVay) {
		this.soTienVay = soTienVay;
	}
	public int getSoNamVay() {
		return soNamVay;
	}
	public void setSoNamVay(int soNamVay) {
		this.soNamVay = soNamVay;
	}
	public Time getNgayVay() {
		return ngayVay;
	}
	public void setNgayVay(Time ngayVay) {
		this.ngayVay = ngayVay;
	}
	public String getThongTinTaiChinh() {
		return thongTinTaiChinh;
	}
	public void setThongTinTaiChinh(String thongTinTaiChinh) {
		this.thongTinTaiChinh = thongTinTaiChinh;
	}
	public String getMucDichVay() {
		return mucDichVay;
	}
	public void setMucDichVay(String mucDichVay) {
		this.mucDichVay = mucDichVay;
	}
	public Time getNgayTraNo() {
		return ngayTraNo;
	}
	public void setNgayTraNo(Time ngayTraNo) {
		this.ngayTraNo = ngayTraNo;
	}
	public String getcCCD() {
		return cCCD;
	}
	public void setcCCD(String cCCD) {
		this.cCCD = cCCD;
	}
	public double getLaiSuatVayMoiThang() {
		return laiSuatVayMoiThang;
	}
	public void setLaiSuatVayMoiThang(double laiSuatVayMoiThang) {
		this.laiSuatVayMoiThang = laiSuatVayMoiThang;
	}
	
}
