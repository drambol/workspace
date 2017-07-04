# require_relative '../Page/TestPage.rb'
Given(/^I am on Login Page$/) do
	@page = LoginPage.new
	@page.load
end		

Then(/^I login with "(.*?)" and "(.*?)"$/) do |username, password|
	#@page = LoginPage.new
	#@page.load
	@page.login_with(username, password)
end

Then(/^take screenshoot$/) do
	@page.save_screenshot('screenshot.png')
end
