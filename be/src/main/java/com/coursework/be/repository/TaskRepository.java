package com.coursework.be.repository;

import com.coursework.be.entity.Group;
import com.coursework.be.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByGroup(Group group);
    List<Task> findAllByTeacherIdteacher(Long id);
    Optional<Task> findById(Long id);
    List<Task> findAllByGroupId(Long id);
}
