require 'parseexcel'  
      
#从命令行输入要打开的excel文件名  
workbook = Spreadsheet::ParseExcel.parse("C:/Grace/Automation/CucumberRuby/MyTest/test-data/data.xlsx")  
      
#得到第一个表单  
worksheet = workbook.worksheet['SG']  
      
#遍历行  
worksheet.each { |row|  
  j=0  
  i=0  
  if row != nil  
  #遍历该行非空单元格  
  row.each { |cell|  
    if cell != nil  
      #取得单元格内容为string类型  
      contents = cell.to_s('latin1')  
      puts "Row: #{j} Cell: #{i}> #{contents}"  
    end  
    i = i+1  
  }  
  end  
}  
