package com.cognizant.projects.management.service;

import com.cognizant.projects.management.db.repository.UserRepository;
import com.cognizant.projects.management.service.dto.DomainToDAO;
import com.cognizant.projects.management.service.exception.ServiceException;
import com.cognizant.projects.management.web.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private DomainToDAO domainToDAO;

    @Autowired
    private UserRepository userRepository;

    public boolean addUser(User user) throws ServiceException {
        boolean isSucess = false;
        com.cognizant.projects.management.db.Entities.User dbUser = domainToDAO.getUser(user);
        try {
            com.cognizant.projects.management.db.Entities.User save = userRepository.save(dbUser);
            isSucess = true;
        } catch (Exception e) {
            log.error("Excception Occured while saving user", e);
            throw new ServiceException(e.getMessage());
        }
        return isSucess;
    }

    public boolean updateUser(User user) throws ServiceException {
        boolean isSucess = false;
        try {
            Optional<com.cognizant.projects.management.db.Entities.User> byId = userRepository.findById(user.getUserId());
            if (byId.isPresent()) {
                com.cognizant.projects.management.db.Entities.User dbUser = byId.get();
                domainToDAO.getUser(user, dbUser);//rely on side effect
                com.cognizant.projects.management.db.Entities.User save = userRepository.save(dbUser);
                isSucess = true;
            }
        } catch (Exception e) {
            log.error("Excception Occured while updating user", e);
            throw new ServiceException(e.getMessage());
        }
        return isSucess;
    }

    public boolean deleteUser(int id) throws ServiceException {
        boolean isSucess = false;
        try {
            userRepository.deleteById(id);
            isSucess = true;
        } catch (Exception e) {
            log.error("Excception Occured while updating user", e);
            throw new ServiceException(e.getMessage());
        }
        return isSucess;
    }

    public List<com.cognizant.projects.management.db.Entities.User> getUsers() throws ServiceException {
        boolean isSucess = false;
        List<com.cognizant.projects.management.db.Entities.User> userlist = new ArrayList();
        try {
            for (com.cognizant.projects.management.db.Entities.User u : userRepository.findAll()) {
                userlist.add(u);
            }
            isSucess = true;
        } catch (Exception e) {
            log.error("Excception Occured while updating user", e);
            throw new ServiceException(e.getMessage());
        }
        return userlist;
    }

}
