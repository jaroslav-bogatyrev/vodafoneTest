package com.example.vodafoneTest.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class HomePage extends BasePage{

    @Autowired
    public WebDriver webDriver;


    @Value("${appUrl}")
    private String appUrl;

    @FindBy(how = How.XPATH, using = "//*[@value=\"allowAll\"]")
    public WebElement acceptAllCookiesButton;
    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Telefony a")
    public WebElement phonesAndDevicesLink;


    public void goToHomePage() throws InterruptedException {
        webDriver.navigate().to(appUrl);
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//*[@value=\"allowAll\"]")));
        acceptAllCookiesButton.click();
    }

    public void goToPhonesAndDevices() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Telefony a")));
        phonesAndDevicesLink.isDisplayed();
        phonesAndDevicesLink.click();
    }
}
