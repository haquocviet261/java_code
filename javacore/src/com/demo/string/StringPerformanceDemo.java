package com.demo.string;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Demo so sánh hiệu năng giữa String, StringBuilder và StringBuffer.
 * Bài học này giúp hiểu rõ tại sao KHÔNG nên dùng String để nối chuỗi trong vòng lặp lớn.
 */
public class StringPerformanceDemo {

    //

    public static void main(String[] args) throws InterruptedException {

    }

    //--------------------- Stack------------------------ | -----------------------------------------------HEAP-----------------------------------------------

    /**
     * String: Mỗi lần cộng chuỗi sẽ tạo ra một đối tượng String mới trong bộ nhớ (String Pool/Heap).
     * Do đó tiêu tốn rất nhiều bộ nhớ và thời gian xử lý của Garbage Collector.
     */
    private static void testStringPerformance(int count) {
        long startTime = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < count; i++) {
            s += "data";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("1. String (+) cho " + count + " lần: " + (endTime - startTime) + "ms");
    }

    /**
     * StringBuffer: Có cơ chế Synchronized (đồng bộ hóa), giúp an toàn khi nhiều luồng (Thread) 
     * cùng truy cập. Tuy nhiên, việc đồng bộ hóa làm giảm tốc độ một chút so với StringBuilder.
     */
    private static void testStringBufferPerformance(int count) {
        long startTime = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < count; i++) {
            sb.append("data");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("2. StringBuffer (Thread-safe) cho " + count + " lần: " + (endTime - startTime) + "ms");
    }

    /**
     * StringBuilder: Không có cơ chế Synchronized. Đây là lựa chọn NHANH NHẤT khi xử lý chuỗi 
     * trong môi trường đơn luồng (Single-thread).
     */
    private static void testStringBuilderPerformance(int count) {
        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append("data");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("3. StringBuilder (Non-thread-safe) cho " + count + " lần: " + (endTime - startTime) + "ms");
    }
}
