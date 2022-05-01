import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;


public class StartPage extends PageBase {


    private final By titlePLocator = By.id("recentsTabs-1-tab") ;
    //sc-bmyXtO hFxQig



    public StartPage(WebDriver driver) {
        super(driver);
    }

    public void WaitToAuthiticate(){
        this.wait.until(ExpectedConditions.urlContains("authorize?token")) ;
        this.wait.until(ExpectedConditions.urlToBe("https://start.atlassian.com/")) ;


    }



    public JiraSoftwarePage GoTo_JiraSoftware(String SiteName)  {


     //   this.driver.get("https://start.atlassian.com/");

       this.wait.until(ExpectedConditions.urlToBe("https://start.atlassian.com/"));

        WebElement titlePLocator_WebElement = this.waitAndReturnElement(titlePLocator) ;
      //  this.driver.navigate().refresh();
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
       // this.wait.until(ExpectedConditions.urlToBe("https://start.atlassian.com/"));
       // By JiraSoftwareLinkLocator = By.xpath("//a[@class='sc-iAyFgw rLxqC' and contains(@href ,'johnfrancis.atlassian.net') and //button[@role='presentation']] ");
       // By JiraSoftwareLinkLocator = By.xpath("//a[@class='sc-iAyFgw rLxqC' and contains(@href ,'johnfrancis.atlassian.net') ]//button[@role='presentation'] ");
        By JiraSoftwareLinkLocator = By.xpath("//div[@data-testid='start-product__JIRA_SOFTWARE_33cb968f-696b-4a3b-9e59-461af0b1b8dc']") ;
        //start-product__JIRA_SOFTWARE_33cb968f-696b-4a3b-9e59-461af0b1b8dc
        WebElement JiraSoftwareLink_WebElement = this.waitAndReturnElement(JiraSoftwareLinkLocator) ;
      // JiraSoftwareLink_WebElement.click();

        System.out.println("--------------click  to johnfrancis.atlassian");
        //this.driver.get("https://johnfrancis.atlassian.net/jira/projects?selectedProjectType=software");

        System.out.println("done --------------navigate to johnfrancis.atlassian");
        JiraSoftwarePage Jira_SoftwarePage = new JiraSoftwarePage(this.driver) ;
        System.out.println("done -------------- waitin for LoadingCreateProjectButtong");
        Jira_SoftwarePage.Wait_for_LoadingCreateProjectButton();
        System.out.println("done --------------done waitin for LoadingCreateProjectButtong");
//        Jira_SoftwarePage.wait.until(ExpectedConditions.urlToBe("https://johnfrancis.atlassian.net/jira/projects?selectedProjectType=software")) ;
//        Jira_SoftwarePage.driver.get("https://johnfrancis.atlassian.net/jira/projects?selectedProjectType=software");
       // this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        System.out.println("--------------here return jira software page");

//        try {
//            Thread.sleep(8000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.stop();");


//        try{
//
//            this.wait.until(ExpectedConditions.urlToBe("https://start.atlassian.com/"));
//
//            System.out.println("--------------here return to jira start");
//             JiraSoftwareLinkLocator = By.xpath("//a[contains(@href ,'johnfrancis.atlassian.net') ]//button[@role='presentation'] ");
//            JiraSoftwareLink_WebElement = this.waitAndReturnElement(JiraSoftwareLinkLocator) ;
//            JiraSoftwareLink_WebElement.click();
//        }catch (Exception E){
//
//       }


        return Jira_SoftwarePage ;

    }
}
