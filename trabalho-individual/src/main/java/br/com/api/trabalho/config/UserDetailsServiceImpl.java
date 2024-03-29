package br.com.api.trabalho.config;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.api.trabalho.entities.User;
import br.com.api.trabalho.repositories.RoleRepository;
import br.com.api.trabalho.repositories.UserRepository;
import br.com.api.trabalho.services.UserService;




@Component 
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	UserService userService;

	@Autowired
	RoleRepository roleRepo;
	
	
	@Override
	
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		
		Optional<User> userRes = userRepo.findByEmail(email);
		if (userRes.isEmpty()) {
			throw new UsernameNotFoundException("Não foi possível encontrar usuário com o email = " + email);
		}
		return new org.springframework.security.core.userdetails.User(
				email,
				userRes.get().getSenha(),
				roleRepo.roles(email) 
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList()) 
				);
	}
}
