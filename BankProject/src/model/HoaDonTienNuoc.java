package model;

public class HoaDonTienNuoc extends HoaDon {
	private double soKhoi;
	private double tienNuocApDung;

	public HoaDonTienNuoc(int soTien , String khachHang, double soKhoi,
			double tienNuocApDung) {
		super(soTien , khachHang);
		this.soKhoi = soKhoi;
		this.tienNuocApDung = tienNuocApDung;
	}

	public double getSoKhoi() {
		return soKhoi;
	}

	public void setSoKhoi(double soKhoi) {
		this.soKhoi = soKhoi;
	}

	public double getTienNuocApDung() {
		return tienNuocApDung;
	}

	public void setTienNuocApDung(double tienNuocApDung) {
		this.tienNuocApDung = tienNuocApDung;
	}

	@Override
	public String hienThiThongTin() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("Số khối nước: ").append(soKhoi).append("\n");
		sb.append("Tiền nước áp dụng: ").append(tienNuocApDung).append(" VND/khối\n");
		return sb.toString();
	}

	@Override
	public double tinhTienHoaDon() {
		return this.soKhoi * this.tienNuocApDung;
	}

	// method kiểm tra hóa đơn đã được thanh toán hay chưa
	public boolean kiemTraThanhToan() {
		return this.trangThaiThanhToan;
	}

	public boolean xacDinhTieuChuan() {
		return this.soKhoi < 20;
	}
}
