package com.huazaiki.utils;

public record Result<T>(int code, T data, String msg) {

    public static <T> Result<T> success(T data) {
        return new Result<>(200, data, "请求成功");
    }

    public static <T> Result<T> success() {
        return success(null);
    }

    public static <T> Result<T> failure(int code, String msg) {
        return new Result<>(code, null, msg);
    }

    public static <T> Result<T> unauthorized(String msg) {
        return failure(401, msg);
    }

    public static <T> Result<T> forbidden(String msg) {
        return failure(403, msg);
    }
}