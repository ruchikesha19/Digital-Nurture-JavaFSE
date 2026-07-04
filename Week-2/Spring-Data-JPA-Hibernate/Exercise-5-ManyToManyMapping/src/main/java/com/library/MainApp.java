package com.library;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.library.model.Course;
import com.library.model.Student;
import com.library.util.HibernateUtil;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Starting Hibernate Many-To-Many Mapping Application...");

        Long studentId1 = null;
        Long studentId2 = null;

        // 1. Save Student-Course relationship
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();

            Student s1 = new Student("Alice");
            Student s2 = new Student("Bob");

            Course c1 = new Course("Introduction to Java");
            Course c2 = new Course("Database Systems");

            s1.addCourse(c1);
            s1.addCourse(c2);
            s2.addCourse(c1);

            session.persist(s1); // Cascades PERSIST to courses (Java, DB)
            session.persist(s2); // Cascades PERSIST to Bob

            tx.commit();

            studentId1 = s1.getId();
            studentId2 = s2.getId();
            System.out.println("Saved Students and Courses with Many-To-Many associations successfully!");
        } catch (Exception e) {
            System.err.println("Error saving entities: " + e.getMessage());
            e.printStackTrace();
        }

        // 2. Fetch and verify relationships
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            if (studentId1 != null) {
                Student fetchedS1 = session.find(Student.class, studentId1);
                System.out.println("Student: " + fetchedS1.getName() + " is enrolled in:");
                for (Course c : fetchedS1.getCourses()) {
                    System.out.println(" - Course: " + c.getTitle());
                }
            }

            if (studentId2 != null) {
                Student fetchedS2 = session.find(Student.class, studentId2);
                System.out.println("Student: " + fetchedS2.getName() + " is enrolled in:");
                for (Course c : fetchedS2.getCourses()) {
                    System.out.println(" - Course: " + c.getTitle());
                }
            }
        } catch (Exception e) {
            System.err.println("Error fetching entities: " + e.getMessage());
        }

        HibernateUtil.shutdown();
        System.out.println("Many-To-Many Application finished.");
    }
}
