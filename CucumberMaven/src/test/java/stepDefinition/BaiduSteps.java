package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import page.BaiduHome_page;

/**
 * Created by 1547857 on 5/3/2017.
 */
public class BaiduSteps {

    private WebDriver driver = BaseCaseTemplate.driver;
    BaiduHome_page baiduHome_page = PageFactory.initElements(driver, BaiduHome_page.class);

    @Given("^Go to baidu home$")
    public void go_to_baidu_home() throws Exception {
        driver.navigate().to("http://www.baidu.com");

    }

    @When("^I find baidu logo$")
    public WebElement i_find_baidu_logo() {
        WebElement element = baiduHome_page.ElementBaiduLogo;
        return element;
    }

    @And("^Type the search text \"([^\"]*)\"$")
    public void type_the_search_text(String searchText) throws Throwable {
        baiduHome_page.enterSearch(searchText);
    }

    @And("^Click the submit$")
    public void click_the_submit() {
        baiduHome_page.submit();
    }

    @Then("^Wait the query result$")
    public void wait_the_query_result() throws InterruptedException {
        Thread.sleep(5000);    //后面可以用显示等待或者隐示等待来优化代码
        Assert.assertEquals("selenium_百度搜索", baiduHome_page.getPageTitle());
    }
}
