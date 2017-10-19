package test.selfTest;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseline.AutoContext;
import baseline.MyDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import test.BaseCaseTemplate;
import utility.dateTime.DateTime;

public class FullScreenshot extends BaseCaseTemplate{

	@Test
	public void testBaiDu() throws SQLException, IOException {

		MyDriver driver = AutoContext.myWebDriverTL.get();
		driver.get("http://www.baidu.com/");
		WebElement txtbox = driver.findElement(By.name("wd"));
		txtbox.sendKeys("StandardChartered");
		WebElement btn = driver.findElement(By.id("su"));
		btn.click();

		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='1']/h3/a/em")).getText(), "Standard Chartered",
				"test pass");
		Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver.getOriginalDriver());
		String fileName = DateTime.getCurrentTime() + ".png";
	    ImageIO.write(fpScreenshot.getImage(),"PNG",new File(System.getProperty("user.dir") + "\\screenshot\\" + fileName));

	}
}
