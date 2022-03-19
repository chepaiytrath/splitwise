package entity;

import lombok.Getter;
import entity.split.Split;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
public class Expense {
    public Expense(ExpenseRequest expenseReq){
        this.expenseId = UUID.randomUUID().toString();
        this.expenseDescription = expenseReq.getExpenseDescription();
        this.expenseAmount = expenseReq.getExpenseAmount();
        this.expenseDate = expenseReq.getExpenseDate();
        this.paidByUser = expenseReq.getPaidByUser();
        this.groupId = expenseReq.getGroupId();
        this.splits = expenseReq.getSplits();
    }

    private String expenseId;
    private String expenseDescription;
    private double expenseAmount;
    private LocalDateTime expenseDate;
    private String paidByUser;
    private String groupId;
    private List<Split> splits;
}