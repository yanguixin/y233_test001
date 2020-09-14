package cn.bdqn.domain;

import org.apache.ibatis.type.Alias;

import java.util.Date;

public class Employee {


    // 主键id
    private Integer id;

    // 员工姓名
    private String empName;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getEmpName() {
        return empName;
    }

    public String getSex() {
        return sex;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    // 性别
    private String sex;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // 邮箱
    private String email;

    // 出生日期
    private Date birthday;

    // 家庭地址
    private String address;



}
