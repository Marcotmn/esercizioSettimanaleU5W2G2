package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import entities.User;
import services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService usersService;
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED) // <-- 201
	public User saveUser(@RequestBody User body) {
		User createdUser = usersService.save(body);
		return createdUser;
	}

}
