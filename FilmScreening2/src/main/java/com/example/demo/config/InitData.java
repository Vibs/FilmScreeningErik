package com.example.demo.config;

import com.example.demo.model.Film;
import com.example.demo.model.Screening;
import com.example.demo.repository.FilmRepository;
import com.example.demo.repository.ScreeningRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Time;

@Component
public class InitData implements CommandLineRunner {
    private final FilmRepository filmRepository;
    private final ScreeningRepository screeningRepository;

    public InitData(FilmRepository filmRepository, ScreeningRepository screeningRepository) {
        this.filmRepository = filmRepository;
        this.screeningRepository = screeningRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Skab nogle film og screenings");
        Film film1 = new Film("Borte med blæsten", (short)145);
        filmRepository.save(film1);

        long millis = System.currentTimeMillis();
        java.sql.Date date1 = new java.sql.Date(millis);
        java.sql.Time time1 = Time.valueOf("10:30:40");
        Screening screen1 = new Screening(date1,time1,film1);
        film1.getScreenings().add(screen1);
        screeningRepository.save(screen1);

        film1 = new Film("Druk", (short)115);
        filmRepository.save(film1);

        date1 = java.sql.Date.valueOf("2021-03-25");
        time1 = Time.valueOf("17:30:00");
        screen1 = new Screening(date1,time1,film1);
        film1.getScreenings().add(screen1);
        screeningRepository.save(screen1);

        time1 = Time.valueOf("19:30:00");
        screen1 = new Screening(date1,time1,film1);
        film1.getScreenings().add(screen1);
        screeningRepository.save(screen1);

        System.out.println("Film gemt =" + filmRepository.findAll().size());
        System.out.println("Screenin gemt=" + screeningRepository.findAll().size());

    }
}


