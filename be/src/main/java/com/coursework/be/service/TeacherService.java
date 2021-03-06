package com.coursework.be.service;

import com.coursework.be.entity.Subject;
import com.coursework.be.entity.Teacher;
import com.coursework.be.repository.SubjectRepository;
import com.coursework.be.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TeacherService {

    private SubjectRepository subjectRepository;
    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository, SubjectRepository subjectRepository) {
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
    }


    public List<Teacher> getTeacherPage(int page){
        Page<Teacher> teacherPage =  teacherRepository.findAll(new PageRequest(page,5));
        Iterator<Teacher> iterator = teacherPage.iterator();
        List<Teacher> teacherList = new ArrayList<>();
        while(iterator.hasNext()){
            teacherList.add(iterator.next());
        }
        return teacherList;
    }

    public Integer getNumberPage(){
        Page<Teacher> teacherPage =  teacherRepository.findAll(new PageRequest(0,5));
        return teacherPage.getTotalPages();
    }

    public Teacher getTeacherByEmail(String email){
        return teacherRepository.findByEmail(email).get();
    }

    public Teacher saveTeacherAccount(Teacher teacher){
        List<Subject> subjects = teacher.getSubjects();
        List<Subject> addSubjects = new ArrayList<>();
        teacher.setSubjects(Collections.emptyList());
        Teacher teacher1 = teacherRepository.save(teacher);

        for(int i = 0; i < subjects.size(); i++){
            Optional<Subject> subjectOptional = subjectRepository.findById(subjects.get(i).getIdsubject());
            addSubjects.add(subjectOptional.get());
        }
        teacher1.setSubjects(addSubjects);
        return teacherRepository.save(teacher1);
    }

    public Iterable<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public void deleteTeacher(Long id){
        teacherRepository.deleteById(id);
    }

    public Optional<Teacher> getTeacherById(Long id){
        return teacherRepository.findById(id);
    }

    public Iterable<Teacher> getTeacherByIdSubject(Long id) {
        Optional<Subject> subjectOptional = subjectRepository.findById(id);
        Subject subject = subjectOptional.isPresent()? subjectOptional.get() : new Subject();
        List<Teacher> teacherList = subject.getTeachers();
        return teacherList;
    }

}
