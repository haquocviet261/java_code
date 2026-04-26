# Java Threads Deep Dive Demo

Gói này cung cấp một cái nhìn sâu sắc về lập trình đa luồng (Multi-threading) trong Java, từ các khái niệm cơ bản đến các kỹ thuật quản lý luồng nâng cao.

## Các nội dung chính:

### 1. Cơ bản về Thread (`ThreadBasicsDemo.java`)
- **Extending Thread class**: Kế thừa trực tiếp lớp `Thread`.
- **Implementing Runnable**: Triển khai interface `Runnable` (Cách được khuyến khích vì tính linh hoạt).
- **Lambda Expression**: Cách tạo luồng ngắn gọn trong Java hiện đại.
- **join()**: Đợi một luồng kết thúc trước khi tiếp tục luồng hiện tại.

### 2. Đồng bộ hóa (`ThreadSynchronizationDemo.java`)
- **Race Condition**: Vấn đề khi nhiều luồng cùng truy cập và sửa đổi dữ liệu chung.
- **Synchronized**: Sử dụng từ khóa `synchronized` để khóa (lock) phương thức, đảm bảo chỉ một luồng truy cập tại một thời điểm.
- **Atomic Variables**: Sử dụng các lớp trong gói `java.util.concurrent.atomic` (như `AtomicInteger`) để thực hiện các thao tác nguyên tử mà không cần dùng khóa (lock-free), giúp tăng hiệu năng.
- **ReentrantLock** (`LockVisualizationDemo.java`): Trực quan hóa cách nhiều luồng tranh giành và lấy/nhả (acquire/release) khóa cho một tài nguyên chung (ví dụ: máy in). Cung cấp khả năng kiểm soát linh hoạt hơn so với `synchronized`.
- **Deadlock** (`DeadlockDemo.java`): Trực quan hóa tình trạng "bế tắc" khi hai hoặc nhiều luồng đợi nhau giải phóng tài nguyên mãi mãi, khiến ứng dụng bị treo.

### 3. Thread Pool & Executor Service (`ExecutorServiceDemo.java`)
- **ExecutorService**: Cách quản lý tập hợp các luồng (Thread Pool) một cách hiệu quả.
- **FixedThreadPool**: Giới hạn số lượng luồng hoạt động đồng thời.
- **Graceful Shutdown**: Cách đóng Executor một cách an toàn.

### 4. Vòng đời của Thread (`ThreadLifecycleDemo.java`)
Minh họa các trạng thái mà một Thread trải qua:
- **NEW**: Vừa được khởi tạo bằng `new Thread()`.
- **RUNNABLE**: Đang chạy hoặc sẵn sàng chạy trong JVM.
- **BLOCKED**: Đang đợi khóa (monitor lock) để vào một khối `synchronized`.
- **WAITING**: Đợi vô thời hạn cho đến khi một luồng khác gọi `notify()`.
- **TIMED_WAITING**: Đợi trong một khoảng thời gian xác định (ví dụ: `Thread.sleep()`).
- **TERMINATED**: Đã hoàn thành công việc.

### 5. Case Study thực tế (`EmailServiceDemo.java`)
- **Bài toán**: Trong các ứng dụng Web/E-commerce, việc gửi Email xác nhận thường mất vài giây do độ trễ mạng. Nếu thực hiện tuần tự, khách hàng sẽ phải chờ rất lâu.
- **Giải pháp**: Sử dụng **Background Worker** (Thread Pool). Luồng chính xử lý logic nghiệp vụ và trả về kết quả ngay lập tức, trong khi việc gửi Email được đẩy xuống hàng chờ để các luồng phụ xử lý ở nền.

## Tại sao cần Multi-threading?
- **Performance**: Tận dụng tối đa sức mạnh của CPU đa nhân.
- **Responsiveness**: Giữ cho ứng dụng (đặc biệt là giao diện người dùng) luôn phản hồi trong khi xử lý các tác vụ nặng ở nền.
- **Parallelism**: Thực hiện nhiều công việc cùng một lúc.

## Cách chạy các demo:

```powershell
# Chạy demo vòng đời (Lifecycle)
javac com/demo/threads/ThreadLifecycleDemo.java; java com.demo.threads.ThreadLifecycleDemo

# Chạy demo thực tế (Email Service)
javac com/demo/threads/EmailServiceDemo.java; java com.demo.threads.EmailServiceDemo

# Chạy demo trực quan hóa khóa (Lock Visualization)
javac com/demo/threads/LockVisualizationDemo.java; java com.demo.threads.LockVisualizationDemo

# Chạy demo trực quan hóa bế tắc (Deadlock Visualization)
javac com/demo/threads/DeadlockDemo.java; java com.demo.threads.DeadlockDemo
```
