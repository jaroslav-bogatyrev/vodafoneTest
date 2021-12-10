package com.example.vodafoneTest.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class PhonesPage extends BasePage{

    @Autowired
    public WebDriver webDriver;

    @FindBy(how = How.ID, using = "s2id_customerTypeSelect")
    public WebElement checkClientDdropdown;
    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Telefony a")
    public WebElement phonesAndDevicesLink;
    @FindBy(how = How.ID, using = "tariffsSelect")
    public WebElement tariffSelector;
    @FindBy(how = How.XPATH, using = "//*[@data-tariff=\"cena\"]")
    public WebElement phoneWithoutTariff;
    @FindBy(how = How.ID, using = "product_sony-xperia-10-iii-5g:soxperiaiii5g")
    public WebElement sonyXperia10Phone;
    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Koupit telefon bez")
    public WebElement buyPhoneWithoutTariffBtn;
    @FindBy(how = How.ID, using = "detail_image")
    public WebElement phoneDetailsImage;
    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Pokračovat v objednávce")
    public WebElement proceedWithOrder;


    public boolean checkIfUserIsNotClient(){
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("s2id_customerTypeSelect")));
        return checkClientDdropdown.getText().toString().contains("Nejsem");
    }

    public void choosePhoneWithoutTariff() throws InterruptedException {
        Thread.sleep(5000);
        JavascriptExecutor jse = (JavascriptExecutor)webDriver;
        jse.executeScript("arguments[0].click()", tariffSelector);
        jse.executeScript("arguments[0].click()", phoneWithoutTariff);
        Thread.sleep(5000);
    }

    public boolean checkIfUserChosenWithoutTariffCorrectly(){
        return tariffSelector.getText().toString().contains("Ne, chci telefon bez tarifu");
    }

    public void chooseSonyXperiaPhone()
    {
        sonyXperia10Phone.click();
        phoneDetailsImage.isDisplayed();
    }

    public void chooseToBuyWithoutTariff(){
        buyPhoneWithoutTariffBtn.click();
    }

    public void takeScreenshot(String pathname) throws IOException {
        File src = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(pathname));
    }

    public void proceedWithOrder() throws InterruptedException {
        proceedWithOrder.click();
        Thread.sleep(10000);
    }

}
