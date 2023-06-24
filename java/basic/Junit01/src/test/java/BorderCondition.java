import org.example.work.Data;
import org.example.work.Province;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Map;

public class BorderCondition {

    private Province noProducers;

    @BeforeEach
    public void setFixture() {
        Data data = new Data("No producers", new ArrayList<>(), 30, 20);
        noProducers = new Province(data);
    }

    @Test
    public void shortFall() {
        Assertions.assertEquals(noProducers.getShortFall(), 30);
    }

    @Test
    public void profit() {
        Assertions.assertEquals(noProducers.getProfit(), 0);
    }


}

