package com.demo.hr.model;

import java.time.LocalDateTime;

public class History {
    private LocalDateTime timestamp;
    private String actorId;
    private String action;
    private String note;

    public History(String actorId, String action, String note) {
        this.timestamp = LocalDateTime.now();
        this.actorId = actorId;
        this.action = action;
        this.note = note;
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + actorId + ": " + action + (note != null ? " (" + note + ")" : "");
    }
}
