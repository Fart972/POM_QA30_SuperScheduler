package advancedscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;

public class SwipeableBasicVerticalScreen extends BaseScreenADV{
    public SwipeableBasicVerticalScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy (xpath = "//*[@resource-id ='com.h6ah4i.android.example.advrecyclerview:id/container' and @class='android.widget.FrameLayout']")
    List<MobileElement> list;

    public SwipeableBasicVerticalScreen swipeToUp(){
        MobileElement element = list.get(0);

        Rectangle rect = element.getRect();

        int x = rect.getX()+ rect.getWidth()/2;
        int yFrom = rect.getY()+ (rect.getHeight()-20);
        int yTo = rect.getY()+20;

        TouchAction<?> action = new TouchAction<>(driver);
        action.longPress(PointOption.point(x,yFrom))
                .moveTo(PointOption.point(x,yTo))
                .release()
                .perform();


        return this;
    }

    public SwipeableBasicVerticalScreen swipeToDown(){
        MobileElement element = list.get(3);
        Rectangle rect = element.getRect();

        int x = rect.getX()+ rect.getWidth()/2;
        int yFrom  = rect.getY()+20;
        int yTo = rect.getY()+ (rect.getHeight() -20);

        TouchAction<?> action = new TouchAction<>(driver);
        action.longPress(PointOption.point(x,yFrom))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(x,yTo))
                .release()
                .perform();


        return this;
    }
}