package com.movie.controller;

import com.movie.service.MovieService;
import com.movie.utility.BaseResponse;
import com.movie.utility.BaseResponseBuilder;
import com.movie.utility.StatusCodeEnum;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired //inject service into controller
    MovieService movieService;

    public ResponseEntity<BaseResponse> addMovie(HttpServletRequest request, HttpServletResponse response,
                                                 @RequestParam(required = false) String title,
                                                 @RequestParam(required = false) String description,
                                                 @RequestParam(required = false) List<String> cast,
                                                 @RequestParam(required = false) LocalDateTime releaseDate,
                                                 @RequestParam(required = false) List<String> trailers,
                                                 @RequestParam(required = false) List<String> photos,
                                                 @RequestParam(required = false) String rating,
                                                 @RequestParam(required = false) String duration,
                                                 @RequestParam(required = false) String language,
                                                 @RequestParam(required = false) String genre) {
        log.info("Getting /addMovie ");

        BaseResponse buildSellerDetailsResponse = new BaseResponseBuilder()
                .setBaseResponseWithStatusAndCodeAndData(HttpStatus.OK.name(), StatusCodeEnum.SUCCESS_CODE.getCode(), movieService.addMovie(title, description, cast, releaseDate, trailers, photos,rating,duration,language,genre));
        return new ResponseEntity<>(buildSellerDetailsResponse,
                HttpStatus.valueOf(buildSellerDetailsResponse.getStatus()));
    }


}

