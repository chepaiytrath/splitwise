package service.split.applier;

import entity.split.Split;

import java.util.List;

public interface SplitApplier {
    void applySplit(double totalExpenseAmount, String paidByUser, int usersInExpense, List<Split> splits);
}
