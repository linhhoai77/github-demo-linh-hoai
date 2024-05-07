package model;

public class TocDoNhanh extends TocDo{
	public TocDoNhanh(HoaDonTienMang hoaDonMang) {
		super(hoaDonMang);
	}

	@Override
	public double tinhTienHoaDon() {
		return this.hoaDonMang.soTien + 50000.0;
	}
	// method hiển thị thông tin
			public String hienThiThongTin() {
				return this.hoaDonMang.hienThiThongTin()+"\n Tốc độ: Nhanh";
			}
}
