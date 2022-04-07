package com.tsbx.common.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
//@NoArgsConstructor
public class ApiResponse  <T> implements Serializable {
    private Integer status;
    private String statusText;
    private T data;

    public ApiResponse() {
        this.status = 0;
        this.statusText = "Success";
    }

    public ApiResponse(Integer status,String statusText){
        this(status,statusText,null);

    }

}
