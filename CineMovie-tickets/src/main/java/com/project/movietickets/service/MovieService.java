package com.project.movietickets.service;

import com.project.movietickets.entity.MovieEntity;
import com.project.movietickets.entity.RoomMovieScheduleEntity;
import com.project.movietickets.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    private final StorageService storageService;

    public List<MovieEntity> getAllMovie() {
        return movieRepository.findAll();
    }

    public void deleteMovie(int id) {
        movieRepository.deleteById(id);
    }

    public MovieEntity createMovie(String name,
                                   String description,
                                   String director,
                                   String category,
                                   String premiere,
                                   int time,
                                   String language,
                                   String format,
                                   int ageLimit,
                                   MultipartFile image) {
        var imagePath = storageService.store(image);

        var movie = MovieEntity.builder()
                .name(name)
                .description(description)
                .director(director)
                .category(category)
                .premiere(LocalDate.parse(premiere))
                .time(time)
                .language(language)
                .format(format)
                .ageLimit(ageLimit)
                .image(imagePath)
                .build();

        return movieRepository.save(movie);
    }

    public MovieEntity updateMovie(int id,
                                   String name,
                                   String description,
                                   String director,
                                   String category,
                                   String premiere,
                                   int time,
                                   String language,
                                   String format,
                                   int ageLimit) {
        var movie = movieRepository.getOne(id);
        movie.setName(name);
        movie.setDescription(description);
        movie.setDirector(director);
        movie.setCategory(category);
        movie.setPremiere(LocalDate.parse(premiere));
        movie.setTime(time);
        movie.setLanguage(language);
        movie.setFormat(format);
        movie.setAgeLimit(ageLimit);

        return movieRepository.save(movie);
    }

    public MovieEntity findById(int id) {
        return movieRepository.getOne(id);
    }

    public Set<String> getAllCategories() {
        return movieRepository.findAll()
                .stream()
                .map(movie -> movie.getCategory())
                .collect(Collectors.toSet());
    }

    public List<MovieEntity> getListMovieViewHighest(){
        return movieRepository.getListMovieViewHighest();
    }

    public List<MovieEntity> getListMovieLastest(){
        return movieRepository.getTopNewMovieLastest();
    }
}
