import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.util.List;

public class SeleniumDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        findLoginPageElements(driver);
        driver.quit();
    }

    private static void findExceptionPageElements(WebDriver driver) {
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
        // Find WebElement for the "Selenium WebDriver with Java for beginners program" link using link text and partial link text
        // Find WebElements for the input field using tag, class name, XPath, and CSS
        // Create a list of WebElements for all buttons using tag
        // Identify both buttons, using ID, name, CSS, XPath for each
    }

    private static void findLoginPageElements(WebDriver driver) {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        // WebElement locators will be added here
        WebElement usernameInputField = driver.findElement(By.id("username"));
        WebElement usernameInputFieldXpath = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement usernameInputFieldCss = driver.findElement(By.cssSelector("input[id='username']"));

        WebElement passwordInputField = driver.findElement(By.name("password"));
        WebElement passwordInputFieldXpath = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement passwordInputFieldCss = driver.findElement(By.cssSelector("input[name='password']"));

        WebElement submitButton = driver.findElement(By.className("btn"));
        WebElement submitButtonXpath = driver.findElement(By.xpath("//button[@id='submit']"));
        WebElement submitButtonCss = driver.findElement(By.cssSelector("button[id=submit]"));

        List<WebElement> inputFields = driver.findElements(By.tagName("input"));

        WebElement linkTextLocator = driver.findElement(By.linkText("Practice Test Automation."));
        WebElement partialLinkTextLocator = driver.findElement(By.partialLinkText("Test Automation"));

        WebElement passwordFieldBelowUsername = driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.id("username")));
        WebElement privacyPolicyLink = driver.findElement(RelativeLocator.with(By.tagName("a")).toRightOf(By.partialLinkText("Test Automation")));

        WebElement homeButton = driver.findElement(By.className("menu-item-home"));

    }

    private static String chromeTest(String url) {
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        String title = driver.getTitle();
        driver.quit();
        return title;
    }

    private static String firefoxTest(String url) {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get(url);
        String title = driver.getTitle();
        driver.quit();
        return title;
    }
}