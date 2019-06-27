package test;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

// 查询所有使用谷歌邮箱的雇员
public class Test03 {

    @Test
    public void test() throws IOException {
        String s = "mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(s);
        SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);

        EmployeeExample example=new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        // 这里用的是sql的模糊查询，将包含的字符串用两个%包起来（并不是正则表达式）
        criteria.andEmailLike("%gmail%");
        List<Employee> employees = employeeMapper.selectByExample(example);
        for(Employee employee:employees){
            System.out.println("name:"+employee.getLastName()+"\n"+"email:"+employee.getEmail());
        }
    }
}
