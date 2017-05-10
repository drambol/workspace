require 'page-object'
include PageObject::PageFactory
require_relative '../Page/LoginPage.rb'

Given(/^Go to LoginPage and login with "(.*?)" and "(.*?)"$/) do |username, password|
	visit(LoginPage).login(username, password)
end

Given(/^Go to LoginPage$/) do
	visit(LoginPage) 
end