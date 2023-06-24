import jdk.nashorn.internal.ir.annotations.Ignore;
import org.example.work.Data;
import org.example.work.Province;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProvinceTest {

    @Test
    public void shortFallTest() {
        Province asia = new Province(Data.sampleProvinceData());
        Assertions.assertEquals(asia.getShortFall(), 5);
     }

    @Test
    public void profitTest() {
        Province asia = new Province(Data.sampleProvinceData());
        Assertions.assertEquals(asia.getProfit(), 230);
    }

    @Test
    public void shortFallAndProfitTest() {
        Province asia = new Province(Data.sampleProvinceData());
        Assertions.assertEquals(asia.getShortFall(), 5);
        Assertions.assertEquals(asia.getProfit(), 230);
    }
}


