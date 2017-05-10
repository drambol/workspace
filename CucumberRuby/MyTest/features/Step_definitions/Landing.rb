Then(/^I am on Landing Page$/) do
	@page = LandingPage.new
	sleep 5
	#expect(page).to be_displayed
	#page.click_menu
end

Then(/^I click Menu$/) do
	@page.click_menu
end
