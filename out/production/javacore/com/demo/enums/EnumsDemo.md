# Java Enums Demo

Gói này minh họa cách sử dụng **Enum** (Enumeration) trong Java để định nghĩa một tập hợp các hằng số cố định, giúp mã nguồn rõ ràng và an toàn hơn.

## Các khái niệm chính được minh họa:

1.  **Basic Enum**: Cách khai báo và sử dụng các hằng số đơn giản.
2.  **Enum với Fields & Methods**: Thêm các thuộc tính (fields) và phương thức (methods) vào Enum (ví dụ: `description` trong `OrderStatus`).
3.  **Enum Constructor**: Cách sử dụng constructor (luôn là private) để khởi tạo giá trị cho các thuộc tính của hằng số.
4.  **Enum in Switch**: Sử dụng Enum như một điều kiện trong câu lệnh `switch`.
5.  **Iteration**: Sử dụng phương thức `values()` để duyệt qua tất cả các hằng số trong Enum.

## Lợi ích của Enum:
- **Type Safety**: Đảm bảo biến chỉ có thể nhận một trong các giá trị đã được định nghĩa trước.
- **Readability**: Làm cho mã nguồn dễ đọc và dễ hiểu hơn so với việc sử dụng các hằng số `int` hoặc `String`.
- **Namespace**: Các hằng số Enum nằm trong namespace của chính nó.
- **Singleton**: Mỗi hằng số Enum là một thực thể duy nhất (instance) của lớp Enum đó.

## Cách chạy demo:

```powershell
javac com/demo/enums/OrderStatus.java com/demo/enums/EnumDemo.java
java com.demo.enums.EnumDemo
```
