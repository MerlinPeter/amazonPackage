package amazonPackage;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AmazonDriver {
	static WebDriver driver;

	public static void main(String[] args)  throws Exception{

		String dt_path ="/Users/peter/Downloads/Amazon_TestSuite.xlsx";
		String[][] recData= 	ReusableMethods.readXLSheet(dt_path, "Sheet1");
		
		//check that box for firefox use this if 
	/*	System.setProperty("webdriver.gecko.driver", "/Users/peter/Downloads/Seleniumtestcases/geckodriver");
		driver = new FirefoxDriver(); */
		 

		System.setProperty("webdriver.chrome.driver", "/Users/peter/Downloads/Seleniumtestcases/chromedriver");
		driver = new ChromeDriver(); 

		for(int i=1; i<recData.length; i++){
			String execute =  recData[i][1];
			

			if(execute.equalsIgnoreCase("Y")){
				for(int j=5; j<=6; j++){
					String browserTest =  recData[i][j];
					if(browserTest.equalsIgnoreCase("Y")){
						String testcase = recData[i][2];

                         if (j==5){
                        	System.setProperty("webdriver.gecko.driver", "/Users/peter/Downloads/Seleniumtestcases/geckodriver");
                     		driver = new FirefoxDriver();

							Object resulthtmlpath = ReusableMethods.startReport(testcase, "/Users/peter/ReportLogs/","fire fox");	

                         }
                         if (j==6){
                        	 System.setProperty("webdriver.chrome.driver", "/Users/peter/Downloads/Seleniumtestcases/chromedriver");
                     		driver = new ChromeDriver(); 
							Object resulthtmlpath = ReusableMethods.startReport(testcase, "/Users/peter/ReportLogs/","Chrome");	

                         }
						
						try{

							String start = recData[i][3];
							String end = recData[i][4];
							int startRow = Integer.parseInt(start);
							int endRow = Integer.parseInt(end);

							/* Java Reflection */		
							Method tc = AutomationScript.class.getMethod(testcase,int.class,int.class);


							Object  result = tc.invoke(tc,startRow,endRow );

						
						} catch(Exception e){
							e.printStackTrace();
						}

					}
				}
			}

		}
		//driver.close();

	}
}




