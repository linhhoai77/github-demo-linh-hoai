package model;

import java.time.LocalDate;
import java.util.Random;

public abstract class HoaDon {
	protected String maHoaDon;
	protected int soTien;
	protected Time ngayGuiHoaDon;
	protected Time ngayHetHan;
	protected boolean trangThaiThanhToan;
	protected String maKH;
	private LocalDate now = LocalDate.now();

	// constructor của HoaDon
	public HoaDon(int soTien , String maKH) {
		this.maHoaDon = String.valueOf(new Random().nextInt(1000000));
		this.soTien = soTien;
		this.ngayGuiHoaDon = new Time(now.getDayOfMonth(), now.getMonthValue(), now.getYear());
		this.ngayHetHan = new Time(now.getDayOfMonth(), now.getMonthValue() + 3, now.getYear()); // hết hạn thanh toán
		this.trangThaiThanhToan = false;
		this.maKH = maKH;
	}

	public HoaDon() {

	}

	public String hienThiThongTin() {
		StringBuilder sb = new StringBuilder();
		sb.append("Thông tin hóa đơn:\t");
		sb.append("Mã hóa đơn: ").append(maHoaDon).append("\t");
		sb.append("Số tiền: ").append(soTien).append(" VND\t");
		sb.append("Ngày gửi hóa đơn: ").append(ngayGuiHoaDon.xemNgay()).append("\t");
		sb.append("Ngày hết hạn: ").append(ngayHetHan.xemNgay()).append("\t");
		sb.append("Trạng thái thanh toán: ").append(trangThaiThanhToan ? "Đã thanh toán" : "Chưa thanh toán")
				.append("\t");
		sb.append("Khách hàng: ").append(maKH).append("\t");
		return sb.toString();
	}

	// method cập nhật trạng thái thanh toán
	public void capNhatTrangThaiThanhToan() {
		this.trangThaiThanhToan = true;
	}

	// tất cả các hàm getter và setter của HoaDon
	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public int getSoTien() {
		return soTien;
	}

	public void setSoTien(int soTien) {
		this.soTien = soTien;
	}

	public Time getNgayGuiHoaDon() {
		return ngayGuiHoaDon;
	}

	public void setNgayGuiHoaDon(Time ngayGuiHoaDon) {
		this.ngayGuiHoaDon = ngayGuiHoaDon;
	}

	public Time getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(Time ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

	public boolean getTrangThaiThanhToan() {
		return trangThaiThanhToan;
	}

	public void setTrangThaiThanhToan(boolean trangThaiThanhToan) {
		this.trangThaiThanhToan = trangThaiThanhToan;
	}

	public String getKhachHang() {
		return maKH;
	}

	public void setKhachHang(String maKH) {
		this.maKH = maKH;
	}

	public abstract double tinhTienHoaDon();
}
