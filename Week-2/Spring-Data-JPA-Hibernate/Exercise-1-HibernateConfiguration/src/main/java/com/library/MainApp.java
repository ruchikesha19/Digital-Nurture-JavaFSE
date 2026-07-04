package com.library;

import org.hibernate.Session;
import com.library.util.HibernateUtil;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Starting Hibernate Configuration Application...");
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println("Hibernate Session opened successfully. Configuration verified!");
        } catch (Exception e) {
            System.err.println("Error verifying configuration: " + e.getMessage());
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
            System.out.println("Hibernate SessionFactory shutdown completed.");
        }
    }
}
