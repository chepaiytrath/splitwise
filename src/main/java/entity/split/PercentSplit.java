package entity.split;

import lombok.Getter;

@Getter
public class PercentSplit extends Split {
    private double percentage;

    public PercentSplit(String userId, double percentage) {
        super(userId);
        this.percentage = percentage;
    }

}