package com.tsvhlpom.prodapi.inter.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class InterCvrgVO {
    @JsonProperty(value = "CCvrgNo")
    private String CCvrgNo;//险别代码
    @JsonProperty(value = "NAmt")
    private Double NAmt;//险别金额
}
