package com.coursework.be.service;

import com.coursework.be.entity.Group;
import com.coursework.be.entity.Subject;
import com.coursework.be.repository.GroupRepository;
import com.coursework.be.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    private SubjectRepository subjectRepository;
    private GroupRepository groupRepository;

    @Autowired
    public SubjectService(SubjectRepository repository, GroupRepository groupRepository){
        this.subjectRepository = repository;
        this.groupRepository = groupRepository;
    }

    public Subject createSubject(Subject subject){
        return subjectRepository.save(subject);
    }

    public Iterable<Subject> getSubjects(){
        return subjectRepository.findAll();
    }

    public void deleteSubject(Long id){ subjectRepository.deleteById(id);}

    public Optional<Subject> getSubject(Long id){
        return  subjectRepository.findById(id);
    }

    public Iterable<Subject> getSubjectsNotAttachedByGroup(Long idgroup){
        Group group = groupRepository.findById(idgroup).get();
        List<Subject> subjectInGroup = group.getSubjects();
        List<Subject> subjectNotGroup = (List<Subject>) subjectRepository.findAll();
        subjectNotGroup.removeAll(subjectInGroup);
        return  subjectNotGroup;
    }
}
