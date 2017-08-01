Given(/^I am on Baidu Page$/) do
	@page = BaiduSearchPage.new
	@page.load
end	

Then(/^Input search criteria with "(.*?)"$/) do |str|
	@page.input_txt(str)
end	

Then(/^Click submit$/) do
	@page.click_submit
end	