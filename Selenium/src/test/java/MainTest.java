import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

import java.time.Duration;


public class MainTest {

    public WebDriver driver;



    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions().addArguments("user-data-dir=C:\\\\webdriver") ;
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();


    }


//https://johnfrancis.atlassian.net/secure/BrowseProjects.jspa?selectedProjectType=software
   // @Test
    public void LogInTest_GoToJiraSoftware_Page()  {




        LogInPage LogIn_Page = new LogInPage(this.driver);

        System.out.println(LogIn_Page.driver.getTitle());

        Assert.assertTrue(LogIn_Page.get_footerText().contains("One account for Jira, Confluence, Trello and "));

        StartPage Start_Page = LogIn_Page.LogIn("john.issam.francis@gmail.com","ElteCode@01");
        // this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Start_Page.waitForTitle("Atlassian | Start page");
        System.out.println("--------------here -----------------");
        System.out.println(LogIn_Page.driver.getTitle());

       Assert.assertTrue(Start_Page.get_Title().contains("Start page"));

      //  System.out.println(Start_Page.driver.getTitle());
        System.out.println("--------------here -----------------");
        JiraSoftwarePage  Jira_SoftwarePage = Start_Page.GoTo_JiraSoftware("johnfrancis");

          this.driver.close();

      // String ProjectName =  Jira_SoftwarePage.Get_Current_Project_a_Text() ;
      //  Assert.assertTrue(ProjectName == "johnfrancis");



        System.out.println("JiraSoftwarePage - returned");

    }












    @Test
   public void CreateNewJiraScrumProjectTest()
   {
       try{
         //  this.LogInTest_GoToJiraSoftware_Page() ;

           this.driver.get("https://start.atlassian.com/");

           StartPage Start_Page = new StartPage(this.driver) ;
          // this.driver.navigate().refresh();
           //Start_Page.WaitToAuthiticate();
          // Thread.sleep(2000);
           JiraSoftwarePage  JiraSoftware_Page =  Start_Page.GoTo_JiraSoftware("") ;
          // this.wait.until(ExpectedConditions.urlContains("https://start.atlassian.com/"));

        //   JiraSoftwarePage  JiraSoftware_Page = new JiraSoftwarePage(this.driver) ;

           JiraSoftware_Page.createNewScrumProject("Project1");

           String ProjectName = "Project_1" ;
           JiraSoftware_Page.createNewScrumProject(ProjectName);
           Assert.assertTrue(JiraSoftware_Page.Get_Current_Project_a_Text() == ProjectName);

           this.driver.close();
       }catch (Exception E) {
           this.driver.close();

       }

    }

    /*@Test
    public void TestLoadJira_SoftwarePage() {

        StartPage Start_Page = new StartPage(this.driver) ;
        Start_Page.GoTo_JiraSoftware("johnfrancis") ;






    }*/




   /* @Test
    public void testSearch2() {
        String[] searchQueries={"something","","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"};
        for(String searchQuery : searchQueries) {
            MainPage mainPage = new MainPage(this.driver);
            SearchResultPage searchResultPage = mainPage.search(searchQuery);
            String bodyText = searchResultPage.getBodyText();
            Assert.assertTrue(bodyText.contains("found"));
        }
    }*/



    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}



