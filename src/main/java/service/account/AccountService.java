package service.account;

import exception.GroupNotFoundException;
import exception.UserNotFoundException;
import entity.Group;
import entity.User;

public interface AccountService {
    User createUser(String name, String email, String phone, String address);

    Group createGroup(String name, String createdByUser);

    void addUserToGroup(String userId, String groupId) throws UserNotFoundException, GroupNotFoundException;
}