package cn.bdqn.domain;

public class EmployeeTO {
    private String empName;

    private String sex;

    @Override
    public String toString() {
        return "EmployeeTO{" +
                "empName='" + empName + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmpName() {
        return empName;
    }

    public String getSex() {
        return sex;
    }
}
