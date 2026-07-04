package com.library;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.library.model.Department;
import com.library.model.Employee;
import com.library.util.HibernateUtil;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Starting Hibernate One-To-Many Mapping Application...");

        Long deptId = null;

        // 1. Save Department with associated Employees
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();

            Department dept = new Department("Engineering");
            Employee emp1 = new Employee("Alice", "alice@example.com");
            Employee emp2 = new Employee("Bob", "bob@example.com");

            dept.addEmployee(emp1);
            dept.addEmployee(emp2);

            session.persist(dept); // Cascades persistence to employees list
            tx.commit();

            deptId = dept.getId();
            System.out.println("Saved Department and Employees successfully!");
        } catch (Exception e) {
            System.err.println("Error saving entities: " + e.getMessage());
            e.printStackTrace();
        }

        // 2. Fetch Department and verify mapping
        if (deptId != null) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Department fetchedDept = session.find(Department.class, deptId);
                System.out.println("Fetched Department: " + fetchedDept.getName());
                System.out.println("Total Employees in Dept: " + fetchedDept.getEmployees().size());
                for (Employee emp : fetchedDept.getEmployees()) {
                    System.out.println(" - Employee: " + emp.getName() + " | Email: " + emp.getEmail());
                }
            } catch (Exception e) {
                System.err.println("Error fetching department: " + e.getMessage());
            }
        }

        HibernateUtil.shutdown();
        System.out.println("One-To-Many Application finished.");
    }
}
