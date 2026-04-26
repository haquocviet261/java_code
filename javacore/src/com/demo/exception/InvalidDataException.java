package com.demo.exception;

/**
 * Custom Unchecked Exception.
 * Kế thừa từ RuntimeException, nên không bắt buộc phải khai báo 'throws' 
 * hoặc bao quanh bởi try-catch khi sử dụng.
 */
public class InvalidDataException extends RuntimeException {
    public InvalidDataException(String message) {
        super(message);
    }
}
