# Java Stream API Demo

Gói này minh họa cách sử dụng **Stream API** trong Java để xử lý tập hợp dữ liệu một cách hiệu quả và ngắn gọn.

## Các khái niệm chính được minh họa:

1.  **Filtering**: Lọc các phần tử dựa trên một điều kiện (ví dụ: `price > 300`).
2.  **Mapping**: Chuyển đổi các phần tử từ dạng này sang dạng khác (ví dụ: từ `Product` sang `String` là tên sản phẩm).
3.  **Sorting**: Sắp xếp các phần tử (ví dụ: theo giá giảm dần).
4.  **Terminal Operations**: Các thao tác kết thúc như `count()`, `anyMatch()`, `min()`, `max()`.
5.  **Collectors**: Thu thập kết quả vào `List`, `Map` hoặc nhóm dữ liệu bằng `groupingBy`.
6.  **Numeric Streams**: Sử dụng `IntStream`, `DoubleStream` cho các phép toán số học (`sum()`, `average()`).
7.  **Reduce**: Kết hợp các phần tử của stream thành một kết quả duy nhất.

## Cách chạy demo:

```bash
javac com/demo/stream/Product.java com/demo/stream/StreamDemo.java
java com.demo.stream.StreamDemo
```
