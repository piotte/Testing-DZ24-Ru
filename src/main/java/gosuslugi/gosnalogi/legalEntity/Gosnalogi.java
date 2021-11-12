package gosuslugi.gosnalogi.legalEntity;

import lombok.Data;

@Data
public class Gosnalogi {
    private int income;
    private int expenses;

    //Non-trivial constructor but never used
    /*
    public Gosnalogi(int income, int expenses){
        if (income < 0 || expenses < 0) {
            //throw new IllegalArgumentException("Negative numbers are not allowed");
            return;
        }
        this.income = income;
        this.expenses = expenses;
    }
    */

    public void addIncome(int increase){
        if (increase < 0) return;
        this.income += increase;
    }

    public void addExpenses(int increase){
        if (increase < 0) return;
        this.expenses += increase;
    }

    public int calculateTaxesSixPerIncome(){
        double rate = 0.06;
        int res = (int)Math.ceil(this.income * rate);
        res = res > 0 ? res : 0;
        return res;
    }

    public int calculateTaxes15PerDifference(){
        double rate = 0.15;
        int res = (int)Math.ceil((this.income - this.expenses)*rate);
        if (res < 0) res = 0;
        return res;
    }


}
