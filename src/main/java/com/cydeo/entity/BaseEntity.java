package com.cydeo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {

    private Long id;
    private LocalDateTime insertDayTime;
    private Long insertUserId;
    private LocalDateTime lastUpdateDateTime;
    private Long lastUpdateUserId;

}
