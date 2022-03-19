package service.split.applier;

import entity.split.Split;

import java.util.List;

public class EqualSplitApplier implements SplitApplier {
    @Override
    public void applySplit(double totalExpenseAmount, String paidByUser, int usersInExpense, List<Split> splits) {
        double eachPersonShare = totalExpenseAmount / usersInExpense;
        for (Split split : splits) {
            if (split.getUserId().equals(paidByUser)) {
                split.setSplitAmount(0.00);
            } else {
                split.setSplitAmount(eachPersonShare);
            }
        }
    }
}