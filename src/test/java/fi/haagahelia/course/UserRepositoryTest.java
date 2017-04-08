package fi.haagahelia.course;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.course.domain.User;
import fi.haagahelia.course.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void findByTitleShouldReturnBook() {
        User user = repository.findByUsername("user");
        
        assertThat(user.getRole()).isEqualTo("USER");
    }
    
    @Test
    public void createNewUser() {
    	User user = new User("user123", "$2a$04$tqHfDd5OQt4ZH9vGfg64.erutLiTZS.b7VQPWhOHRiyNZ2NgZT2Mm", "ADMIN");
    	repository.save(user);
    	assertThat(user.getId()).isNotNull();
    }    

}
