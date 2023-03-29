package com.boot.compositejpa02.domain;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ExamEntity {
    @EmbeddedId
    private ExamEmbed bookinfo;
    private Date published;
    private String author;

    public ExamVo getEntity() {
        return ExamVo.builder()
                .num(bookinfo.getNum())
                .name(bookinfo.getName())
                .published(published)
                .author(author)
                .build();
    }
}
