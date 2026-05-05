# Java Input/Output (I/O)

## 1. Giới thiệu về Java I/O
Java I/O (Input và Output) được sử dụng để xử lý đầu vào và tạo ra đầu ra. Java sử dụng khái niệm **Streams (Luồng)** để giúp các thao tác I/O trở nên nhanh chóng và hiệu quả. Một stream là một chuỗi dữ liệu.

Trong Java, có hai loại stream cơ bản:
- **Input Stream:** Đọc dữ liệu từ một nguồn (source).
- **Output Stream:** Ghi dữ liệu đến một đích (destination).

---

## 2. Lớp `File`: Quản lý Metadata
Lớp `File` không dùng để đọc/ghi nội dung mà dùng để quản lý thông tin về tệp tin và thư mục (metadata).
- **Lưu ý quan trọng:** Một đối tượng `File` đại diện cho một đường dẫn (path), không phải nội dung thực tế của tệp.
- **Các thao tác phổ biến:** `exists()`, `createNewFile()`, `mkdir()`, `length()`, `delete()`.
- **Demo:** Xem `FileDemo.java`.

---

## 3. Byte Streams vs. Character Streams

### 3.1. Byte Streams (`InputStream`, `OutputStream`)
- **Đơn vị:** Byte 8-bit.
- **Trường hợp sử dụng:** Tốt nhất cho dữ liệu nhị phân như hình ảnh, âm thanh, video hoặc bất kỳ tệp nào mà bạn không muốn Java "tự ý giải mã" dữ liệu.
- **Các lớp cốt lõi:** `FileInputStream`, `FileOutputStream`.
- **Demo:** Xem `ByteStreamDemo.java`.

### 3.2. Character Streams (`Reader`, `Writer`)
- **Đơn vị:** Ký tự Unicode 16-bit.
- **Trường hợp sử dụng:** Tốt nhất cho dữ liệu văn bản (text). Nó tự động xử lý việc mã hóa ký tự (như UTF-8).
- **Các lớp cốt lõi:** `FileReader`, `FileWriter`.
- **Demo:** Xem `CharacterStreamDemo.java`.

---

## 4. Tăng hiệu suất với Buffered Streams
Việc đọc/ghi trực tiếp từ đĩa cứng rất tốn kém tài nguyên. Buffered streams cung cấp một bộ nhớ đệm (buffer) để lưu trữ dữ liệu tạm thời, giúp giảm số lượng thao tác truy xuất đĩa.
- **Cơ chế:** Nó đọc một khối dữ liệu lớn vào bộ nhớ cùng một lúc.
- **Mô hình Wrapper:** Bạn bao bọc một stream cấp thấp (như `FileReader`) bên trong một `BufferedReader`.
- **Demo:** Xem `BufferedStreamDemo.java`.

---

## 5. Object Serialization (Tuần tự hóa đối tượng)
Serialization là quá trình chuyển đổi trạng thái của một đối tượng thành một chuỗi byte để có thể lưu vào tệp hoặc gửi qua mạng.
- **Interface `Serializable`:** Một marker interface (không có phương thức). Nếu một lớp không implement nó, đối tượng của lớp đó không thể được serialized.
- **`serialVersionUID`:** Dùng để kiểm soát phiên bản của lớp.
- **Từ khóa `transient`:** Các trường được đánh dấu `transient` sẽ bị bỏ qua trong quá trình serialization (hữu ích cho dữ liệu nhạy cảm như mật khẩu).
- **Demo:** Xem `SerializationDemo.java`.

---

## 6. Các quy tắc tốt nhất (Best Practices) trong Java I/O
1.  **Luôn đóng Stream:** Sử dụng **Try-with-Resources** (từ Java 7) để đảm bảo các stream được đóng tự động, tránh rò rỉ bộ nhớ (memory leak).
2.  **Sử dụng Buffering:** Luôn sử dụng `BufferedReader`/`BufferedWriter` cho các tệp văn bản để cải thiện hiệu suất.
3.  **Chọn đúng loại Stream:** Không dùng Character Streams cho hình ảnh; không dùng Byte Streams cho văn bản nếu bạn quan tâm đến vấn đề mã hóa (encoding).
4.  **Xử lý ngoại lệ:** Các thao tác IO rất dễ gây ra `IOException`. Luôn sử dụng cơ chế xử lý lỗi phù hợp.

---

## Bài tập thực hành
1.  **Chạy `FileDemo`**: Quan sát cách các tệp được tạo và metadata được in ra.
2.  **So sánh Byte vs. Char**: Thử ghi các ký tự tiếng Việt (như 'á', 'ờ', 'đ') bằng `ByteStreamDemo` và `CharacterStreamDemo`. Xem cái nào hiển thị đúng trong tệp tin.
3.  **Kiểm tra hiệu suất**: Tạo một tệp lớn (1MB+) và so sánh thời gian sao chép tệp khi dùng `FileInputStream` so với `BufferedInputStream`.
