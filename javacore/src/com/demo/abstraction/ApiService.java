package com.demo.abstraction;

/**
 * Interface định nghĩa cách hệ thống giao tiếp với bên ngoài (API).
 * Minh họa tính trừu tượng: Chúng ta chỉ quan tâm API có những chức năng gì (GET, POST...),
 * còn việc nó gọi đến server nào hay dùng thư viện gì thì sẽ được triển khai ở lớp con.
 */
public interface ApiService {
    String BASE_URL = "https://api.v1.demo.com";

    boolean callApiGet(Object object);
    boolean callApiPost(Object object);
    boolean callApiPut(Object object);
    boolean callApiDelete(Object object);
}
