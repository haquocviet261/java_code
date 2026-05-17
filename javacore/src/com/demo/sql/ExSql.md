# 📝 NORTHWIND SQL PRACTICE LABS
# Thực chiến Querying với Northwind Database

---

#MỤC TIÊU

Sau phần bài tập này, moin người sẽ:
- quen tay viết SQL
- hiểu cách JOIN dữ liệu
- hiểu business mindset
- tăng tốc debugging
- học cách đọc schema

---

# 📌 QUY TẮC

❌ Không dùng AI để solve ngay  
❌ Không copy paste StackOverflow 
✅ Tự đọc schema  
✅ Tự thử query  
✅ Sai cũng được, miễn là hiểu

---

# 🟢 PHẦN 1 — BÀI TẬP CƠ BẢN

---

# Bài 1 — Khách hàng từ Germany 🇩🇪

Hiển thị:
- CustomerID
- CompanyName
- ContactName
- Country

Chỉ lấy:
- khách hàng ở Germany.

Sắp xếp:
- theo CompanyName tăng dần.

---

# Bài 2 — Top sản phẩm đắt nhất 

Hiển thị:
- ProductName
- UnitPrice
- UnitsInStock

Lấy:
- top 10 sản phẩm giá cao nhất.

---

# Bài 3 — Đơn hàng chưa ship 

Hiển thị:
- OrderID
- CustomerID
- OrderDate
- ShippedDate

Chỉ lấy:
- orders chưa được ship.

---

# Bài 4 — Danh sách sản phẩm và category 

Hiển thị:
- ProductName
- CategoryName
- UnitPrice

Yêu cầu:
- JOIN Products và Categories.

---

# Bài 5 — Tổng số đơn hàng theo khách hàng 

Hiển thị:
- CustomerID
- TotalOrders

Yêu cầu:
- dùng GROUP BY.

Sắp xếp:
- nhiều orders nhất trước.

---

# PHẦN 2 — BÀI TẬP HƠI KHÓ

---

# Bài 6 — Top khách hàng đem lại nhiều doanh thu nhất 🔥

Hiển thị:
- CompanyName
- TotalRevenue

Cách tính revenue:

```text id="7h0j01"
UnitPrice * Quantity * (1 - Discount)