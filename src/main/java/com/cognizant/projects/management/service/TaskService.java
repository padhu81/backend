package com.cognizant.projects.management.service;

import com.cognizant.projects.management.db.Entities.Task;
import com.cognizant.projects.management.db.repository.TaskRepository;
import com.cognizant.projects.management.service.dto.DaoToDomain;
import com.cognizant.projects.management.service.dto.DomainToDAO;
import com.cognizant.projects.management.service.exception.ServiceException;
import com.cognizant.projects.management.web.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialException;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private DomainToDAO domainToDAO;

    @Autowired
    private DaoToDomain daoToDomain;

    @Autowired
    private UserService userService;

    /**
     * @param task
     * @return
     */
    public boolean addTask(com.cognizant.projects.management.web.vo.Task task) throws ServiceException {
        boolean isSuccess = false;
        Task dbTask = domainToDAO.getTask(task);
        Optional<User> OptionalUser = Optional.ofNullable(task.getUser());
        try {
            taskRepository.save(dbTask);
            if (OptionalUser.isPresent()) {
                userService.updateUser(OptionalUser.get());
            }
            isSuccess = true;
        } catch (Exception e) {
            log.error("Exception occurred in add task", e);
            throw new ServiceException(e.getMessage());
        }
        return isSuccess;
    }

    public boolean updateTask(com.cognizant.projects.management.web.vo.Task task) throws ServiceException {
        boolean isSuccess = false;
        try {
            Optional<Task> byId = taskRepository.findById(task.getTaskId());
            Optional<User> OptionalUser = Optional.ofNullable(task.getUser());
            if (byId.isPresent()) {
                Task dbTask = byId.get();
                domainToDAO.getTask(task, dbTask);
                taskRepository.save(dbTask);
                if (OptionalUser.isPresent()) {
                    userService.updateUser(OptionalUser.get());
                }
            }
            isSuccess = true;
        } catch (Exception e) {

            log.error("Exception occurred in update task", e);
            throw new ServiceException(e.getMessage());
        }
        return isSuccess;
    }

    public boolean deleteTask(int taskId) throws ServiceException {
        boolean isSuccess = false;
        try {
            taskRepository.deleteById(taskId);
            isSuccess = true;
        } catch (Exception e) {
            log.error("Exception occurred in delete task", e);
            throw new ServiceException(e.getMessage());
        }
        return isSuccess;
    }

    public List<com.cognizant.projects.management.web.vo.Task> getTaskList(int projectId) throws ServiceException {
        boolean isSuccess = false;
        List<com.cognizant.projects.management.web.vo.Task> taskList = null;
        try {
            List<Task> byproject_id = taskRepository.findByProjectId(projectId);
            taskList = daoToDomain.getTaskList(byproject_id);
            isSuccess = true;
        } catch (Exception e) {
            log.error("Exception occurred in delete task", e);
            throw new ServiceException(e.getMessage());
        }
        return taskList;
    }
}
