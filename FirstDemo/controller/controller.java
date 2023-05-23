package com.example.FirstDemo.controller;

import java.io.IOException;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.FirstDemo.model.register;
import com.example.FirstDemo.repository.registerRepository;


@Controller
public class controller {
	
	register reg = new register();
	int count = 0;
	
	
	@Autowired
	public registerRepository repository;
	
	@RequestMapping("/mainPage")
	public String mainPage() {
		return "index.html";
	}

	@RequestMapping("/loginPage")
	public String loginPage() {
		return "login.html";
	}
	
	@RequestMapping("/SignupPage")
	public String SignupPage() {
		return "signUp.html";
	}
	
	@RequestMapping("/UserDashboard")
	public String UserDashboard(
			@RequestParam("email") String email) 
			
			throws IOException {
			
			Iterable<register> log = repository.findPatientsByEmail(email);
			
			String admin = "ahsanulhaqueshawn@gmail.com";
			
			String[] doc = new String[5];
			
			doc[0] = "doctorsanjana@yahoo.com";
			doc[1] = "doctorjohn@gmail.com";
			doc[2] = "doctorsauda123@yahoo.com";
			
			for (register user : log) {
		        if (user.getEmail().equals(admin)) {
		            return "redirect:/adminPage";
		        }
				else {
					for (String elemets : doc) {
			            if (user.getEmail().equals(elemets)) {
			                return "redirect:/doctorPage";
			            }
			        }
				}
		    }
			
			if (log.iterator().hasNext()) {
				return "userDashboard.html";
			}
			return "redirect:/loginPage";
	}
	
	
	@PostMapping("/registrationForm")
	public String registrationForm(
			@RequestParam("name") String name,
			@RequestParam("age") int age,
			@RequestParam("gender") String gender,
			@RequestParam("number") String number,
			@RequestParam("email") String email,
			@RequestParam("password") String password, RedirectAttributes redirectAttribute) 
			
			throws IOException {
		
			Iterable<register> existingUsers = repository.findPatientsByEmail(email);
			
			if (existingUsers.iterator().hasNext()) {
				redirectAttribute.addFlashAttribute("msg", "Email already exists");
		        return "redirect:/SignupPage";
			}
			
			
			register reg = new register();
			reg.setName(name);
			reg.setAge(age);
			reg.setGender(gender);
			reg.setNumber(number);
			reg.setEmail(email);
			reg.setPassword(password);
			
			repository.save(reg);
			redirectAttribute.addFlashAttribute("msg", "Registered Successfully");
			
		    return "redirect:/SignupPage";
	}
	
	
	@RequestMapping("/bookingPage")
	public String bookingPage() {
		return "book.html";
	}
	
	@RequestMapping("/doctorPage")
	public String doctorPage() {
		return "doctorDashboard.html";
	}
	
	@RequestMapping("/adminPage")
	public String adminPage() {
		return "adminDashboard.html";
	}
	
}
