package beanAnnotation.repository;

import beanAnnotation.component.TestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository{
    @Autowired(required = false)
    private TestObject testObject;
    public void save() {
        System.out.println("UserRepositoty save ...");
        System.out.println(testObject);
    }
}
