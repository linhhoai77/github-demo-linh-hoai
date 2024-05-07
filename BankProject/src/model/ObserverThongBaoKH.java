package model;

import java.util.List;

public abstract class ObserverThongBaoKH {
	protected String thongBao;
	protected abstract void nhanThongBao(String tenNganHang, String thongBaoTuNganHang);
	public abstract String xemDanhSachThongBao();
	public abstract boolean thayDoiMatKhau(NganHang nganHang, String mkCu, String mkMoi1, String mkMoi2);
	public abstract String getMaKH();
    public abstract String getTenKH();
    public abstract void setTenKH(String tenKH);
    public abstract Time getNgaySinh();
    public abstract void setNgaySinh(Time ngaySinh);
    public abstract String getDiaChi();
    public abstract void setDiaChi(String diaChi);
    public abstract String getSoCCCD();
    public abstract void setSoCCCD(String soCCCD);
    public abstract String getsDT();
    public abstract void setsDT(String sDT);
    public abstract String getEmail();
    public abstract void setEmail(String email);
    public abstract Account getAccount();
    public abstract void setAccount(Account account);
    public abstract GuiTietKiem getGuiTietKiem();
    public abstract void setGuiTietKiem(GuiTietKiem guiTietKiem);
    public abstract VayNganHang getVayTien();
    public abstract void setVayTien(VayNganHang vayTien);
    public abstract int getSoDuTaiKhoan();
    public abstract void setSoDuTaiKhoan(int newSoDu);
    public abstract List<String> getdSThongBao();
    public abstract void setdSThongBao(List<String> dSThongBao);
    public abstract List<GiaoDich> getdSGiaoDich();
    public abstract void setdSGiaoDich(List<GiaoDich> dSGiaoDich);
    public abstract void setMaKH(String maKH);
    public abstract String xemSoDuTaiKhoan();
    public abstract String xemLaiSuatTietKiem(NganHang nganHang);
    public abstract boolean guiTietKiem(GuiTietKiem guiTietKiem, NganHang nganHang, int[] maPIN);
    public abstract int rutTietKiem( NganHang nganHang, int[] maPIN);
    public abstract String xemLaiSuatVayTien(NganHang nganHang);
    public abstract boolean vayTienNganHang(NganHang nganHang, VayNganHang vay, String soCCCD, int[] maPIN);
    public abstract boolean traTienNganHang(NganHang nganHang, VayNganHang vay, int[] PIN);
    public abstract boolean thanhToanHoaDon(NganHang nganHang, String maHD, int[] maPIN);
    public abstract boolean thucHienChuyenTien(NganHang nganHang, ChuyenTien chuyenTien, int[] maPIN);
    public abstract boolean thayDoiMaPIN(NganHang nganHang, int[] maPIN, int[] maPINMo);
    public abstract ObserverThongBaoKH dangNhap(NganHang nganHang, String stk, String mk);
    public abstract boolean dangXuat(NganHang nganHang);
    
    





}
