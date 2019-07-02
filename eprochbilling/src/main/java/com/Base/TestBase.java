package com.Base;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

	import com.util.TestUtil;

	public class TestBase {
		public static WebDriver driver;
		public static Properties prop;

		public TestBase() {
			try {
				prop = new Properties();
				FileInputStream fip = new FileInputStream(
						"C:\\Mamta\\programs\\eprochbilling\\src\\main\\java\\com\\config\\config.properties");

				prop.load(fip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();

			}
		}

		public static void initiatization() {
			String browserName = prop.getProperty("browser");
			if (browserName.equals("chrome")) {
				System.setProperty("WebDriver.chrome.driver", "chromedriver.exe");
				driver = new ChromeDriver();

			} else if (browserName.equals("firefox")) {
				driver = new FirefoxDriver();

			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));

		}

	}


