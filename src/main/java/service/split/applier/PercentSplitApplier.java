package service.split.applier;

import entity.split.PercentSplit;
import entity.split.Split;

import java.util.List;

public class PercentSplitApplier implements SplitApplier {
    @Override
    public void applySplit(double totalExpenseAmount, String paidByUser, int usersInExpense, List<Split> splits) {
        for (Split split : splits) {
            PercentSplit percentSplit = (PercentSplit) split;
            if (split.getUserId().equals(paidByUser)) {
                split.setSplitAmount(0.00);
            } else {
                double percentage = percentSplit.getPercentage();
                double thisPersonShare = (totalExpenseAmount * percentage) / 100.00;
                split.setSplitAmount(thisPersonShare);
            }
        }
    }
}
