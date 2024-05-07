package test;

import model.Account;
import model.KhachHang;
import model.NganHang;
import model.ObserverThongBaoKH;
import model.Time;

public class Main {
	public static void main(String[] args) {
		NganHang nganHang = NganHang.getInstance();
		int[] maPIN = {1,6,0,3,0,4};
		 ObserverThongBaoKH khachHang = new KhachHang("KH001", "Nguyễn Văn A", new Time(16,3,2004),
                 "123 Đường ABC, Quận XYZ, Thành phố HCM",
                 "123456789", "0123456789", "nguyenvana@gmail.com", new Account("0377314202","linhhoai69@@", maPIN) );
		 nganHang.themKhachHang(khachHang);
		 nganHang.guiThongBao();
		 System.out.println(khachHang.xemDanhSachThongBao());
		 nganHang.setThongBao("Miễn phí 2 nước khi dùng set gà tại KFC");
		 System.out.println(khachHang.xemDanhSachThongBao());
		 System.out.println(khachHang.toString());
		 System.out.println(nganHang.xemLaiSuatTietKiem());
	}
}
