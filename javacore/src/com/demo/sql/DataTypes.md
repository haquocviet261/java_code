# 📊 BUỔI 2: DATA TYPES - CHỌN SAO CHO ĐÚNG?
## Tối ưu hóa dung lượng & Hiệu năng từ những byte đầu tiên

---

# 🕒 AGENDA
1. **WHY:** Tại sao chọn sai kiểu dữ liệu là "tự sát" trong Production?
2. **Numeric:** Khi nào dùng INT, khi nào dùng DECIMAL?
3. **String:** Cuộc chiến giữa VARCHAR và NVARCHAR.
4. **DateTime:** Đừng dùng DATETIME nữa, hãy dùng DATETIME2.
5. **Best Practices:** Quy tắc "Vừa đủ" và chọn Primary Key.
---

# 1. TẠI SAO PHẢI CẨN THẬN? ⚠️
### "Database không phải là cái túi không đáy"

*   **Analogy:** Bạn đi mua giày. 
    *   Chân size 40 nhưng mua giày size 45 => Lỏng lẻo, dễ ngã (Tốn RAM, tốn Disk).
    *   Chân size 40 nhưng mua giày size 35 => Đau chân, không đi được (Lỗi Overflow).
*   **Production Insight:** Một bảng có 1 tỷ dòng, mỗi dòng bạn dư 1 byte => Bạn mất **1GB** vô ích trên cả Disk và RAM.

---

# 2. KIỂU SỐ (NUMERIC) 🔢
| Kiểu dữ liệu | Dung lượng | Phạm vi | Ứng dụng |
| :--- | :--- | :--- | :--- |
| **BIT** | 1 bit | 0 hoặc 1 | Trạng thái IsActive, IsDeleted |
| **TINYINT** | 1 byte | 0 - 255 | Tuổi người, trạng thái Order (0-5) |
| **INT** | 4 bytes | +/- 2 tỷ | ID người dùng, số lượng kho |
| **BIGINT** | 8 bytes | Vô cùng lớn | Transaction ID ngân hàng, Log ID |

> **🔥 Best Practice:** Luôn chọn kiểu nhỏ nhất có thể. Đừng dùng `BIGINT` cho cột "Tuổi học sinh".

---

# 3. KIỂU CHUỖI (STRING) 📝
### "N" có nghĩa là gì?

*   **CHAR(n):** Độ dài cố định. (Dùng cho Mã vùng, Mã quốc gia - ISO Code).
*   **VARCHAR(n):** Độ dài biến đổi. Tiết kiệm không gian.
*   **NVARCHAR(n):** Hỗ trợ Unicode (Tiếng Việt có dấu). **Tốn gấp đôi dung lượng (2 bytes/char)** so với VARCHAR.

| Case | Nên dùng | Tại sao? |
| :--- | :--- | :--- |
| Số điện thoại | `VARCHAR(15)` | Không cần tiếng Việt, độ dài thay đổi ít. |
| Tên người | `NVARCHAR(100)` | Cần lưu "Nguyễn Văn A". |
| Username | `VARCHAR(50)` | Thường chỉ dùng ký tự Latin. |

---

# 4. NGÀY THÁNG (DATETIME) 📅
### "Sai lầm 10 năm của Dev"

*   ❌ **DATETIME:** Độ chính xác thấp (3.33ms), phạm vi từ năm 1753.
*   ✅ **DATETIME2:** Độ chính xác cực cao (100ns), phạm vi từ năm 0001, tiết kiệm dung lượng hơn.
*   ✅ **DATETIMEOFFSET:** Bắt buộc dùng cho ứng dụng đa quốc gia (Lưu kèm múi giờ).

---

# 5. BEST PRACTICES & COMMON MISTAKES
*   **Quy tắc "Vừa đủ":** Đừng `NVARCHAR(MAX)` cho mọi cột. Nó sẽ giết chết hiệu năng của Index.
*   **Primary Key:** 
    *   Dùng `INT IDENTITY` hoặc `BIGINT`: Nhanh, nhẹ, dễ quản lý.
    *   Dùng `GUID (Uniqueidentifier)`: Tốt cho hệ thống phân tán nhưng gây phân mảnh Index (Fragmentation) rất nặng.
*   **Tiền tệ:** Luôn dùng `DECIMAL(18, 2)`. **KHÔNG BAO GIỜ** dùng `FLOAT` cho tiền vì sai số làm tròn.

---

# 📝 MINI EXERCISE
**Câu hỏi:** Bạn thiết kế bảng "Sách", cột "Mã ISBN" (13 ký tự số) và cột "Mô tả nội dung" (có thể rất dài, có tiếng Việt). Bạn chọn kiểu dữ liệu gì cho 2 cột này?

---
