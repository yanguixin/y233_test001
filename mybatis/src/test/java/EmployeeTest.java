import cn.bdqn.domain.Employee;
import cn.bdqn.domain.EmployeeTO;
import cn.bdqn.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.*;

public class EmployeeTest {
    @Test
    public void testSelectAllEmployees() throws Exception {
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过SqlSession提供的方法查询数据[参数是一个查询id,组成: namespace+id]
        List<Employee> employees = session.selectList("cn.bdqn.mapper.selectAllEmployees");
        System.out.println(employees);
        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();

    }

    @Test
    public void testselectById() throws Exception {
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过SqlSession提供的方法查询数据[参数是一个查询id,组成: namespace+id]
        List<Employee> employees = session.selectList("cn.bdqn.mapper.selectById", 1);
        System.out.println(employees);
        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();

    }

    @Test
    public void testselectByName() throws Exception {
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过SqlSession提供的方法查询数据[参数是一个查询id,组成: namespace+id]
        List<Employee> employees = session.selectList("cn.bdqn.mapper.selectByName", "陈");
        System.out.println(employees);
        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();

    }


    // 根据id查询单个员工
    @Test
    public void testQueryById() throws Exception {
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Employee employee = employeeMapper.queryById(1);

        // 5、打印
        System.out.println(employee);

        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();
    }

    // 添加员工
    @Test
    public void testSave() throws Exception {
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        // 5、保存
        Employee employee = new Employee();
        employee.setEmpName("刘泰阳");
        employee.setAddress("山西煤窑山");
        employee.setBirthday(new Date());
        employee.setEmail("taiyang@126.com");
        employee.setSex("女");

        employeeMapper.save(employee);

        // 6、事务提交
        session.commit();

        // 7、关闭SqlSession
        session.close();

        // 8、关闭流
        is.close();
    }

    // 根据员工姓名和性别查询员工
    @Test
    public void testQueryByNameAndSex() throws Exception {
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Employee employee = employeeMapper.queryByNameAndSex("陈瓜西", "男");

        // 5、打印
        System.out.println(employee);

        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();
    }

    // 根据员工姓名和性别查询员工
    @Test
    public void testQueryByNameAndSex1() throws Exception {
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Employee employee1 = new Employee();
        employee1.setEmpName("刘泰阳");
        employee1.setSex("女");
        Employee employee = employeeMapper.queryByNameAndSex1(employee1);


        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();
    }

    // 根据员工姓名和性别查询员工
    @Test
    public void testQueryByNameAndSex2() throws Exception {
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("empNameKey", "刘德华");
        params.put("sexKey", "男");
        Employee employee = employeeMapper.queryByNameAndSex2(params);

        // 5、打印
        System.out.println(employee);

        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();
    }

    // 根据员工姓名和性别查询员工
    @Test
    public void testQueryByNameAndSex3() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("empNameKey","刘泰阳");
        params.put("sexKey","女");
        Employee employee = employeeMapper.queryByNameAndSex3(params);

        // 5、打印
        System.out.println(employee);

        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();
    }
    // 根据员工姓名和性别查询员工
    @Test
    public void testQueryByNameAndSex4() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        EmployeeTO employeeTO = new EmployeeTO();
        employeeTO.setEmpName("王梦瑶");
        employeeTO.setSex("男");
        Employee employee = employeeMapper.queryByNameAndSex4(employeeTO);

        // 5、打印
        System.out.println(employee);

        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();
    }

    // 根据id查询员工信息
    @Test
    public void testQueryByIds() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        List<Integer> list=new ArrayList<Integer>();
        list.add(4);
        Employee employee = employeeMapper.queryByIds(list);

        // 5、打印
        System.out.println(employee);

        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();
    }
    // 根据id查询员工信息
    @Test
    public void testQueryByIds2() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Integer[] ids = {6};
        Employee employee = employeeMapper.queryByIds2(ids);

        // 5、打印
        System.out.println(employee);

        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();
    }

    // 根据id查询员工信息
    @Test
    public void testQueryEmployeesByName() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        List<Employee> employees = employeeMapper.queryEmployeesByName("王");

        // 5、打印
        if (employees != null){
            for (Employee employee:employees) {
                System.out.println(employee);
            }
        }

        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();
}
    // 根据id查询员工信息
    @Test
    public void testQueryByIdA1() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Map<String,Object> result = employeeMapper.queryByIdA1(6);

        // 5、打印
        System.out.println(result);

        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();
    }
    // 根据id查询员工信息
    @Test
    public void testQueryByName() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory2
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        List<Map<String, Object>> maps = employeeMapper.queryByNameA1("刘");

        // 5、打印
        System.out.println(maps);

        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();
    }





}
