package service.split;

import entity.split.Split;
import entity.split.SplitRequest;
import exception.InvalidSplitRequestException;
import strategy.SplitsGeneratorFactoryStrategy;
import service.split.SplitService;

import java.util.List;

public class SplitServiceImpl implements SplitService {

    @Override
    public List<Split> createSplits(SplitRequest req) throws InvalidSplitRequestException {
        return SplitsGeneratorFactoryStrategy.getInstance(req.getSplitType()).createSplits(req);
    }
}