package com.chang.team.service;

/**
 * 
 * @Description 表示员工的状态 
 * @author ChangZhi Email:chriszchang@163.com
 * @version
 * @date 2020年3月6日下午6:34:06
 *
 */
public class Status {


	private final String NAME;
	public static final Status FREE = new Status("FREE");
	public static final Status BUSY = new Status("BUSY");
	public static final Status VOCATION = new Status("VOCATION");
	
	private Status(String name) {
		this.NAME = name;
	}

	public String getNAME() {
		return NAME;
	}
	
	@Override
	public String toString() {
		return NAME;
	}
}
