package org.xyz.dm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {
    private String success;
    private String errorCode;
    private String msg;
    private T data;

    public CommonResponse(String errorCode, String msg) {
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public CommonResponse(String success, String errorCode, T data) {
        this.success = success;
        this.errorCode = errorCode;
        this.data = data;
    }
}


