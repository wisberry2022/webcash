import org.example.work.Data;
import org.example.work.Province;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FixtureModify {

    private Province province;

    @BeforeEach
    public void setFixture() {
        province = new Province(Data.sampleProvinceData());
        province.getProducers().get(0).setProduction("20");
    }

    @Test
    public void changeProduction() {
        Assertions.assertEquals(province.getShortFall(), -6);
    }

    @Test
    public void profit() {
        Assertions.assertEquals(province.getProfit(), 292);
    }

}
