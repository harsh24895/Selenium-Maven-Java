import org.testng.annotations.*;

public class DataAnnotationexample {

    @BeforeSuite
    public void beforesuite(){
        System.out.println("Chrome-setup property");
    }

    @BeforeTest
    public void beforetest(){
        System.out.println("open chrome");
    }
    @BeforeClass
    public void beforeclass(){
        System.out.println("Open Test application");
    }
    @BeforeMethod
    void beforemain(){
        System.out.println("Sign In");

    }


    @Test
    public void searchCustomer(){
        System.out.println("Search for Customer");
    }

    @Test
    public void searchProduct(){
        System.out.println("Search for Product");
    }



    @AfterSuite
    public void aftersuite(){
        System.out.println("Chrome-clean all cookies");
    }
    @AfterTest
    public void aftertest(){
        System.out.println("close chrome");
    }
    @AfterClass
    public void afterClass() {
        System.out.println("close Test application");

    }
    @AfterMethod
    public void aftermethod() {
        System.out.println("Sign Out");
    }
}
