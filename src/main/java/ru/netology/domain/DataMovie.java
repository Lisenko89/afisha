package ru.netology.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class DataMovie {
    private int id;
    private String movieName;
    private String movieGenre;
    private boolean premiere;

}
