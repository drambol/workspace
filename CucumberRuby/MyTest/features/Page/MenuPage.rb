require 'capybara'
require 'capybara/cucumber'
require 'selenium-webdriver'
require 'site_prism'

class MenuPage < SitePrism::Page

  element :myaccounts, :xpath, "//a[@id='menu-OwnAccountTransfer']"

  def click_myaccounts
    myaccounts.click
    #execute_script("$(myaccounts).click()")
  end
end