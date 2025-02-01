package StepDefination;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import Pageobject.EBaybookslectionpage;
import Pageobject.Ebaylandingpage;
import Utility.Utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Ebay {
	public WebDriver driver;
	Ebaylandingpage elp;
	EBaybookslectionpage ebp;
	String noofelement;
	Utility ul;
	String booktitle;

	@Given("user Open browser")
	public void user_open_browser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("user navigate to ebay.com")
	public void user_navigate_to_ebay_com() {
		driver.get("https://www.ebay.com/?msockid=1dd316381c2763942317077a1dbc62fe");
		ul = new Utility(driver);
		ul.pageTakesScreenShot("launch");
	}

	@Then("user should display with ebay shopping page and verify number of items in the cart")
	public void user_should_display_with_ebay_shopping_page_and_verify_number_of_items_in_the_cart() {
		String ActaulTitle = driver.getTitle();
		String ExcpetedTitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";
		Assert.assertEquals("Title mismatch", ActaulTitle, ExcpetedTitle);
	}

	@When("user search for {string} in search box and click on search button")
	public void user_search_for_in_search_box_and_click_on_search_button(String book) {
		elp = new Ebaylandingpage(driver);
		elp.searchBook(book);
		elp.clickSerach();
		ul.pageTakesScreenShot("List Page");
	}

	@When("user select an item form listing page")
	public void user_select_an_item_form_listing_page() throws InterruptedException {
		booktitle = elp.getBookTitle();
		elp.clickOnBookimg();
		Thread.sleep(3000);
	}

	@When("user click on Add to cart")
	public void user_click_on_add_to_cart() throws InterruptedException {
		ebp = new EBaybookslectionpage(driver);
		Set<String> se = driver.getWindowHandles();
		ArrayList<String> as = new ArrayList<String>(se);
		driver.switchTo().window(as.get(1));
		Thread.sleep(3000);
		ul.pageTakesScreenShot("cart Page");
		ebp.scrollToAddcart();
		ebp.addCart();
	}

	@Then("the cart should be updated")
	public void the_cart_should_be_updated() throws InterruptedException {
		String carttitile = driver.getTitle();
		Assert.assertEquals("user is not on cart page", carttitile, "eBay shopping cart");
		WebElement erb = driver.findElement(By.xpath("//a[@class='gh-flyout__target']//span[@class='gh-cart__icon']"));
		ul.webElementTakesScreenShot(erb);
		if (ebp.getCartItemTitle().equals(booktitle)) {
			System.out.println("Element is updated in cart");
		}
	}

	@Then("verify the number of items in the cart page and cart symbol")
	public void verify_the_number_of_items_in_the_cart_page_and_cart_symbol() {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue((ebp.noOfItenmCartSymbl() == ebp.noOfElementInCart()));
		System.out.println("No element in cart is:" + ebp.noOfItenmCartSymbl());
		driver.quit();
	}
	

}
