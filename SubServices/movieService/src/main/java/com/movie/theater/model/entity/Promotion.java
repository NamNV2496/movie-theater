package com.movie.theater.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Data
@Entity
public class Promotion extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int promotionId;

    @Column(columnDefinition = "varchar(255)")
    private String details;

    @Column(columnDefinition = "int(20) default 0")
    private int discountLevel;

    private LocalDate endTime;

    @Column(columnDefinition = "varchar(255)")
    private String image;

    private LocalDate startTime;

    @Column(columnDefinition = "varchar(255)")
    private String title;

}
