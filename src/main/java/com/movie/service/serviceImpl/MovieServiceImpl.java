package com.movie.service.serviceImpl;

import com.movie.entity.MovieMaster;
import com.movie.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public String addMovie(String title, String description, List<String> cast, LocalDateTime releaseDate, List<String> trailers, List<String> photos, String rating, String duration, String language, String genre) {

        try {
                MovieMaster movieMaster = new MovieMaster();

                if (title != null)
                    movieMaster.setTitle(title);

                if (description != null)
                    movieMaster.setDescription(description);

                if (cast!=null)
                    movieMaster.setCast(cast);

                if (releaseDate != null)
                    movieMaster.setReleaseDate(releaseDate);

                if (trailers!=null)
                    movieMaster.setTrailers(trailers);

                if (photos!=null)
                    movieMaster.setPhotos(photos);

                    movieMaster.setCreatedDate(LocalDateTime.now());

                if (rating != null)
                    movieMaster.setRating(new BigDecimal(rating));

                if (duration != null)
                    movieMaster.setDuration(duration);

                if (language != null)
                    movieMaster.setLanguage(language);

                if (genre!=null)
                    movieMaster.setGenre(genre);

                mongoTemplate.save(movieMaster);
                return "Movie Added Successfully";

        } catch (Exception e) {

            log.info("Error Occurred : "+e.getMessage());
            return "Error Occurred";

        }
    }
}
