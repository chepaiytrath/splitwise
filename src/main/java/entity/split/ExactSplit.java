package entity.split;

public class ExactSplit extends Split{
    public ExactSplit(String userId, double exactSplitAmount){
        super(userId);
        this.setSplitAmount(exactSplitAmount);
    }
}