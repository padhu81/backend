package com.cognizant.projects.management;
import com.cognizant.projects.management.web.vo.User;
import java.sql.Timestamp;

import com.cognizant.projects.management.web.vo.Project;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.stereotype.Controller;

public class ProjectTest {

    @Test
    public void test()throws Exception{
        Project project = new Project();
        User user = new User();
        user.setUserId(0);
        user.setFirstName("");
        user.setLastName("");
        user.setEmployeeId("");
        user.setProjectId(100);
        user.setTaskId(0);
        user.setEmpId(0);
        project.setUser(user);
        project.setProjectID(1);
        project.setProjectName("TEst Project");
        project.setStartDate(new Timestamp(new java.util.Date().getTime()));
        project.setEndDate(new Timestamp(new java.util.Date().getTime()));
        project.setPriority(10);
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(project);
        System.out.println(s);


    }

}
