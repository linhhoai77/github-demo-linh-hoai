package model;

public class HoaDonTienDien extends HoaDon {
	private double soKWH;
	private double giaDienApDung;

	// constructor của HoaDonTienDien
	public HoaDonTienDien(String maHoaDon, int soTien, Time ngayGuiHoaDon, Time ngayHetHan, String phuongThucThanhToan,
			String khachHang, double soKWH, double giaDienApDung) {
		super(soTien, khachHang);
		this.soKWH = soKWH;
		this.giaDienApDung = giaDienApDung;
	}

	// method hiển thị thông tin
	public String hienThiThongTin() {
		StringBuilder sb = new StringBuilder(super.hienThiThongTin());
		sb.append("Chi tiết tiêu thụ điện: ").append(soKWH).append(" kWh\n");
		sb.append("Giá điện áp dụng: ").append(giaDienApDung).append(" VND/kWh\n");
		return sb.toString();
	}

	public double getChiTietTieuThuDien() {
		return soKWH;
	}

	public void setChiTietTieuThuDien(double chiTietTieuThuDien) {
		this.soKWH = chiTietTieuThuDien;
	}

	public double getGiaDienApDung() {
		return giaDienApDung;
	}

	public void setGiaDienApDung(double giaDienApDung) {
		this.giaDienApDung = giaDienApDung;
	}

	@Override
	public double tinhTienHoaDon() {
		return this.giaDienApDung * this.soKWH;
	}

	public boolean xacDinhTieuChuanTieuThu() {
		return this.soKWH < 500;
	}

	// method kiểm tra hóa đơn đã được thanh toán hay chưa
	public boolean kiemTraThanhToan() {
		return this.trangThaiThanhToan;
	}
}
