package com.huazaiki.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Schedules implements Serializable {
    private Integer schId;
    private Integer schMovieId;
    private Integer schCinemaId;
    private Date schShowTime;
}