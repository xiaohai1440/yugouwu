package com.xh.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Areas entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "areas", catalog = "cloud_shopping")


/**
 * 
 * @author LSZ
 *
 * 非宁静无以致远！
 * 2018-5-8上午11:12:39   县
 *
 */
public class Areas implements java.io.Serializable {

	// Fields

	private Integer id;
	private String areaid;
	private String area;
	private String cityid;

	// Constructors

	/** default constructor */
	public Areas() {
	}

	/** full constructor */
	public Areas(String areaid, String area, String cityid) {
		this.areaid = areaid;
		this.area = area;
		this.cityid = cityid;
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

	@Column(name = "areaid", nullable = false, length = 20)
	public String getAreaid() {
		return this.areaid;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}

	@Column(name = "area", nullable = false, length = 50)
	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "cityid", nullable = false, length = 20)
	public String getCityid() {
		return this.cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	@Override
	public String toString() {
		return "Areas [id=" + id + ", areaid=" + areaid + ", area=" + area
				+ ", cityid=" + cityid + "]";
	}

}