package cn.bdqn.mapper;

import cn.bdqn.domain.Employee;
import cn.bdqn.domain.EmployeeTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    //查询全部
    public List<Employee> selectAllEmployees();
    // 根据id查询员工
    public Employee queryById(Integer id);

    // 添加员工
    public void save(Employee employee);

    //根据员工名和性别查询员工
    public Employee queryByNameAndSex(@Param("empName") String empName, @Param("sex")String sex);
    // 根据员工名和性别查询员工
    public Employee queryByNameAndSex1(Employee employee);


    // 根据员工名和性别查询员工(使用Map方式)
    public Employee queryByNameAndSex2(Map<String,Object> params);

    // 根据员工名和性别查询员工(使用Map方式)
    public Employee queryByNameAndSex3(Map<String,Object> params);

    // 根据员工名和性别查询员工(使用TO方式)
    public Employee queryByNameAndSex4(EmployeeTO employeeTO);

    // 根据id查询员工
    public Employee queryByIds(List<Integer> ids);

    public Employee queryByIds2(Integer[] ids);



    // 根据员工姓名查询所有员工
    public List<Employee> queryEmployeesByName(String empName);


    // 根据员工id查询员工信息，返回值是一个Map
    public Map<String,Object> queryByIdA1(Integer id);

    // 根据姓名模糊查询员工列表，返回的值是一个List<Map<String,Object>>
    public List<Map<String,Object>> queryByNameA1(String empName);


}
