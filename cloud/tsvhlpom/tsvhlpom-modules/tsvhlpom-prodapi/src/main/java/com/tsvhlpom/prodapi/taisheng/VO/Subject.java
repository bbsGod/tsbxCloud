package com.tsvhlpom.prodapi.taisheng.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class Subject {
    private String subjectType;//主体类型
    private String name;//姓名
}
