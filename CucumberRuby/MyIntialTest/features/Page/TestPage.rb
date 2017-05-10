require 'capybara'
require 'capybara/dsl'
require 'capybara/rspec'
require 'selenium-webdriver'
require 'site_prism'

class TestPage < SitePrism::Page
  set_url "https://218.189.41.121/breeze-oat2/#/public/login"
 
  element :username, "input[id='username_input']"
  element :password, "input[id='password_input']"
  element :login, "input[type='submit']"
 
  def login_with(un, psd)
    username.set un
    password.set psd
    login.click
  end
end