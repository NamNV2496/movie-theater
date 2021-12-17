package com.movie.theater.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Seat extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seatId;

    @Column(length = 100, nullable = false)
    private int cinemaRoomId;

    @Column(nullable = false)
    private String seatColumn;

    @Column(length = 10, nullable = false)
    private int seatRow;

    @Column(length = 1, nullable = false)
    private int seatStatus;

    @Column(length = 1, nullable = false)
    private int seatType;

}
