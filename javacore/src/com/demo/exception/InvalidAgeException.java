package com.demo.exception;

/**
 * Custom Checked Exception.
 * Vì kế thừa từ 'Exception', nên trình biên dịch sẽ bắt buộc lập trình viên 
 * phải xử lý (try-catch) hoặc khai báo (throws).
 */
public class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
