package com.tsvhlpom.prodapi.taisheng.VO;

import lombok.Data;

@Data
public class PolicyRisk {
    private String name;
    private Double coverage;
    private Double premium;
    private Double discount;
    private String deduction;
    private String primary;

}
