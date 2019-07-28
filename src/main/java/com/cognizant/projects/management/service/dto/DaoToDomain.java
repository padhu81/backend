package com.cognizant.projects.management.service.dto;
import com.cognizant.projects.management.web.vo.User;
import java.sql.Timestamp;

import com.cognizant.projects.management.db.Entities.Project;
import com.cognizant.projects.management.web.vo.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DaoToDomain {


    public List<Task>  getTaskList(List<com.cognizant.projects.management.db.Entities.Task> dbTasks){
        List<Task> taskList = new ArrayList<>();
        for(com.cognizant.projects.management.db.Entities.Task dbTask : dbTasks){
            Task domainTask = new Task();
            domainTask.setTaskId(dbTask.getTask_id());
            domainTask.setParentId(dbTask.getParent_id());
            domainTask.setProjectId(dbTask.getProjectId());
            domainTask.setTaskName(dbTask.getTask_name());
            domainTask.setStartDate(dbTask.getStart_date());
            domainTask.setEndDate(dbTask.getStart_date());
            domainTask.setPriority(dbTask.getPriority());
            domainTask.setStatus(dbTask.getStatus());
            taskList.add(domainTask);
        }
        return taskList;
    }

    public List<com.cognizant.projects.management.web.vo.Project>  getProjects(Iterable<Project> projectList){
        List<com.cognizant.projects.management.web.vo.Project> taskList = new ArrayList<>();
        for(Project proj : projectList){
            com.cognizant.projects.management.web.vo.Project project = new com.cognizant.projects.management.web.vo.Project();
            project.setProjectID(proj.getProject_ID());
            project.setProjectName(proj.getProject_name());
            project.setStartDate(proj.getStart_date());
            project.setEndDate(proj.getEnd_date());
            project.setPriority(proj.getPriority());
            taskList.add(project);
        }
        return taskList;
    }


}
