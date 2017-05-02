package business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import page.Move.AddBillerConfirmPage;
import page.Move.BillerNameListPage;
import page.Move.BillerTypeListPage;
import page.Move.MovePage;
import page.Move.SelectBillerPage;
import page.Move.ToPage;
import pageObject.PageLoader;
import utility.file.ExcelUtil;
import utility.tools.RandomString;

public class AddBillerBusiness {

	static final Logger logger = LoggerFactory.getLogger(AddBillerBusiness.class);
	MovePage movePage = PageLoader.load(MovePage.class);
	ToPage toPage = PageLoader.load(ToPage.class);
	SelectBillerPage selectBillerPage = PageLoader.load(SelectBillerPage.class);
	BillerTypeListPage billerTypePage = PageLoader.load(BillerTypeListPage.class);
	BillerNameListPage billerNamePage = PageLoader.load(BillerNameListPage.class);
	AddBillerConfirmPage addBillerConfirmPage = PageLoader.load(AddBillerConfirmPage.class);

	public void SelectBillerType() {

		movePage.getCurrentPage();
		toPage = movePage.SelectToAccount();
		selectBillerPage = toPage.SelectTxnType();
		billerTypePage = selectBillerPage.SelectBillerType();
		selectBillerPage = billerTypePage.selectBillerType(ExcelUtil.getData("AddBillerType"));
		billerNamePage = selectBillerPage.SelectBillerName();
		selectBillerPage = billerNamePage.selectBillerName(ExcelUtil.getData("AddBillerName"));
		selectBillerPage.AccountNumber(RandomString.getRandomDigit().substring(0, 8));
		selectBillerPage.AccountPIN(RandomString.getRandomDigit().substring(0, 6));
		addBillerConfirmPage = selectBillerPage.ClickContinue();
	}

	public void goToMove() {

		movePage.getCurrentPage();

	}
}
