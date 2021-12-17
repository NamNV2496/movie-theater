package com.movie.theater.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Movie extends BaseEntity{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(length = 100)
    private String movieId;

    @Column(nullable = false)
    private String actor;

    @Column(length = 1000,nullable = false)
    private String content;

    @Column(nullable = false)
    private String director;

    @Column(length = 10,nullable = false)
    private int duration;

    private LocalDate fromDate;

    @Column(nullable = false)
    private String movieProductionCompany;

    private LocalDate toDate;

    @Column(nullable = false)
    private String version;

    @Column(nullable = false)
    private String movieNameEnglish;

    @Column(nullable = false)
    private String movieNameVn;

    @Column(nullable = false)
    private String largeImage;

    @Column(nullable = false)
    private String smallImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinemaRoomId",nullable = false)
    private CinemaRoom cinemaRoom;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "movie_schedule", joinColumns = @JoinColumn(name = "movieId"),
            inverseJoinColumns = @JoinColumn(name = "scheduleId"))
    private Set<Schedule> schedules = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "movie_type", joinColumns = @JoinColumn(name = "movieId"),
            inverseJoinColumns = @JoinColumn(name = "typeId"))
    private Set<Type> types  = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "movie_date", joinColumns = @JoinColumn(name = "movieId"),
            inverseJoinColumns = @JoinColumn(name = "showDateId"))
    private Set<ShowDates> showDates = new HashSet<>();

    public Movie(String movieId, String actor, String content, String director, int duration, LocalDate fromDate,
                 String movieProductionCompany, LocalDate toDate, String version, String movieNameEnglish,
                 String movieNameVn, String largeImage, String smallImage, CinemaRoom cinemaRoom,
                 Set<Schedule> schedules, Set<Type> types, Set<ShowDates> showDates) {
        this.movieId = movieId;
        this.actor = actor;
        this.content = content;
        this.director = director;
        this.duration = duration;
        this.fromDate = fromDate;
        this.movieProductionCompany = movieProductionCompany;
        this.toDate = toDate;
        this.version = version;
        this.movieNameEnglish = movieNameEnglish;
        this.movieNameVn = movieNameVn;
        this.largeImage = largeImage;
        this.smallImage = smallImage;
        this.cinemaRoom = cinemaRoom;
        this.schedules = schedules;
        this.types = types;
        this.showDates = showDates;
    }

    public Movie() {

    }

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

    public CinemaRoom getCinemaRoom() {
        return cinemaRoom;
    }

    public void setCinemaRoom(CinemaRoom cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
    }

    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }

    public Set<Type> getTypes() {
        return types;
    }

    public void setTypes(Set<Type> types) {
        this.types = types;
    }

    public Set<ShowDates> getShowDates() {
        return showDates;
    }

    public void setShowDates(Set<ShowDates> showDates) {
        this.showDates = showDates;
    }
}
