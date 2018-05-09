package com.xh.bean;

import java.io.Serializable;
import java.util.Date;

public class Browsing implements Serializable {

	private Integer id;
	private Integer userId;
	private Integer productId;
	private  String createTime;
	@Override
	public String toString() {
		return "Browsing [id=" + id + ", userId=" + userId + ", productId="
				+ productId + ", createTime=" + createTime + "]";
	}
	
	
	public Browsing(Integer id, Integer userId, Integer productId,
			String createTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.productId = productId;
		this.createTime = createTime;
	}
	public Browsing() {
		super();
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	
}
