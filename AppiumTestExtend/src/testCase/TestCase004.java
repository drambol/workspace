package testCase;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Node;

import page.CommonPage;
import page.literature.ArticlePage;
import page.miscellaneous.BrokerHelperPage;
import pageObject.PageLoader;
import utility.database.ExcelUtil;
import utility.file.FileUtility;
import utility.file.XmlParser;

public class TestCase004 extends BaseCaseTemplate {
	
	/**
	 * This case could only be run on Firefox until code was improved.
	 */
	@Test
	public void XMLPageTest() {
		BrokerHelperPage brokerHelperPage = new BrokerHelperPage();
		brokerHelperPage.getCurrentPage();
		String url = brokerHelperPage.getEventsGeneric();
		String fileName = "test.xml";
		FileUtility.writeFile(fileName, url);
		XmlParser xml = new XmlParser(fileName);
		
		//Among all events, find the event which the title is "Fispal"
		Node node = xml.getNodeByValue("Title", "Fispal").getParentNode();
		
		String link = xml.getChildNode(node, "Link").getTextContent();
		String startDate = xml.getChildNode(node, "StartDate").getTextContent();
		String endDate = xml.getChildNode(node, "EndDate").getTextContent();
		String location = xml.getChildNode(node, "Location").getTextContent();
		
		System.out.println("Link: " + link);
		System.out.println("StartDate: " + startDate);
		System.out.println("EndDate: " + endDate);
		System.out.println("Location: " + location);

		List<Node> associatedBrands = xml.getChildNodes(node, "AssociatedBrands");
		for(int i=0;i<associatedBrands.size();i++){
			System.out.println("AssociatedBrands: " + associatedBrands.get(i).getTextContent());
		}
		
	}
	
	@Test
	public void xxxtest() {
		CommonPage commonPage = new CommonPage();
		System.out.println(commonPage.verifyNavigation());
	}
	
	@Test
	public void LiteratureTest() {
		ArticlePage articlepage = PageLoader.load(ArticlePage.class);
		articlepage.getCurrentPage("literature");
		String title = articlepage.getHeaderName();
		Assert.assertEquals(title, "literature");
		Assert.assertEquals(articlepage.verifyNavigation(), true);
		Assert.assertEquals(articlepage.verifyBreadcrumbs(), true);
		Assert.assertEquals(articlepage.verifyContainer(), true);
		ExcelUtil.writeTestResult("Test Result Report", 5, 1, true);
		articlepage.navigateTo("articles",1);
		Assert.assertEquals(articlepage.verifyBreadcrumbs(), true);
		Assert.assertEquals(articlepage.verifyContainer(), true);
		ExcelUtil.writeTestResult("Test Result Report", 6, 1, true);
		articlepage.navigateTo("case studies",1);
		Assert.assertEquals(articlepage.verifyBreadcrumbs(), true);
		Assert.assertEquals(articlepage.verifyContainer(), true);
		ExcelUtil.writeTestResult("Test Result Report", 7, 1, true);
		articlepage.navigateTo("white papers",1);
		Assert.assertEquals(articlepage.verifyBreadcrumbs(), true);
		Assert.assertEquals(articlepage.verifyContainer(), true);
		ExcelUtil.writeTestResult("Test Result Report", 8, 1, true);
	}

}
