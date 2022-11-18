package Main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Main.model.User;
import Main.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userrepository;
	
	public void saveOrUpdate(User user) {
		userrepository.save(user);
	}
	
//	public List<User> getAllUsers()   
//	{  
//	List<User> users = new ArrayList<User>();  
//	userrepository.findAll().forEach(value -> users.add(value));  
//	return users;  
//	} 
	
	public void delete(String account)   
	{  
	userrepository.deleteById(account);  
	}
	
	public User getUserById(String account)   
	{  
	return userrepository.findById(account).get();  
	}
}
