package com.movie.service;

import java.time.LocalDateTime;
import java.util.List;

public interface MovieService {


    public String addMovie(String title, String description, List<String> cast, LocalDateTime releaseDate, List<String> trailers, List<String> photos, String rating, String duration, String language, String genre);
}
