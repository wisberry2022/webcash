package com.boot.compositejpa02.service;

import com.boot.compositejpa02.domain.ExamEntity;
import com.boot.compositejpa02.domain.ExamVo;
import com.boot.compositejpa02.repo.ExamRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ExamService {

    private final ExamRepository repo;

    public List<ExamVo> getData() {

        List<ExamVo> data = new ArrayList<>();
        for(ExamEntity exam:repo.findAll()) {
            ExamVo exVo = exam.getEntity();
            data.add(exVo);
        }
        return data;
    }

}
