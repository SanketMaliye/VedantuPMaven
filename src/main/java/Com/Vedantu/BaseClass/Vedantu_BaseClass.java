package Com.Vedantu.BaseClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Com.Vedantu.Configurations.ReadConfiguration;
import net.bytebuddy.utility.RandomString;

public class Vedantu_BaseClass {

	ReadConfiguration readconfig=new ReadConfiguration();
	String URL=readconfig.getBaseUrl();
	protected String PHONE=readconfig.getPhone();
	protected String PWD=readconfig.getPassword();
	String CHROMEPATH=readconfig.getChromePath();
	
	public static WebDriver driver;
	public static Logger log;
	
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void Initiate() throws InterruptedException {
		
		log=Logger.getLogger("Vedantu_Log");
		PropertyConfigurator.configure("log4j.properties");
		
//		System.setProperty("webdriver.gecko.driver","C:\\Drivers\\geckodriver31.exe");
//		driver=new FirefoxDriver();
//		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
 		driver=new ChromeDriver();
 		driver.manage().window().maximize();
 		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.vedantu.com/");
		Thread.sleep(3000);
	}
	
	public String TakeSS(String TestCaseName) throws IOException {

		TakesScreenshot Ts = (TakesScreenshot) driver;
		File Source = Ts.getScreenshotAs(OutputType.FILE);
		String Random = RandomString.make(5);
		String Destination = System.getProperty("user.dir") + "/Screenshots/" + TestCaseName + " " + Random + ".png";
		FileUtils.copyFile(Source, new File(Destination));
		return Destination;
	}
		
	@AfterMethod
	public void Teardown() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}
}
