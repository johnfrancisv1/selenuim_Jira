import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;


class PageBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected FluentWait fluent_wait ;
    
    
    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        this.fluent_wait = new FluentWait(driver);
    }
    
    protected WebElement waitAndReturnElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    } 
    
    public String getBodyText() {
        WebElement bodyElement = this.waitAndReturnElement(By.tagName("body"));
        return bodyElement.getText();
    }

    public String get_Title() {
      return this.driver.getTitle() ;
    }

    public void waitForTitle(String Title)  {
       this.wait.until(ExpectedConditions.titleContains(Title));
    }

    public void WaitFor_Duration(int millisecond){
        this.fluent_wait.withTimeout(Duration.ofMillis(millisecond));
    }

   
}
