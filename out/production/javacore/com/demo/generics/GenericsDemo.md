# Java Generics Demo

Gói này minh họa cách sử dụng **Generics** trong Java để viết mã linh hoạt, có thể tái sử dụng và an toàn về kiểu dữ liệu (Type-safe).

## Các khái niệm chính được minh họa:

1.  **Generic Class**: Sử dụng các tham số kiểu (type parameters) cho lớp (ví dụ: `Box<T>`).
2.  **Generic Method**: Phương thức có tham số kiểu riêng biệt, độc lập với lớp.
3.  **Bounded Type Parameters**: Giới hạn kiểu dữ liệu mà tham số kiểu có thể chấp nhận (ví dụ: `<T extends Number>`).
4.  **Wildcards**:
    *   **Unbounded Wildcard (`?`)**: Chấp nhận bất kỳ kiểu nào.
    *   **Upper Bounded Wildcard (`? extends T`)**: Chấp nhận kiểu `T` hoặc các lớp con của nó.
    *   **Lower Bounded Wildcard (`? super T`)**: Chấp nhận kiểu `T` hoặc các lớp cha của nó.

## Lợi ích của Generics:
- **Type safety**: Kiểm tra lỗi kiểu dữ liệu ngay tại thời điểm biên dịch (compile-time).
- **Elimination of casts**: Loại bỏ việc ép kiểu (casting) thủ công.
- **Generic algorithms**: Cho phép thực hiện các thuật toán trên nhiều kiểu dữ liệu khác nhau.

## Cách chạy demo:

```bash
javac com/demo/generics/Box.java com/demo/generics/GenericDemo.java
java com.demo.generics.GenericDemo
```
