require 'selenium-webdriver'
require 'capybara'

#take screenshot in each page
def take_screenshot(name)
	page.save_screenshot "screenshots/#{name}.png"
end
