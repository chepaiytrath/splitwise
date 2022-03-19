package service.split;

import entity.split.Split;
import entity.split.SplitRequest;
import exception.InvalidSplitRequestException;
import exception.InvalidSplitTypeException;

import java.util.List;

public interface SplitService {

    List<Split> createSplits(SplitRequest req) throws InvalidSplitTypeException, InvalidSplitRequestException;
}