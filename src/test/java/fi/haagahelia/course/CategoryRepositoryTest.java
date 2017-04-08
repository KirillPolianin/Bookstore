package fi.haagahelia.course;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.course.domain.Category;
import fi.haagahelia.course.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository repository;

    @Test
    public void findByLastnameShouldReturnStudent() {
        List<Category> students = repository.findByName("Novel");
        
        assertThat(students).hasSize(1);
    }
    
    @Test
    public void createNewCategory() {
    	Category category = new Category("Philosophical fiction");
    	repository.save(category);
    	assertThat(category.getCategoryId()).isNotNull();
    }    

}
