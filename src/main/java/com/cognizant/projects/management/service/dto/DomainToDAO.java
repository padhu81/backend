package com.cognizant.projects.management.service.dto;
import java.sql.Timestamp;
import java.util.Optional;

import com.cognizant.projects.management.db.Entities.Project;
import com.cognizant.projects.management.db.Entities.Task;
import com.cognizant.projects.management.db.Entities.User;
import org.springframework.stereotype.Component;

/**
 * Data Transfer Objects which converts domain objects
 * to User objects
 */
@Component
public class DomainToDAO {

    /*
     * @param user
     * @return
     */
    public User getUser(com.cognizant.projects.management.web.vo.User user){
        User userdao = new User();
        userdao.setUser_ID(user.getUserId());
        userdao.setFirstName(user.getFirstName());
        userdao.setLastName(user.getLastName());
        userdao.setEmployeeId(user.getEmpId());
        userdao.setTask_ID(user.getTaskId());
        userdao.setProject_ID(user.getProjectId());
        return userdao;
    }

    public User getUser(com.cognizant.projects.management.web.vo.User user, User dbUser){
        dbUser.setFirstName(user.getFirstName());
        dbUser.setLastName(user.getLastName());
        dbUser.setEmployeeId(user.getEmpId());
        dbUser.setTask_ID(user.getTaskId());
        dbUser.setProject_ID(user.getProjectId());
        return dbUser;
    }

    public Task getTask(com.cognizant.projects.management.web.vo.Task task){
        Task dbTask = new Task();
        dbTask.setTask_id(task.getTaskId());
        dbTask.setParent_id(task.getParentId());
        dbTask.setProjectId(task.getProjectId());
        dbTask.setTask_name(task.getTaskName());
        dbTask.setStart_date(new Timestamp(new java.util.Date().getTime()));
        dbTask.setEnd_date(new Timestamp(new java.util.Date().getTime()));
        dbTask.setPriority(task.getPriority());
        dbTask.setStatus(task.getStatus());
        return dbTask;
    }

    public Task getTask(com.cognizant.projects.management.web.vo.Task task, Task dbTask){
        dbTask.setTask_id(task.getTaskId());
        dbTask.setParent_id(task.getParentId());
        dbTask.setProjectId(task.getProjectId());
        dbTask.setTask_name(task.getTaskName());
        dbTask.setStart_date(new Timestamp(new java.util.Date().getTime()));
        dbTask.setEnd_date(new Timestamp(new java.util.Date().getTime()));
        dbTask.setPriority(task.getPriority());
        dbTask.setStatus(task.getStatus());
        return dbTask;
    }

    public Project getProject(com.cognizant.projects.management.web.vo.Project project){
        Project dbProject = new Project();
        dbProject.setProject_ID(project.getProjectID());
        dbProject.setProject_name(project.getProjectName());
        dbProject.setStart_date(project.getStartDate());
        dbProject.setEnd_date(project.getEndDate());
        dbProject.setPriority(project.getPriority());
        return dbProject;
    }

    public Project getProject(com.cognizant.projects.management.web.vo.Project project, Project dbProject){
        dbProject.setProject_ID(project.getProjectID());
        dbProject.setProject_name(project.getProjectName());
        dbProject.setStart_date(project.getStartDate());
        dbProject.setEnd_date(project.getEndDate());
        dbProject.setPriority(project.getPriority());
        return dbProject;
    }

}
