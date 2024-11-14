import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PracticeFormPage extends BasePage{
    private final By nameLocator = By.id("firstName");
    private final By lastnameLocator =By.id("lastName");
    private final By emailLocator =By.id("userEmail");

    private GenderSection genderSection;

    public PracticeFormPage(WebDriver driver) {
        super(driver);
        driver.get(baseUrl.concat("automation-practice-form"));
        genderSection=new GenderSection(driver);

    }
    public GenderSection genderSection(){return this.genderSection;}

    public void setName(String name){
      type(nameLocator,name);
    }
    public void setLastName(String lastName){
        type(lastnameLocator,lastName);
    }
    public void setEmail(String email){
        type(emailLocator,email);
    }
    public  String getName(){
        return find(nameLocator).getAttribute("value"); //If there is no text, we use the expression 'value'.
    }
    public String getLastName(){
        return find(lastnameLocator).getAttribute("value");
    }
    public String getEmail(){
        return find(emailLocator).getAttribute("value");
    }


}
