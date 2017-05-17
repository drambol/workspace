require 'capybara'
require 'capybara/cucumber'
require 'selenium-webdriver'
require 'site_prism'

class MyAccountsPage < SitePrism::Page

  element :inputPIN, :xpath, "//input[@id='inputPIN']"

  def input_pin(pin)
    inputPIN.set pin
  end
end