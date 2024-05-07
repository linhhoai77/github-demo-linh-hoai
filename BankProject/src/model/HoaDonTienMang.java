package model;

public abstract class HoaDonTienMang extends HoaDon {

	public HoaDonTienMang(int soTien, String khachHang) {
		super(soTien, khachHang);
		// TODO Auto-generated constructor stub
	}

	public HoaDonTienMang() {

	}

	@Override
	public abstract double tinhTienHoaDon();

	// method hiển thị thông tin
	public String hienThiThongTin() {
		return super.hienThiThongTin();
	}

}
