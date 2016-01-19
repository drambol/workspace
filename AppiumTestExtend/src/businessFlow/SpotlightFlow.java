package businessFlow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import page.HomePage;
import page.literature.ArticlePage;
import pageObject.PageLoader;

public class SpotlightFlow {
	
	static final Logger logger = LoggerFactory.getLogger(SpotlightFlow.class);
	
	public boolean verifyArticles() {
		HomePage homePage = PageLoader.load(HomePage.class);
		homePage.getCurrentPage();
		int spotlightCount = homePage.getSpotlightArticleCount();
		logger.info("[Spotlight Article] spotlightCount: " + spotlightCount);
		for (int i = 0; i < spotlightCount; i++) {
			ArticlePage articlePage = homePage.clickSpotlightArticle(i);
			if (!articlePage.verifyStoryExists()) {
				logger.info("[Spotlight Article] Article NOT Exists!");
				return false;
			}
		}
		logger.info("[Spotlight Article] All Article Exists!");
		return true;
	}

}
