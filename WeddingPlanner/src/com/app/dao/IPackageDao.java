package com.app.dao;

import java.util.List;

import com.app.pojos.City;
import com.app.pojos.Packages;

public interface IPackageDao {

	public Integer addPackage(Packages packages);
	List<Packages> getAllPackages();
	public Packages getPackagesById(int id);
	public boolean deletePackage(int packageId); 
	public City getCityByName(String city);
	
	public Packages getPackageDetail(int packageId);

	public String updatePackageById(Packages packages);
}
