package com.boot.compositejpa02.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.io.Serializable;

@ToString
@EqualsAndHashCode
@Embeddable
@Getter
public class ExamEmbed implements Serializable {

    private int num;
    private String name;
}
