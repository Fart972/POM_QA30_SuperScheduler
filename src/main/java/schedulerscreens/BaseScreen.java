package schedulerscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BaseScreen {
    AppiumDriver <MobileElement> driver;

    public BaseScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public void type(MobileElement element, String text){
        if(text!= null) {
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    public void hideKeyboard(){
        driver.hideKeyboard();
    }

public boolean isDisplayWithExp(MobileElement element){
        try{
        return element.isDisplayed();
}catch (Exception ex){
            return false;
        }
}
