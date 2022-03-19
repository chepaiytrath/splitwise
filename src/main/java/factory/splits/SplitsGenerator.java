package factory.splits;

import entity.split.Split;
import entity.split.SplitRequest;
import exception.InvalidSplitRequestException;

import java.util.List;

public interface SplitsGenerator {
    List<Split> createSplits(SplitRequest splitRequest) throws InvalidSplitRequestException;
}
