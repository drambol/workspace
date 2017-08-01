require 'selenium-webdriver'

# Other drivers are available as well http://selenium.googlecode.com/svn/trunk/docs/api/rb/Selenium/WebDriver.html#for-class_method
driver = Selenium::WebDriver.for :chrome
driver.navigate.to 'http://www.google.com'

driver.save_screenshot('screenshot.png')

driver.quit
