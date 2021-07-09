package com.cg.anurag.ls.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.anurag.ls.dto.Login;
import com.cg.anurag.ls.service.LoginService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginController 
{
	@Autowired
	LoginService loginService;
	public void setLoginService(LoginService loginService)
	{
		this.loginService = loginService;
	}
	@GetMapping("/login/{user_id}/{password}")
	public Login getLogin(@PathVariable String user_id,@PathVariable String password)
	{
		Login login = loginService.getLoginById(user_id);
		if(login!=null && login.getPassword().equals(password))
			return login;
		else
			return login;
	}
	
	@PostMapping(value = "/register", consumes = "application/json")
	public ResponseEntity<String> register(@RequestBody Login login)
	{
		String message="Registered Successfully";
		   if(loginService.register(login)==null)
			   message="Registration Failed";
		   return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);		
	}
}

