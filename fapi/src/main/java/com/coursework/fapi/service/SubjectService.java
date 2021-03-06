package com.coursework.fapi.service;

import com.coursework.fapi.model.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class SubjectService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    public List<Subject> getSubjects() {
        RestTemplate restTemplate = new RestTemplate();
        Subject[] subjects = restTemplate.getForObject(backendServerUrl + "/api/subject", Subject[].class);
        return Arrays.asList(subjects);
    }

    public Subject createSubject(Subject subject) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/subject", subject, Subject.class).getBody();
    }


    public List<Subject> getSubjectIdGroup(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        Subject[] subjects = restTemplate.getForObject(backendServerUrl + "/api/subject/get/" + id, Subject[].class);
        return Arrays.asList(subjects);
    }

    public void deleteSubject(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/subject/" + id);
    }


    public List<Subject> getSubjectsNotAttachedByGroup(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        Subject[] subjects = restTemplate.getForObject(backendServerUrl + "/api/subject/get/not_attached/" + id, Subject[].class);
        return Arrays.asList(subjects);
    }
}
