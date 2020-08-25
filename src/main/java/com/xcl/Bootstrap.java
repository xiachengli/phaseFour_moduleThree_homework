package com.xcl;

import com.xcl.com.xcl.service.ResumeService;
import com.xcl.dao.Resume;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Bootstrap {
    public static void main(String[] args) {
        ApplicationContext applicationContext  = SpringApplication.run(Bootstrap.class,args);
        ResumeService resumeService = applicationContext.getBean("resumeService",ResumeService.class);

        //插入测试
//        for(int i=0;i<1000;i++) {
//            Resume resume  = new Resume();
//            String index = i<10?"000"+i:i>=10&&i<100?"00"+i:i>=100&&i<1000?"0"+i:i+"";
//            resume.setName("00"+index);
//            resume.setCity("广州");
//            Date date = null;
//            String  dateStr = "yyyy-MM-dd hh:mm:ss";
//            SimpleDateFormat simpleDateFormat  = new SimpleDateFormat(dateStr);
//        try {
//            date = simpleDateFormat.parse("2003-11-02 11:13:14");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        resume.setBirthday(date);
//        resume.setExpectSalary(28000.00);
//        resumeService.insertResume(resume);
//        System.out.println("resume="+resume);
//        }


        //查询
        List<Resume> list = resumeService.findListByName("000002");
        list.forEach(item -> {
            System.out.println(item);
        });
    }
}
