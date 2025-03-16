import org.junit.Assert;
import org.junit.Test;


public class TestCalculator {
    @Test
    public void testAdd(){
    Calculator c = new Calculator();
    int sum = c.add(4, 4);
    Assert.assertEquals(8,sum);
}

}
