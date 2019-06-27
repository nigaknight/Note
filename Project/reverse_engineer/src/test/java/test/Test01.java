package test;



import mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.Employee;

import java.io.IOException;
import java.io.InputStream;


public class Test01 {

    public void test01() throws IOException {
        // 获取mapper
        String s = "mybatis-config.xml";
        InputStream inputStream =Resources.getResourceAsStream(s);
        SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);

        // 调用mapper的查询方法
        Employee employee = mapper.selectByPrimaryKey(3);
        String email = employee.getEmail();
        System.out.println(email);

    }
}
