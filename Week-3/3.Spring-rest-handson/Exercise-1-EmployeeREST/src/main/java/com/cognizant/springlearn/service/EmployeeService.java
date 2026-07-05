package com.cognizant.springlearn.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.dao.EmployeeDao;
@Service
public class EmployeeService {
    @Autowired private EmployeeDao employeeDao;
    @Transactional(readOnly = true)
    public List<Employee> getAllEmployees() { return employeeDao.getAllEmployees(); }
}
