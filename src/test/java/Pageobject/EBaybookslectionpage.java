package Pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EBaybookslectionpage extends Baseclass {

	JavascriptExecutor js = (JavascriptExecutor) driver;

	public EBaybookslectionpage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[text()='Add to cart']")
	WebElement addcart;
	//
	
	@FindBy(xpath = "//div[@class='cart-summary-line-item']//span[contains(text(),'Item')]")
	WebElement noOfItems;
	//
	
	@FindBy(xpath = "//div[@class='grid-item-title']//a")
	WebElement cartelementtitle;
	//
	@FindBy(xpath = "//a[@class='gh-flyout__target']//span[@class='gh-cart__icon']")
	WebElement cartsymb;
	
	public void addCart() {
		addcart.click();
	}

	public void scrollToAddcart() {
		js.executeScript("arguments[0].scrollIntoView();", addcart);
		// System.out.println(js.executeScript("return window.pageYOffset;"));
	}
	
	public int noOfElementInCart() {
		String noElement=noOfItems.getText();
		int a=noElement.indexOf("(");
		String ai=noElement.substring(a+1, 7);
		int noofelement=Integer.parseInt(ai);
		return noofelement;
		
	}
	public String getCartItemTitle() {
			return cartelementtitle.getText();
		
	}
	
	public int noOfItenmCartSymbl() {
		String arial=cartsymb.getAttribute("aria-label");
		return Integer.parseInt(arial.substring(28, 29));
	
	}
}
