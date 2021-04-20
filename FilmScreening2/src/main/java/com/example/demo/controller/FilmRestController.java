package com.example.demo.controller;

import com.example.demo.model.Film;
import com.example.demo.model.Screening;
import com.example.demo.repository.FilmRepository;
import com.example.demo.repository.ScreeningRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
@CrossOrigin(value = "*")
public class FilmRestController {

    FilmRepository filmRepository;
    ScreeningRepository screeningRepository;

    public FilmRestController(FilmRepository filmRepository, ScreeningRepository screeningRepository) {
        this.filmRepository = filmRepository;
        this.screeningRepository = screeningRepository;
    }

    @GetMapping("/films")
    public List<Film> findAllfilms() {
        return filmRepository.findAll();
    }

    @GetMapping("/film/{id}")
    public ResponseEntity<Film> findFilmById(@PathVariable Integer id) {
        Optional<Film> film = filmRepository.findById(id);
        if (film.isPresent()) {
            Film realfilm = film.get();
            return new ResponseEntity<>(realfilm, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value="/newfilm", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Film postFilm(@RequestBody Film film) {
        System.out.println(film);
        return filmRepository.save(film);
    }

    @GetMapping("/screening/{id}")
    public ResponseEntity<Screening> findScreeningById(@PathVariable Integer id) {
        Optional<Screening> screening = screeningRepository.findById(id);
        if (screening.isPresent()) {
            Screening realscreen = screening.get();
            return new ResponseEntity<>(realscreen, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value="/newscreen", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Screening postScreening(@RequestBody Screening screening) {
        System.out.println(screening);
        return screeningRepository.save(screening);
    }



}




