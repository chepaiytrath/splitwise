package factory.splits;

import entity.split.ExactSplit;
import entity.split.Split;
import entity.split.SplitRequest;
import enums.SplitType;
import exception.InvalidSplitRequestException;
import validator.SplitsRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class ExactSplitsGenerator implements SplitsGenerator {
    @Override
    public List<Split> createSplits(SplitRequest splitRequest) throws InvalidSplitRequestException {
        SplitsRequestValidator.validateSplitRequest(splitRequest);

        List<Split> res = new ArrayList<>();
        for (int i = 0; i < splitRequest.getUsersInExpense().size(); i++) {
            res.add(new ExactSplit(
                    splitRequest.getUsersInExpense().get(i),
                    splitRequest.getExpenseDistribution().get(i)
            ));
        }
        return res;
    }
}
