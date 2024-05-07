package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NganHang implements SubjectNganHang {
	private String tenNganHang;
	private String diaChi;
	private List<ObserverThongBaoKH> dSKhachHang;
	private String thongBao;
	private List<HoaDon> dSHoaDon;
	private static NganHang uniqueNganHang;

	// create NganHang by Singleton
	private NganHang() {
		this.tenNganHang = "Ngân hàng ABC Bank";
		this.diaChi = "20 Lê Văn Việt/ Thủ Đức/ TP.Hồ Chí Minh.";
		this.dSKhachHang = new ArrayList<ObserverThongBaoKH>();
		this.dSHoaDon = new ArrayList<HoaDon>();
		this.thongBao = "Ngân hàng mới thành lập!";
	}

	// thêm thông báo đến khách hàng
	public void setThongBao(String thongBao) {
		this.thongBao = thongBao;
		this.guiThongBao();
	}

	public static NganHang getInstance() {
		if (uniqueNganHang == null) {
			uniqueNganHang = new NganHang();
		}
		return uniqueNganHang;
	}

	// all method getter and setter
	public String getTenNganHang() {
		return tenNganHang;
	}

	public void setTenNganHang(String tenNganHang) {
		this.tenNganHang = tenNganHang;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getThongBao() {
		return thongBao;
	}

	// toString method of NganHang
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Tên ngân hàng: ").append(tenNganHang).append("\n");
		sb.append("Địa chỉ: ").append(diaChi).append("\n");
		sb.append("Thông báo: ").append(thongBao);
		return sb.toString();
	}

	@Override
	public boolean themKhachHang(ObserverThongBaoKH kH) {
		return (this.dSKhachHang.contains(kH)) ? false : this.dSKhachHang.add(kH);
	}

	@Override
	public boolean xoaKhachHang(ObserverThongBaoKH kH) {
		return (this.dSKhachHang.contains(kH)) ? this.dSKhachHang.remove(kH) : false;
	}

	@Override
	public void guiThongBao() {
		for (ObserverThongBaoKH kH : this.dSKhachHang) {
			kH.nhanThongBao(tenNganHang, thongBao);
		}
	}

	// đổi mật khẩu cho khách hàng
	public boolean doiMatKhauKhachHang(String maKH, String mkCu, String mkMoi1, String mkMoi2) {
		for (ObserverThongBaoKH kH : this.dSKhachHang) {
			if (kH.getMaKH().equalsIgnoreCase(maKH)) {
				return kH.getAccount().thayDoiMatKhau(mkCu, mkMoi1, mkMoi2);
			}
		}
		return false;
	}

	// nạp tiền cho khách hàng
	public void napTienChoKhachHang(String maKH, int soTienNap) {
		for (ObserverThongBaoKH kH : this.dSKhachHang) {
			if (maKH.equalsIgnoreCase(kH.getMaKH())) {
				kH.setSoDuTaiKhoan(kH.getSoDuTaiKhoan() + soTienNap);
			}
		}
	}

	// hiển thị thông tin lãi suất gửi tiết kiệm cho khách hàng
	public String xemLaiSuatTietKiem() {
		return "Không kỳ hạn: 0.1%\n" + "Có kỳ hạn:\n" + "\tSố tháng\t Lãi suất\n" + "\t1\t1,7%\n" + "\t2\t1,7%\n"
				+ "\t3\t2%\n" + "\t5\t2%\n" + "\t6\t3%\n" + "\t9\t3%\n" + "\t12\t4,7%\n" + "\t13\t4,7%\n"
				+ "\t15\t4,7%\n" + "\t18\t4,7%\n" + "\t24\t4,7%\n" + "\t36\t4,7%";
	}

	// xử lý đơn gửi tiết kiệm cho khách hàng
	public boolean xuLyGuiTietKiemChoKhachHang(GuiTietKiem guiTietKiem, String maKH, int[] maPIN) {
		for (ObserverThongBaoKH kH : this.dSKhachHang) {
			if (maKH.equalsIgnoreCase(kH.getMaKH())) {
				// kiểm tra mã PIN
				if (!kH.getAccount().kiemTraMaPIN(maPIN)) {
					return false;
				}
				// kiểm tra số tháng Lãi suất
				if (guiTietKiem.getLaiSuat() == 0.0) {
					return false;
				}
				kH.setGuiTietKiem(guiTietKiem);
			}
		}
		return true;
	}

	// xử lý rút tiền tiết kiệm của khách hàng
	public int tinhSoTienVaRutTienChoKhachHang(String maKH, int[] maPIN) {
		for (ObserverThongBaoKH kH : this.dSKhachHang) {
			if (kH.getMaKH().equalsIgnoreCase(maKH)) {
				// kiểm tra mã PIN
				if (!kH.getAccount().kiemTraMaPIN(maPIN)) {
					return 0;
				}
				// kiểm tra hạn rút
				if (kH.getGuiTietKiem().tinhSoThangVaRut() == 0) {
					return 0; // chưa đủ số tháng rút
				}
				// tính số tiền và rút
				GuiTietKiem gui = kH.getGuiTietKiem();
				int kq = (int) gui.getSoTienGui() + gui.getSoThangGui() * gui.getSoTienGui() * gui.getSoThangGui();
				kH.setGuiTietKiem(null);
				return kq;
			}
		}
		return 0; //
	}

	// hiển thị thông tin và lãi suất vay tiền của ngân hàng
	public String xemLaiXuatVayTien() {
		return "Vay tiền theo định kỳ mỗi năm, với lãi suất là: 6,7%";
	}

	// xử lý vay tiền ngân hàng cho khách hàng
	public boolean xuLyVayTienNganHang(String maKH, VayNganHang vay, String soCCCD, int[] maPIN) {
		for (ObserverThongBaoKH kH : this.dSKhachHang) {
			if (kH.getMaKH().equalsIgnoreCase(maKH)) {
				// vay tiền cần cccd
				if (soCCCD.isEmpty()) {
					return false;
				}
				// kiemr tra mã pin
				if (!kH.getAccount().kiemTraMaPIN(maPIN)) {
					return false; // sai mã PIN
				}
				kH.setVayTien(vay);
			}
		}
		return true;
	}

	// xử lý trả nợ khoản vay cho khách hàng
	public boolean xuLyTraNoKhoanVayChoKhachHang(String maKH, int[] maPIN) {
		for (ObserverThongBaoKH kH : this.dSKhachHang) {
			if (kH.getMaKH().equalsIgnoreCase(maKH)) {
				if (kH.getVayTien() == null) {
					return false; // không có vay
				}
				if (kH.getSoDuTaiKhoan() < kH.getVayTien().tinhTienPhaiTra()) {
					return false; // không đủ tiền để trả
				}
				if (!kH.getAccount().kiemTraMaPIN(maPIN)) {
					return false; // sai mã PIN
				}
				// thực hiện thanh toán khoản vay
				kH.setSoDuTaiKhoan((int) (kH.getSoDuTaiKhoan() - kH.getVayTien().tinhTienPhaiTra()));
				kH.setVayTien(null);
			}
		}
		return true;
	}
	// xử lý thanh toán hóa đon cho khách hàng
	public boolean xuLyThanhToanHoaDon(String maKH, String maHD, int[] maPIN) {
		for (ObserverThongBaoKH kH : this.dSKhachHang) {
			if (kH.getMaKH().equalsIgnoreCase(maKH)) {
				// kiểm tra hóa đơn đó có phải của kh đó k
				for (HoaDon hoaDon : this.dSHoaDon) {
					if (hoaDon.getMaHoaDon().equalsIgnoreCase(maHD)) {
						if (!hoaDon.getKhachHang().equalsIgnoreCase(maKH)) {
							return false;
						}
						if(!kH.getAccount().kiemTraMaPIN(maPIN)) {
							return false;
						}
						// kiểm tra đủ tiền
						if(kH.getSoDuTaiKhoan() < hoaDon.getSoTien()) {
							return false;
						}
						// thực hiện thanh toán
						kH.setSoDuTaiKhoan((int) (kH.getSoDuTaiKhoan()-hoaDon.tinhTienHoaDon()));
						hoaDon.setTrangThaiThanhToan(true);
						// thông báo thanh toán thành công 
					}
				}
			}
		}
		return true;
	}

	public boolean thayDoiMaPINCuaKhachHang(String maKH, int[] maPINCu, int[] maPINMoi) {
		for(ObserverThongBaoKH kH : this.dSKhachHang) {
			if(kH.getMaKH().equalsIgnoreCase(maKH)) {
				// kiểm tra mã PIN hiện tại hợp lệ không
				if(!kH.getAccount().kiemTraMaPIN(maPINCu)) {
					return false; // sai mã PIN
				}
				if(maPINMoi.length!=6) {
					return false; // không đủ hoặc dư ký tự
				}
				// tiến hành thay đổi mã PIN
				kH.getAccount().thayDoiMaPIN(maPINCu, maPINMoi);
				// thay đỗi mã PIN thành công
			}
		}
		return true;
	}
	// xử lý đăng nhập cho khách hàng
	public ObserverThongBaoKH xuLyKhachHangDangNhap(String maKH, String stk, String mk) {
		for(ObserverThongBaoKH kH : this.dSKhachHang) {
			if(kH.getAccount().kiemTraTaiKhoanVaMatKhau(stk, mk)) {
				return kH; //  không đăng nhập vào được
			}
		}
		return null;
	}
	// xử lý đăng xuất cho khách hàng
	public boolean xuLyDangXuat(String maKH) {
		return true;
	}

}
