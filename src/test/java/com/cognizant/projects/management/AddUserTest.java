package com.cognizant.projects.management;
import com.cognizant.projects.management.web.vo.Project;


import com.cognizant.projects.management.web.vo.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

public class AddUserTest {

    @Test
    public void test() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        User user = new User();
        user.setUserId(0);
        user.setFirstName("hello");
        user.setLastName("cognizant");
        user.setEmployeeId("121");
        user.setProjectId(0);
        user.setTaskId(0);
        user.setEmpId(0);
        String s = mapper.writeValueAsString(user);
        System.out.println(s);
    }

}
