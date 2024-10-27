package dependency;

import org.testng.annotations.*;

public class DependencyOnMethod {

    // Ch: 7.1
    // Dependency : It will follow the test and depend on the another test(ex: Sign out is depend on Sign in Test)
    // If we do vice versa then Signout test will fail as sign in is not depend on Sign out
    // For more info looking for TestNg documentation


    //Ch 7.2 Depends on methods attribute
    //execute test methods without depends on methods attribute
    // execute test methods with depends on methods attribute
    // excute xml file to exclude the Test method
    @Test
    public void beforesuite(){
        System.out.println("Chrome-setup property");
    }

    @Test (dependsOnMethods = "beforesuite")
    public void testbeforetestORM(){

        System.out.println("open chrome");
    }
    @Test(dependsOnMethods = "testbeforetestORM")
    public void beforeclass(){
        System.out.println("Open Test application");
    }
    //ch7.2 : Here we are adding multiple dependency for the test
    @Test(dependsOnMethods = {"testbeforetestORM","beforeclass"})
    public void signIn(){
        System.out.println("Sign In");
    }

    @Test(dependsOnMethods = {"testbeforetestORM","beforeclass","signIn"})
    public void searchCustomer(){
        System.out.println("Search for Customer");
    }

    @Test(dependsOnMethods = {"testbeforetestORM","beforeclass","signIn"})
    public void searchProduct(){
        System.out.println("Search for Product");
    }

    @Test(dependsOnMethods = {"searchProduct"})
    public void aftersuite(){
        System.out.println("Chrome-clean all cookies");
    }

    @Test(dependsOnMethods = {"aftersuite","beforeclass","signIn"})
    public void aftertest(){
        System.out.println("close chrome");
    }
    @Test(dependsOnMethods = {"aftersuite","beforeclass","signIn"})
    public void afterClass() {
        System.out.println("close Test application");

    }

    //this will run after test method
    @Test(dependsOnMethods = {"aftersuite","aftertest","afterClass"})
    public void aftermethod() {
        System.out.println("Sign Out");
    }
}


