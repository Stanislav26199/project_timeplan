package com.coursework.be.repository;

import com.coursework.be.entity.Teacher;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends PagingAndSortingRepository<Teacher,Long> {
    Optional<Teacher> findByEmail(String email);
}
