package advanced;

import advancedscreens.DragScreen;
import config.ConfigurationScheduler;
import configadvanced.ConfigAdvanced;
import org.testng.annotations.Test;

public class DragTest extends ConfigAdvanced {
    @Test
    public void dragDownTest(){
        new DragScreen(driver)
                .selectDraggableBasic()
                .dragDown();
    }
}
