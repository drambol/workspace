# require_relative '../Page/TestPage.rb'

Given(/^Go to Login and login with "(.*?)" and "(.*?)"$/) do |username, password|
	page = TestPage.new
	page.load
	page.login_with(username, password)
end