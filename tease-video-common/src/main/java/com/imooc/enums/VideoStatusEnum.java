package com.imooc.enums;

/**
 * 枚举 视频状态
 */
public enum VideoStatusEnum {
	
	SUCCESS(1),		// 发布成功
	FORBID(2);		// 禁止播放，管理员操作
	
	public final int value;
	
	VideoStatusEnum(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
}
