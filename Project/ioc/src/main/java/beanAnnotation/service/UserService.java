package beanAnnotation.service;

import beanAnnotation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public void add(){
        System.out.println("UserService add...");
        userRepository.save();
    }
}
