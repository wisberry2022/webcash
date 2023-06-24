import jdk.nashorn.internal.ir.annotations.Ignore;
import org.example.work.Data;
import org.example.work.Province;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ZeroDemand {

    private Province province;

    @BeforeEach
    public void setFixture() {
        province = new Province(Data.sampleProvinceData());
    }

    @Test
    public void zeroDemand() {
        province.setDemand(0);
        Assertions.assertEquals(province.getShortFall(), -25);
        Assertions.assertEquals(province.getProfit(), 0);
    }

    @Test
    public void negativeDemand() {
        province.setDemand(-1);
        Assertions.assertEquals(province.getShortFall(), -26);
        Assertions.assertEquals(province.getProfit(), -10);
    }




}
