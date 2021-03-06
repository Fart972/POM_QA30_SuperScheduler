package schedulerscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Event;
import org.openqa.selenium.support.FindBy;

public class EditCreateEventScreen extends BaseScreen{
    public EditCreateEventScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_title_input']")
    MobileElement title;
    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_type_input']")
    MobileElement type;
    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_break_plus_btn']")
    MobileElement breaksPlusButton;
    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_edit']")
    MobileElement wageEdit;
    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_input']")
    MobileElement wageInput;
    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_save']")
    MobileElement wageSave;
    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_save_btn']")
    MobileElement confirmCreation;

    public HomeScreen createNewEvent(Event event){
        should(title,25);
        type(title, event.getTitle());
        type(type, event.getType());
        hideKeyboard();

        int breaks =event.getBreaks();
        if (breaks>0 && breaks<5){
            for (int i = 0; i < breaks; i++) {
                breaksPlusButton.click();
            }
        }
        wageEdit.click();
        type(wageInput,String.valueOf(event.getWage()));
        wageSave.click();
        //hideKeyboard();
        confirmCreation.click();

        return  new HomeScreen(driver);
    }
}
