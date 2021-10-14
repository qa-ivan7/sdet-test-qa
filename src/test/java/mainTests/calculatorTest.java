package mainTests;

import org.junit.jupiter.api.*;
import POM.objectModel;


import static java.lang.Thread.sleep;


public class calculatorTest extends objectModel {

    @Test
    @DisplayName("Проверка операций с целыми числами")
    void test1() throws InterruptedException {
        driver.get("http://google.com");
        calcSearchInGoogle();
        sleep(1000);
        calcBtn();
        sleep(1000);
        calcExpressionFirst();
        sleep(1000);
        resultAssertionForFirst();
    }

    @Test
    @DisplayName("Проверка деления на ноль")
    void test2() throws InterruptedException {
        driver.get("http://google.com");
        calcSearchInGoogle();
        sleep(1000);
        calcBtn();
        sleep(1000);
        calcExpressionForSecond();
        sleep(1000);
        resultAssertionForSecond();
    }

    @Test
    @DisplayName("Проверка деления на ноль")
    void test3() throws InterruptedException {
        driver.get("http://google.com");
        calcSearchInGoogle();
        sleep(1000);
        calcBtn();
        sleep(1000);
        calcExpressionForThird();
        sleep(1000);
        resultAssertionForThird();
    }
}
