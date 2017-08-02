require 'rubyXL'

# Creating a new Workbook
#workbook = RubyXL::Workbook.new

def getData
# Parsing an existing workbook
workbook = RubyXL::Parser.parse("C:/Grace/Automation/CucumberRuby/MyTest/test-data/data.xlsx")
#Define working sheet
worksheet = workbook['SG']

#Table reading
worksheet.each { |row|
   row && row.cells.each { |cell|
     val = cell && cell.value
     puts(val)
   }
}
end

getData
