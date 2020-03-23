package com.chang.team.service;

/**
 * 
 * @Description 自定义异常类
 * @author ChangZhi Email:chriszchang@163.com
 * @version v1.0
 * @date 2020年3月6日下午8:24:33
 *
 */
public class TeamException extends Exception{
    static final long serialVersionUID = -33875169931229966L;
    
    public TeamException() {
    	super();
    }
    
    public TeamException(String msg) {
    	super(msg);
    }
}
