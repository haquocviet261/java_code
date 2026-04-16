# 🧪 JAVA CORE EXERCISE
## 🎯 Topic: Inheritance & Polymorphism

---

## 📌 Bối cảnh

Bạn đang xây dựng hệ thống thanh toán cho một website thương mại điện tử.

Hệ thống cần hỗ trợ nhiều loại thanh toán:
- Cash (tiền mặt)
- Card (thẻ)
- Momo (ví điện tử)

---

## 🧩 YÊU CẦU 1 – THIẾT KẾ CLASS

### 1. Tạo class cha: `Payment`

**Thuộc tính:**
- `amount` (double)

**Constructor:**
- Nhận `amount`

**Method:**
- `pay()` (abstract)

---

### 2. Tạo các class con:

- `CashPayment`
- `CardPayment`
- `MomoPayment`

**Yêu cầu:**
- Kế thừa từ `Payment`
- Override method `pay()`
- In ra nội dung phù hợp với từng loại thanh toán

---

## 🧪 YÊU CẦU 2 – TEST

Tạo class `Main` để test:

- Tạo 3 object tương ứng với 3 loại payment
- Gọi method `pay()` của từng object

---

## 🖥️ VÍ DỤ OUTPUT MONG MUỐN

```plaintext
Processing Cash Payment...
Paid 100.0 using Cash

Processing Card Payment...
Paid 250.0 using Card

Processing Momo Payment...
Paid 500.0 using Momo