package entity;

import lombok.Getter;
import entity.split.Split;
import enums.SplitType;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ExpenseRequest {
    SplitType splitType;
    String expenseDescription;
    double expenseAmount;
    LocalDateTime expenseDate;
    String groupId;
    String paidByUser;
    List<Split> splits;

    public ExpenseRequest(SplitType splitType, String expenseDescription, double expenseAmount, LocalDateTime expenseDate, String paidByUser, String groupId, List<Split> splits) {
        this.splitType = splitType;
        this.expenseDescription = expenseDescription;
        this.expenseAmount = expenseAmount;
        this.expenseDate = expenseDate;
        this.paidByUser = paidByUser;
        this.groupId = groupId;
        this.splits = splits;
    }
}