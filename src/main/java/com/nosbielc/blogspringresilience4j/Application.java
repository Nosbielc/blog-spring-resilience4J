package com.nosbielc.blogspringresilience4j;

import com.nosbielc.blogspringresilience4j.infrastructure.persistence.entities.User;
import com.nosbielc.blogspringresilience4j.infrastructure.persistence.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class Application implements CommandLineRunner {


	private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		var user1 = User.builder()
				.withFirstName("John")
				.withLastName("Snow")
				.withEmail("j_snow@email.com")
				.withAge(76)
				.build();

		var user2 = User.builder()
				.withFirstName("Mario")
				.withLastName("Pizza")
				.withEmail("m_pizza@email.com")
				.withAge(12)
				.build();

		userRepository.save(user1);
		userRepository.save(user2);

	}
}
