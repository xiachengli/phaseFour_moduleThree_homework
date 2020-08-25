package com.xcl.com.xcl.service;

import com.xcl.dao.Resume;

import java.util.List;

public interface ResumeService {

    //插入简历
    void  insertResume(Resume resume);

    //根据名字获取简历
    List<Resume> findListByName(String name);

    //根据名字和期望薪资查询简历
    List<Resume> findListByNameAndExpectSalary(String name, double expectSalary);
}
