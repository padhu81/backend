package com.cognizant.projects.management.service;

import com.cognizant.projects.management.service.exception.ServiceException;
import com.cognizant.projects.management.web.vo.Project;
import com.cognizant.projects.management.web.vo.Task;
import com.cognizant.projects.management.web.vo.User;

public interface ProjMgmt {

    public boolean addTask(Task task) throws ServiceException;

    public Task viewTask() throws ServiceException;

    public boolean addProject(Project project) throws ServiceException;

    public boolean addUser(User user) throws ServiceException;

    public User searchUser() throws ServiceException;

}
