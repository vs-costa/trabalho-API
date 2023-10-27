package br.com.api.trabalho.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.trabalho.entities.User;
import br.com.api.trabalho.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email).get();
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public List<User> listarTodos() {
		return userRepository.findAll();
	}
	public User findById(Integer id) {
		return userRepository.findById(id).get();
	}
}