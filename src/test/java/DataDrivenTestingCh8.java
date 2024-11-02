
//ch-8 data driven

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTestingCh8 {

    //Here we are working on Example only
    //In here are declaring the other DataProvider method annotations to this Test method
    //So that both method conbers with eachother
    @Test(dataProvider = "loginData")
    public void login(String email, String Password, boolean success){
        System.out.println("Log in credentials:"+"\n"+
                            "Email= " + email + "\n"+
                            "Password=" +Password + "\n"+
                            "Successful login="+success+ "\n");
    }

    @DataProvider
    public Object [] [] loginData () {
        //Here we are declaring 2 dimensional array
        Object [] [] data = new Object[3][3];

        data[0][0] = "Test@Framework.com"; data[0][1]="TestNG1234"; data[0][2]=true;
        data[1][0] = "Jow@Doe.com";        data[1][1]="DoeDoe34";   data[1][2]=false;
        data[2][0]="Test@AutomationU.com"; data[2][1]="TAU1234";    data[2][2]=true;

        return data;
    }

    //Another way is that we can set the DataProvider name as well and then call that method in Test method
    //Ex: @DataProvider(name = "loginDataProvider")
}

