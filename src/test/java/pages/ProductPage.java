package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	WebDriver driver;
	public ProductPage(WebDriver sdriver) {
        this.driver= sdriver;
        PageFactory.initElements(sdriver, this);
    }

	@FindBy(xpath = "//a[contains(text(),'Apollo Products')]")
	WebElement apolloProducts;
	public WebElement getapolloProductsList() {
		return apolloProducts;
	}

	//// a[text()='Personal Care']
	@FindBy(xpath = "//a[text()='Personal Care']")
	WebElement PersonalCareOption;
	public WebElement getPersonalCareOption() {
		return PersonalCareOption;
	}

	@FindAll(@FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div/ul/li[1]/div/div[2]/div[1]/div/ul/li"))
	private List<WebElement> PersonalProducts;
	public List<WebElement> getPersonalProductsList() {
		return PersonalProducts;
	}

	@FindBy(xpath = "//*[contains(text(),'Skin Care')]")
	WebElement SkinCare;
	public WebElement getSkinCare() {
		return SkinCare;
	}

//	@FindBy(xpath = "//*[@class='CategoryListing_cpHeader__zUPb5']/p")
//	WebElement totalItems;
//	public WebElement getTotalItems() {
//		return totalItems;
//	}
	///html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/p/text()[2]

	@FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/p")
	WebElement totalItems;
	public WebElement getTotalItems() {
		return totalItems;
	}
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[3]/div/div[2]/div/a/div/div[2]/div[1]/h2")
	WebElement ProductName;
	public WebElement getProductName() {
		return ProductName;
	}

	@FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div[2]/div[2]/div[3]/div/div/div/div/div[1]/div[2]/div/div/div[4]/div[2]/span[2]")
	WebElement CutOffPrice;
	public WebElement getCutOffPrice() {
		return CutOffPrice;
	}

	@FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div[2]/div[2]/div[3]/div/div/div/div/div[1]/div[2]/div/div/div[4]/div[2]")
	WebElement CurrentPrice;
	public WebElement getCurrentPrice() {
		return CurrentPrice;
	}

	@FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[2]/div/div[2]/div[2]/div[3]/div/div/div/div/div[1]/div[2]/div/div/div[3]/a/div/img")
	WebElement ProductClick;
	public WebElement getProductClick() {
		return ProductClick;
	}

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div[2]/button")
	WebElement AddToCart;
	public void getAddtoCart() throws InterruptedException {
		AddToCart.click();
	}

	@FindBy(xpath = "/html/body/div[1]/div[2]/div[3]/div/div/div[1]/div[2]/p[1]")
	WebElement TotalAmount;
	public WebElement getTotalAmount() {
		return TotalAmount;
	}

	// //span[contains(text(),'View Cart')]
	@FindBy(xpath = "//span[contains(text(),'View Cart')]")
	WebElement ViewCart;
	public WebElement getViewCart() {
		return ViewCart;
	}

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div/div[1]/div[2]/div[1]/span[2]")
	WebElement ItemsInYourcart;
	public WebElement getItemsInYourcart() {
		return ItemsInYourcart;
	}

	// Cart total, Discount on MRP, To Pay
	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/p[2]/span")
	WebElement CartTotal;
	public WebElement getCartTotal() {
		return CartTotal;
	}

	@FindBy(xpath = "//*[@class='CartSummary_priceCol__YKIqz CartSummary_green__F6cCx']")
	WebElement discountOnMRP;
	public WebElement getdiscountOnMRP() {
		return discountOnMRP;
	}

	@FindBy(xpath = "//*[@class='CartSummary_priceCol__YKIqz CartSummary_priceColright__ctai9']")
	WebElement ToPay;
	public WebElement getToPay() {
		return ToPay;
	}
}
