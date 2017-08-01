require 'capybara'
require 'capybara/cucumber'
require 'selenium-webdriver'
require 'site_prism'

class BaiduSearchPage < SitePrism::Page

  set_url "http://www.google.com"

  element :inputBox, :xpath, "//input[@id='lst-ib']"
  element :searchButton, :xpath, "//input[@type='submit'][1]"

  def input_txt(str)
  	inputBox.set str
  end
 
  def click_submit
  	searchButton.click
  end
end