package com.coursework.be.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="student_group")
public class Group {
    @Id
    @Column(name = "idgroup")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "group", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Student> students;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "student_group_subjects",
            joinColumns = {@JoinColumn(name="group_id")},
            inverseJoinColumns = {@JoinColumn(name = "subject_id")})
    @JsonIgnore
    private List<Subject> subjects;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Task> tasks;

    public Group() { }

    public Group(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void addSubject(Subject subject){
        this.subjects.add(subject);
    }

    public void addSubjects(Collection<Subject> collection){
        this.subjects.addAll(collection);
    }

    public void removeSubject(Subject subject){
        this.subjects.remove(subject);
    }


    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
