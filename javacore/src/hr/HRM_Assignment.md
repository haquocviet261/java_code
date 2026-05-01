 ---

SOFTWARE REQUIREMENT SPECIFICATION (SRS)
PROJECT: HRM – REQUEST MANAGEMENT SYSTEM (v1.0)

  ---

1. INTRODUCTION
   1.1 Purpose
   Tài liệu này mô tả chi tiết các yêu cầu chức năng và phi chức năng cho hệ thống Quản lý Yêu cầu (Request Management) trong nội bộ doanh nghiệp. Mục tiêu là cung cấp một bộ quy tắc nghiệp vụ (Business Rules) đầy đủ để học viên
   có thể tự thiết kế kiến trúc hệ thống bằng Java Core.

1.2 Scope
Hệ thống tập trung vào việc quản lý vòng đời của các loại yêu cầu nhân sự, cụ thể là:
- Leave Request (Đơn xin nghỉ phép)
- Overtime Request (Đơn làm thêm giờ)
  Hệ thống bao gồm các tính năng từ lúc khởi tạo, xử lý phê duyệt đa cấp cho đến khi kết thúc đơn.

1.3 Definitions
- Employee: Người lao động trong công ty.
- Requester: Nhân viên tạo ra yêu cầu.
- Approver: Người có thẩm quyền (Manager/Admin) thực hiện việc phê duyệt hoặc từ chối.
- Request: Một thực thể chứa thông tin về nguyện vọng của nhân viên.
- Approval Level: Số lượng cấp quản lý cần thiết để một đơn được chấp thuận hoàn toàn.

  ---

2. OVERALL DESCRIPTION
   2.1 System Overview
   Hệ thống cho phép nhân viên gửi các yêu cầu nghỉ phép hoặc làm thêm giờ. Các yêu cầu này sẽ đi qua một quy trình phê duyệt nghiêm ngặt dựa trên vai trò, bộ phận và các quy tắc nghiệp vụ định trước.

2.2 System Boundaries
Hệ thống chỉ quản lý logic nghiệp vụ và dữ liệu trong bộ nhớ (In-memory). Không bao gồm giao diện đồ họa (UI) phức tạp hay kết nối Database bên ngoài.

2.3 Assumptions
- Mỗi nhân viên chỉ thuộc về một bộ phận (Department) duy nhất.
- Một nhân viên có thể có một hoặc nhiều vai trò (Roles).

2.4 Constraints
- Hệ thống phải được viết hoàn toàn bằng Java Core.
- Không sử dụng các thư viện bên thứ ba (ngoại trừ thư viện Unit Test nếu cần).

  ---

3. USER ROLES
   3.1 Employee
- Mô tả: Vai trò cơ bản nhất trong hệ thống.
- Quyền hạn:
    - Tạo mới các loại Request.
    - Chỉnh sửa hoặc Hủy (Cancel) các Request do mình tạo ra (khi chưa được duyệt xong).
    - Xem danh sách Request cá nhân.

3.2 Manager
- Mô tả: Người quản lý trực tiếp của một bộ phận.
- Quyền hạn:
    - Bao gồm tất cả quyền của Employee.
    - Phê duyệt (Approve) hoặc Từ chối (Reject) các Request của nhân viên thuộc cùng bộ phận.

3.3 Admin
- Mô tả: Người quản trị hệ thống có quyền cao nhất.
- Quyền hạn:
    - Toàn quyền thao tác với tất cả Request trong hệ thống (bất kể bộ phận).
    - Thực hiện các tác vụ quản trị nâng cao.

  ---

4. FUNCTIONAL REQUIREMENTS

FR-01: Create Request
- Description: Cho phép Requester khởi tạo một yêu cầu mới.
- Actor: Employee.
- Preconditions: Tài khoản nhân viên đang hoạt động.
- Main Flow:
    1. Người dùng chọn loại Request (Leave/OT).
    2. Người dùng nhập các thông tin bắt buộc (Lý do, số giờ/ngày, v.v.).
    3. Hệ thống kiểm tra tính hợp lệ của dữ liệu (Validation).
    4. Hệ thống lưu tạm yêu cầu.
- Postconditions: Request được tạo ở trạng thái mặc định.

FR-02: Submit Request
- Description: Gửi yêu cầu vào luồng phê duyệt chính thức.
- Actor: Employee.
- Preconditions: Request đã được tạo (FR-01).
- Main Flow:
    1. Người dùng xác nhận gửi đơn.
    2. Hệ thống chuyển trạng thái đơn sang trạng thái chờ duyệt đầu tiên.
- Postconditions: Trạng thái chuyển thành PENDING.

FR-03: Update Request
- Description: Chỉnh sửa thông tin yêu cầu.
- Actor: Requester.
- Preconditions: Request đang ở trạng thái cho phép chỉnh sửa.
- Main Flow:
    1. Người dùng thay đổi thông tin đơn.
    2. Hệ thống thực hiện Validation lại toàn bộ.
    3. Hệ thống cập nhật dữ liệu và thực hiện quy tắc "Reset Approval".
- Postconditions: Thông tin được cập nhật, trạng thái và cấp độ duyệt bị reset.

FR-04: Cancel Request
- Description: Hủy bỏ yêu cầu đã gửi.
- Actor: Requester.
- Preconditions: Request chưa ở trạng thái cuối (APPROVED/REJECTED).
- Postconditions: Trạng thái chuyển thành CANCELLED.

FR-05: Approve Request
- Description: Chấp thuận một phần hoặc toàn bộ yêu cầu.
- Actor: Manager, Admin.
- Preconditions: Người dùng có quyền phê duyệt Request này và trạng thái hiện tại là PENDING hoặc IN_PROGRESS.
- Main Flow:
    1. Approver thực hiện lệnh Approve.
    2. Hệ thống kiểm tra cấp độ duyệt hiện tại.
    3. Nếu chưa đủ số cấp độ duyệt cần thiết -> Chuyển sang IN_PROGRESS.
    4. Nếu đã đủ -> Chuyển sang APPROVED.
- Postconditions: Trạng thái đơn được cập nhật.

FR-06: Reject Request
- Description: Từ chối yêu cầu.
- Actor: Manager, Admin.
- Main Flow:
    1. Approver thực hiện lệnh Reject kèm lý do.
    2. Hệ thống lập tức dừng luồng phê duyệt.
- Postconditions: Trạng thái chuyển thành REJECTED.

FR-07: Bulk Approval
- Description: Phê duyệt nhiều yêu cầu cùng lúc.
- Actor: Manager, Admin.
- Main Flow: Hệ thống duyệt qua danh sách Request ID, áp dụng logic Approve cho từng cái.
- Alternative Flow: Các đơn không đủ điều kiện (sai role, sai dept) sẽ bị bỏ qua và ghi nhận lỗi vào log.

FR-08: View Requests
- Description: Xem danh sách các yêu cầu.
- Actor: All roles.
- Constraint: Employee chỉ thấy đơn của mình. Manager thấy đơn bộ phận mình. Admin thấy tất cả.

  ---

5. BUSINESS RULES

5.1 Request Lifecycle
Một yêu cầu phải tuân theo các trạng thái sau:
- PENDING: Mới gửi, chưa có ai xử lý.
- IN_PROGRESS: Đã được ít nhất một người duyệt nhưng chưa đủ cấp độ.
- APPROVED: Đã đạt đủ số cấp độ duyệt yêu cầu.
- REJECTED: Bị từ chối bởi bất kỳ cấp nào.
- CANCELLED: Người tạo chủ động hủy đơn.

5.2 State Transition Rules
- Chỉ có thể chuyển trạng thái từ PENDING/IN_PROGRESS sang các trạng thái khác.
- Một khi đã là APPROVED hoặc REJECTED, trạng thái là vĩnh viễn (Immutable), không thể thay đổi trừ khi có quy tắc Reset.

5.3 Multi-Level Approval
- Mỗi Request khi khởi tạo phải xác định số cấp độ duyệt cần thiết (ví dụ: RequiredLevel = 2).
- Mỗi hành động Approve của một người hợp lệ sẽ tăng CurrentLevel lên 1.

5.4 Authorization Rules
- Manager Rule: Một Manager chỉ có quyền Approve/Reject Request nếu nhân viên tạo Request đó có cùng DepartmentID với Manager.
- Admin Rule: Admin không bị giới hạn bởi bộ phận.

5.5 Validation Rules
- Leave Request:
    - FromDate không được lớn hơn ToDate.
    - Thời gian nghỉ tối đa của một đơn là 30 ngày.
- OT Request:
    - Số giờ làm thêm (hours) phải là số dương.
    - Một đơn OT không được quá 12 giờ/ngày.

5.6 Reset Approval on Update
- Nếu một đơn đang trong quá trình duyệt (PENDING hoặc IN_PROGRESS) mà bị Requester chỉnh sửa nội dung, hệ thống phải:
    - Đưa CurrentLevel về 0.
    - Đưa trạng thái về PENDING.

  ---

6. STATE TRANSITION TABLE

┌─────────────────────┬─────────────────┬─────────────┬───────────────────────────────────┐
│ Current State       │ Action          │ Next State  │ Condition                         │
├─────────────────────┼─────────────────┼─────────────┼───────────────────────────────────┤
│ (None)              │ Create & Submit │ PENDING     │ Validation Passed                 │
│ PENDING             │ Approve         │ IN_PROGRESS │ CurrentLevel + 1 < RequiredLevel  │
│ PENDING             │ Approve         │ APPROVED    │ CurrentLevel + 1 == RequiredLevel │
│ IN_PROGRESS         │ Approve         │ IN_PROGRESS │ CurrentLevel + 1 < RequiredLevel  │
│ IN_PROGRESS         │ Approve         │ APPROVED    │ CurrentLevel + 1 == RequiredLevel │
│ PENDING/IN_PROGRESS │ Reject          │ REJECTED    │ Any level rejects                 │
│ PENDING/IN_PROGRESS │ Cancel          │ CANCELLED   │ Requester cancels                 │
│ PENDING/IN_PROGRESS │ Update          │ PENDING     │ Reset Level to 0                  │
└─────────────────────┴─────────────────┴─────────────┴───────────────────────────────────┘
  ---

7. REQUEST HISTORY (Audit Trail)
   Mỗi hành động tác động lên Request phải được lưu lại lịch sử gồm:
- Timestamp: Thời điểm thực hiện.
- Actor: Người thực hiện hành động.
- Action: Loại hành động (Create, Update, Approve, Reject, v.v.).
- Note: Ghi chú đi kèm (ví dụ: Lý do reject).

  ---

8. NON-FUNCTIONAL REQUIREMENTS
- Clean Architecture: Phải tách biệt rõ ràng giữa Entity (chứa dữ liệu), Service (chứa logic) và Repository (chứa cơ chế lưu trữ).
- Maintainability: Code phải dễ đọc, tuân thủ naming convention của Java.
- Extensibility: Thiết kế phải cho phép thêm loại Request thứ 3 (ví dụ: WorkFromHomeRequest) mà không phải sửa đổi code xử lý duyệt chính.

  ---

9. CONSTRAINTS
- Ngôn ngữ: Java 8+.
- Database: Không sử dụng (Sử dụng Collections như List, Map để quản lý dữ liệu).
- Thread-safety: Cần lưu ý khi có nhiều luồng xử lý cùng lúc (giả lập).

  ---

10. ADVANCED BUSINESS RULES

10.1 Escalation Rule
Nếu một Request ở trạng thái IN_PROGRESS hoặc PENDING quá 2 ngày mà chưa có hành động mới, hệ thống sẽ đánh dấu là Escalated. Lúc này, Admin sẽ nhận được thông báo ưu tiên xử lý thay cho Manager.

10.2 Auto-Reject Rule
Nếu một Request không đạt trạng thái APPROVED sau 5 ngày kể từ ngày Submit, hệ thống tự động chuyển trạng thái thành REJECTED với lý do "System Timeout".

10.3 Concurrency Handling
Hệ thống phải đảm bảo nếu 2 Manager cùng nhấn Approve một Request tại cùng một thời điểm:
- Cấp độ duyệt không được tăng vượt quá RequiredLevel.
- Không có tình trạng một người Approve 2 lần cho cùng một cấp độ.

10.4 Idempotency
Hành động Approve/Reject lần thứ 2 với cùng một thông tin không được làm thay đổi trạng thái của hệ thống nếu kết quả đã được xác lập.

10.5 Bulk Approval Rule
Trong một danh sách phê duyệt hàng loạt, nếu gặp đơn không hợp lệ, hệ thống phải tiếp tục xử lý các đơn còn lại, không được dừng chương trình đột ngột.

  ---

11. SAMPLE SCENARIOS

Scenario 1: Multi-level Approval (Happy Path)
1. Employee A tạo đơn Leave (RequiredLevel = 2). Status: PENDING, Level: 0/2.
2. Manager B (cùng Dept) nhấn Approve. Status: IN_PROGRESS, Level: 1/2.
3. Admin C nhấn Approve. Status: APPROVED, Level: 2/2.

Scenario 2: Reject Flow
1. Employee A tạo đơn OT. Status: PENDING.
2. Manager B nhấn Reject. Status: REJECTED.
3. Admin C cố gắng Approve đơn này -> Hệ thống báo lỗi "Immutable State".

Scenario 3: Modify After Submit
1. Employee A tạo đơn Leave, Manager B đã duyệt 1 cấp. Status: IN_PROGRESS, Level: 1/2.
2. Employee A cập nhật lại ngày nghỉ.
3. Hệ thống reset: Status: PENDING, Level: 0/2.

Scenario 4: Concurrent Approval
1. Một đơn cần 2 cấp duyệt. Hiện tại đang là Level 1/2.
2. Hai Admin cùng nhấn Approve đồng thời.
3. Chỉ có một Admin được ghi nhận, đơn chuyển thành APPROVED (Level 2/2). Người thứ hai nhận thông báo "Request already finalized".

  ---
END OF DOCUMENT