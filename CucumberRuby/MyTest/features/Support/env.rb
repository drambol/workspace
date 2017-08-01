require 'capybara'
require 'capybara/cucumber'
require 'capybara/poltergeist'
require 'selenium-webdriver'
require 'capybara/angular'
require 'rspec/expectations'
require 'capybara-screenshot/cucumber'
require 'date'

if ENV['chrome']
 Capybara.default_driver = :chrome
 Capybara.register_driver :chrome do |app|
 options = {
 :js_errors => true,
 :timeout => 360,
 :debug => false,
 :inspector => false,
 }
 Capybara::Selenium::Driver.new(app, :browser => :chrome)
 end
 elsif ENV['firefox']
 Capybara.default_driver = :firefox
 Capybara.register_driver :firefox do |app|
 options = {
 :js_errors => true,
 :timeout => 360,
 :debug => false,
 :inspector => false,
 }
 Capybara::Selenium::Driver.new(app, :browser => :firefox)
 end
 elsif
 Capybara.default_driver = :poltergeist
 Capybara.register_driver :poltergeist do |app|
 options = {
 :js_errors => false,
 :timeout => 360,
 :debug => false,
 :phantomjs_options => ['--load-images=no', '--disk-cache=false'],
 :inspector => false,
 }
 Capybara::Poltergeist::Driver.new(app, options)
 end
end

#set wait time for loading pages
include Capybara::Angular::DSL
Capybara.default_selector = :xpath
Capybara.default_max_wait_time = 20
World(RSpec::Matchers)

Before do
  #page.driver.browser.manage.window.resize_to(1366, 768)
  #page.driver.browser.manage.window.maximize
  window = Capybara.current_session.driver.browser.manage.window
  window.maximize # width, height
end

After do
#   Capybara::Screenshot doesn’t know that :chrome is a Selenium driver. Either call your driver :selenium and it’ll use this code to take screenshots, or define a similar driver:
#	Capybara::Screenshot.register_driver(:chrome) do |driver, path|
#  	driver.browser.save_screenshot('C:/Grace/Automation/CucumberRuby/MyTest/GraceTestScreenshot.png')
	time = Time.now.strftime("%Y%m%d%H%M%S")
  	page.save_screenshot "screenshots/#{time}.png"
end
