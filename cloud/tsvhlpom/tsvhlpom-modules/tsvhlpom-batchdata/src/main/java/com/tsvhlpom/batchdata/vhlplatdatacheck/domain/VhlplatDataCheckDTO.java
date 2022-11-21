package com.tsvhlpom.batchdata.vhlplatdatacheck.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述
 * 平台对账数据表
 * @Author Xinglong Lei
 * @Date 2020/3/9
 */

@Data
public class VhlplatDataCheckDTO implements Serializable {

    private String month;

    private String zipStatus;

    private String errStatus;

}
