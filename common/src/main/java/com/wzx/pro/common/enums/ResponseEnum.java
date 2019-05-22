package com.wzx.pro.common.enums;

/**
 * 返回响应状态枚举
 * @author wangzx
 *
 */
public enum ResponseEnum {
	
	/** 格式校验枚举 **/
	VALIDATE_ISNULL("100001","{0} 数据项为空!"),
	VALIDATE_FORMAT("100002","{0} 数据项格式有误!"),
	FUNC_ID_NOT_EXISTS("200001","功能号：{0} 未定义!"),
	
	/** 系统枚举 **/
	SYS_SUCCESS("000000","正常"),
	SYS_FAILD("900000","系统忙"),
	SYS_EXIST("900000","已经存在，请重新输入"),
	SYS_ErrorActionCode("900001","没有操作权限"),
	SYS_SessionOutActionCode("900002","会话超时"),
	SYS_WARN("000001","可忽略异常");
	
	private final String code;
	private final String desc;

	private ResponseEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
	
	
	
	
}
