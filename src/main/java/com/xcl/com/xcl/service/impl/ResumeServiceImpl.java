package com.xcl.com.xcl.service.impl;

import com.xcl.com.xcl.service.ResumeService;
import com.xcl.dao.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("resumeService")
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void insertResume(Resume resume) {
        mongoTemplate.insert(resume,"lg_resume_datas");
    }

    public List<Resume> findListByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        List<Resume> datas = mongoTemplate.find(query,Resume.class,"lg_resume_datas");
        return  datas;
    }

    public List<Resume> findListByNameAndExpectSalary(String name, double expectSalary) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name).andOperator(Criteria.where("expectSalary").is(expectSalary)));
        return  mongoTemplate.find(query,Resume.class,"lg_resume_datas");
    }
}
