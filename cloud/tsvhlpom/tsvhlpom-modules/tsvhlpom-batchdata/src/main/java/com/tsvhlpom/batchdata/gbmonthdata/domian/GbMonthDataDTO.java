package com.tsvhlpom.batchdata.gbmonthdata.domian;

import lombok.Data;

@Data
public class GbMonthDataDTO {
    private String month;

    private String middleDataStatus;

    private String csvStatus;

    private String errStatus;
}
