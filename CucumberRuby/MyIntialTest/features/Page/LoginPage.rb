require 'page-object'

class LoginPage
  include PageObject
 
  page_url "https://218.189.41.121/breeze-oat2/#/public/login/"
   page_url "www.google.com/"
 
  text_field(:username, id: 'username_nameinput')
  text_field(:password, id: 'password_input')
  button(:login, type: 'login')
 
  def login_with(username, password)
    self.username = username
    self.password = password
    login
  end
end
