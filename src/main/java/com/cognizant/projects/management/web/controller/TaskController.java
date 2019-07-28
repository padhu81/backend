package com.cognizant.projects.management.web.controller;
import com.cognizant.projects.management.service.TaskService;
import com.cognizant.projects.management.service.exception.ServiceException;
import com.cognizant.projects.management.web.vo.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projmgmt")
@Slf4j
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(method= RequestMethod.POST,value = "/addTask")
    @CrossOrigin("*")
    @Transactional
    public ResponseEntity<Boolean> addTask(@RequestBody Task task){
        boolean isSucess = false;
        try {
            isSucess = taskService.addTask(task);
        }catch(ServiceException se){
            log.error("Service Exception occurred",se);
            return new ResponseEntity<>(isSucess, HttpStatus.SERVICE_UNAVAILABLE);
        }
        return new ResponseEntity<>(isSucess, HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/updateTask")
    @CrossOrigin("*")
    @Transactional
    public ResponseEntity<Boolean> updateTask(@RequestBody Task task){
        boolean isSucess = false;
        try {
            isSucess = taskService.updateTask(task);
        }catch(ServiceException se){
            log.error("Service Exception occurred",se);
            return new ResponseEntity<>(isSucess, HttpStatus.SERVICE_UNAVAILABLE);
        }
        return new ResponseEntity<>(isSucess, HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/deleteTask/{id}")
    @CrossOrigin("*")
    @Transactional
    public ResponseEntity<Boolean> deleteTask(@PathVariable int id){
        boolean isSucess = false;
        try {
            isSucess = taskService.deleteTask(id);
        }catch(ServiceException se){
            log.error("Service Exception occurred",se);
            return new ResponseEntity<>(isSucess, HttpStatus.SERVICE_UNAVAILABLE);
        }
        return new ResponseEntity<>(isSucess, HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.GET, value="/getTasks/{id}")
    @CrossOrigin("*")
    @Transactional
    public ResponseEntity<List<Task>> getTasks(@PathVariable int id){
        boolean isSucess = false;
        List<Task> taskList = null;
        try {
            taskList = taskService.getTaskList(id);
        }catch(ServiceException se){
            log.error("Service Exception occurred",se);
            return new ResponseEntity<List<Task>>(taskList, HttpStatus.SERVICE_UNAVAILABLE);
        }
        return new ResponseEntity<List<Task>>(taskList, HttpStatus.OK);
    }
}
