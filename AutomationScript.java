package amazonPackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AutomationScript extends ReusableMethods {

//	----------------------------- Test 1 ----------------------------------
	public static Boolean AddCart(int row,int end) throws Exception {


		/*  Launch URL*/
		driver.get("https://www.amazon.com/");
		//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS); 


		String dt_path = "/Users/peter/Downloads/Amazon_OR.xlsx";

		String[][]  recData = readXLSheet(dt_path, "Sheet1");

		WebElement wl = null;

		for(int i=row;i<=end;i++){  
			if (recData[i][1].equals("xpath") ){
				try{
					wl =  driver.findElement(By.xpath(recData[i][2]));
					Update_Report("Pass"+"  ", recData[i][2],"find succeded ", driver );

				}
				catch(Exception e){
					e.printStackTrace();
					Update_Report("Fail"+"  ", recData[i][2],"find failed ", driver );
					break;
				}

			}else  if (recData[i][1].equals("name")){
				wl = driver.findElement(By.name(recData[i][2]));
			}else  if (recData[i][1].equals("linkText")){

				wl = driver.findElement(By.linkText(recData[i][2]));
			}else  if (recData[i][1].equals("id")){
				try{
					wl = driver.findElement(By.id(recData[i][2]));
				}
				catch(Exception e){
					e.printStackTrace();
					Update_Report("Fail"+"  ", recData[i][2],"testcase failed because of successful login.", driver );
					break;
				}
			}


			/* deals with first   3rd  and 4th col to execute  wl */  
			if (recData[i][3].equals("sendKeys")){
				enterText(wl,  recData[i][4], recData[i][4]);

			} if (recData[i][3].equals("text")){
				checkError(wl,  recData[i][4]);

			}else  if (recData[i][3].equals("click")){

				try{
					clickButton(wl, "Click ",recData[i][4]);
					Update_Report("Pass"+"  ", recData[i][2],"   click success", driver );

				}catch (Exception e){
					Update_Report("Fail "  +"  ",recData[i][2]," not able to find  element, terminating the test", driver);
					e.printStackTrace();
					break;
				}  

			}


		

		}
		bw.close();

		// driver.close();
		// driver.quit();
		return true;

	}

// ---------------------------------  Test 2 --------------------------------------------
	public static boolean MainTabs(int row,int end) throws Exception {


		/*  Launch URL*/
		driver.get("https://www.amazon.com/");
		//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS); 


		String dt_path = "/Users/peter/Downloads/Amazon_OR.xlsx";

		String[][]  recData = readXLSheet(dt_path, "Sheet1");

		WebElement wl = null;


		for(int i=row;i<=end;i++){  
			if (recData[i][1].equals("xpath") ){
				try{
					wl =  driver.findElement(By.xpath(recData[i][2]));
					Update_Report("Pass"+"  ", recData[i][2],"find succeded ", driver );

				}
				catch(Exception e){
					e.printStackTrace();
					Update_Report("Fail"+"  ", recData[i][2],"find failed ", driver );

				}

			}else  if (recData[i][1].equals("name")){
				wl = driver.findElement(By.name(recData[i][2]));
			}else  if (recData[i][1].equals("linkText")){

				wl = driver.findElement(By.linkText(recData[i][2]));
			}else  if (recData[i][1].equals("id")){
				try{
					wl = driver.findElement(By.id(recData[i][2]));
				}
				catch(Exception e){
					e.printStackTrace();
					Update_Report("Fail"+"  ", recData[i][2],"testcase failed because of successful login.", driver );
					break;
				}
			}


			/* deals with first   3rd  and 4th col to execute  wl */  
			if (recData[i][3].equals("sendKeys")){
				enterText(wl,  recData[i][4], recData[i][4]);

			} if (recData[i][3].equals("text")){
				checkError(wl,  recData[i][4]);

			}else  if (recData[i][3].equals("click")){

				try{
					clickButton(wl, "Click ",recData[i][4]);
					Update_Report("Pass"+"  ", recData[i][2],"   click success", driver );

				}catch (Exception e){
					Update_Report("Fail "  +"  ",recData[i][2]," not able to find  element, terminating the test", driver);
					e.printStackTrace();
					break;
				}  

			}else  if (recData[i][3].equals("perform")){

				try{
					// clickButton(wl, "Action perform ",recData[i][4]);
					Actions builder = new Actions(driver);
					builder.moveToElement(wl).build().perform();

					Update_Report("Pass"+"  ", recData[i][2],"   Perform hover success", driver );

				}catch (Exception e){
					Update_Report("Fail "  +"  ",recData[i][2]," not able to find  element, terminating the test", driver);
					e.printStackTrace();
					break;
				}  
			}


		}

		bw.close();
		Thread.sleep(5000);
		// driver.close();
		// driver.quit();
		return true;
	}

// ------------------------------------ Test case 3--------------------------------------
	
	public static boolean DepartmentTab(int row,int end) throws Exception {


		/*  Launch URL*/
		driver.get("https://www.amazon.com/");
		//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS); 


		String dt_path = "/Users/peter/Downloads/Amazon_OR.xlsx";

		String[][]  recData = readXLSheet(dt_path, "Sheet1");

		WebElement wl = null;


		for(int i=row;i<=end;i++){  
			if (recData[i][1].equals("xpath") ){
				try{
					wl =  driver.findElement(By.xpath(recData[i][2]));
					Update_Report("Pass"+"  ", recData[i][2],"find succeded ", driver );
					if (recData[i][3].equals("availablecheck")){
						continue;

					} 
				}
				catch(Exception e){
					e.printStackTrace();
					Update_Report("Fail"+"  ", recData[i][2],"find failed ", driver );

				}

			}else  if (recData[i][1].equals("name")){
				wl = driver.findElement(By.name(recData[i][2]));
			}else  if (recData[i][1].equals("linkText")){

				wl = driver.findElement(By.linkText(recData[i][2]));
			}else  if (recData[i][1].equals("id")){
				try{
					wl = driver.findElement(By.id(recData[i][2]));
				}
				catch(Exception e){
					e.printStackTrace();
					Update_Report("Fail"+"  ", recData[i][2],"testcase failed because of successful login.", driver );
					break;
				}
			}


			/* deals with first   3rd  and 4th col to execute  wl */  
			if (recData[i][3].equals("sendKeys")){
				enterText(wl,  recData[i][4], recData[i][4]);

			} if (recData[i][3].equals("text")){
				checkError(wl,  recData[i][4]);

			}else  if (recData[i][3].equals("click")){

				try{
					clickButton(wl, "Click ",recData[i][4]);
					Update_Report("Pass"+"  ", recData[i][2],"   click success", driver );

				}catch (Exception e){
					Update_Report("Fail "  +"  ",recData[i][2]," not able to find  element, terminating the test", driver);
					e.printStackTrace();
					break;
				}  

			}else  if (recData[i][3].equals("perform")){

				try{
					// clickButton(wl, "Action perform ",recData[i][4]);
					Actions builder = new Actions(driver);
					builder.moveToElement(wl).build().perform();

					Update_Report("Pass"+"  ", recData[i][2],"   Perform hover success", driver );

				}catch (Exception e){
					Update_Report("Fail "  +"  ",recData[i][2]," not able to find  element, terminating the test", driver);
					e.printStackTrace();
					break;
				}  
			}


		}

		bw.close();
		Thread.sleep(5000);
		// driver.close();
		// driver.quit();
		return true;
	}

	//-------------------------- Test 4------------------------------------------------------------
	public static boolean HelloSigninTab(int row,int end) throws Exception {


		/*  Launch URL*/
		driver.get("https://www.amazon.com/");
		//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS); 


		String dt_path = "/Users/peter/Downloads/Amazon_OR.xlsx";

		String[][]  recData = readXLSheet(dt_path, "Sheet1");

		WebElement wl = null;


		for(int i=row;i<=end;i++){  
			
			/* deals with first   1st  and 2nd col to execute  wl */ 
			if (recData[i][1].equals("xpath") ){
				try{
					wl =  driver.findElement(By.xpath(recData[i][2]));
					Update_Report("Pass"+"  ", recData[i][2],"find succeded ", driver );
					if (recData[i][3].equals("availablecheck")){
						continue;

					} 
				}
				catch(Exception e){
					e.printStackTrace();
					Update_Report("Fail"+"  ", recData[i][2],"find failed ", driver );

				}

			}else  if (recData[i][1].equals("name")){
				wl = driver.findElement(By.name(recData[i][2]));
			}else  if (recData[i][1].equals("linkText")){

				wl = driver.findElement(By.linkText(recData[i][2]));
			}else  if (recData[i][1].equals("id")){
				try{
					wl = driver.findElement(By.id(recData[i][2]));
				}
				catch(Exception e){
					e.printStackTrace();
					Update_Report("Fail"+"  ", recData[i][2],"testcase failed because of successful login.", driver );
					break;
				}
			}


			/* deals with first   3rd  and 4th col to execute  wl */  
			if (recData[i][3].equals("sendKeys")){
				enterText(wl,  recData[i][4], recData[i][4]);

			} if (recData[i][3].equals("text")){
				checkError(wl,  recData[i][4]);

			}else  if (recData[i][3].equals("click")){

				try{
					clickButton(wl, "Click ",recData[i][4]);
					Update_Report("Pass"+"  ", recData[i][2],"   click success", driver );

				}catch (Exception e){
					Update_Report("Fail "  +"  ",recData[i][2]," not able to find  element, terminating the test", driver);
					e.printStackTrace();
					break;
				}  

			}else  if (recData[i][3].equals("perform")){

				try{
			
					Actions builder = new Actions(driver);
					builder.moveToElement(wl).build().perform();

					Update_Report("Pass"+"  ", recData[i][2],"   Perform hover success", driver );

				}catch (Exception e){
					Update_Report("Fail "  +"  ",recData[i][2]," not able to find  element, terminating the test", driver);
					e.printStackTrace();
					break;
				}  
			}


		}

		bw.close();
		Thread.sleep(5000);
		// driver.close();
		// driver.quit();
		return true;
	}
	
	//------------------------------------- Test 5---------------------------------
	
	public static boolean AllMenu(int row,int end) throws Exception {


		/*  Launch URL*/
		driver.get("https://www.amazon.com/");
		//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS); 


		String dt_path = "/Users/peter/Downloads/Amazon_OR.xlsx";

		String[][]  recData = readXLSheet(dt_path, "Sheet1");

		WebElement wl = null;


		for(int i=row;i<=end;i++){  
			
			/* deals with first   1st  and 2nd col to execute  wl */ 
			if (recData[i][1].equals("xpath") ){
				try{
					wl =  driver.findElement(By.xpath(recData[i][2]));
					Update_Report("Pass"+"  ", recData[i][2],"find succeded ", driver );
					if (recData[i][3].equals("availablecheck")){
						continue;

					} 
				}
				catch(Exception e){
					e.printStackTrace();
					Update_Report("Fail"+"  ", recData[i][2],"find failed ", driver );

				}

			}else  if (recData[i][1].equals("name")){
				wl = driver.findElement(By.name(recData[i][2]));
			}else  if (recData[i][1].equals("linkText")){

				wl = driver.findElement(By.linkText(recData[i][2]));
			}else  if (recData[i][1].equals("id")){
				try{
					wl = driver.findElement(By.id(recData[i][2]));
				}
				catch(Exception e){
					e.printStackTrace();
					Update_Report("Fail"+"  ", recData[i][2],"testcase failed because of successful login.", driver );
					break;
				}
			}


			/* deals with first   3rd  and 4th col to execute  wl */  
			if (recData[i][3].equals("sendKeys")){
				enterText(wl,  recData[i][4], recData[i][4]);

			} if (recData[i][3].equals("text")){
				checkError(wl,  recData[i][4]);

			}else  if (recData[i][3].equals("click")){

				try{
					clickButton(wl, "Click ",recData[i][4]);
					Update_Report("Pass"+"  ", recData[i][2],"   click success", driver );

				}catch (Exception e){
					Update_Report("Fail "  +"  ",recData[i][2]," not able to find  element, terminating the test", driver);
					e.printStackTrace();
					break;
				}  

			}else  if (recData[i][3].equals("perform")){

				try{
					
					Actions builder = new Actions(driver);
					builder.moveToElement(wl).build().perform();

					Update_Report("Pass"+"  ", recData[i][2],"   Perform hover success", driver );

				}catch (Exception e){
					Update_Report("Fail "  +"  ",recData[i][2]," not able to find  element, terminating the test", driver);
					e.printStackTrace();
					break;
				}  
			}


		}

		bw.close();
		Thread.sleep(5000);
		// driver.close();
		// driver.quit();
		return true;
	}
	

	//------------------------------------- Test 6---------------------------------
	
		public static boolean EmptyCart(int row,int end) throws Exception {


			/*  Launch URL*/
			driver.get("https://www.amazon.com/");
			//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS); 


			String dt_path = "/Users/peter/Downloads/Amazon_OR.xlsx";

			String[][]  recData = readXLSheet(dt_path, "Sheet1");

			WebElement wl = null;


			for(int i=row;i<=end;i++){  
				
				/* deals with first   1st  and 2nd col to execute  wl */ 
				if (recData[i][1].equals("xpath") ){
					try{
						wl =  driver.findElement(By.xpath(recData[i][2]));
						Update_Report("Pass"+"  ", recData[i][2],"find succeded ", driver );
						if (recData[i][3].equals("availablecheck")){
							continue;

						} 
					}
					catch(Exception e){
						e.printStackTrace();
						Update_Report("Fail"+"  ", recData[i][2],"find failed ", driver );

					}

				}else  if (recData[i][1].equals("name")){
					wl = driver.findElement(By.name(recData[i][2]));
				}else  if (recData[i][1].equals("linkText")){

					wl = driver.findElement(By.linkText(recData[i][2]));
				}else  if (recData[i][1].equals("id")){
					try{
						wl = driver.findElement(By.id(recData[i][2]));
					}
					catch(Exception e){
						e.printStackTrace();
						Update_Report("Fail"+"  ", recData[i][2],"testcase failed because of successful login.", driver );
						break;
					}
				}


				/* deals with first   3rd  and 4th col to execute  wl */  
				if (recData[i][3].equals("sendKeys")){
					enterText(wl,  recData[i][4], recData[i][4]);

				} if (recData[i][3].equals("text")){
					checkError(wl,  recData[i][4]);

				}else  if (recData[i][3].equals("click")){

					try{
						
						clickButton(wl, "Click ",recData[i][4]);
						Update_Report("Pass"+"  ", recData[i][2],"   click success", driver );
						
					}catch (Exception e){
						Update_Report("Fail "  +"  ",recData[i][2]," not able to find  element, terminating the test", driver);
						e.printStackTrace();
						break;
					}  

				}else  if (recData[i][3].equals("perform")){

					try{
						
						Actions builder = new Actions(driver);
						builder.moveToElement(wl).build().perform();

						Update_Report("Pass"+"  ", recData[i][2],"   Perform hover success", driver );

					}catch (Exception e){
						Update_Report("Fail "  +"  ",recData[i][2]," not able to find  element, terminating the test", driver);
						e.printStackTrace();
						break;
					}  
				}

				else  if (recData[i][3].equals("popupClick")){

					try{
						
						String homePage = driver.getWindowHandle();
						System.out.println(homePage);
						clickButton(wl, "Click ",recData[i][4]);
						Update_Report("Pass"+"  ", recData[i][2],"   click success", driver );
						
						String popPage = driver.getWindowHandle();
						System.out.println(popPage);

						Set<String> windows = driver.getWindowHandles();
						System.out.println(windows.size());
						
					}catch (Exception e){
						Update_Report("Fail "  +"  ",recData[i][2]," not able to find  element, terminating the test", driver);
						e.printStackTrace();
						break;
					}  

				}
				

			}

			bw.close();
			Thread.sleep(5000);
			// driver.close();
			// driver.quit();
			return true;
		}
	

		// ----------------------------------  Test 7----------------------------------------------
		
		public static boolean HelpPage(int row,int end) throws Exception {


			/*  Launch URL*/
			driver.get("https://www.amazon.com/");
			//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS); 


			String dt_path = "/Users/peter/Downloads/Amazon_OR.xlsx";

			String[][]  recData = readXLSheet(dt_path, "Sheet1");

			WebElement wl = null;


			for(int i=row;i<=end;i++){  
				
				/* deals with first   1st  and 2nd col to execute  wl */ 
				if (recData[i][1].equals("xpath") ){
					try{
						wl =  driver.findElement(By.xpath(recData[i][2]));
						Update_Report("Pass"+"  ", recData[i][2],"find succeded ", driver );
						if (recData[i][3].equals("availablecheck")){
							continue;

						} 
					}
					catch(Exception e){
						e.printStackTrace();
						Update_Report("Fail"+"  ", recData[i][2],"find failed ", driver );

					}

				}else  if (recData[i][1].equals("name")){
					wl = driver.findElement(By.name(recData[i][2]));
				}else  if (recData[i][1].equals("linkText")){

					wl = driver.findElement(By.linkText(recData[i][2]));
				}else  if (recData[i][1].equals("id")){
					try{
						wl = driver.findElement(By.id(recData[i][2]));
					}
					catch(Exception e){
						e.printStackTrace();
						Update_Report("Fail"+"  ", recData[i][2],"testcase failed because of successful login.", driver );
						break;
					}
				}


				/* deals with first   3rd  and 4th col to execute  wl */  
				if (recData[i][3].equals("sendKeys")){
					enterText(wl,  recData[i][4], recData[i][4]);

				} if (recData[i][3].equals("text")){
					checkError(wl,  recData[i][4]);

				}else  if (recData[i][3].equals("click")){

					try{
						
						clickButton(wl, "Click ",recData[i][4]);
						Update_Report("Pass"+"  ", recData[i][2],"   click success", driver );
						
					}catch (Exception e){
						Update_Report("Fail "  +"  ",recData[i][2]," not able to find  element, terminating the test", driver);
						e.printStackTrace();
						break;
					}  

				}else  if (recData[i][3].equals("perform")){

					try{
						
						Actions builder = new Actions(driver);
						builder.moveToElement(wl).build().perform();

						Update_Report("Pass"+"  ", recData[i][2],"   Perform hover success", driver );

					}catch (Exception e){
						Update_Report("Fail "  +"  ",recData[i][2]," not able to find  element, terminating the test", driver);
						e.printStackTrace();
						break;
					}  
				}

				

			}

			bw.close();
			Thread.sleep(5000);
			// driver.close();
			// driver.quit();
			return true;
		}

	
		// ----------------------------------  Test 8----------------------------------------------
		
				public static boolean CartQuantity(int row,int end) throws Exception {


					/*  Launch URL*/
					driver.get("https://www.amazon.com/");
					//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS); 


					String dt_path = "/Users/peter/Downloads/Amazon_OR.xlsx";

					String[][]  recData = readXLSheet(dt_path, "Sheet1");

					WebElement wl = null;


					for(int i=row;i<=end;i++){  
						
						/* deals with first   1st  and 2nd col to execute  wl */ 
						if (recData[i][1].equals("xpath") ){
							try{
								wl =  driver.findElement(By.xpath(recData[i][2]));
								Update_Report("Pass"+"  ", recData[i][2],"find succeded ", driver );
								if (recData[i][3].equals("availablecheck")){
									continue;

								} 
							}
							catch(Exception e){
								e.printStackTrace();
								Update_Report("Fail"+"  ", recData[i][2],"find failed ", driver );

							}

						}else  if (recData[i][1].equals("name")){
							wl = driver.findElement(By.name(recData[i][2]));
						}else  if (recData[i][1].equals("linkText")){

							wl = driver.findElement(By.linkText(recData[i][2]));
						}else  if (recData[i][1].equals("id")){
							try{
								wl = driver.findElement(By.id(recData[i][2]));
							}
							catch(Exception e){
								e.printStackTrace();
								Update_Report("Fail"+"  ", recData[i][2],"testcase failed because of successful login.", driver );
								break;
							}
						}


						/* deals with first   3rd  and 4th col to execute  wl */  
						if (recData[i][3].equals("sendKeys")){
							enterText(wl,  recData[i][4], recData[i][4]);

						} if (recData[i][3].equals("text")){
							checkError(wl,  recData[i][4]);

						}else  if (recData[i][3].equals("click")){

							try{
								
								clickButton(wl, "Click ",recData[i][4]);
								Update_Report("Pass"+"  ", recData[i][2],"   click success", driver );
								
							}catch (Exception e){
								Update_Report("Fail "  +"  ",recData[i][2]," not able to find  element, terminating the test", driver);
								e.printStackTrace();
								break;
							}  

						}else  if (recData[i][3].equals("perform")){

							try{
								
								Actions builder = new Actions(driver);
								builder.moveToElement(wl).build().perform();

								Update_Report("Pass"+"  ", recData[i][2],"   Perform hover success", driver );

							}catch (Exception e){
								Update_Report("Fail "  +"  ",recData[i][2]," not able to find  element, terminating the test", driver);
								e.printStackTrace();
								break;
							}  
						}

						

					}

					bw.close();
					Thread.sleep(5000);
					// driver.close();
					// driver.quit();
					return true;
				}


				// ----------------------------------  Test 9 ----------------------------------------------
				
				public static boolean SaveForLater(int row,int end) throws Exception {


					/*  Launch URL*/
					driver.get("https://www.amazon.com/");
					//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS); 
 ;

					String dt_path = "/Users/peter/Downloads/Amazon_OR.xlsx";

					String[][]  recData = readXLSheet(dt_path, "Sheet1");

					WebElement wl = null;


					for(int i=row;i<=end;i++){  
						
						/* deals with first   1st  and 2nd col to execute  wl */ 
						if (recData[i][1].equals("xpath") ){
							try{
								wl =  driver.findElement(By.xpath(recData[i][2]));
								Update_Report("Pass"+"  ", recData[i][2],"find succeded ", driver );
								if (recData[i][3].equals("availablecheck")){
									continue;

								} 
							}
							catch(Exception e){
								e.printStackTrace();
								Update_Report("Fail"+"  ", recData[i][2],"find failed ", driver );

							}

						}else  if (recData[i][1].equals("name")){
							wl = driver.findElement(By.name(recData[i][2]));
						}else  if (recData[i][1].equals("linkText")){

							wl = driver.findElement(By.linkText(recData[i][2]));
						}else  if (recData[i][1].equals("id")){
							try{
								wl = driver.findElement(By.id(recData[i][2]));
							}
							catch(Exception e){
								e.printStackTrace();
								Update_Report("Fail"+"  ", recData[i][2],"testcase failed because of successful login.", driver );
								break;
							}
						}


						/* deals with first   3rd  and 4th col to execute  wl */  
						if (recData[i][3].equals("sendKeys")){
							enterText(wl,  recData[i][4], recData[i][4]);

						} if (recData[i][3].equals("text")){
							checkError(wl,  recData[i][4]);

						}else  if (recData[i][3].equals("click")){

							try{
								
								clickButton(wl, "Click ",recData[i][4]);
								Update_Report("Pass"+"  ", recData[i][2],"   click success", driver );
								
							}catch (Exception e){
								Update_Report("Fail "  +"  ",recData[i][2]," not able to find  element, terminating the test", driver);
								e.printStackTrace();
								break;
							}  

						}else  if (recData[i][3].equals("perform")){

							try{
								
								Actions builder = new Actions(driver);
								builder.moveToElement(wl).build().perform();

								Update_Report("Pass"+"  ", recData[i][2],"   Perform hover success", driver );

							}catch (Exception e){
								Update_Report("Fail "  +"  ",recData[i][2]," not able to find  element, terminating the test", driver);
								e.printStackTrace();
								break;
							}  
						}

						

					}

					bw.close();
					Thread.sleep(5000);
					// driver.close();
					// driver.quit();
					return true;
				}

				
	// ----------------------------------  Test 10 ----------------------------------------------
				
				public static boolean FirstThreeDisplay(int row,int end) throws Exception {


					/*  Launch URL*/
					driver.get("https://www.amazon.com/");
					//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS); 


					String dt_path = "/Users/peter/Downloads/Amazon_OR.xlsx";

					String[][]  recData = readXLSheet(dt_path, "Sheet1");

					WebElement wl = null;


					for(int i=row;i<=end;i++){  
					

						/* deals with first   1st  and 2nd col to execute  wl */ 
						if (recData[i][1].equals("delay") ){
							String time = recData[i][2];
							if(time != null && !time.isEmpty() &&  !time.equals("0")){
								 
								long threadTime = Long.parseLong(time);
								Thread.sleep(threadTime);
								continue;
						 
							}  
						} else if (recData[i][1].equals("xpath") ){
					 
							try{
								wl =  driver.findElement(By.xpath(recData[i][2]));
								Update_Report("Pass"+"  ", recData[i][2],"find succeded ", driver );
								if (recData[i][3].equals("availablecheck")){
									continue;

								} 
							}
							catch(Exception e){
								e.printStackTrace();
								Update_Report("Fail"+"  ", recData[i][2],"find failed ", driver );
								continue;

							}

						}else  if (recData[i][1].equals("name")){
							wl = driver.findElement(By.name(recData[i][2]));
						}else  if (recData[i][1].equals("linkText")){

							wl = driver.findElement(By.linkText(recData[i][2]));
						}else  if (recData[i][1].equals("id")){
							try{
								wl = driver.findElement(By.id(recData[i][2]));
							}
							catch(Exception e){
								e.printStackTrace();
								Update_Report("Fail"+"  ", recData[i][2],"testcase failed because of successful login.", driver );
								break;
							}
						}


						/* deals with first   3rd  and 4th col to execute  wl */  
						if (recData[i][3].equals("sendKeys")){
							enterText(wl,  recData[i][4], recData[i][4]);

						} if (recData[i][3].equals("text")){
							checkError(wl,  recData[i][4]);

						}else  if (recData[i][3].equals("click")){

							try{
								
								clickButton(wl, "Click ",recData[i][4]);
								Update_Report("Pass"+"  ", recData[i][2],"   click success", driver );
								
							}catch (Exception e){
								Update_Report("Fail "  +"  ",recData[i][2]," not able to find  element, terminating the test", driver);
								e.printStackTrace();
								break;
							}  

						}else  if (recData[i][3].equals("perform")){

							try{
								
								Actions builder = new Actions(driver);
								builder.moveToElement(wl).build().perform();

								Update_Report("Pass"+"  ", recData[i][2],"   Perform hover success", driver );

							}catch (Exception e){
								Update_Report("Fail "  +"  ",recData[i][2]," not able to find  element, terminating the test", driver);
								e.printStackTrace();
								break;
							}  
						}

						

					}

					bw.close();
 					// driver.close();
					// driver.quit();
					return true;
				}

				
				
				
				
				
				
}
