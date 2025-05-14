package com.cinemate.controller;

import com.cinemate.model.Film;
import com.cinemate.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/films")
public class FilmController {
    @Autowired private FilmService filmService;

    @GetMapping("/cautaFilm")
    public List<Film> search(@RequestParam String title) {
        return filmService.searchByTitle(title);
    }

    @GetMapping("/{id}")
    public Film get(@PathVariable String id) {
        return filmService.getById(id).orElseThrow();
    }

    @PostMapping("/adaugaFilm")
    public Film addFilm(@RequestBody Film film) {
        System.out.println("Saving film: " + film);
        return filmService.save(film);
    }
    @DeleteMapping("/eliminareFilm/{id}")
    public void deleteFilm(@PathVariable String id) {
        filmService.deleteById(id);
    }
}