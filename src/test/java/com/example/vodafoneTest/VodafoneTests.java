package com.example.vodafoneTest;


import com.example.vodafoneTest.pages.PhonesPage;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.vodafoneTest.pages.HomePage;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.IOException;

@RunWith(SpringRunner.class) // using SpringRunner instead of @ExtendWith(SpringExtension.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-${spring.profiles.active:local}.properties")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VodafoneTests {

	@Autowired
	public HomePage homePage;

	@Autowired
	public PhonesPage phonesPage;

	@Test
	public void methodSolving() throws InterruptedException, IOException {
		homePage.goToHomePage();
		homePage.goToPhonesAndDevices();
		phonesPage.checkIfUserIsNotClient();
		phonesPage.choosePhoneWithoutTariff();
		phonesPage.checkIfUserChosenWithoutTariffCorrectly();
		phonesPage.chooseSonyXperiaPhone();
		phonesPage.chooseToBuyWithoutTariff();
		phonesPage.takeScreenshot("screenshots/scr.png");
		phonesPage.proceedWithOrder();
	}

}
