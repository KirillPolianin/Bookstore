package fi.haagahelia.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.course.domain.*;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository cRepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of books");
			cRepository.save(new Category("Fiction"));
			cRepository.save(new Category("Satire"));
			cRepository.save(new Category("Novel"));
			
			repository.save(new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "1232323-21", 49, cRepository.findByName("Novel").get(0)));
			repository.save(new Book("Animal Farm", "George Orwell", 1945, "2212343-5", 45, cRepository.findByName("Satire").get(0)));	
			
			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$10$SxWxwTd2nv/GVsmFb4.SCeF7apAqR2vPGyNYhlOK7ecp.NciAQylK", "USER");
			User user2 = new User("admin", "$2a$10$mL4mLtkI8WyDKOSHBqoVseN31wYGH584LeqhfZTMn./WgQkirBT5a", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
