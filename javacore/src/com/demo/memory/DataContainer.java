package com.demo.memory;

public class DataContainer {
    // Tồn tại duy nhất một bản sao cho toàn bộ lớp, không phụ thuộc vào đối tượng.
    public static String category = "GENERAL_DATA";

    // Instance variables: Lưu trữ tại HEAP (nằm bên trong vùng nhớ của đối tượng)
    private int id;
    private String name;

    public DataContainer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void showInfo() {
        //  Local variable: Lưu trữ tại STACK (nằm trong Stack Frame của phương thức này)
        // Sẽ bị hủy ngay khi phương thức showInfo() kết thúc.
        String label = "Record Info: ";
        System.out.println(label + name + " (ID: " + id + ")");
    }
}
