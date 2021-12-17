package com.movie.theater.DTO.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.movie.theater.model.entity.Schedule;
import com.movie.theater.model.entity.Type;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
public class MovieRequest {

    private String movieId;
    @NotBlank
    private String actor;
    private int cinemaRoomId;
    private List<Integer> scheduleIds;
    private List<Integer> typeIds;
    private List<Integer> showDateIds;
    @NotBlank
    private String cinemaRoom;
    @NotBlank
    private String content;
    @NotBlank
    private String director;
    @NotBlank
    private int duration;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fromDate;
    @NotBlank
    private String movieProductionCompany;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate toDate;
    @NotBlank
    private String version;
    @NotBlank
    private String movieNameEnglish;
    @NotBlank
    private String movieNameVn;
    @NotBlank
    private String largeImage;
    @NotBlank
    private String smallImage;

    public int getCinemaRoomId() {
        return cinemaRoomId;
    }

    public void setCinemaRoomId(int cinemaRoomId) {
        this.cinemaRoomId = cinemaRoomId;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public List<Integer> getScheduleIds() {
        return scheduleIds;
    }

    public void setScheduleIds(List<Integer> scheduleIds) {
        this.scheduleIds = scheduleIds;
    }

    public List<Integer> getTypeIds() {
        return typeIds;
    }

    public void setTypeIds(List<Integer> typeIds) {
        this.typeIds = typeIds;
    }

    public List<Integer> getShowDateIds() {
        return showDateIds;
    }

    public void setShowDateIds(List<Integer> showDateIds) {
        this.showDateIds = showDateIds;
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
