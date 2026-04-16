# 🧪 JAVA CORE EXERCISE
## 🎯 Topic: Inheritance & Polymorphism

---

# 📌 Bối cảnh

Bạn đang xây dựng hệ thống thanh toán cho một website thương mại điện tử.

Hệ thống cần hỗ trợ nhiều phương thức thanh toán khác nhau:
- 💵 Cash (tiền mặt)
- 💳 Card (thẻ ngân hàng)
- 📱 Momo (ví điện tử)

Mỗi phương thức thanh toán sẽ có cách xử lý riêng nhưng đều tuân theo một chuẩn chung.

---

# 🎯 MỤC TIÊU BÀI TẬP

Sau bài này, các bạn cần hiểu rõ:
- Inheritance (kế thừa)
- Polymorphism (đa hình)
- Abstract class
- Method overriding
- Tránh sử dụng if-else để phân loại logic

---

# 🧩 YÊU CẦU 1 – THIẾT KẾ CLASS

---

## 1. Tạo abstract class `Payment`

### Thuộc tính:
- `amount` (double): số tiền thanh toán

### Constructor:
- Nhận vào `amount`

### Method:
- `pay()` → abstract method
- `getPaymentType()` → trả về tên loại thanh toán

---

## 2. Tạo các class con kế thừa `Payment`

Tạo 3 class:

- `CashPayment`
- `CardPayment`
- `MomoPayment`

### Yêu cầu:
- Kế thừa từ `Payment`
- Override 2 method:
    - `pay()`
    - `getPaymentType()`

---

## 💡 LOGIC TỪNG CLASS

### 💵 CashPayment
```plaintext
Processing Cash Payment...
Paid {amount} using Cash