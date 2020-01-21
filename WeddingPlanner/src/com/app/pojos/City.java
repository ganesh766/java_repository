package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "cities")
public class City {
	private Integer cityId;
	private String cityName;
	private List<Packages> packages;

	public City() {
		// TODO Auto-generated constructor stub
		this.packages = new ArrayList<>();
	}

	public City(Integer cityId, String cityName, List<Packages> packages) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.packages = packages;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.PERSIST, mappedBy = "city",orphanRemoval=true)
	public List<Packages> getPackages() {
		return packages;
	}

	public void setPackages(List<Packages> packages) {
		this.packages = packages;
	}

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityName=" + cityName + "]";
	}

}
