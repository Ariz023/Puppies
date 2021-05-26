package Test1;
import Base.Base;
import Utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/*
scenario: 1
1.user should go to the puppies website
2.user should validate the title of website
3.user should click Brook's "View Details" in the Puppy List
4.user should verify image of the Brook(Puppy)

scenario:2
1.user should go to the puppies website
2.user should click Hanna's "View Details" in the Puppy list
3.user should click the "Travel Carrier" checkbox
4.user should verify that if checkbox is selected or not


scenario:3
1.user should go to the puppies website.
2.user should click to the next page.
3.user should click to Spud's View Details in the Puppy List.
4.user should click "Adopt Me!
5.user should click to checkboxes and verify those are selected.
6.user should click to the "Complete the Adoption.
7.User should fill the payment form with valid credentials and place the order.
8.Then user should see the purchase message: "Thank you for adopting a puppy!"
 */


public class PuppyTest extends Base {

    @Test(priority = 1)
    public void BrooksTest() {

// actual and expected result
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Sally's Puppy Adoption Agency";
// validating the title
        System.out.println("Page title is: " + ExpectedTitle);
        Assert.assertEquals(ActualTitle, ExpectedTitle);
// wait
        BrowserUtils.sleep(5);
// click Brook's detatils
        driver.findElement(By.xpath("//div[@id=\"content\"]/div[2]/div/div[4]/form/div/input")).click();

// verifying that Brooks image is displayed or not
        boolean img = driver.findElement(By.xpath("//div[@id=\"content\"]/div[2]/img")).isDisplayed();
        Assert.assertTrue(img);
        BrowserUtils.sleep(5);

    }

    @Test(priority = 2)
    public void HannaTest() {
        BrowserUtils.sleep(5);
        // click to Hanna's details
        driver.findElement(By.xpath("//div[@id=\"content\"]/div[3]/div/div[4]/form/div/input")).click();
        BrowserUtils.sleep(5);

        //click to "Adopt Me!"
        driver.findElement(By.xpath("//div[@id=\"content\"]/div[2]/div/form/div/input[1]")).click();
        //click the checkbox
        driver.findElement(By.xpath("//input[@id=\"carrier\"]")).click();
        BrowserUtils.sleep(5);
        //verify that if checkbox is selected
        boolean checkbox = driver.findElement(By.xpath("//*[@id=\"carrier\"]")).isSelected();
        Assert.assertTrue(checkbox);


    }

    @Test(priority = 3)
    public void SpudTest() {

        BrowserUtils.sleep(5);
        //go to the next page
        driver.findElement(By.xpath("//div[@id=\"content\"]/div[6]/a[3]")).click();
        BrowserUtils.sleep(5);

    //click to Spud's details
        driver.findElement(By.xpath("//div[@id=\"content\"]/div[3]/div/div[4]/form/div/input")).click();
        BrowserUtils.sleep(5);
        //click "Adopt Me!
        driver.findElement(By.xpath("//div[@id=\"content\"]/div[2]/div/form/div/input[1]")).click();
        BrowserUtils.sleep(5);
    //click to checkboxes
        driver.findElement(By.xpath("//*[@id=\"collar\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"toy\"]")).click();
        BrowserUtils.sleep(5);
        boolean checkBox1 = driver.findElement(By.xpath("//*[@id=\"collar\"]")).isSelected();
        boolean checkBox2 = driver.findElement(By.xpath("//*[@id=\"toy\"]")).isSelected();
    //verify that checkboxes are selected
        Assert.assertTrue(checkBox1);
        Assert.assertTrue(checkBox2);


        driver.findElement(By.xpath("//div[@id=\"content\"]/div[2]/form[1]/div/input")).click();
        BrowserUtils.sleep(5);

        driver.findElement(By.xpath("//*[@id=\"order_name\"]")).sendKeys("Alex");
        BrowserUtils.sleep(3);
        driver.findElement(By.xpath("//*[@id=\"order_address\"]")).sendKeys("5006 Mclean Dr");
        BrowserUtils.sleep(3);
        driver.findElement(By.xpath("//*[@id=\"order_email\"]")).sendKeys("alex@gmail.com");
        BrowserUtils.sleep(3);
        Select paymentOptions = new Select(driver.findElement(By.xpath("//*[@id=\"order_pay_type\"]")));
        paymentOptions.selectByIndex(2);
        BrowserUtils.sleep(3);
        driver.findElement(By.xpath("//*[@id=\"new_order\"]/div[6]/input")).click();

        WebElement message = driver.findElement(By.xpath("//*[@id=\"notice\"]"));
        System.out.println("Purschase message: "+message.getText());
        BrowserUtils.sleep(4);
    }


    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
