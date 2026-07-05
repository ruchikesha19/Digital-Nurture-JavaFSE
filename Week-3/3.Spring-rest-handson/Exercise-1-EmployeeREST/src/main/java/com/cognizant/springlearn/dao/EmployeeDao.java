package com.cognizant.springlearn.dao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import com.cognizant.springlearn.Employee;
@Repository
public class EmployeeDao {
    private static List<Employee> EMPLOYEE_LIST = new ArrayList<>();
    @SuppressWarnings("unchecked")
    public EmployeeDao() {
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        EMPLOYEE_LIST = context.getBean("employeeList", ArrayList.class);
    }
    public List<Employee> getAllEmployees() { return EMPLOYEE_LIST; }
}
