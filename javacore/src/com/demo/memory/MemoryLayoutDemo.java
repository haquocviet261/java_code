package com.demo.memory;

/**
 * Demo Java Memory Layout:
 * - Stack: Lưu các biến nguyên thủy (primitive) và các biến tham chiếu (reference variables).
 * - Heap: Lưu các đối tượng (objects) và mảng (arrays).
 * - Metaspace: Lưu thông tin về lớp (class metadata) và biến static.
 */
public class MemoryLayoutDemo {

    public static void main(String[] args) {
        // 'primitiveVar' lưu trực tiếp giá trị 10 vào Stack của main()
        int primitiveVar = 10;

        // 'obj1' là biến tham chiếu lưu ở Stack, trỏ tới đối tượng DataContainer thực sự ở Heap
        DataContainer obj1 = new DataContainer(101, "Java Memory");

        // Gọi phương thức sẽ tạo một Stack Frame mới
        executeTask(obj1, primitiveVar);

        System.out.println("Static Context: " + DataContainer.category);
    }

    public static void executeTask(DataContainer container, int value) {
        // Biến 'container' ở đây là một bản sao của tham chiếu obj1, trỏ cùng tới 1 đối tượng ở Heap
        // Biến 'value' là một bản sao giá trị (pass-by-value)
        int doubleValue = value * 2;
        
        container.showInfo();
        
        System.out.println("Processed value: " + doubleValue);
        // Sau khi kết thúc hàm này, Stack Frame của executeTask sẽ bị giải phóng.
    }
}
