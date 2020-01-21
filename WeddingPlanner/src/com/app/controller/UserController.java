package com.app.controller;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.app.dao.IUserDao;
import com.app.pojos.City;
import com.app.pojos.Packages;
import com.app.pojos.User;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	IUserDao Iuserdao;

	@Autowired
	private JavaMailSender mailSender;

	@GetMapping("/value")
	public List<User> getAllUser() {

		return Iuserdao.allUser();

	}

	@PostMapping("/register")
	public Integer register(@RequestBody User user) {

		if (Iuserdao.registerUser(user) != 0) {
			System.out.println(user);
			String msg = "Your one time password for forgot password is = ";
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(user.getEmail());
			mailMessage.setSubject("One Time Password");
			mailMessage.setText(msg);
			try {
				mailSender.send(mailMessage);
			} catch (MailException e) {
				System.out.println("inside mail exception");
				e.printStackTrace();
			}
			return 1;
		}

		return 0;

	}

	@PostMapping("/login")
	public User login(@RequestBody User user) {
		System.out.println("inside login");
		System.out.println(user);
		return Iuserdao.login(user);
	}

	@GetMapping("/logout")
	public String logout(HttpSession hs) {
		hs.invalidate();
		return "redirect:home";
	}
	
	
	@PostMapping("/resetpassword")
	public boolean resetPassword(@RequestBody User user)
	{
		//System.out.println(user.getPassword());
		//System.out.println(user.getEmail());
		Iuserdao.resetPassword(user);
		return true;
	}
	
	@PostMapping("/searchpkg")
	public List<Packages> search(@RequestBody City city)
	
	{
		City city1=new City();
		city1.setCityName(city.getCityName());
		System.out.println(city1);
//		Integer cityid=city.getCityId();
//		System.out.println(city);
		City c1=Iuserdao.searchCity(city1.getCityName());
		return Iuserdao.search(c1.getCityId());
	}
	

	
	@GetMapping
	public List<City> getAllCities()
	{
		return Iuserdao.getAllCities();
	}
	

}
