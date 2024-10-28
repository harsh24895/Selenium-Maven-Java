package dependency;

import org.testng.annotations.Test;

public class DependsOnGroups {

    //ch-7.3 Groups and Depends on Group
    // If we have group name decided by project then it should be like groups : env_application
    // Then we have to use this name to all the test in the list
    @Test
    public void beforesuite() {
        System.out.println("Chrome-setup property");
    }

    @Test(dependsOnGroups = "initialize", groups = "env_application")
    public void testbeforetestORM() {

        System.out.println("open chrome");
    }

    @Test(dependsOnGroups = "env_application")
    public void beforeclass() {
        System.out.println("Open Test application");
    }

    //ch7.3 this all belongs to the same group starts with "env_application" if we mention dependsOnGroup with the name
    //7.3 need to work on this chapter
    @Test(dependsOnMethods = {"testbeforetestORM", "beforeclass"})
    public void signIn() {
        System.out.println("Sign In");
    }

    @Test(dependsOnMethods = {"testbeforetestORM", "beforeclass", "signIn"})
    public void searchCustomer() {
        System.out.println("Search for Customer");
    }

    @Test(dependsOnMethods = {"testbeforetestORM", "beforeclass", "signIn"})
    public void searchProduct() {
        System.out.println("Search for Product");
    }

    @Test(dependsOnMethods = {"searchProduct"})
    public void aftersuite() {
        System.out.println("Chrome-clean all cookies");
    }

    @Test(dependsOnMethods = {"aftersuite", "beforeclass", "signIn"})
    public void aftertest() {
        System.out.println("close chrome");
    }

    @Test(dependsOnMethods = {"aftersuite", "beforeclass", "signIn"})
    public void afterClass() {
        System.out.println("close Test application");

    }

    //this will run after test method
    @Test(dependsOnMethods = {"aftersuite", "aftertest", "afterClass"})
    public void aftermethod() {
        System.out.println("Sign Out");
    }

}
