package model;

import java.time.LocalDateTime;
import java.util.Random;

public abstract class GiaoDich {
	protected String maGiaoDich;
	protected Time thoiGianThucHien;
	protected int soTienGiaoDich;
	private LocalDateTime now = LocalDateTime.now();
	// constructor của giaodich
	public GiaoDich( int soTienGiaoDich) {
		this.maGiaoDich =String.valueOf(new Random().nextInt(10000000));
		this.thoiGianThucHien = new Time(now.getMinute(), now.getHour(), now.getDayOfMonth(), now.getMonthValue(), now.getYear());
		this.soTienGiaoDich = soTienGiaoDich;
	}

	// tất cả các hàm getter và setter
	public String getMaGiaoDich() {
		return maGiaoDich;
	}
	public void setMaGiaoDich(String maGiaoDich) {
		this.maGiaoDich = maGiaoDich;
	}
	public Time getThoiGianThucHien() {
		return thoiGianThucHien;
	}
	public void setThoiGianThucHien(Time thoiGianThucHien) {
		this.thoiGianThucHien = thoiGianThucHien;
	}
	public int getSoTienGiaoDich() {
		return soTienGiaoDich;
	}
	public void setSoTienGiaoDich(int soTienGiaoDich) {
		this.soTienGiaoDich = soTienGiaoDich;
	}
	// method hiển thị thông tin được hiện thực bên trong các class con
	public abstract String hienThiThongTin();
}
