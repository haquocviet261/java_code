# ⌨️ BUỔI 4: SQL COMMANDS CLASSIFICATION
## Làm chủ 4 nhóm ngôn ngữ cốt lõi trong SQL Server

**Speaker:** Senior SQL Server Engineer / Technical Instructor
**Mục tiêu:** Hiểu rõ bản chất và cách dùng DDL, DML, DQL, DCL. Đảm bảo an toàn dữ liệu trong Production.

---
1. **The Big Picture:** 4 nhóm lệnh chính.
2. **DDL:** Xây dựng khung xương (Structure).
3. **DML:** Thao tác nội dung (Data).
4. **DQL:** Nghệ thuật truy vấn (Query).
5. **DCL:** Bảo vệ tài sản (Security).
6. **Best Practices:** Giao dịch an toàn & Những "nút bấm" nguy hiểm.

---

# 1. CÁI NHÌN TỔNG QUAN (THE BIG PICTURE) 🖼️

Hãy tưởng tượng bạn đang quản lý một **Thư viện**:
*   **DDL:** Xây thêm kệ sách, sửa thiết kế phòng đọc.
*   **DML:** Thêm sách mới, sửa thông tin sách, bỏ sách rách.
*   **DQL:** Tìm xem cuốn sách "SQL 101" nằm ở đâu.
*   **DCL:** Cấp thẻ thủ kho, cấm người lạ vào kho lưu trữ.

---

# 2. DDL (DATA DEFINITION LANGUAGE) - ĐỊNH NGHĨA 🏗️
### "Xây nhà trước, ở sau"

| Lệnh | Ý nghĩa | Production Insight |
| :--- | :--- | :--- |
| **CREATE** | Tạo mới Table, View, Index. | Luôn check `IF NOT EXISTS` trước khi chạy script. |
| **ALTER** | Sửa cấu trúc (Thêm/Sửa/Xóa cột). | Cẩn thận khi ALTER cột có hàng triệu dòng (Gây treo DB). |
| **DROP** | Xóa sạch cả cấu trúc và dữ liệu. | **CỰC NGUY HIỂM.** Lệnh này không thể Rollback dễ dàng. |
| **TRUNCATE** | Xóa sạch dữ liệu, giữ lại khung. | Nhanh hơn DELETE vì không ghi log chi tiết từng dòng. |

> **Analogy:** `DROP` là phá hủy cả tòa nhà. `TRUNCATE` là dọn sạch đồ đạc nhưng giữ lại cái vỏ nhà.

---

# 3. DML (DATA MANIPULATION LANGUAGE) - THAO TÁC ✍️
### "Dữ liệu là dòng chảy"

*   **INSERT:** Thêm dòng mới.
*   **UPDATE:** Sửa dữ liệu hiện có.
*   **DELETE:** Xóa dòng dữ liệu.
*   **MERGE:** "2 trong 1" - Nếu có thì Update, chưa có thì Insert.

### 🚩 CẢNH BÁO ĐỎ (DANGER ZONE):
**LUÔN LUÔN** dùng `WHERE` khi chạy `UPDATE` hoặc `DELETE`.
```sql
-- SAI LẦM CHẾT NGƯỜI: Cập nhật giá toàn bộ sản phẩm về 0
UPDATE Products SET Price = 0; 

-- ĐÚNG: Chỉ cập nhật sản phẩm cụ thể
UPDATE Products SET Price = 100 WHERE Id = 5;
```

---

# 4. DQL (DATA QUERY LANGUAGE) - TRUY VẤN 🔍
### "Lấy đúng, lấy đủ, lấy nhanh"

DQL chỉ có một lệnh duy nhất nhưng là lệnh quan trọng nhất: **SELECT**.

**Thứ tự thực thi của SQL Server (Khác với thứ tự viết):**
1. `FROM`: Lấy ở đâu?
2. `WHERE`: Lọc điều kiện gì?
3. `GROUP BY`: Nhóm lại theo cái gì?
4. `HAVING`: Lọc sau khi nhóm?
5. `SELECT`: Lấy cột nào?
6. `ORDER BY`: Sắp xếp thế nào?

> **Production Insight:** Đừng bao giờ dùng `SELECT *` trong code Backend. Hãy liệt kê rõ tên cột để giảm tải cho băng thông mạng và tận dụng Index.

---

# 5. DCL (DATA CONTROL LANGUAGE) - KIỂM SOÁT 🔑
### "Ai có quyền làm gì?"

*   **GRANT:** Cấp quyền (Đọc/Ghi/Xóa).
*   **REVOKE:** Thu hồi quyền đã cấp.
*   **DENY:** Cấm tuyệt đối (Quyền này cao hơn cả GRANT).

**Ví dụ thực tế:**
```sql
-- Cấp quyền chỉ được READ cho user 'StaffApp'
GRANT SELECT ON Orders TO StaffApp;

-- Cấm user 'Intern' xóa dữ liệu
DENY DELETE ON Users TO Intern;
```

---

### 💎 Sự khác biệt giữa DELETE và TRUNCATE
| Tính năng | DELETE | TRUNCATE |
| :--- | :--- | :--- |
| **Tốc độ** | Chậm (Ghi log từng dòng) | Cực nhanh (Ghi log trang) |
| **Điều kiện** | Dùng được `WHERE` | Không dùng được `WHERE` |
| **Identity** | Giữ nguyên ID tiếp theo | Reset ID về giá trị ban đầu |
| **Trigger** | Kích hoạt Trigger | Không kích hoạt Trigger |

---

# 📝 MINI EXERCISE
1. Bạn muốn xóa toàn bộ dữ liệu bảng `Logs` (10 triệu dòng) để giải phóng dung lượng nhanh nhất. Bạn dùng lệnh nào?
2. Phân biệt `DROP TABLE` và `DELETE FROM TABLE`.
3. Viết một lệnh `GRANT` cấp quyền `UPDATE` trên bảng `Products` cho một Role tên là `MarketingTeam`.

---
*Senior SQL Instructor - Precision is the key to data integrity.*
