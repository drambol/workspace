#require_relative '../Page/MyAccountsPage.rb'

Given(/^I am on MyAccounts Page$/) do
	@page = MyAccountsPage.new
end

Then(/^I input TSP PIN with "(.*?)"$/) do |pin|
	@page.input_pin(pin)
end