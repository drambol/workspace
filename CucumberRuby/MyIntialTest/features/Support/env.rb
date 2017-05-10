require 'capybara'
require 'capybara/cucumber'
require 'capybara/poltergeist'
require 'selenium-webdriver'

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