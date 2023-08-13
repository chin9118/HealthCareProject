package executePageClasses;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import Utilities.ExcelRead;

public class DataProviderClass {

  
  @DataProvider(name="login")
  public Object[][] dp() throws IOException {
    return new Object[][] {
      new Object[] { ExcelRead.getStringData(2,4), ExcelRead.getStringData(3,4) },
      new Object[] { ExcelRead.getStringData(2,5), ExcelRead.getStringData(3,5) },
      new Object[] { ExcelRead.getStringData(2,6), ExcelRead.getStringData(3,6) }
    };
  }
    
    @DataProvider(name="loginsuccessful")
    public Object[][] dp1() throws IOException {
      return new Object[][] {
        new Object[] { ExcelRead.getStringData(2,1), ExcelRead.getStringData(3,1)},
       };
  }
    
    
}
