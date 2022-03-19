package validator;

import entity.split.SplitRequest;
import enums.SplitType;
import exception.InvalidSplitRequestException;

import java.util.List;

public class SplitsRequestValidator {
    public static void validateSplitRequest(SplitRequest splitRequest) throws InvalidSplitRequestException {
        SplitType splitType = splitRequest.getSplitType();
        List<String> usersInExpense = splitRequest.getUsersInExpense();
        List<Double> expenseDistribution = splitRequest.getExpenseDistribution();

        if (!splitType.equals(SplitType.EQUAL) && usersInExpense.size() != expenseDistribution.size()) {
            throw new InvalidSplitRequestException("Size of usersInExpense and expenseDistribution don't match");
        }
    }
}