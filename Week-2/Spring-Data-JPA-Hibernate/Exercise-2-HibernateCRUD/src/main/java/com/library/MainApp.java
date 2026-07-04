package com.library;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.library.model.Book;
import com.library.util.HibernateUtil;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Starting Hibernate CRUD Application...");
        
        Long generatedId = null;

        // 1. CREATE Operation
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Book newBook = new Book("Design Patterns", "GoF");
            session.persist(newBook);
            tx.commit();
            generatedId = newBook.getId();
            System.out.println("CREATE: Saved Book -> " + newBook);
        } catch (Exception e) {
            System.err.println("CREATE ERROR: " + e.getMessage());
        }

        // 2. READ Operation
        if (generatedId != null) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Book fetchedBook = session.find(Book.class, generatedId);
                System.out.println("READ: Fetched Book -> " + fetchedBook);
            } catch (Exception e) {
                System.err.println("READ ERROR: " + e.getMessage());
            }
        }

        // 3. UPDATE Operation
        if (generatedId != null) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Transaction tx = session.beginTransaction();
                Book bookToUpdate = session.find(Book.class, generatedId);
                bookToUpdate.setTitle("Design Patterns (Revised)");
                session.merge(bookToUpdate);
                tx.commit();
                System.out.println("UPDATE: Updated Book -> " + bookToUpdate);
            } catch (Exception e) {
                System.err.println("UPDATE ERROR: " + e.getMessage());
            }
        }

        // 4. DELETE Operation
        if (generatedId != null) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Transaction tx = session.beginTransaction();
                Book bookToDelete = session.find(Book.class, generatedId);
                session.remove(bookToDelete);
                tx.commit();
                System.out.println("DELETE: Removed Book ID: " + generatedId);
                
                Book checkDeleted = session.find(Book.class, generatedId);
                System.out.println("DELETE VERIFICATION: Is Book null? " + (checkDeleted == null));
            } catch (Exception e) {
                System.err.println("DELETE ERROR: " + e.getMessage());
            }
        }

        HibernateUtil.shutdown();
        System.out.println("CRUD Application finished.");
    }
}
