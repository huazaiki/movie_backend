package com.huazaiki.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Movies {
    private Integer movId;
    private String movTitle;
    private String movDescription;
    private String movDirector;
    private Integer movDuration;
    private BigDecimal movRating;
    private Date movReleaseDate;
    private String movImage;
}