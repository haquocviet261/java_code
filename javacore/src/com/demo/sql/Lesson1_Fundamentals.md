# BUỔI 1 — GIỚI THIỆU HỆ QUẢN TRỊ CƠ SỞ DỮ LIỆU VÀ SQL SERVER

---

# 1. DỮ LIỆU LÀ GÌ?

Trong cuộc sống hằng ngày chúng ta luôn làm việc với dữ liệu.

Ví dụ:

- tên sinh viên
- ngày sinh
- số điện thoại
- địa chỉ
- điểm thi

Tất cả những thông tin đó đều được gọi là dữ liệu.

---

# Ví dụ thực tế

Giả sử lớp học có danh sách sinh viên:

| MaSV | HoTen | Lop |
|---|---|---|
| SV01 | Nguyễn Văn A | CNTT1 |
| SV02 | Trần Thị B | CNTT2 |

Trong bảng trên:

- SV01 là dữ liệu
- Nguyễn Văn A là dữ liệu
- CNTT1 là dữ liệu

---

# Tại sao phải lưu dữ liệu?

Giả sử trường học không lưu dữ liệu sinh viên.

Khi cần:
- tìm sinh viên
- nhập điểm
- thống kê
- in bằng tốt nghiệp

thì gần như không thể thực hiện được.

Do đó dữ liệu cần được lưu trữ để:
- quản lý
- tìm kiếm
- cập nhật
- thống kê

---

# 2. CÁCH LƯU DỮ LIỆU TRUYỀN THỐNG

Ngày xưa dữ liệu thường được lưu bằng:

- giấy tờ
- sổ sách
- file Excel

---

# Ví dụ lưu bằng Excel

| MaSV | HoTen | Lop |
|---|---|---|
| SV01 | Nguyễn Văn A | CNTT1 |
| SV02 | Trần Thị B | CNTT2 |

Ban đầu số lượng dữ liệu ít nên quản lý khá dễ.

---

# Vấn đề khi dữ liệu lớn

Nếu:
- có 100.000 sinh viên
- nhiều giáo viên cùng sửa
- dữ liệu lưu nhiều năm

thì sẽ phát sinh nhiều vấn đề.

---

# Các vấn đề thường gặp

# 1. Dữ liệu bị trùng

Ví dụ:

| MaSV | HoTen |
|---|---|
| SV01 | Nguyễn Văn A |
| SV01 | Nguyễn Văn A |

Một sinh viên bị nhập nhiều lần.

---

# 2. Khó tìm kiếm

Ví dụ:
- tìm sinh viên tên "An"
- tìm sinh viên lớp CNTT1

Nếu dữ liệu quá lớn:
- tìm rất chậm
- dễ sai

---

# 3. Dễ mất dữ liệu

Nếu:
- file Excel bị lỗi
- máy tính hỏng

thì dữ liệu có thể mất hoàn toàn.

---

# 4. Nhiều người sửa cùng lúc

Nếu:
- 2 người cùng mở file Excel
- cùng sửa dữ liệu

thì rất dễ:
- ghi đè dữ liệu
- mất dữ liệu

---

# Kết luận

Khi dữ liệu lớn:
- Excel không còn phù hợp
- cần một hệ thống quản lý chuyên nghiệp hơn

---

# 3. CƠ SỞ DỮ LIỆU LÀ GÌ?

Cơ sở dữ liệu (Database):
là nơi dùng để lưu trữ dữ liệu có tổ chức.

---

# Ví dụ

Database quản lý sinh viên có thể chứa:

- thông tin sinh viên
- lớp học
- môn học
- điểm thi

---

# Database giúp gì?

Database giúp:
- lưu dữ liệu tập trung
- tìm kiếm nhanh
- quản lý dễ dàng
- hạn chế trùng dữ liệu

---

# Ví dụ thực tế

| Hệ thống | Dữ liệu cần lưu |
|---|---|
| Facebook | người dùng |
| Shopee | sản phẩm |
| Ngân hàng | giao dịch |
| Trường học | sinh viên |

---

# 4. HỆ QUẢN TRỊ CƠ SỞ DỮ LIỆU LÀ GÌ?

Database chỉ là nơi chứa dữ liệu.

Để làm việc với dữ liệu cần có phần mềm quản lý.

Phần mềm đó gọi là:

Hệ quản trị cơ sở dữ liệu
(DBMS — Database Management System)

---

# DBMS dùng để làm gì?

DBMS giúp:

- tạo database
- lưu dữ liệu
- sửa dữ liệu
- xóa dữ liệu
- tìm kiếm dữ liệu
- phân quyền người dùng

---

# Ví dụ DBMS phổ biến

| Tên | Hãng |
|---|---|
| SQL Server | Microsoft |
| MySQL | Oracle |
| PostgreSQL | PostgreSQL Global |
| Oracle Database | Oracle |

---

# 5. SQL SERVER LÀ GÌ?

SQL Server:
là hệ quản trị cơ sở dữ liệu do Microsoft phát triển.

---

# SQL Server dùng để làm gì?

SQL Server được dùng để:

- lưu dữ liệu
- quản lý dữ liệu
- xử lý dữ liệu

---

# Ví dụ thực tế

# Hệ thống ngân hàng

SQL Server lưu:
- thông tin tài khoản
- số dư
- lịch sử giao dịch

---

# Hệ thống bán hàng

SQL Server lưu:
- sản phẩm
- khách hàng
- hóa đơn

---

# Hệ thống trường học

SQL Server lưu:
- sinh viên
- giảng viên
- môn học
- điểm thi

---

# 6. DATABASE TRONG SQL SERVER

Trong SQL Server:
database là nơi chứa dữ liệu.

---

# Ví dụ

Một công ty có thể có database:

- QuanLyNhanVien
- QuanLyBanHang
- QuanLyKho

---

# Mỗi database gồm nhiều bảng

Ví dụ:

Database QuanLySinhVien gồm:
- bảng SinhVien
- bảng LopHoc
- bảng MonHoc

---

# 7. TABLE LÀ GÌ?

Table là bảng dùng để lưu dữ liệu.

---

# Ví dụ bảng SinhVien

| MaSV | HoTen | NamSinh |
|---|---|---|
| SV01 | Nguyễn Văn A | 2004 |
| SV02 | Trần Thị B | 2003 |

---

# Giải thích

Bảng SinhVien dùng để lưu:
- mã sinh viên
- họ tên
- năm sinh

---

# Một table chỉ nên lưu một loại dữ liệu

Ví dụ:

| Table | Dữ liệu |
|---|---|
| SinhVien | sinh viên |
| MonHoc | môn học |
| GiangVien | giảng viên |

---

# 8. ROW LÀ GÌ?

Row là một dòng dữ liệu trong bảng.

---

# Ví dụ

| MaSV | HoTen | NamSinh |
|---|---|---|
| SV01 | Nguyễn Văn A | 2004 |

Dòng trên gọi là một row.

---

# Ý nghĩa

Một row thường đại diện cho:
- một sinh viên
- một sản phẩm
- một khách hàng

---

# 9. COLUMN LÀ GÌ?

Column là cột dữ liệu trong bảng.

---

# Ví dụ

| Column | Ý nghĩa |
|---|---|
| MaSV | mã sinh viên |
| HoTen | họ tên |
| NamSinh | năm sinh |

---

# Vai trò của column

Column dùng để mô tả thông tin.

Ví dụ:

Sinh viên cần:
- mã sinh viên
- họ tên
- năm sinh

nên bảng phải có các cột tương ứng.

---

# 10. DATA TYPE LÀ GÌ?

Mỗi cột trong database phải có kiểu dữ liệu.

Kiểu dữ liệu cho biết:
- dữ liệu được lưu dạng gì

---

# Ví dụ

| Data Type | Ý nghĩa |
|---|---|
| INT | số nguyên |
| VARCHAR | chuỗi |
| DATE | ngày tháng |

---

# Ví dụ thực tế

| Column | Data Type |
|---|---|
| MaSV | VARCHAR |
| HoTen | VARCHAR |
| NamSinh | INT |

---

# Vì sao cần data type?

Ví dụ:

NamSinh:
- phải là số

Nếu nhập:
- "abc"

thì dữ liệu sẽ sai.

Do đó cần quy định kiểu dữ liệu.

---

# 11. SQL LÀ GÌ?

SQL:
viết tắt của Structured Query Language.

Là ngôn ngữ dùng để làm việc với database.

---

# SQL dùng để làm gì?

SQL dùng để:
- tạo database
- tạo bảng
- thêm dữ liệu
- sửa dữ liệu
- xóa dữ liệu
- tìm kiếm dữ liệu

---

# Ví dụ

```sql
CREATE DATABASE QuanLySinhVien;

---

# 7. TABLE LÀ GÌ?

Trong database, dữ liệu được lưu bên trong các bảng.

Các bảng này được gọi là table.

---

# Có thể hiểu table giống như bảng Excel

Ví dụ:

| MaSV | HoTen | NamSinh |
|---|---|---|
| SV01 | Nguyễn Văn A | 2004 |
| SV02 | Trần Thị B | 2003 |

Đây là một table.

---

# Vai trò của table

Table dùng để lưu dữ liệu của một đối tượng cụ thể.

Ví dụ:

| Table | Dùng để lưu |
|---|---|
| SinhVien | dữ liệu sinh viên |
| MonHoc | dữ liệu môn học |
| GiangVien | dữ liệu giảng viên |

---

# Một table chỉ nên lưu một loại dữ liệu

Ví dụ:

Bảng SinhVien:
- chỉ lưu dữ liệu sinh viên

Không nên:

| MaSV | HoTen | TenMonHoc |
|---|---|---|
| SV01 | An | Database |

Vì:
- dữ liệu bị trộn
- khó quản lý
- dễ bị lặp dữ liệu

---

# Ví dụ thực tế

# Sai thiết kế

| MaSV | HoTen | MonHoc1 | MonHoc2 | MonHoc3 |
|---|---|---|---|---|
| SV01 | An | SQL | Java | Python |

Vấn đề:
- nếu học thêm môn thứ 4 thì sao?
- nếu sinh viên khác học ít môn hơn?

---

# Thiết kế tốt hơn

# Bảng SinhVien

| MaSV | HoTen |
|---|---|
| SV01 | An |

---

# Bảng MonHoc

| MaMH | TenMH |
|---|---|
| MH01 | SQL |

---

# Bảng DangKyHoc

| MaSV | MaMH |
|---|---|
| SV01 | MH01 |

---

# Kết luận

Một table:
- chỉ nên lưu một loại dữ liệu
- không nên nhồi nhiều thông tin khác nhau vào cùng bảng

---

# 8. ROW LÀ GÌ?

Row là một dòng dữ liệu trong bảng.

---

# Ví dụ

| MaSV | HoTen | NamSinh |
|---|---|---|
| SV01 | Nguyễn Văn A | 2004 |
| SV02 | Trần Thị B | 2003 |

Trong bảng trên:
- SV01 ... 2004 là một row
- SV02 ... 2003 là một row

---

# Ý nghĩa của row

Thông thường:
- một row đại diện cho một đối tượng thực tế

Ví dụ:

| Table | Một row đại diện cho |
|---|---|
| SinhVien | một sinh viên |
| SanPham | một sản phẩm |
| KhachHang | một khách hàng |

---

# Ví dụ thực tế

# Bảng sản phẩm

| MaSP | TenSP | Gia |
|---|---|---|
| SP01 | Bàn phím | 500000 |

Row trên đại diện cho:
- một sản phẩm cụ thể

---

# Một lỗi phổ biến

# Sai

| MaSV | HoTen |
|---|---|
| SV01, SV02 | An, Bình |

Một row chứa nhiều sinh viên.

---

# Đúng

| MaSV | HoTen |
|---|---|
| SV01 | An |
| SV02 | Bình |

Mỗi row chỉ đại diện cho:
- một đối tượng

---

# 9. COLUMN LÀ GÌ?

Column là cột dữ liệu trong bảng.

---

# Ví dụ

| MaSV | HoTen | NamSinh |
|---|---|---|

Trong bảng trên:
- MaSV là một column
- HoTen là một column
- NamSinh là một column

---

# Vai trò của column

Column dùng để mô tả thông tin của đối tượng.

Ví dụ:

Đối tượng sinh viên cần:
- mã sinh viên
- họ tên
- năm sinh

=> bảng cần các column tương ứng.

---

# Ví dụ khác

# Bảng sản phẩm

| MaSP | TenSP | Gia |
|---|---|---|

Các column:
- MaSP
- TenSP
- Gia

---

# Mỗi column chỉ nên lưu một loại thông tin

# Sai

| ThongTin |
|---|
| SV01 - Nguyễn Văn A - 2004 |

Toàn bộ dữ liệu bị nhét vào một column.

---

# Đúng

| MaSV | HoTen | NamSinh |
|---|---|---|
| SV01 | Nguyễn Văn A | 2004 |

Dữ liệu được tách rõ ràng.

---

# Vì sao phải tách column?

Nếu dữ liệu không tách:
- khó tìm kiếm
- khó xử lý
- khó thống kê

---

# Ví dụ

Nếu muốn:
- tìm sinh viên sinh năm 2004

thì database cần column riêng:
- NamSinh

---

# 10. DATA TYPE LÀ GÌ?

Mỗi column trong database phải có kiểu dữ liệu.

Kiểu dữ liệu cho biết:
- dữ liệu được lưu dưới dạng gì

---

# Ví dụ

| Data Type | Ý nghĩa |
|---|---|
| INT | số nguyên |
| VARCHAR | chuỗi |
| DATE | ngày tháng |
| FLOAT | số thực |

---

# Ví dụ thực tế

| Column | Data Type |
|---|---|
| MaSV | VARCHAR |
| HoTen | VARCHAR |
| NamSinh | INT |

---

# Ví dụ giải thích

```sql
MaSV VARCHAR(10)

```
---

# 15. PRIMARY KEY LÀ GÌ?

Khi dữ liệu ngày càng nhiều:
- cần cách để phân biệt từng dòng dữ liệu

---

# Ví dụ

| MaSV | HoTen |
|---|---|
| SV01 | Nguyễn Văn A |
| SV01 | Trần Văn B |

Trong bảng trên:
- MaSV bị trùng

Vấn đề:
- không biết sinh viên nào là ai
- dữ liệu dễ bị sai

---

# Giải pháp

Mỗi dòng dữ liệu cần:
- một giá trị duy nhất

Giá trị đó gọi là:
Primary Key.

---

# Primary Key là gì?

Primary Key:
là cột dùng để phân biệt từng row trong bảng.

---

# Đặc điểm của Primary Key

Primary Key:
- không được trùng
- không được NULL

---

# Ví dụ đúng

| MaSV | HoTen |
|---|---|
| SV01 | Nguyễn Văn A |
| SV02 | Trần Thị B |

Ở đây:
- MaSV là Primary Key

vì:
- không bị trùng
- mỗi sinh viên có mã riêng

---

# Ví dụ sai

| MaSV | HoTen |
|---|---|
| SV01 | Nguyễn Văn A |
| SV01 | Trần Thị B |

Sai vì:
- Primary Key bị trùng

---

# Ví dụ sai khác

| MaSV | HoTen |
|---|---|
| NULL | Nguyễn Văn A |

Sai vì:
- Primary Key không được NULL

---

# Tại sao cần Primary Key?

Primary Key giúp:
- phân biệt dữ liệu
- tìm kiếm nhanh hơn
- tránh dữ liệu bị trùng

---

# Ví dụ thực tế

| Hệ thống | Primary Key |
|---|---|
| Sinh viên | MaSV |
| Nhân viên | MaNV |
| Sản phẩm | MaSP |
| Khách hàng | MaKH |

---

# Tạo Primary Key trong SQL Server

# Ví dụ

```sql
CREATE TABLE SinhVien (
    MaSV VARCHAR(10) PRIMARY KEY,
    HoTen NVARCHAR(50),
    NamSinh INT
);

```
# 17. RELATIONSHIP LÀ GÌ?

Trong thực tế:
dữ liệu không tồn tại riêng lẻ.

Các dữ liệu thường có liên quan với nhau.

Ví dụ:
- sinh viên thuộc lớp học
- hóa đơn thuộc khách hàng
- sản phẩm thuộc danh mục

Mối liên kết giữa các bảng được gọi là:
Relationship.

---

# Ví dụ thực tế

# Bảng LopHoc

| MaLop | TenLop |
|---|---|
| CNTT1 | Công nghệ thông tin 1 |
| CNTT2 | Công nghệ thông tin 2 |

---

# Bảng SinhVien

| MaSV | HoTen | MaLop |
|---|---|---|
| SV01 | Nguyễn Văn A | CNTT1 |
| SV02 | Trần Thị B | CNTT1 |

---

# Quan sát

Trong bảng SinhVien:
- cột MaLop liên kết tới bảng LopHoc

Điều này cho biết:
- sinh viên thuộc lớp học nào

---

# Tại sao cần relationship?

Nếu không có relationship:
- dữ liệu sẽ bị rời rạc
- khó quản lý
- khó truy vấn

---

# Ví dụ

Giả sử có:
- bảng HoaDon
- bảng KhachHang

Nếu hóa đơn không liên kết khách hàng:
- không biết hóa đơn của ai

---

# Relationship giúp gì?

Relationship giúp:
- liên kết dữ liệu
- tổ chức dữ liệu
- giảm trùng lặp
- dễ quản lý

---

# Trong database có 3 loại relationship phổ biến

- One To One (1-1)
- One To Many (1-N)
- Many To Many (N-N)

---

# 18. ONE TO ONE (1-1)

# Khái niệm

One To One nghĩa là:

- một dữ liệu bên A
- chỉ liên kết với một dữ liệu bên B

và ngược lại.

---

# Ví dụ thực tế

# Một người có một căn cước công dân

| Người | CCCD |
|---|---|
| 1 người | 1 CCCD |

Ngược lại:
- một CCCD chỉ thuộc một người

---

# Ví dụ database

# Bảng NguoiDung

| UserID | HoTen |
|---|---|
| U01 | Nguyễn Văn A |

---

# Bảng CCCD

| CCCD | UserID |
|---|---|
| 012345678 | U01 |

---

# Quan sát

- UserID U01 chỉ có một CCCD
- CCCD 012345678 chỉ thuộc một UserID

=> đây là quan hệ 1-1.

---

# Ví dụ khác

| Hệ thống | Quan hệ 1-1 |
|---|---|
| Công dân | CCCD |
| Người dùng | Hồ sơ cá nhân |
| Xe máy | Biển số |

---

# Đặc điểm của 1-1

Trong quan hệ 1-1:
- dữ liệu hai bảng gắn chặt với nhau
- một bản ghi chỉ có duy nhất một bản ghi liên kết

---

# Quan hệ 1-1 có phổ biến không?

Không phổ biến bằng:
- 1-N

Trong thực tế:
- ít dùng hơn

---

# Vì sao vẫn cần 1-1?

Để:
- tách dữ liệu nhạy cảm
- tách dữ liệu lớn
- quản lý riêng từng phần

---

# Ví dụ

# Bảng NhanVien

| MaNV | HoTen |
|---|---|
| NV01 | Nguyễn Văn A |

---

# Bảng ThongTinLuong

| MaNV | Luong |
|---|---|
| NV01 | 20000000 |

---

# Lý do tách bảng

Không phải ai cũng được xem:
- lương nhân viên

Do đó:
- dữ liệu lương được tách riêng

---

# 19. ONE TO MANY (1-N)

# Khái niệm

One To Many nghĩa là:

- một dữ liệu bên A
- có thể liên kết với nhiều dữ liệu bên B

Nhưng:
- mỗi dữ liệu bên B
- chỉ thuộc về một dữ liệu bên A

---

# Đây là quan hệ phổ biến nhất

Trong database thực tế:
- 1-N xuất hiện rất nhiều

---

# Ví dụ thực tế

# Một lớp có nhiều sinh viên

| Lớp học | Sinh viên |
|---|---|
| CNTT1 | nhiều sinh viên |

Nhưng:
- mỗi sinh viên chỉ thuộc một lớp

---

# Ví dụ database

# Bảng LopHoc

| MaLop | TenLop |
|---|---|
| CNTT1 | Công nghệ thông tin 1 |

---

# Bảng SinhVien

| MaSV | HoTen | MaLop |
|---|---|---|
| SV01 | An | CNTT1 |
| SV02 | Bình | CNTT1 |

---

# Quan sát

Một MaLop:
- xuất hiện nhiều lần trong bảng SinhVien

Điều này nghĩa là:
- một lớp có nhiều sinh viên

---

# Nhưng mỗi sinh viên

chỉ có:
- một MaLop

=> sinh viên chỉ thuộc một lớp.

---

# Đây chính là quan hệ 1-N

| Một lớp | Nhiều sinh viên |
|---|---|

---

# Ví dụ thực tế khác

| Bảng A | Bảng B |
|---|---|
| Một khách hàng | nhiều hóa đơn |
| Một danh mục | nhiều sản phẩm |
| Một giảng viên | nhiều môn học |

---

# Vì sao 1-N quan trọng?

Phần lớn hệ thống thực tế đều sử dụng:
- 1-N

Ví dụ:
- Facebook
- Shopee
- Ngân hàng
- Trường học

đều có rất nhiều quan hệ 1-N.

---

# Foreign Key trong 1-N

Quan hệ 1-N thường được tạo bằng:
Foreign Key.

---

# Ví dụ

# Bảng LopHoc

```sql
CREATE TABLE LopHoc (
    MaLop VARCHAR(10) PRIMARY KEY,
    TenLop NVARCHAR(50)
);

```

# 20. MANY TO MANY (N-N)

# Khái niệm

Many To Many (N-N) nghĩa là:

- nhiều dữ liệu bên A
- liên kết với nhiều dữ liệu bên B

---

# Ví dụ thực tế

# Sinh viên và môn học

Một sinh viên:
- có thể học nhiều môn

Ví dụ:
- SQL
- Java
- Python

---

# Đồng thời

Một môn học:
- cũng có nhiều sinh viên học

Ví dụ:
- môn SQL có:
    - An
    - Bình
    - Cường

---

# Đây chính là quan hệ N-N

| Sinh viên | Môn học |
|---|---|
| 1 sinh viên | nhiều môn |
| 1 môn | nhiều sinh viên |

---

# Minh họa dữ liệu

| SinhVien | MonHoc |
|---|---|
| An | SQL |
| An | Java |
| Bình | SQL |

---

# Quan sát

Sinh viên:
- học nhiều môn

Môn học:
- có nhiều sinh viên

=> đây là Many To Many.

---

# Sai lầm phổ biến

Người mới thường thiết kế như sau:

---

# Thiết kế sai

| MaSV | HoTen | MonHoc1 | MonHoc2 | MonHoc3 |
|---|---|---|---|---|
| SV01 | An | SQL | Java | Python |

---

# Vấn đề của thiết kế này

# 1. Không mở rộng được

Nếu:
- sinh viên học môn thứ 4

thì phải:
- thêm cột mới

---

# 2. Nhiều dữ liệu NULL

Ví dụ:

| MaSV | MonHoc1 | MonHoc2 | MonHoc3 |
|---|---|---|---|
| SV02 | SQL | NULL | NULL |

Lãng phí dữ liệu.

---

# 3. Khó truy vấn

Ví dụ:
- tìm tất cả sinh viên học SQL

sẽ rất khó:
- vì SQL có thể nằm ở MonHoc1
- hoặc MonHoc2
- hoặc MonHoc3

---

# 4. Vi phạm nguyên tắc thiết kế database

Một column:
- chỉ nên lưu một giá trị

Không nên:
- nhét nhiều dữ liệu động vào nhiều cột

---

# Thiết kế đúng cho N-N

Quan hệ N-N cần:
- bảng trung gian

---

# Ví dụ thiết kế đúng

# Bảng SinhVien

| MaSV | HoTen |
|---|---|
| SV01 | An |
| SV02 | Bình |

---

# Bảng MonHoc

| MaMH | TenMH |
|---|---|
| MH01 | SQL |
| MH02 | Java |

---

# Bảng DangKyHoc

| MaSV | MaMH |
|---|---|
| SV01 | MH01 |
| SV01 | MH02 |
| SV02 | MH01 |

---

# Ý nghĩa

# Dòng 1

| SV01 | MH01 |

Nghĩa là:
- sinh viên SV01 học môn MH01

---

# Dòng 2

| SV01 | MH02 |

Nghĩa là:
- sinh viên SV01 học môn Java

---

# Dòng 3

| SV02 | MH01 |

Nghĩa là:
- sinh viên SV02 học môn SQL

---

# Vai trò của bảng trung gian

Bảng DangKyHoc dùng để:
- liên kết sinh viên và môn học

---

# Vì sao cần bảng trung gian?

Database quan hệ:
- không lưu trực tiếp quan hệ N-N

Do đó:
- phải tách thành 2 quan hệ 1-N

---

# Minh họa

# Sai

```text
SinhVien <---> MonHoc


