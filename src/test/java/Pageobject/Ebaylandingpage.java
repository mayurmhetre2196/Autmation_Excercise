package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Ebaylandingpage extends Baseclass {

	public Ebaylandingpage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//label[text()='Enter your search keyword']/following-sibling::input")
	WebElement searchbox;

	@FindBy(xpath = "//div[@class='gh-search-button__wrap']//button")
	WebElement Serchbutton;

	@FindBy(xpath = "//ul[@class='srp-results srp-list clearfix']//li[1]//div[@class='s-item__image-section']")
	WebElement bookimage;

	@FindBy(xpath = "//ul[@class='srp-results srp-list clearfix']//li[1]//div[@class='s-item__info clearfix']//div[@class='s-item__title']//span")
	WebElement booktitle;

	public void searchBook(String book) {
		searchbox.sendKeys(book);

	}

	public void clickSerach() {
		Serchbutton.click();
	}

	public void clickOnBookimg() {
		bookimage.click();
	}

	public String getBookTitle() {
		return booktitle.getText();

	}

}
