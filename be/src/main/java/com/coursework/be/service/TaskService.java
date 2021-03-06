package com.coursework.be.service;


import com.coursework.be.entity.Task;
import com.coursework.be.repository.GroupRepository;
import com.coursework.be.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {
    private TaskRepository taskRepository;
    private GroupRepository groupRepository;

    @Autowired
    public TaskService(TaskRepository repository, GroupRepository groupRepository) {
        this.taskRepository = repository;
        this.groupRepository = groupRepository;
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public Iterable<Task> getTaskByIdGroup(Long idgroup) {
        return taskRepository.findAllByGroupId(idgroup);
    }


    public Optional<Task> getTask(Long id) {
        return taskRepository.findById(id);
    }

    public Iterable<Task> getTaskByIdTeacher(Long idteacher) {
        return taskRepository.findAllByTeacherIdteacher(idteacher);
    }


    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }


}
