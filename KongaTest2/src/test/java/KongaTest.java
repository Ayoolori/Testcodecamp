import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

    public class KongaTest {

        private WebDriver driver;

        @BeforeTest
        public void launchSite() throws InterruptedException {
            //instruct the webdrivermanager to setup the chromedriver
            WebDriverManager.chromedriver().setup();
            // create an instance of a chromedriver to run the script
            driver = new ChromeDriver();
            // navigate to the website
            driver.get("https://www.konga.com");
            //instruct to maximize the webpage
            driver.manage().window().maximize();
            Thread.sleep(5000);
        }

        @Test(priority = 0)
        public void login() throws InterruptedException {
            //click the login/signup link
            driver.findElement(By.xpath("//div[1]/div/div/div[4]/a")).click();
            Thread.sleep(5000);
            //insert the username
            driver.findElement(By.xpath("//input[@name='username']")).sendKeys("odunayooke97@gmail.com");
            //insert the password
            driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Omoyeni1245$$");
            Thread.sleep(5000);
            // click login button
            driver.findElement(By.xpath("//div[3]/button[@type='submit']")).click();
            Thread.sleep(5000);
        }

        @Test(priority = 1)
        public void clickComputerAndAccessories() throws InterruptedException {
            //click computer and accessories
            driver.findElement(By.xpath("//div/a[@href='/category/accessories-computing-5227']")).click();
            Thread.sleep(10000);
        }

        @Test(priority = 2)
        public void clickLaptops() throws InterruptedException {
            //click laptops
            driver.findElement(By.xpath("//li/a[@href='/category/accessories-computing-5227?menu=Computers and Accessories > Laptops']")).click();
            Thread.sleep(5000);
        }

        @Test(priority = 3)
        public void clickAppleMacBooks() throws InterruptedException {
            //click Apple and MacBooks
            driver.findElement(By.xpath("//li/a[@href='/category/accessories-computing-5227?menu=Computers and Accessories > Laptops > Apple MacBooks']")).click();
            Thread.sleep(5000);
        }

        @Test(priority = 4)
        public void clickAddToCart() throws InterruptedException {
            //click add to cart button
            driver.findElement(By.xpath("//li[2]/div/div/div[2]/form[@action='/cart/overview']/div[3]")).click();
            Thread.sleep(8000);
            //click the cart button to see the added item
            driver.findElement(By.xpath("//div[@id='nav-bar-fix']/div/div/div/a[@href='/cart/overview']")).click();
            Thread.sleep(5000);
            //click the checkout button to proceed to payment page
            driver.findElement(By.xpath("//aside/div[3]/div/div[2]/button")).click();
            Thread.sleep(5000);
        }

        @Test(priority = 5)
        public void proceedToPayment() throws InterruptedException {
            //proceed to click on the card payment
            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
            Thread.sleep(6000);
            //click the pay now button
            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
            Thread.sleep(5000);
            System.out.println("Clicked proceed to payment");
        }

        @Test(priority = 6)
        public void insertPaymentDetails() throws InterruptedException {
            //switched to payment modal i frame
            driver.switchTo().frame("kpg-frame-component");
            //clicked the card option for the payment
            driver.findElement(By.xpath("//button[@class='dashboard-card__button Card']")).click();
            Thread.sleep(5000);
            //inserted an invalid card number
            driver.findElement(By.xpath("//input[@id='card-number']")).sendKeys("1234353609874652");
            Thread.sleep(5000);
            //inserted an invalid expiry date
            driver.findElement(By.xpath("//input[@id='expiry']")).sendKeys("12/24");
            //inserted an invalid CVV number on the CVV field
            driver.findElement(By.xpath("//*[@id=\"cvv\"]")).sendKeys("234");
            Thread.sleep(5000);

        }

        @Test(priority = 7)
        public void printError() throws InterruptedException {
            //identify the element that display the error message
            WebElement errorMessage = driver.findElement(By.xpath("//label[@id='card-number_unhappy']"));
            //print the error to console by getting the text attribute
            System.out.println("The Error Message is: "+errorMessage.getText());
            Thread.sleep(5000);
        }

        @Test(priority = 8)
        public void closePaymentDetailsFrame() {
            //closed the payment modal iframe
            driver.switchTo().defaultContent();
        }

        @AfterTest
        public void tearDown() {
            //shutdown the browser
            driver.quit();

        }
    }

