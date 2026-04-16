package com.demo.abstraction;

/**
 * Lớp giả lập một Client thực hiện các cuộc gọi API.
 * Ở đây chúng ta chỉ in ra Console để học viên dễ hình dung luồng dữ liệu.
 */
public class UserClient implements ApiService {

    @Override
    public boolean callApiGet(Object object) {
        System.out.println("[API GET] Calling: " + BASE_URL + "/users - Data: " + object);
        return true;
    }

    @Override
    public boolean callApiPost(Object object) {
        System.out.println("[API POST] Calling: " + BASE_URL + "/users/create - Data: " + object);
        return true;
    }

    @Override
    public boolean callApiPut(Object object) {
        System.out.println("[API PUT] Calling: " + BASE_URL + "/users/update - Data: " + object);
        return true;
    }

    @Override
    public boolean callApiDelete(Object object) {
        System.out.println("[API DELETE] Calling: " + BASE_URL + "/users/delete - Data: " + object);
        return true;
    }
}
