import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test_Setting_Name_Lastname_Email extends  BaseTest{

    @Test
    public void setName(){
        PracticeFormPage practiceFormPage=new PracticeFormPage(driver);
        practiceFormPage.setName("Zehra");
        Assertions.assertEquals("Zehra",practiceFormPage.getName(),"Name value is not correct!");

    }

    @Test
    public void setLastName(){
        PracticeFormPage practiceFormPage=new PracticeFormPage(driver);
        practiceFormPage.setLastName("Aykan");
        Assertions.assertEquals("Aykan",practiceFormPage.getLastName(),"Last name value is not correct!");

    }
    @Test
    public void setEmail(){
        PracticeFormPage practiceFormPage=new PracticeFormPage(driver);
        practiceFormPage.setEmail("zehra2324445.com");
        Assertions.assertEquals("zehra2324445.com",practiceFormPage.getEmail(),"Email value is not correct!");
    }
}
