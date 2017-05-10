#features/step_definitions/SearchGoogle.rb

Given(/^I am on the Google homepage$/) do
    visit 'http://www.google.com/'
end

Then(/^I will search for "(.*?)"$/) do |searchText|
    fill_in 'q', :with => searchText
end

Then(/^I should see "(.*?)"$/) do |expectedText|
	expect(page).to have_content(expectedText)
end