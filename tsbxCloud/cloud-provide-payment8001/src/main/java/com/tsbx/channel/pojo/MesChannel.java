package com.tsbx.channel.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * 表mes_channel的PO对象<br/>
 * 对应表名：mes_channel	,备注：渠道信息表
 * @author mybatis-generate-util
 * @date 2022-03-17
 *
 */
@Data
public class MesChannel implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 对应主键：id
	 * 渠道ID
	 */
	private String id;

	/**
	 * 对应字段：channel_name
	 * 渠道名称
	 */
	private String channelName;

	/**
	 * 对应字段：channel_type
	 * 渠道代码
	 */
	private String channelType;

	/**
	 * 对应字段：mes_type
	 * 消息类型：详见配置表
	 */
	private String mesTypeCode;

	/**
	 * 对应字段：mes_company
	 * 第三方信息厂商：详见配置表
	 */
	private String mesCompanyCode;

	/**
	 * 对应字段：channel_key
	 * 签名key
	 */
	private String channelKey;

	/**
	 * 对应字段：valid_status
	 * 状态，Y-有效，N-无效
	 */
	private String validStatus;

	/**
	 * 对应字段：create_time
	 * 创建时间，格式YYYY-MM-DD HH:mm:SS
	 */
	private String createTime;

	/**
	 * 对应字段：update_time
	 * 更新时间，格式YYYY-MM-DD HH:mm:SS
	 */
	private String updateTime;

	/**
	 * 对应字段：flag
	 * 备用
	 */
	private String flag;

}
