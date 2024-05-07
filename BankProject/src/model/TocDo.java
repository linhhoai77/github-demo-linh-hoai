package model;

public abstract class TocDo extends HoaDonTienMang {
	protected HoaDonTienMang hoaDonMang;

	public TocDo(int soTien, String khachHang) {
		super(soTien, khachHang);
		// TODO Auto-generated constructor stub
	}

	public TocDo(HoaDonTienMang hoaDonMang) {
		this.hoaDonMang = hoaDonMang;
	}

	@Override
	public abstract double tinhTienHoaDon();

	// method hiển thị thông tin
	public String hienThiThongTin() {
		return super.hienThiThongTin();
	}
}
