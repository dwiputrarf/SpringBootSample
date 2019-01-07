package restorans.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restorans.model.User;
import restorans.repository.UserRepository;

@Service
public class UserDAO {
	@Autowired
	UserRepository userRepository;
	
	public User save(User item) {
		return userRepository.save(item);
	}
	
	public List<User> getAll() {
		return userRepository.findAll();
	}
	
	public User findOne(Long itemId) {
		return userRepository.findOne(itemId);
	}
	
	public void delete(User item) {
		userRepository.delete(item);
	}
}
