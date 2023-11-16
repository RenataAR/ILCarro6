package tests;

import manage.NGListener;
import manage.ProviderData;
import model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(NGListener.class)

public class LoginTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(app.getUser().isLogged()){
            app.getUser().logOut();
        }
    }

    @Test(dataProvider = "loginModelDto", dataProviderClass = ProviderData.class)
    public void loginPositiveTest(User user){
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLoginForm();
        Assert.assertTrue(app.getUser().isLoginSuccess());
    }

    @Test
    public void loginNegativeTestWrongEmail(){
        User user = User.builder()
                .email("galinagmail.com")
                .password("Gg123456$")
                .build();
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLoginForm();
        Assert.assertTrue(app.getUser().isLoginFailed());
    }

    @Test
    public void loginNegativeTestWrongPassword(){
        User user = User.builder()
                .email("galina@gmail.com")
                .password("Gg123456")
                .build();
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLoginForm();
        Assert.assertTrue(app.getUser().isLoginOrPasswordIncorrect());
    }

    @AfterMethod
    public void postCondition(){
        app.getUser().clickOkButton();
    }
}
