import gosuslugi.gosnalogi.legalEntity.Gosnalogi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class GosnalogiTest {

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/testAddIncomeOrExpenses.csv")
    public void testAddIncome(int addIncome, int expectedIncome){
        Gosnalogi gosnalogi = new Gosnalogi();
        gosnalogi.addIncome(addIncome);

        int expected = expectedIncome;
        int actual = gosnalogi.getIncome();

        Assertions.assertEquals(expected, actual, "Empty constructor used");
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/testAddIncomeOrExpenses.csv")
    public void testAddExpenses(int addExpenses, int expectedExpenses){
        Gosnalogi gosnalogi = new Gosnalogi();
        gosnalogi.addExpenses(addExpenses);

        int expected = expectedExpenses;
        int actual = gosnalogi.getExpenses();

        Assertions.assertEquals(expected, actual, "Empty constructor used");
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/testSixPerIncome.csv")
    public void testTaxSixPerIncome(int Income, int expectedTax){
        Gosnalogi gosnalogi = new Gosnalogi();
        gosnalogi.addIncome(Income);

        int expected = expectedTax;
        int actual = gosnalogi.calculateTaxesSixPerIncome();

        Assertions.assertEquals(expected, actual, "Empty constructor used");
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/test15PerDifference.csv")
    public void testTax15PerDifference(int Income, int Expenses,  int expectedTax){
        Gosnalogi gosnalogi = new Gosnalogi();
        gosnalogi.addIncome(Income);
        gosnalogi.addExpenses(Expenses);

        int expected = expectedTax;
        int actual = gosnalogi.calculateTaxes15PerDifference();

        Assertions.assertEquals(expected, actual, "Empty constructor used");
    }
}
