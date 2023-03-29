package com.boot.compositejpa02.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ExamVo {
    private int num;
    private String name;
    private Date published;
    private String author;

}
