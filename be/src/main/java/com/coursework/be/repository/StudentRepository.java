package com.coursework.be.repository;

import com.coursework.be.entity.Student;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student,Long> {
    List<Student> findAllByLname(String fname);
    Optional<Student> findByEmail(String email);
}
