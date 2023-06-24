import org.example.work.Data;
import org.example.work.Province;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BetterProvinceTest {

    private Province province;

    @BeforeEach
    public void setFixture() {
        province = new Province(Data.sampleProvinceData());
    }

    @Test
    public void shortFallTest() {
        Assertions.assertEquals(province.getProfit(), 230);
    }

    @Test
    public void profitTest() {
        province.setDemand(50);
        province.setTotalProduction(150);
        Assertions.assertEquals(province.getProfit(), 730);
    }



}
