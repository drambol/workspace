require 'selenium-webdriver'
require 'capybara'

def take_screenshot(name)
	page.save_screenshot "screenshots/#{name}.png"
end