Given(/^I am on Landing Page$/) do
	@page = LandingPage.new
	sleep 5
end

Then(/^I click Menu$/) do
	@page.click_menu
end
