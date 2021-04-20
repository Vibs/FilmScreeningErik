package com.example.demo.controller;

import com.example.demo.model.Film;
import com.example.demo.repository.FilmRepository;
import com.example.demo.repository.ScreeningRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class FilmController {

    FilmRepository filmRepository;
    ScreeningRepository screeningRepository;

    public FilmController(FilmRepository filmRepository, ScreeningRepository screeningRepository) {
        this.filmRepository = filmRepository;
        this.screeningRepository = screeningRepository;
    }

    @RequestMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("film", filmRepository.findAll());
        return "index";
    }

    @RequestMapping("/films")
    public String getFilms(Model model) {
        List<Film> lst = filmRepository.findAll();
        model.addAttribute("films", lst);
        return "films/list";
    }

    @RequestMapping("/sog")
    public String doSog(Model model) {
        List<Film> lst = filmRepository.findAll();
        model.addAttribute("films", lst);
        return "films/films";
    }


}
