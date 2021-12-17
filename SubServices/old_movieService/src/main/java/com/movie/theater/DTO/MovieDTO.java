package com.movie.theater.DTO;

import com.movie.theater.model.entity.CinemaRoom;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
public class MovieDTO {

    private String movieId;
    private String actor;
    private int cinemaRoomId;
    private String cinemaRoom;
    private String content;
    private String director;
    private int duration;
    private LocalDate fromDate;
    private String movieProductionCompany;
    private LocalDate toDate;
    private String version;
    private String movieNameEnglish;
    private String movieNameVn;
    private String largeImage;
    private String smallImage;

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public int getCinemaRoomId() {
        return cinemaRoomId;
    }

    public void setCinemaRoomId(int cinemaRoomId) {
        this.cinemaRoomId = cinemaRoomId;
    }

    public String getCinemaRoom() {
        return cinemaRoom;
    }

    public void setCinemaRoom(String cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public String getMovieProductionCompany() {
        return movieProductionCompany;
    }

    public void setMovieProductionCompany(String movieProductionCompany) {
        this.movieProductionCompany = movieProductionCompany;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMovieNameEnglish() {
        return movieNameEnglish;
    }

    public void setMovieNameEnglish(String movieNameEnglish) {
        this.movieNameEnglish = movieNameEnglish;
    }

    public String getMovieNameVn() {
        return movieNameVn;
    }

    public void setMovieNameVn(String movieNameVn) {
        this.movieNameVn = movieNameVn;
    }

    public String getLargeImage() {
        return largeImage;
    }

    public void setLargeImage(String largeImage) {
        this.largeImage = largeImage;
    }

    public String getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(String smallImage) {
        this.smallImage = smallImage;
    }
}
