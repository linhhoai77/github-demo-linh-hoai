package model;

import java.util.Random;

public class ChuyenTien extends GiaoDich{
		private String stkNguoiNhan;
		private String noiDungChuyen;
		
		// constructor của chuyển tiền
	public ChuyenTien(String stkNguoiNhan, String noiDungChuyen, int soTienGiaoDich) {
		super(soTienGiaoDich);
			this.stkNguoiNhan = stkNguoiNhan;
			this.noiDungChuyen = noiDungChuyen;
		}

	@Override
	public String hienThiThongTin() {
		 return "GiaoDich{" +
	                "\tMã giao dịch='" + maGiaoDich + '\'' +
	                "\tThời gian thực hiện=" + thoiGianThucHien +
	                "\tSố tiền giao dịch=" + soTienGiaoDich +
	                "\tSTK người nhận=" + stkNguoiNhan +
	                "\tNội dung chuyển=" + noiDungChuyen +
	                '}';
	}

}
