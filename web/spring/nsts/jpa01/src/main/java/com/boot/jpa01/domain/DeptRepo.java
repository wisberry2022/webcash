package com.boot.jpa01.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.jpa01.domain.entity.Dept;

public interface DeptRepo extends JpaRepository<Dept, Integer> {

}
