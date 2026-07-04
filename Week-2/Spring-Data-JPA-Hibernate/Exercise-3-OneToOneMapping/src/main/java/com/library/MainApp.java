package com.library;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.library.model.User;
import com.library.model.UserProfile;
import com.library.util.HibernateUtil;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Starting Hibernate One-To-One Mapping Application...");

        Long userId = null;

        // 1. Save User with Profile
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();

            User user = new User("john_doe", "john@example.com");
            UserProfile profile = new UserProfile("9876543210", "123 Main Street");
            user.setUserProfile(profile);

            session.persist(user); // Cascades persistence to userProfile
            tx.commit();

            userId = user.getId();
            System.out.println("Saved User and associated UserProfile successfully!");
        } catch (Exception e) {
            System.err.println("Error saving entities: " + e.getMessage());
            e.printStackTrace();
        }

        // 2. Fetch User and verify Bidirectional reference
        if (userId != null) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                User fetchedUser = session.find(User.class, userId);
                System.out.println("Fetched User: " + fetchedUser.getUsername());
                System.out.println("Associated Profile Address: " + fetchedUser.getUserProfile().getAddress());
                System.out.println("UserProfile references back to User: " + fetchedUser.getUserProfile().getUser().getUsername());
            } catch (Exception e) {
                System.err.println("Error fetching user: " + e.getMessage());
            }
        }

        HibernateUtil.shutdown();
        System.out.println("One-To-One Application finished.");
    }
}
