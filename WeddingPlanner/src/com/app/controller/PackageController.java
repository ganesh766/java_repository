package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IPackageDao;
import com.app.pojos.Packages;

@CrossOrigin(allowedHeaders="*")
@RestController
@RequestMapping("/planner")
public class PackageController
{

	@Autowired
	private IPackageDao dao;
	
	public PackageController()
	{
		System.out.println("in planner controller");
	}

	@PostMapping("/addPackage/{city}")
	public Integer addPackage(@RequestBody Packages packages,@PathVariable String city)
	{
		System.out.println(packages);
		//System.out.println(dao.getCityByName(city));
		//packages.setCity(dao.getCityByName(city));
		System.out.println(packages.getCity());
		return dao.addPackage(packages);
	}
	@GetMapping
	public List<Packages> getAllPackages()
	{
		return dao.getAllPackages();
	}
	@GetMapping("/delete/{packageId}")
	public boolean deletePackage(@PathVariable int packageId)
	{
		System.out.println(packageId);
		return dao.deletePackage(packageId);
	}
	
	@GetMapping("/getPackageDetails/{packageId}")   
	public Packages getPackageDetails(@PathVariable int packageId)
	{
		System.out.println(packageId);
		System.out.println(dao.getPackageDetail(packageId));
		return dao.getPackageDetail(packageId);
	}
	
	@PostMapping("/update")
	public Integer proceesUpdatePackage(@RequestBody Packages p)
	{
		System.out.println("in package controller");
		System.out.println(p);
	//	p.setPackageId(p.getPackageId());
		dao.updatePackageById(p);
		return 1;
	}
	
}
