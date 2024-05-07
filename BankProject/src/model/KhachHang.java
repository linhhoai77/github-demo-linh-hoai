package model;

import java.util.ArrayList;
import java.util.List;

public class KhachHang extends ObserverThongBaoKH{
	private String maKH;
	private String tenKH;
	private Time ngaySinh;
	private String diaChi;
	private String soCCCD;
	private String sDT;
	private String email;
	private int soDuTaiKhoan;
	private Account account;
	private GuiTietKiem guiTietKiem;
	private VayNganHang vayTien;
	private List<String> dSThongBao;
	private List<GiaoDich> dSGiaoDich;
	
	
	public KhachHang(String maKH, String tenKH, Time ngaySinh, String diaChi, String soCCCD, String sDT, String email,
			Account account) {
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.soCCCD = soCCCD;
		this.sDT = sDT;
		this.email = email;
		this.account = account;
		this.soDuTaiKhoan = 0;
		this.guiTietKiem = null;
		this.vayTien = null;
		this.dSThongBao = new ArrayList<String>();
		this.dSGiaoDich = new ArrayList<GiaoDich>();
	}
	 public String toString() {
	        return "Thông tin Khách hàng:\n" +
	               "Mã KH: " + maKH + "\n" +
	               "Tên KH: " + tenKH + "\n" +
	               "Ngày sinh: " + ngaySinh.xemNgay() + "\n" +
	               "Địa chỉ: " + diaChi + "\n" +
	               "Số CCCD: " + soCCCD + "\n" +
	               "Số điện thoại: " + sDT + "\n" +
	               "Email: " + email;
	    }
	 // nhận thông báo từ ngân hàng rồi lưu vào danh sách thông báo đã nhận
	@Override
	public void nhanThongBao(String tenNganHang, String thongBaoTuNganHan) {
		super.thongBao = "Thông báo từ Ngân Hàng: "+tenNganHang+": "+thongBaoTuNganHan+"\n";
		// thêm thông báo vào danh sách thông báo
		this.dSThongBao.add(super.thongBao);
	} 
	// method hiển thị thông báo
	public String xemDanhSachThongBao() {
		String kq ="";
		for(String tB: this.dSThongBao) {
			kq+=tB;
		}
		return kq;
	}
	@Override
	public boolean thayDoiMatKhau(NganHang nganHang, String mkCu, String mkMoi1, String mkMoi2) {
		return nganHang.doiMatKhauKhachHang( this.maKH, mkCu,  mkMoi1,  mkMoi2);
	}
	
	
	public int getSoDuTaiKhoan() {
		return soDuTaiKhoan;
	}
	public void setSoDuTaiKhoan(int soDuTaiKhoan) {
		this.soDuTaiKhoan = soDuTaiKhoan;
	}
	// Tất cả các method getter and setter của khách hàng
	@Override
	public String getMaKH() {
		// TODO Auto-generated method stub
		return this.maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public Time getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Time ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoCCCD() {
		return soCCCD;
	}
	public void setSoCCCD(String soCCCD) {
		this.soCCCD = soCCCD;
	}
	public String getsDT() {
		return sDT;
	}
	public void setsDT(String sDT) {
		this.sDT = sDT;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public GuiTietKiem getGuiTietKiem() {
		return guiTietKiem;
	}
	public void setGuiTietKiem(GuiTietKiem guiTietKiem) {
		this.guiTietKiem = guiTietKiem;
	}
	public VayNganHang getVayTien() {
		return vayTien;
	}
	public void setVayTien(VayNganHang vayTien) {
		this.vayTien = vayTien;
	}
	public List<String> getdSThongBao() {
		return dSThongBao;
	}
	public void setdSThongBao(List<String> dSThongBao) {
		this.dSThongBao = dSThongBao;
	}
	public List<GiaoDich> getdSGiaoDich() {
		return dSGiaoDich;
	}
	public void setdSGiaoDich(List<GiaoDich> dSGiaoDich) {
		this.dSGiaoDich = dSGiaoDich;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	@Override
	public String xemSoDuTaiKhoan() {
		return "Số dư tài khoản hiện là: "+soDuTaiKhoan;
	}
	@Override
	public String xemLaiSuatTietKiem(NganHang nganHang) {
		return nganHang.xemLaiSuatTietKiem();
	}
	@Override
	public boolean guiTietKiem(GuiTietKiem guiTietKiem, NganHang nganHang, int[] maPIN) {
	return nganHang.xuLyGuiTietKiemChoKhachHang(guiTietKiem, maKH, maPIN);
	
	}
	@Override
	public int rutTietKiem(NganHang nganHang, int[] maPIN) {
		return nganHang.tinhSoTienVaRutTienChoKhachHang(maKH, maPIN);
	}
	@Override
	public String xemLaiSuatVayTien(NganHang nganHang) {
		return nganHang.xemLaiXuatVayTien();
	}
	@Override
	public boolean vayTienNganHang(NganHang nganHang, VayNganHang vay, String soCCCD, int[] maPIN) {
		return nganHang.xuLyVayTienNganHang(maKH,vay, soCCCD, maPIN);
	}
	@Override
	public boolean traTienNganHang(NganHang nganHang, VayNganHang vay, int[] maPIN) {
		return nganHang.xuLyTraNoKhoanVayChoKhachHang(maKH, maPIN);
	}
	@Override
	public boolean thanhToanHoaDon(NganHang nganHang, String maHD, int[] maPIN) {
		return nganHang.xuLyThanhToanHoaDon(maKH, maHD, maPIN);
	}
	@Override
	public boolean thucHienChuyenTien(NganHang nganHang, ChuyenTien chuyenTien, int[] maPIN) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean thayDoiMaPIN(NganHang nganHang, int[] maPINCu, int[] maPINMoi) {
		return nganHang.thayDoiMaPINCuaKhachHang(maKH, maPINCu, maPINMoi);
	}
	@Override
	public ObserverThongBaoKH dangNhap(NganHang nganHang, String stk, String mk) {
		return nganHang.xuLyKhachHangDangNhap(maKH, stk, mk);
	}
	@Override
	public boolean dangXuat(NganHang nganHang) {
		return nganHang.xuLyDangXuat(maKH);
	}
	public static void main(String[] args) {
		for (int i = 1; i <25 ; i++) {
			System.out.println("Câu "+i+": ");
		}
	}
}
