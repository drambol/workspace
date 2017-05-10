require 'capybara'
require 'capybara/cucumber'
require 'selenium-webdriver'
require 'site_prism'

class LandingPage < SitePrism::Page

  element :menu, "a[id='menu']"
 
  def click_menu()
    menu.click
  end
end