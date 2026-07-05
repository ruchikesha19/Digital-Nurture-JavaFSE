package com.cognizant.springlearn.dao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;
@Repository
public class EmployeeDao {
    private static List<Employee> EMPLOYEE_LIST = new ArrayList<>();
    @SuppressWarnings("unchecked")
    public EmployeeDao() {
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        EMPLOYEE_LIST = context.getBean("employeeList", ArrayList.class);
    }
    public List<Employee> getAllEmployees() { return EMPLOYEE_LIST; }
    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        boolean found = false;
        for(int i=0; i<EMPLOYEE_LIST.size(); i++) {
            if(EMPLOYEE_LIST.get(i).getId().equals(employee.getId())) {
                EMPLOYEE_LIST.set(i, employee);
                found = true;
                break;
            }
        }
        if(!found) throw new EmployeeNotFoundException();
    }
    public void deleteEmployee(int id) throws EmployeeNotFoundException {
        Employee toRemove = null;
        for(Employee emp : EMPLOYEE_LIST) {
            if(emp.getId().equals(id)) {
                toRemove = emp;
                break;
            }
        }
        if(toRemove == null) throw new EmployeeNotFoundException();
        EMPLOYEE_LIST.remove(toRemove);
    }
}
