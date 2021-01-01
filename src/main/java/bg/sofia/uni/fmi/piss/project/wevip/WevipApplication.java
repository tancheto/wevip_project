package bg.sofia.uni.fmi.piss.project.wevip;

import bg.sofia.uni.fmi.piss.project.wevip.model.WevipUser;
import bg.sofia.uni.fmi.piss.project.wevip.repository.WevipUserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.NumberFormat;
import java.util.stream.Stream;

@SpringBootApplication
public class WevipApplication {

	public static void main(String[] args) {
		SpringApplication.run(WevipApplication.class, args);
	}

	@Bean public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	ApplicationRunner init(WevipUserRepository repository) {

		String[][] data = {
				{"2", "Martin", "Iliev", "blah"},
				{"3", "Daniel", "Penchev", "blah"},
				{"4", "Victoria", "Dobreva", "blah"}
		};

		return args -> {
			Stream.of(data).forEach(array -> {
					WevipUser user = new WevipUser(
							array[1],
							array[2],
							array[3]
					);
					repository.save(user);
			});
			repository.findAll().forEach(System.out::println);
		};
	}


}
