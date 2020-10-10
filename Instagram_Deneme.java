package web.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;
import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.xpath;


public class Instagram_Deneme {

    protected WebDriver driver;
    public static String loginUrl = "https://www.instagram.com/";

    @Before
    public void setUp() {

        try {

            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bekir Emanet\\IdeaProjects\\deneme\\Driver\\chromedriver.exe");
            driver = new ChromeDriver(capabilities);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

            //dynamic wait
            driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Login() {

        try {
            driver.get(loginUrl);
            driver.findElement(name("username")).sendKeys("sampleUsername");
            Thread.sleep(1000);
            driver.findElement(name("password")).sendKeys("123456789");
            Thread.sleep(1000);
            driver.findElement(xpath("//*[@id=\"loginForm\"]/div/div[3]/button/div")).click();



        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @After
    public void tearDown() throws Exception {

    }
}
