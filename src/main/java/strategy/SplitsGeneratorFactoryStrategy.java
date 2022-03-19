package strategy;

import enums.SplitType;
import factory.splits.EqualSplitsGenerator;
import factory.splits.ExactSplitsGenerator;
import factory.splits.PercentSplitsGenerator;
import factory.splits.SplitsGenerator;

import java.util.HashMap;
import java.util.Map;

public class SplitsGeneratorFactoryStrategy {
    private static Map<SplitType, SplitsGenerator> generators = new HashMap<>();

    static{
        generators.put(SplitType.EQUAL, new EqualSplitsGenerator());
        generators.put(SplitType.EXACT, new ExactSplitsGenerator());
        generators.put(SplitType.PERCENT, new PercentSplitsGenerator());
    }

    public static SplitsGenerator getInstance(SplitType splitType) {
        return generators.get(splitType);
    }
}