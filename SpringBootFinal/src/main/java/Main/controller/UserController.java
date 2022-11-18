package Main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Main.model.User;
import Main.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userservice;
	
	@PostMapping("/save")
	private void saveData(@RequestBody User user) {
		userservice.saveOrUpdate(user);
	}
	
//	@GetMapping("/")  
//	private List<User> getAllusers()   
//	{  
//	return userservice.getAllUsers();  
//	}
	
	@GetMapping("/{account}")
	private User getByAccount(@PathVariable("account") String account )
	{
		return userservice.getUserById(account);
	}
	
	@DeleteMapping("/{account}")  
	private void deleteUser(@PathVariable("account") String account)   
	{  
	userservice.delete(account);  
	}
}
