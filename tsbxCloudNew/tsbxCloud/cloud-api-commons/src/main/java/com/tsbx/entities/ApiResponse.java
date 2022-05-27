package com.tsbx.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ApiResponse<T> implements Serializable {
    private Integer status;
    private String statusText;
    private T data;

    public ApiResponse() {
        this.status = 0;
        this.statusText = "Success";
    }

    public ApiResponse(Integer status, String statusText){
        this(status,statusText,null);

    }

}
