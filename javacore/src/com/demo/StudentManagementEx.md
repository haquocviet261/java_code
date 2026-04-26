# PHẦN 1 – CƠ BẢN (MODEL + OOP)

## 1.1. Tạo class Student

Yêu cầu tạo class `Student` với các thuộc tính:

- id (String)
- name (String)
- age (int)
- gpa (double)

---

## 1.2. Constructor

Viết:

- Constructor không tham số
- Constructor đầy đủ tham số

---

## 1.3. Getter / Setter

Viết đầy đủ getter & setter cho tất cả các field:

- getId / setId
- getName / setName
- getAge / setAge
- getGpa / setGpa

---

## 1.4. toString()

Override phương thức:

@Override
public String toString()

Hiển thị dạng:

Student{id='S01', name='An', age=20, gpa=3.5}

---

## 1.5. equals() và hashCode()

Override:

@Override
public boolean equals(Object o)

@Override
public int hashCode()

Quy tắc:

- 2 Student được coi là giống nhau nếu cùng `id`

---

## 1.6. Validate dữ liệu

Dữ liệu hợp lệ khi:

- id ≠ null, ≠ ""
- age > 0
- gpa ∈ [0, 4]

Gợi ý cách làm:

Cách 1:
- Validate trực tiếp trong constructor

Cách 2:
- Tạo method:

public boolean isValid()

---

## 1.7. Demo cơ bản

Trong hàm main:

- Tạo 3–5 object Student
- In ra màn hình

---

## 2.1. Thêm sinh viên

Yêu cầu:
- Không trùng id
- Validate:
    - id ≠ null, ≠ ""
    - age > 0
    - gpa ∈ [0,4]

---

## 2.2. Tìm sinh viên theo ID

Student findById(String id);

---

## 2.3. Hiển thị danh sách

void displayAll();

---

## 2.4. Xóa sinh viên

void deleteById(String id);

---

## 2.5. Sắp xếp theo GPA giảm dần

void sortByGpa();

---

BONUS PHẦN 2:
- Tìm theo tên (contains)
- Lọc sinh viên có GPA > X
- Update thông tin sinh viên

---

RULE:
- Không viết logic trong main
- Tất cả xử lý nằm trong StudentService

---

PHẦN 3 – NÂNG CAO

3.1. Refactor:
List<Student> -> Map<String, Student>

---

3.2. Viết lại:
- addStudent
- findById
- deleteById
- displayAll

Không được giữ logic cũ

---

3.3. Design:

interface StudentService {
void addStudent(Student student);
Student findById(String id);
}

class StudentServiceImpl implements StudentService {
}

---

3.4. Bonus:

Phân loại học lực:
>= 3.6 → Excellent
>= 3.2 → Good
>= 2.5 → Average
< 2.5 → Weak

Thống kê:
- GPA trung bình
- Sinh viên cao điểm nhất

---

PHẦN 4 – MAIN

1. Add student
2. Show all
3. Find by ID
4. Delete
5. Sort by GPA
0. Exit

---

CHALLENGE:
- Lưu file
- Load data
- JSON
- Unit test

---
