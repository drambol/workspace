Given(/^I am on Landing Page$/) do
	@page = LandingPage.new
	#sleep 15
	#expect(@page).to have_xpath("//a[@id='menu']")
	#expect(@page).to have_selector(:xpath, "//a[@id='menu']")
	#@page.wait_until_menu_visible
	@page.wait_for_menu
	#expect(@page).to have_menu
	#expect(@page).to have_content("I Have")
	#expect(@page).to have_selector(:xpath, "//script[@id='metamorph-151-start']")
end

Then(/^I click Menu$/) do
	@page.click_menu
end
