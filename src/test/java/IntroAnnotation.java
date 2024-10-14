import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public class IntroAnnotation {

    public static WebDriver driver;
    public static SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        System.out.println("Open Chrome and Application");
    }

    @BeforeTest
    public void signI() {
    }

    @Test
    public void signIn() throws InterruptedException {
        Thread.sleep(6000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("Admin");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("admin123");

        //on click
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a")).click();
    }
    //Chapter6.3 soft assert
    // soft assert uses just 2 methods: assertAll(), doassert()


        @Test
        public void testHomePage2() {
            softAssert.assertEquals(true, true, "It works");
            System.out.println("Verify the web link");

            softAssert.assertFalse(false, "Admin is not dispalyed on the page");
            System.out.println("Verify admin tab");

            softAssert.assertTrue(true, "Dashboard is not correct on the Home page");
            System.out.println("Verify Dashboard");
            //This need to put at end of the assert statements if we get error above statements it will store in assertAll()
            softAssert.assertAll();
        }

//        //Chapter6.2 Hard assert
//        @Test
//        public void testHomePage() {
//            Assert.assertEquals(true, true, "It works");
//            System.out.println("Verify the web link");
//
//            Assert.assertFalse(false, "Admin is not dispalyed on the page");
//            System.out.println("Verify admin tab");
//
//            Assert.assertTrue(true, "Dashboard is not correct on the Home page");
//            System.out.println("Verify Dashboard");
//        }


        @Test(priority = 3)
        public void Usersearch() {
            //this will search and click to the field of search
            WebElement webElement = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input"));
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")).click();

            String actual = webElement.getText();

            String expected = "Admin";

            Assert.assertEquals(expected, actual);
            driver.close();


        }

        public void userSignout() {
        }

        public void tearDown() {
        }

        //*****
        // we can set multiple @Test methods and set the priority
        //also we can set the class as a @Test too



}