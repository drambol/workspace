package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import stepDefinition.BaseCaseTemplate;

/**
 * Created by 1547857 on 5/3/2017.
 */
public class BaiduHome_page {

    private WebDriver driver = BaseCaseTemplate.driver;
//    BaiduHome_page baiduHome_page = PageFactory.initElements(driver, BaiduHome_page.class);

//    public BaiduHome_page(WebDriver driver){
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }

    //百度logo
    @FindBy(xpath="//div[@id='lg']/img")
    public WebElement ElementBaiduLogo;

    //输入框
    @FindBy(id="kw")
    public WebElement ElementBaiduInput;

    //按钮 查询一下
    @FindBy(id="su")
    public WebElement ElementSubmit;


    //获取当前页面面包屑信息 预约订单
    public String getPageTitle(){
        return driver.getTitle();
    }

    // 输入查询内容，并点击查询按钮
    public void enterSearch(String searchText){
        ElementBaiduInput.sendKeys(searchText);
    }

    // 输入查询内容，并点击查询按钮
    public void submit(){
        ElementSubmit.click();
    }
}
