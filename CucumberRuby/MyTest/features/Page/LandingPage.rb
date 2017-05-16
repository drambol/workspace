require 'capybara'
require 'capybara/cucumber'
require 'selenium-webdriver'
require 'site_prism'

class LandingPage < SitePrism::Page

  #element :menu, "a[id='menu']"
  element :menu, :xpath, "//a[@id='menu']"
 
  def click_menu
    #wait_until{ menu.visible? }
  	#menu.click 
  	execute_script("$(menu).click()")
  end
end
