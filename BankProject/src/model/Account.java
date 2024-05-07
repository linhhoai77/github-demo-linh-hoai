package model;

public class Account {
	private String soTaiKhoan;
	private String matKhau;
	private int[] maPIN;
	// constructor method
	public Account(String soTaiKhoan, String matKhau, int[] maPIN) {
		this.soTaiKhoan = soTaiKhoan;
		this.matKhau = matKhau;
		this.maPIN = maPIN;
	}
	// change password 
	public boolean thayDoiMatKhau(String mkCu, String mkMoi1, String mkMoi2) {
		if(mkCu.equals(matKhau) && mkMoi1.equals(mkMoi2)) {
			this.matKhau = mkMoi1;
			return true;
		}else {
			return false;
		}
	}
	// change PIN code
	public boolean thayDoiMaPIN(int[] maPINCu, int[] maPINMoi) {
		if(this.kiemTraMaPIN(maPINCu) && maPINMoi.length == 6) {
			this.maPIN = maPINMoi.clone();
			return true;
		}else {
			return false;
		}
	}
	// Phương thức kiểm tra mảng maPIN
	public boolean kiemTraMaPIN(int[] maPINCanKiemTra) {
	    if (maPINCanKiemTra.length != maPIN.length) {
	        return false; // Độ dài không khớp
	    }
	    for (int i = 0; i < maPIN.length; i++) {
	        if (maPINCanKiemTra[i] != maPIN[i]) {
	            return false; // Phần tử không khớp
	        }
	    }
	    return true;
	}
	// kiểm tra tài khoản và mật khẩu để đăng nhập
	public boolean kiemTraTaiKhoanVaMatKhau(String stk, String mk) {
		return (stk.equalsIgnoreCase(this.soTaiKhoan) && mk.equalsIgnoreCase(this.matKhau))? true: false;
	}
	// tất cả các hàm getter setter
	public String getSoTaiKhoan() {
		return soTaiKhoan;
	}
	public void setSoTaiKhoan(String soTaiKhoan) {
		this.soTaiKhoan = soTaiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public int[] getMaPIN() {
		return maPIN;
	}
	public void setMaPIN(int[] maPIN) {
		this.maPIN = maPIN;
	}
	
}
