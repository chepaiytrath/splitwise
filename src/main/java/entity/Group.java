package entity;

import lombok.Getter;

import java.util.*;

@Getter
public class Group {
    public Group(String name, String createdByUser) {
        this.groupId = UUID.randomUUID().toString();
        this.name = name;
        this.createdByUser = createdByUser;
        this.members = new HashSet<>();
        this.expenses = new HashSet<>();
        this.balances = new HashMap<>();
    }

    private String groupId;
    private String name;
    private String createdByUser;
    private Set<String> members;
    private Set<String> expenses;
    private Map<String, Map<String, Double>> balances;      //key=from user, value = to user
}