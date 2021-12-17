package com.movie.theater.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column (length = 100)
    private String memberId;

    @Column(columnDefinition = "int(10) default 0")
    private int score;


    @Column(nullable = false)
    private String accountId;
}
