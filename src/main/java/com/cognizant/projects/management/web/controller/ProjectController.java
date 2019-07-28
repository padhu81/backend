package com.cognizant.projects.management.web.controller;
import com.cognizant.projects.management.db.repository.TaskRepository;
import com.cognizant.projects.management.service.ProjectService;
import com.cognizant.projects.management.service.exception.ServiceException;
import com.cognizant.projects.management.web.vo.Project;
import com.cognizant.projects.management.web.vo.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller handles the context path "/projmgmt"
 *
 */
@RestController
@RequestMapping("/projmgmt")
@Slf4j
public class ProjectController {



    @Autowired
    private ProjectService projectService;


    @RequestMapping(method= RequestMethod.GET,value = "/getProjects")
    @CrossOrigin("*")
    @Transactional
    public ResponseEntity<List<Project>> getProjects(){
        List<Project> projects =null;
        boolean isSucess = false;
        try {
            projects = projectService.getProjects();
        }catch(ServiceException se){
            log.error("Service Exception occurred",se);
            return new ResponseEntity<List<Project>>(projects, HttpStatus.SERVICE_UNAVAILABLE);
        }
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }


    @RequestMapping(method= RequestMethod.POST,value = "/addProject")
    @CrossOrigin("*")
    @Transactional
    public ResponseEntity<Boolean> addProject(@RequestBody Project project){
        boolean isSucess = false;
        try {
            isSucess = projectService.addProject(project);
        }catch(ServiceException se){
            log.error("Service Exception occurred",se);
            return new ResponseEntity<>(isSucess, HttpStatus.SERVICE_UNAVAILABLE);
        }
        return new ResponseEntity<>(isSucess, HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/updateProject")
    @CrossOrigin("*")
    @Transactional
    public ResponseEntity<Boolean> updateProject(@RequestBody Project project){
        boolean isSucess = false;
        try {
            isSucess = projectService.updateProject(project);
        }catch(ServiceException se){
            log.error("Service Exception occurred",se);
            return new ResponseEntity<>(isSucess, HttpStatus.SERVICE_UNAVAILABLE);
        }
        return new ResponseEntity<>(isSucess, HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/deleteProject/{id}")
    @CrossOrigin("*")
    @Transactional
    public ResponseEntity<Boolean> deleteProject(@PathVariable int id){
        boolean isSucess = false;
        try {
            isSucess = projectService.deleteProject(id);
        }catch(ServiceException se){
            log.error("Service Exception occurred",se);
            return new ResponseEntity<>(isSucess, HttpStatus.SERVICE_UNAVAILABLE);
        }
        return new ResponseEntity<>(isSucess, HttpStatus.OK);
    }

}
