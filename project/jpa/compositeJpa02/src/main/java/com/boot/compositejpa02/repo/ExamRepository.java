package com.boot.compositejpa02.repo;

import com.boot.compositejpa02.domain.ExamEmbed;
import com.boot.compositejpa02.domain.ExamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<ExamEntity, ExamEmbed> {
}
