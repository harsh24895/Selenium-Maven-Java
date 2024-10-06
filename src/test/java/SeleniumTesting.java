
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

//For this project we need to install Maven
// then TestNg in Jetbrans Marketplace
//Add testng dependency in the pom.xml file under dependencies attributes
//Add the dependency for selenium in pom.xml file

public class SeleniumTesting {

    public static WebDriver webDriver;    //This is method is for setting up the chrome driver
    //HEre we are setting BeforeTest Annotations as we are setting up the chrome first so
    @BeforeTest
    void Setup(){
        //If after line 21 the code throws an error then uncomment and try to add the chromeoptions and see
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver webDriver = new ChromeDriver(options);*/

        // in here we need to get the chromdriver intall
        // so need to create a resources directory
        // in that put the chromedriver-win64 file
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/chromedriver-win64/chromedriver.exe");
        webDriver = new ChromeDriver();
        //Here we are using predefine link for testing
        webDriver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");

    }

    //here we are setting up the test
    @Test
    void teststeps() throws InterruptedException {
        webDriver.findElement(By.xpath("//*[@id=\"menuToggle\"]/input")).click();
        Thread.sleep(6000);//this is not a ideal way to wait : this is Hard wait
        //there are another ways to wait like Hard wait and soft wait and we just to use soft wait
        //here we click on the bar button on the left
        webDriver.findElement(By.xpath("//*[@id=\"menu\"]/a[2]/li")).click();

        //here we are sending the username and password
        webDriver.findElement(By.xpath("//*[@id=\"usr\"]")).sendKeys("sa");
        webDriver.findElement(By.xpath("//*[@id=\"pwd\"]")).sendKeys("sa");

        //Here we are clicking the Login button
        webDriver.findElement(By.xpath("//*[@id=\"second_form\"]/input")).click();

        //We need to find the Formal shoes so we need to set webelement for it and then add the webdriver path
        WebElement webElement = webDriver.findElement(By.xpath("//*[@id=\"ShoeType\"]"));
        String actualWebelement = webElement.getText();


        // this will get the string as Formal shoes
        String expected = "Formal Shoes";
        Assert.assertEquals(expected, actualWebelement);

        webDriver.close();
    }

}
