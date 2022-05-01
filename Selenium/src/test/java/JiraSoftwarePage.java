import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Random;
import java.util.random.RandomGenerator;

public class JiraSoftwarePage extends LogInPage {


    //global-pages.directories.projects-directory-v2.create-projects-button.button.button


    private final By CreateProjectButtonLocator = By.xpath("//button[@data-test-id='global-pages.directories.projects-directory-v2.create-projects-button.button.button']") ;
    private final By SelectScrumButtonLocator = By.xpath("//button[@data-test-class='project-template-select-v2.ui.layout.category-overview.template-list-card.template-list-card-container' and .//div/h4[text()='Scrum']]") ;
    private final By UseTemplateButtonLocator = By.xpath("//button[@data-testid='project-template-select-v2.ui.layout.screens.template-overview.template-overview-card.use-template-button.button']") ;
    private final By SelectTeamManagedButtonLocator = By.xpath("//button[@data-testid='project-template-select-v2.ui.layout.screens.project-types.footer.select-project-button-team-managed']") ;

    private final By FieldName_CreateProjectLocator = By.id("project-create.create-form.name-field.input") ;

    private final By CreateProjectSubmitLocator = By.xpath("//div[@data-test-id='project-create.create-form.create-screen.submit-button']/button[./span[text()='Create project']]");
    private final By CreatedProject_aLocator = By.xpath("//div[@class='sc-11q07q1-0 gsxdCo']/nav/ol/li/a[@class='css-oj2grg' and @href='/browse/TEST2']");

    //project-create.create-form.advanced-dropdown.key-field.input
    private final By FieldKeys_CreateProject_Locator = By.id("project-create.create-form.advanced-dropdown.key-field.input") ;



    public JiraSoftwarePage(WebDriver driver) {
        super(driver);
    }

    public void Wait_for_LoadingCreateProjectButton(){
        WebElement CreateProjectButtonElement = this.waitAndReturnElement(CreateProjectButtonLocator) ;
    }

    public void createNewScrumProject(String ProjectName) throws InterruptedException {
        WebElement CreateProjectButtonElement = this.waitAndReturnElement(CreateProjectButtonLocator) ;
        CreateProjectButtonElement.click();


          Thread.sleep(4000);


        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement SelectScrumButtonElement = this.waitAndReturnElement(SelectScrumButtonLocator) ;
        SelectScrumButtonElement.click();



        Thread.sleep(1000);

        WebElement UseTemplateButtonElement = this.waitAndReturnElement(UseTemplateButtonLocator) ;
        UseTemplateButtonElement.click();

        Thread.sleep(1000);

        WebElement SelectTeamManagedButtonElement = this.waitAndReturnElement(SelectTeamManagedButtonLocator) ;
        SelectTeamManagedButtonElement.click();

        Thread.sleep(1000);

        WebElement CreateProjectFieldNameElement = this.waitAndReturnElement(FieldName_CreateProjectLocator) ;
        CreateProjectFieldNameElement.click();
        CreateProjectFieldNameElement.sendKeys(ProjectName);


        Thread.sleep(1000);

        WebElement  FieldKeys = this.waitAndReturnElement(FieldKeys_CreateProject_Locator) ;
        FieldKeys.click();

//        String query = FieldKeys.getText() ;
//        Actions actions = new Actions(driver);
//        // go to the beginning of input
//        actions.sendKeys(Keys.HOME).build().perform();
//        int length = query.substring(0, 3).length();
//
//        actions.keyDown(Keys.LEFT_SHIFT);
//        for (int i = 0; i < length; i++){
//            actions.sendKeys(Keys.ARROW_RIGHT);
//        }
//        actions.keyUp(Keys.LEFT_SHIFT);
//        actions.build().perform();
//        FieldKeys.sendKeys(Keys.BACK_SPACE) ;
       // RandomGenerator.
        FieldKeys.sendKeys("key1");


        WebElement CreateProjectSubmitElement = this.waitAndReturnElement(CreateProjectSubmitLocator) ;
        CreateProjectSubmitElement.click();

        Thread.sleep(5000);

    }


    public String Get_Current_Project_a_Text(){
        WebElement Project_aElement = this.waitAndReturnElement(CreatedProject_aLocator) ;
        By Project_aSpanElement = By.xpath("//span") ;
        return Project_aElement.findElement(Project_aSpanElement).getText() ;
    }



}
