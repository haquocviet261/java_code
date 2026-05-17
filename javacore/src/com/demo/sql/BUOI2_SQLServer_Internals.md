# 🏗️ BUỔI 2: SQL QUERYING DEEP DIVE

## Từ “biết SQL” → “giải quyết business problem bằng SQL”

**Speaker:** Senior SQL Server Engineer / Backend Architect
**Database:** Northwind
**Mục tiêu:** Có thể viết query thực chiến để phân tích dữ liệu và phục vụ business requirement.

---

## TRIẾT LÝ CỦA BUỔI NÀY

SQL KHÔNG PHẢI chỉ để học syntax.

SQL LÀ dùng dữ liệu để trả lời câu hỏi business.

---

## Ví dụ thực tế

Business hỏi:

- Top khách hàng mua nhiều nhất?
- Sản phẩm nào bán chạy?
- Nhân viên nào tạo nhiều doanh thu nhất?
- Đơn hàng nào chưa ship?
- Quốc gia nào đem lại nhiều tiền nhất?

=> tất cả đều là SQL.

---

## TƯ DUY SAI CỦA NGƯỜI MỚI

Nhiều người học SQL theo kiểu chỉ nhớ syntax và không biết áp dụng vào dữ liệu thực tế.

Sai:

```sql
SELECT column1, column2
FROM table;
```

Hậu quả: không biết phân tích dữ liệu, không biết JOIN, không biết aggregate.

## TƯ DUY ĐÚNG

Khi gặp vấn đề, làm theo các bước:

1. Xác định: dữ liệu nằm ở bảng nào?
2. Xác định: liên kết bảng bằng khóa nào?
3. Xác định: cần filter gì?
4. Xác định: cần aggregate không?

---

## AGENDA

- SELECT & Filtering
- ORDER BY / TOP / DISTINCT
- Alias & CASE WHEN
- JOINs
- Aggregate Functions
- GROUP BY & HAVING
- Subquery
- CTE
- Mini Challenges
- Production Insights

---

## 🗂️ NORTHWIND DATABASE OVERVIEW

Northwind là database kinh điển của Microsoft.

Các bảng quan trọng:

- `Customers` — Khách hàng
- `Orders` — Đơn hàng
- `Order Details` — Chi tiết đơn hàng
- `Products` — Sản phẩm
- `Categories` — Danh mục
- `Employees` — Nhân viên
- `Suppliers` — Nhà cung cấp
- `Shippers` — Đơn vị vận chuyển

Quan hệ chính:

Customers → Orders → Order Details → Products → Categories

---

## 1. SELECT & FILTERING 

`SELECT` dùng để lấy dữ liệu từ database.

Ví dụ cơ bản:

```sql
SELECT * FROM Customers;
```

⚠️ Production KHÔNG nên dùng `SELECT *` vì đọc dư dữ liệu, tăng network traffic, tăng memory usage và khó tối ưu index. Thay vào đó chỉ chọn cột cần dùng:

```sql
SELECT CustomerID, CompanyName, Country
FROM Customers
WHERE Country = 'Germany';
```

### Bài tập

1. Lấy `ProductName`, `UnitPrice` từ bảng `Products`.
2. Lấy khách hàng ở `Germany` và `France`.
3. Lấy sản phẩm có giá > 50.
4. Lấy khách hàng có tên bắt đầu bằng 'B'.

---

## 2. ORDER BY / TOP / DISTINCT 

`ORDER BY` để sắp xếp kết quả. `ASC` tăng dần, `DESC` giảm dần.

Ví dụ: top sản phẩm đắt nhất:

```sql
SELECT ProductName, UnitPrice
FROM Products
ORDER BY UnitPrice DESC;
```

`TOP` lấy N hàng đầu:

```sql
SELECT TOP 5 ProductName, UnitPrice
FROM Products
ORDER BY UnitPrice DESC;
```

`DISTINCT` loại bỏ duplicate, nhưng không phải là cách sửa lỗi join sai — tránh lạm dụng.

### Bài tập

1. Lấy 10 sản phẩm rẻ nhất.
2. Lấy danh sách quốc gia unique.
3. Lấy 5 đơn hàng mới nhất.

---

## 3. ALIAS & CASE WHEN 🏷️

Alias giúp đặt tên cột/ bảng dễ đọc:

```sql
SELECT ProductName AS Product, UnitPrice AS Price
FROM Products;
```

`CASE WHEN` tương tự `if-else`:

```sql
SELECT ProductName, UnitPrice,
    CASE
        WHEN UnitPrice >= 100 THEN 'Expensive'
        WHEN UnitPrice >= 50 THEN 'Medium'
        ELSE 'Cheap'
    END AS PriceCategory
FROM Products;
```

Business use: reporting, dashboards, BI.

### Bài tập

1. Phân loại sản phẩm: `UnitPrice >= 50` = High, else Low.
2. Hiển thị `In Stock` / `Out of Stock` dựa vào `UnitsInStock`.

---

## 4. JOINs 🔗

JOIN là phần quan trọng nhất — dữ liệu thực tế thường nằm trên nhiều bảng.

Ví dụ lấy thông tin order kèm tên khách hàng:

```sql
SELECT o.OrderID, c.CompanyName, o.OrderDate
FROM Orders o
INNER JOIN Customers c ON o.CustomerID = c.CustomerID;
```

LEFT JOIN lấy tất cả bên trái kể cả không có match (useful để tìm khách hàng chưa order):

```sql
SELECT c.CustomerID, c.CompanyName
FROM Customers c
LEFT JOIN Orders o ON c.CustomerID = o.CustomerID
WHERE o.OrderID IS NULL;
```

⚠️ Luôn viết `ON` cho JOIN để tránh Cartesian product.

### Bài tập

1. Hiển thị `OrderID`, `Customer Name`, `OrderDate`.
2. Hiển thị `ProductName`, `CategoryName`.
3. Tìm khách hàng chưa từng order.
4. Hiển thị `CustomerName`, `ProductName`, `Quantity`.

---

## 5. AGGREGATE FUNCTIONS 

Aggregate thực hiện tính toán trên nhiều rows: `COUNT`, `SUM`, `AVG`, `MAX`, `MIN`.

Ví dụ đếm khách hàng:

```sql
SELECT COUNT(*) AS TotalCustomers FROM Customers;
```

Tổng doanh thu:

```sql
SELECT SUM(UnitPrice * Quantity) AS Revenue FROM [Order Details];
```

⚠️ `COUNT(*)` đếm rows, `COUNT(column)` bỏ NULL.

### Bài tập

1. Đếm tổng số products.
2. Tìm giá cao nhất.
3. Tính average `UnitPrice`.

---

## 6. GROUP BY & HAVING 📊

`GROUP BY` gom dữ liệu theo nhóm; `HAVING` lọc sau khi aggregate.

Ví dụ tổng số đơn hàng theo customer:

```sql
SELECT CustomerID, COUNT(*) AS TotalOrders
FROM Orders
GROUP BY CustomerID
HAVING COUNT(*) > 10;
```

`WHERE` filter trước aggregate; `HAVING` filter sau aggregate.

⚠️ Mọi cột trong SELECT phải nằm trong GROUP BY hoặc là aggregate.

### Bài tập

1. Đếm số orders theo customer.
2. Tính doanh thu theo product.
3. Top 5 khách hàng có nhiều orders nhất.
4. Tìm category có doanh thu > 10,000.

---

## 7. SUBQUERY 🧩

Subquery là query bên trong query. Ví dụ tìm orders có freight lớn hơn trung bình:

```sql
SELECT * FROM Orders
WHERE Freight > (SELECT AVG(Freight) FROM Orders);
```

Hoặc dùng `IN`:

```sql
SELECT * FROM Customers
WHERE CustomerID IN (SELECT CustomerID FROM Orders);
```

Subquery đôi khi dễ đọc nhưng không luôn performant.

### Bài tập

1. Tìm sản phẩm giá cao hơn average price.
2. Tìm khách hàng từng order.
3. Tìm sản phẩm chưa từng được order.

---

## 8. CTE (COMMON TABLE EXPRESSIONS) 

CTE giúp chia logic, làm query dễ đọc:

```sql
WITH SalesCTE AS (
    SELECT CustomerID, SUM(Freight) AS TotalFreight
    FROM Orders
    GROUP BY CustomerID
)
SELECT * FROM SalesCTE;
```

CTE hữu dụng cho reporting, analytics, ETL.

### Bài tập

1. Viết CTE tính tổng order theo customer.
2. Dùng CTE lấy top 5 customers.

---

## 9. PRODUCTION INSIGHTS 

mindset ❌: “SQL chỉ là syntax.”

mindset ✅: SQL là data analysis, business logic, backend foundation, reporting engine.

Query tốt cần: đúng logic, dễ đọc, maintainable, performant.

Common Production Mistakes:

- `SELECT *` everywhere
- JOIN thiếu điều kiện
- Dùng `DISTINCT` để che duplicate
- Không hiểu GROUP BY
- Subquery lồng quá sâu
- Không alias
- Không format SQL

### SQL STYLE GUIDE

GOOD:

```sql
SELECT c.CompanyName, COUNT(*) AS TotalOrders
FROM Customers c
INNER JOIN Orders o ON c.CustomerID = o.CustomerID
GROUP BY c.CompanyName;
```

BAD:

```sql
select * from customers c join orders o on c.customerid=o.customerid
```

---



---

**Senior SQL Instructor:** “Good SQL engineers don’t memorize syntax. They solve business problems with data.”
