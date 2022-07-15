package br.com.biomob.restcontroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.biomob.entity.User;
import br.com.biomob.repository.UserRepository;

@CrossOrigin
@RestController
public class LoginController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/user/register")
	public User register(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@GetMapping("/user/login")
	public ResponseEntity<User> login(@RequestBody User user) {
		
		Optional<User> opt = userRepository.findById(user.getEmail());
		if(opt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok()
				.body(opt.get());
	}

}
