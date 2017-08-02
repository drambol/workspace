 require 'parseexcel'

# Parsing an existing workbook, The .xls file must be saved in EXCEL 2003 format. So File-->Save As from All Formats dropdown select the Excel year 2003 
workbook = Spreadsheet::ParseExcel.parse("C:/Grace/Automation/CucumberRuby/MyTest/test-data/data2.xls")

#Define working sheet
worksheet = workbook.worksheet('SG')
      
worksheet.each { |row|  
  j=0  
  i=0  
  if row != nil  
   
  row.each { |cell|  
    if cell != nil    
      contents = cell.to_s('latin1')  
      puts "Row: #{j} Cell: #{i}> #{contents}"  
      #puts "asdfasdfadf"
    end  
    i = i+1  
  }  
  j = j +1  
  end  
}  


