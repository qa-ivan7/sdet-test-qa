package POM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class objectModel {

    public WebDriver driver;

    // Действия до старта всех тестов
    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    // Действия до старта каждого теста
    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
    }

    // Действия после каждого теста (выход из браузера)
    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    By searchBar = By.xpath("//input[@title='Поиск']");
    By searchButton = By.xpath("//input[@value='Поиск в Google']");
    By calc0 = By.xpath("//div[text()='0']");
    By calc1 = By.xpath("//div[text()='1']");
    By calc2 = By.xpath("//div[text()='2']");
    By calc3 = By.xpath("//div[text()='3']");
    By calc4 = By.xpath("//div[text()='4']");
    By calc5 = By.xpath("//div[text()='5']");
    By calc6 = By.xpath("//div[text()='6']");
    By calcRoundStart = By.xpath("//div[text()='(']");
    By calcRoundEnd = By.xpath("//div[text()=')']");
    By calcPlus = By.xpath("//div[@aria-label='сложение']");
    By calcMinus = By.xpath("//div[@aria-label='вычитание']");
    By calcMulti = By.xpath("//div[@aria-label='умножение']");
    By calcDel = By.xpath("//div[@aria-label='деление']");
    By calcResult = By.xpath("//div[@aria-label='равно']");
    By calcSinus = By.xpath("//div[@aria-label='синус']");
    By calcMemoryLine = By.xpath("//span[@class='vUGUtc']");
    By calcResultLine = By.xpath("//span[@id='cwos']");


    public objectModel calcSearchInGoogle() {
        driver.findElement(searchBar).sendKeys("Калькулятор");
        return this;
    }

    public objectModel calcBtn() {
        driver.findElement(searchButton).click();
        return this;
    }

    // Действия первого кейса

    public objectModel calcExpressionFirst() {
        driver.findElement(calcRoundStart).click();
        driver.findElement(calc1).click();
        driver.findElement(calcPlus).click();
        driver.findElement(calc2).click();
        driver.findElement(calcRoundEnd).click();
        driver.findElement(calcMulti).click();
        driver.findElement(calc3).click();
        driver.findElement(calcMinus).click();
        driver.findElement(calc4).click();
        driver.findElement(calc0).click();
        driver.findElement(calcDel).click();
        driver.findElement(calc5).click();
        driver.findElement(calcResult).click();
        return this;
    }

    public objectModel resultAssertionForFirst() {
        String calcMemory = driver.findElement(calcMemoryLine).getText();
        String calcResult = driver.findElement(calcResultLine).getText();
        assertEquals("(1 + 2) × 3 - 40 ÷ 5 =", calcMemory);
        assertEquals("1", calcResult);
        return this;
    }

    // Действия второго кейса

    public objectModel calcExpressionForSecond() {
        driver.findElement(calc6).click();
        driver.findElement(calcDel).click();
        driver.findElement(calc0).click();
        driver.findElement(calcResult).click();
        return this;
    }

    public objectModel resultAssertionForSecond() {
        String calcMemory = driver.findElement(calcMemoryLine).getText();
        String calcResult = driver.findElement(calcResultLine).getText();
        assertEquals("6 ÷ 0 =", calcMemory);
        assertEquals("Infinity", calcResult);
        return this;
    }

    // Действия третьего кейса

    public objectModel calcExpressionForThird() {
        driver.findElement(calcSinus).click();
        driver.findElement(calcResult).click();
        return this;
    }

    public objectModel resultAssertionForThird() {
        String calcMemory = driver.findElement(calcMemoryLine).getText();
        String calcResult = driver.findElement(calcResultLine).getText();
        assertEquals("sin() =", calcMemory);
        assertEquals("Error", calcResult);
        return this;
    }

}
