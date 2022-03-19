package entity.split;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Split {
    public Split(String userId){
        this.userId = userId;
    }

    private String userId;
    private String expenseId;
    private double splitAmount;
}