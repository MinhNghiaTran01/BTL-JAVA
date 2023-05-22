create database QuanlyMayTinh

go
create TABLE Chuc_vu
(
	ten_chuc_vu NVARCHAR(100) NOT NULL PRIMARY KEY,
	mo_ta VARCHAR(100)
)
GO
CREATE TABLE Nhan_vien
(	
	ma_nhan_vien VARCHAR(100) NOT NULL PRIMARY KEY,
	ten_nhan_vien NVARCHAR(100) NOT NULL,
	ngay_sinh DATE,
	gioi_tinh NVARCHAR(100),
	so_dien_thoai VARCHAR(100),
	email VARCHAR(100),
	chuc_vu NVARCHAR(100) NOT NULL FOREIGN KEY REFERENCES dbo.Chuc_vu(ten_chuc_vu)
)
GO

CREATE TABLE KhachHang
(
	ten_khach_hang NVARCHAR(100) NOT NULL,
	so_dien_thoai VARCHAR(100) NOT NULL PRIMARY KEY,
)
GO

GO
CREATE TABLE nhaCungCap
(
	maNhaCungCap VARCHAR(100) NOT NULL PRIMARY KEY,
	tenNhaCungCap NVARCHAR(100) NOT NULL,
	sdtNhaCungCap VARCHAR(100) NOT NULL,
	diaChi NVARCHAR(100) NOT NULL,
	email VARCHAR(100) NOT NULL
)
go
CREATE TABLE DanhSachHoaDonNhap
(
	maHoaDonNhap VARCHAR(100) NOT NULL PRIMARY KEY,
	maNhaCungCap VARCHAR(100) NOT NULL FOREIGN KEY REFERENCES dbo.nhaCungCap(maNhaCungCap),
	maNhanVien VARCHAR(100) NOT NULL FOREIGN KEY REFERENCES dbo.Nhan_vien(ma_nhan_vien),
	ngayNhap VARCHAR(100) NOT NULL,
)
CREATE TABLE ChiTietHoaDonNhap
(
	maHoaDonNhap VARCHAR(100) NOT NULL FOREIGN KEY REFERENCES dbo.DanhSachHoaDonNhap(maHoaDonNhap),
	tenMayTinh NVARCHAR(100) NOT NULL,
	giaNhap INT NOT NULL,
	soLuong INT NOT NULL,
)
GO

CREATE TABLE DanhSachHoaDonBan
(
    ma_hoa_don VARCHAR(100) NOT NULL PRIMARY KEY,
    ma_nhan_vien VARCHAR(100) NOT NULL FOREIGN KEY REFERENCES dbo.Nhan_vien(ma_nhan_vien),
    so_dien_thoai_khachHang VARCHAR(100) NOT NULL FOREIGN KEY REFERENCES dbo.KhachHang(so_dien_thoai),
    ngay_ban VARCHAR(100) NOT NULL, 
    hinh_thuc_thanh_toan VARCHAR(100) NOT NULL
)

GO
CREATE TABLE SanPham
(
    ma_may_tinh VARCHAR(100) NOT NULL PRIMARY KEY,
    ten_may_tinh NVARCHAR(100) NOT NULL,
    xuat_xu VARCHAR(100) NOT NULL,
    thoi_gian_bao_hanh NVARCHAR(100) NOT NULL,
    so_luong INT NOT NULL,
    gia_ban INT NOT NULL 
)
go
CREATE TABLE ChiTietHoaDon(
    maHoaDon VARCHAR(100) NOT NULL FOREIGN KEY REFERENCES dbo.DanhSachHoaDonBan(ma_hoa_don), 
    tenMayTinh NVARCHAR(100),
    giaBan INT NOT NULL,
    soLuong INT NOT NULL
)

GO
CREATE TABLE TaiKhoanDangNhap
(
	maNhanVien VARCHAR(100) NOT NULL FOREIGN KEY REFERENCES dbo.Nhan_vien,
	taiKhoan VARCHAR(100) NOT NULL,
	matKhau VARCHAR(100) NOT NULL 
)

Insert into Chuc_vu 
values (N'nhân viên bán hàng', 'saler'),
		(N'quản lý', 'saler')