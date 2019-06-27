package test;


import mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.Employee;
import pojo.EmployeeExample;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

// 获取所有雇员的名字
public class Test02 {
    @Test
    public void test() throws IOException {

        String s ="mybatis-config.xml" ;
        InputStream stream = Resources.getResourceAsStream(s);
        SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(stream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);

        EmployeeExample example=new EmployeeExample();
        List<Employee> employees = mapper.selectByExample(example);
        for(Employee employee:employees){
            System.out.println(employee.getLastName());
        }


    }
}
