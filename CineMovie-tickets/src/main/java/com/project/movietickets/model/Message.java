package com.project.movietickets.model;

public class Message {
    public static int SUCCESS = 0;
    public static int ERROR = 1;

    private final int code;
    private final String message;

    public Message(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
