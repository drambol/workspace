#require_relative '../Page/MenuPage.rb'

Given(/^I am on Menu$/) do
	@page = MenuPage.new
end

Then(/^I click MyAccounts$/) do
	@page.click_myaccounts
end