package com.todo_be.todo_be.response;

import lombok.Data;

@Data
public class BaseResponse {
    private String message;

    public BaseResponse(String message) {
        this.message = message;
    }
}
