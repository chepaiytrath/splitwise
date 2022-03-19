package service.notification;

import entity.Expense;
import entity.User;

public interface NotificationService {
    public void notifyUser(User user, Expense expense);
}
