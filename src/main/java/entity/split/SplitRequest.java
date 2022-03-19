package entity.split;

import lombok.Getter;
import enums.SplitType;

import java.util.List;

@Getter
public class SplitRequest {
    public SplitRequest(SplitType splitType, List<String> usersInExpense, List<Double> expenseDistribution){
        this.splitType = splitType;
        this.usersInExpense = usersInExpense;
        this.expenseDistribution = expenseDistribution;
    }

    private SplitType splitType;
    private List<String> usersInExpense;
    private List<Double> expenseDistribution;
}
