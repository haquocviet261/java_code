package com.demo.hr.repository;

import com.demo.hr.model.Request;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RequestRepository {
    private Map<String, Request> requests = new ConcurrentHashMap<>();

    public void save(Request request) {
        requests.put(request.getId(), request);
    }

    public Request findById(String id) {
        return requests.get(id);
    }

    public Collection<Request> findAll() {
        return requests.values();
    }
}
