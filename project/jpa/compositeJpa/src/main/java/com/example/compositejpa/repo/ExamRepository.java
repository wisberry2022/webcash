package com.example.compositejpa.repo;

import com.example.compositejpa.domain.ExamEmbed;
import com.example.compositejpa.domain.ExamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<ExamEntity, ExamEmbed> {
}
