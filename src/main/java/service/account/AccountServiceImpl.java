package service.account;

import entity.Group;
import entity.User;
import exception.GroupNotFoundException;
import exception.UserNotFoundException;
import repository.GroupRepository;
import repository.UserRepository;

import java.util.HashMap;

public class AccountServiceImpl implements AccountService {
    private UserRepository userRepository;

    @Override
    public User createUser(String name, String email, String phone, String address) {
        User user = new User(name, email, phone, address);
        UserRepository.userMap.putIfAbsent(user.getUserId(), user);
        return user;
    }

    @Override
    public Group createGroup(String groupName, String createdByUser) {
        Group group = new Group(groupName, createdByUser);
        group.getMembers().add(createdByUser);
        group.getBalances().put(createdByUser, new HashMap<>());
        GroupRepository.groupMap.putIfAbsent(group.getGroupId(), group);
        return group;
    }

    @Override
    public void addUserToGroup(String userId, String groupId) throws UserNotFoundException, GroupNotFoundException {
        User user = UserRepository.userMap.get(userId);
        if(user == null){
            throw new UserNotFoundException();
        }
        Group group = GroupRepository.groupMap.get(groupId);
        if(group == null){
            throw new GroupNotFoundException();
        }

        group.getMembers().add(user.getUserId());
        group.getBalances().put(userId, new HashMap<>());
    }
}
