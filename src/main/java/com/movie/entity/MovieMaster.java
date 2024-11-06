package com.movie.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "MOVIE_MASTER")
public class MovieMaster implements Serializable {

    private static final long serialVersionUID = 1L;


    @Field(name = "CREATED_DATE")
    public LocalDateTime createdDate;

    @Field(name = "MODIFIED_DATE")
    public LocalDateTime modifiedDate;

    @Field(name = "TITLE")  //Title of Movie
    public String title;

    @Field(name = "MOVIE_DESCRIPTION")
    public String description;

    @Field(name = "MOVIE_MAKERS")
    public List<String> movieMakerMakers;

    @Field(name = "CAST")
    public List<String> cast;

    @Field(name = "RATING")
    public BigDecimal rating;

    @Field(name = "RELEASE_DATE")
    public LocalDateTime releaseDate;

    @Field(name = "TRAILERS")
    public List<String> trailers;

    @Field(name = "PHOTOS")
    public List<String> photos;

    @Field(name = "MOVIE_GENRE")
    public String genre;

    @Field(name = "DURATION")
    public String duration;

    @Field(name = "LANGUAGE")
    public String language;

    @Field(name = "IS_ACTIVE")
    private String isActive = "Y";

    @Field(name = "IS_DELETED")
    private String isDeleted = "N";

}
