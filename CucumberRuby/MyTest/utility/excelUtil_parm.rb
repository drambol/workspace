require 'rubyXL'

# Creating a new Workbook
#workbook = RubyXL::Workbook.new

def getData(str)
# Parsing an existing workbook
workbook = RubyXL::Parser.parse("C:/Grace/Automation/CucumberRuby/MyTest/test-data/data.xlsx")
#Define working sheet
worksheet = workbook['SG']

#Table reading
worksheet.each { |row|
   row && row.cells.each { |cell|
     val = cell && cell.value
     #expect(@cell.value).to eq(str)
     if cell.value.eql? str
    	 puts(val)
 	 end
   }
}
end

getData('Location')
