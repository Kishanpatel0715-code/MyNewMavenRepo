package data;

import utilities.Xls_Reader;

public class DataFile {

	Xls_Reader d = new Xls_Reader("C:\\testing\\NikulTest.xlsx");
	
	  //Login Data
	  public String correctEmail = d.getCellData("Data1", "UserName", 2);
	  public String wrongEmail =  d.getCellData("Data1", "UserName", 3);
	  public String wrongPassword = d.getCellData("Data1", "Password", 2);
	  public String passwordErr = d.getCellData("Data1", "Password Error", 2);
	  public String emailErr = d.getCellData("Data1", "Email Error", 2);
	 
	  //Home Page
	  
	  //Footer
	  
	  
	  //AddToCart
}
