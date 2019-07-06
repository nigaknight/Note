package beanGenericDi;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author micro soft
 * @date 2019/7/6 11:07
 */
public class BaseService <T> {
    @Autowired
    BaseRepository<T> baseRepository;

    public void add(){
        System.out.println("add...");
        System.out.println(baseRepository);
    }
}
