package strategy;

import enums.SplitType;
import service.split.applier.EqualSplitApplier;
import service.split.applier.ExactSplitApplier;
import service.split.applier.PercentSplitApplier;
import service.split.applier.SplitApplier;

import java.util.HashMap;
import java.util.Map;

public class SplitApplierStrategy {
    private static Map<SplitType, SplitApplier> splitAppliers = new HashMap<>();

    static {
        splitAppliers.put(SplitType.EQUAL, new EqualSplitApplier());
        splitAppliers.put(SplitType.EXACT, new ExactSplitApplier());
        splitAppliers.put(SplitType.PERCENT, new PercentSplitApplier());
    }

    public static SplitApplier getInstance(SplitType splitType){
        return splitAppliers.get(splitType);
    }
}
