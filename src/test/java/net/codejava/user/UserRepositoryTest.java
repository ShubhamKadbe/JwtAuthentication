package net.codejava.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import net.codejava.user.UserData;
import net.codejava.user.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;

	@Test
	public void tesCreateUser() {
		PasswordEncoder passwoedEncoder = new BCryptPasswordEncoder();
		String rawPassword = "kadbe8999";
		String encodedPassword = passwoedEncoder.encode(rawPassword);

		UserData newUser = new UserData("shubhkadbe@gmail.com", encodedPassword);

		UserData savedUser = userRepository.save(newUser);

		assertThat(newUser).isNotNull();
		assertThat(savedUser.getId()).isGreaterThan(0);

	}
}
