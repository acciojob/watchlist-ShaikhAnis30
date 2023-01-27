package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieService movieService;


    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        String response = movieService.addMovie(movie);

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }




    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director director) {
        String response = movieService.addDirector(director);

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }




    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("mName") String mName, @RequestParam("dName") String dName) {
        String response = movieService.addMovieDirectorPair(mName, dName);

        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }




    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name") String name) {
        Movie response = movieService.getMovieByName(name);

        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }



    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable("name") String name) {
        Director response = movieService.getDirectorByName(name);

        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }



    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("director") String name) {
        List<String> response = movieService.getMoviesByDirectorName(name);

        if(response == null)
            return new ResponseEntity<>("movie not present", HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }




    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies() {
        List<String> response = movieService.findAllMovies();

        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }



    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("name") String name) {
        String response = movieService.deleteDirectorByName(name);

        return new ResponseEntity<>(response, HttpStatus.GONE);
    }



    @DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteAllDirectors() {
        String response = movieService.deleteAllDirectors();

        return new ResponseEntity<>(response, HttpStatus.GONE);
    }





}
