import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage extends PageBase {

    private final By bodyLocator = By.tagName("body");
    private final By searchTogglerLocator = By.className("search-bar-toggler");
    private final By searchLocator = By.xpath("//div[@class='sliding-search-wrapper']/form/input[@name='search']");

    private final By footerLocator = By.xpath("//footer[@class='sc-ifAKCX blPkwJ']") ;
    private final By EmailLocator = By.name("username") ;
    private final By login_submitLocator = By.id("login-submit") ;
    private final By passwordLocator = By.name("password") ;



    public LogInPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://id.atlassian.com/login");
    }

    public StartPage LogIn(String UserName , String Pass){

        WebElement UserNameElement = this.waitAndReturnElement(EmailLocator );
        UserNameElement.click();
        UserNameElement.sendKeys(UserName);

        WebElement ContinueBtnElement = this.waitAndReturnElement(login_submitLocator );
        ContinueBtnElement.click();

        // the webpage redirect to password page

        WebElement PasswordElement = this.waitAndReturnElement(passwordLocator );
        PasswordElement.click();
        PasswordElement.sendKeys(Pass);


        WebElement LogInBtnElement = this.waitAndReturnElement(login_submitLocator );
        LogInBtnElement.click();

        return new StartPage(this.driver) ;

        //password



    }

    public String get_footerText(){
        WebElement resultElement = this.waitAndReturnElement(footerLocator);
        return resultElement.getText() ;
    }
}
