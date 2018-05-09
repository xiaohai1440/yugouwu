package com.xh.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Provinces entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "provinces", catalog = "cloud_shopping")


/**
 * 
 * @author LSZ
 *
 * 非宁静无以致远！
 * 2018-5-8上午11:10:51   省
 *
 */
public class Provinces implements java.io.Serializable {

	// Fields

	private Integer id;
	private String provinceid;
	private String province;

	// Constructors

	/** default constructor */
	public Provinces() {
	}

	/** full constructor */
	public Provinces(String provinceid, String province) {
		this.provinceid = provinceid;
		this.province = province;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "provinceid", nullable = false, length = 20)
	public String getProvinceid() {
		return this.provinceid;
	}

	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}

	@Column(name = "province", nullable = false, length = 50)
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Override
	public String toString() {
		return "Provinces [id=" + id + ", provinceid=" + provinceid
				+ ", province=" + province + "]";
	}

}