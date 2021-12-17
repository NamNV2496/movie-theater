package com.movie.theater.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class ShowDates extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showDateId;

    private LocalDate showDate;

    @Column(columnDefinition = "varchar(255)")
    private String dateName;

    @ManyToMany(mappedBy = "showDates")
    private List<Movie> movies = new ArrayList<>();

    public ShowDates(String date_name) {
        super();
        this.dateName = date_name;
    }

    public ShowDates() {
    }

    public Integer getShowDateId() {
        return showDateId;
    }

    public void setShowDateId(Integer showDateId) {
        this.showDateId = showDateId;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public String getDateName() {
        return dateName;
    }

    public void setDateName(String dateName) {
        this.dateName = dateName;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
