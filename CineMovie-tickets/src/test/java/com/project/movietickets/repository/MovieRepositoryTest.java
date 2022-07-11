package com.project.movietickets.repository;

import com.project.movietickets.entity.MovieEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MovieRepositoryTest {
    @Autowired
    private MovieRepository repository;

    @Test
    public void testInsertMovieToDatabase() {
        MovieEntity created = MovieEntity.builder()
                .name("Name")
                .description("Description")
                .director("Director")
                .category("Category")
                .premiere(LocalDate.parse("2020-08-08"))
                .time(120)
                .language("Viet Nam")
                .image("Image")
                .view(70)
                .build();

        MovieEntity result = repository.save(created);

        assertEquals("Name", result.getName());
        assertEquals("Description", result.getDescription());
        assertEquals("Director", result.getDirector());
        assertEquals("Category", result.getCategory());
        assertEquals(LocalDate.parse("2020-08-08"), result.getPremiere());
        assertEquals(120, result.getTime());
        assertEquals("Viet Nam", result.getLanguage());
        assertEquals("Image", result.getImage());
        assertEquals(70, result.getView());
    }

    @Test
    public void testUpdateMovie(){
        final var created = MovieEntity.builder()
                .name("Name")
                .description("Description")
                .director("Director")
                .category("Category")
                .premiere(LocalDate.parse("2020-08-08"))
                .time(120)
                .language("Viet Nam")
                .image("Image")
                .view(70)
                .build();

        final var movie = repository.save(created);
        final var id = movie.getId();


        movie.setName("UpdateName");
        movie.setDirector("UpdateDirector");
        repository.save(movie);

        final var result = repository.findById(id).get();

        assertEquals("UpdateName", result.getName());
        assertEquals("UpdateDirector", result.getDirector());
    }

    @Test
    public void testFunctionGetTopMovie() {
        MovieEntity created = MovieEntity.builder()
                .name("Name")
                .description("Description")
                .director("Director")
                .category("Category")
                .premiere(LocalDate.now())
                .time(120)
                .language("Viet Nam")
                .image("http://images").build();

        repository.save(created);
        List<MovieEntity> movies = repository.getTopNewMovieLastest();

        assertThat(movies.size()).isGreaterThan(0);
    }
}
