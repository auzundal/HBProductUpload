package lima.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import lima.util.DriverUtil;

public class BaseStep {


    @Before(order = Integer.MIN_VALUE)
    public void setup() {
        DriverUtil.setUp();
    }

    @After
    public void tearDown() {
        DriverUtil.closeDriver();
    }


}
