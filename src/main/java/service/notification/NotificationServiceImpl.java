package service.notification;

import entity.Expense;
import entity.User;
import service.notification.NotificationService;

public class NotificationServiceImpl implements NotificationService {

    @Override
    public void notifyUser(User user, Expense expense) {
        System.out.println("Notified user " + user.getEmail());
    }
}