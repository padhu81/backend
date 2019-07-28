package com.cognizant.projects.management.web.controller;

import com.cognizant.projects.management.db.repository.TaskRepository;
import com.cognizant.projects.management.service.UserService;
import com.cognizant.projects.management.service.exception.ServiceException;
import com.cognizant.projects.management.web.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/projmgmt")
@Slf4j
/**
 * Controller to Handler user CRUD operations
 */
public class UserController {

    @Autowired
    private TaskRepository taskrepository;

    @Autowired
    private UserService userService;

    @RequestMapping(method= RequestMethod.POST,value="/addUser")
    @CrossOrigin("Access-Control-Allow-Origin: *")
    public ResponseEntity<Boolean> addUser(@RequestBody User user) {
        boolean isSucess=false;
        try {
            isSucess = userService.addUser(user);
        }catch(ServiceException se){
            log.error("Service Exception while adding user", se);
            return new ResponseEntity<>(isSucess, HttpStatus.SERVICE_UNAVAILABLE);

        }
        return new ResponseEntity<>(isSucess, HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.PUT,value="/updateUser")
    public ResponseEntity<Boolean> updateUser(@RequestBody User user){
        boolean isSucess=false;
        try {
            isSucess = userService.updateUser(user);
        }catch(ServiceException se){
            log.error("Service Exception while adding user", se);
            return new ResponseEntity<>(isSucess, HttpStatus.SERVICE_UNAVAILABLE);

        }
        return new ResponseEntity<>(isSucess, HttpStatus.OK);
    }


    @RequestMapping(method=RequestMethod.DELETE,value="/deleteUser/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") int id){
        boolean isSucess=false;
        try {
            isSucess = userService.deleteUser(id);
        }catch(ServiceException se){
            log.error("Service Exception while adding user", se);
            return new ResponseEntity<>(isSucess, HttpStatus.SERVICE_UNAVAILABLE);
        }
        return new ResponseEntity<>(isSucess, HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.GET,value="/getUsers")
    public Map<String , List<com.cognizant.projects.management.db.Entities.User > > getUsers(){
        List<com.cognizant.projects.management.db.Entities.User > userList=new ArrayList();
        Map<String , List<com.cognizant.projects.management.db.Entities.User > > usersMap = new HashMap();
        try {
            userList=userService.getUsers();
            usersMap.put("users",userList);
        }catch(ServiceException se){
            log.error("Service Exception while adding user", se);
        }
        return usersMap;
    }
}
