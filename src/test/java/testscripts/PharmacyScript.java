package testscripts;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class PharmacyScript extends TestBase{
	
	@Test
	void ApolloPage() throws InterruptedException, AWTException, IOException {
		mousehover(apollopages.getapolloProductsList());
		List<WebElement> PersonalProductsList = apollopages.getPersonalProductsList();
		for(WebElement Options :PersonalProductsList ) {
			System.out.println(Options.getText());
		}
		//System.out.println("Size of PersonalProductsList : "+apollopages.getPersonalCareOption().getText());
		//apollopages.getPersonalProductsList().get(1).isDisplayed()
		for(WebElement option : PersonalProductsList) {
			if(option.getText().contains("Skin Care")) {
				captureScreenshot("ApolloPage");
				System.out.println("Skin Care Option is Presented");
			}			
		}
		driver.manage().deleteAllCookies();
		
		apollopages.getSkinCare().click();
		Thread.sleep(5000);
		System.out.println("Total Items Presented in Skin Care Page : "+apollopages.getTotalItems().getText());
		//captureScreenshot("Total Items in Skin Care Page");
		
		// Chosen one product, printing and verifying with assertions ProductName, Cuff-off-price and CurrentPrice
		boolean ProductName = apollopages.getProductName().getText().contains("Apollo Pharmacy");
		boolean CutOffPrice = apollopages.getCutOffPrice().getText().contains("(₹160)");
		boolean CurrentPrice = apollopages.getCurrentPrice().getText().contains("MRP(₹160)₹100");
		boolean OneProductDetails = ProductName && CutOffPrice && CurrentPrice;
		if(OneProductDetails){
		    System.out.println("Product Name : " +apollopages.getProductName().getText());
		    System.out.println("Cut-Off-Price : " +apollopages.getCutOffPrice().getText());
			System.out.println("Current Price : " +apollopages.getCurrentPrice().getText());
		    captureScreenshot("ApolloPage");
			Assert.assertTrue(OneProductDetails);    
		}
		else {
			System.out.println("Product Name : " +apollopages.getProductName().getText());
		    System.out.println("Cut-Off-Price : " +apollopages.getCutOffPrice().getText());
			System.out.println("Current Price : " +apollopages.getCurrentPrice().getText());
		    captureScreenshot("ApolloPage");
			Assert.assertTrue(OneProductDetails);   
		}
		        
		apollopages.getProductClick().click();
		Thread.sleep(4000);
		captureScreenshot("ApolloPage");
		        
		// Clicking on AddToCart Button
		apollopages.getAddtoCart();
		driver.navigate().back();
		captureScreenshot("ApolloPage");
		        
		// Verifying TotalAmount 
		boolean TotalAmount = apollopages.getTotalAmount().getText().contains("₹100");
		if(TotalAmount) {
			System.out.println("Total Amount : "+apollopages.getTotalAmount().getText());
			captureScreenshot("ApolloPage");
			Assert.assertTrue(TotalAmount);
		}
		else {
			System.out.println("Total Amount : "+apollopages.getTotalAmount().getText());
			captureScreenshot("ApolloPage");
			Assert.assertTrue(TotalAmount);			
		}
		
		// Clicking on ViewCart Button
		apollopages.getViewCart().click();
		Thread.sleep(3000);
		driver.manage().deleteAllCookies();
		
		// Verifying details in the Cart page : Items in Your Cart, Cart total, Discount on MRP and To Pay
		boolean ItemsInYourCart = apollopages.getItemsInYourcart().getText().contains("(1)");
		boolean CartTotal = apollopages.getCartTotal().getText().contains("₹160");
		boolean DiscountOnMRP = apollopages.getdiscountOnMRP().getText().contains("- ₹60");
		boolean ToPay = apollopages.getToPay().getText().contains("₹100");
		boolean CartDetails = ItemsInYourCart && CartTotal && DiscountOnMRP && ToPay;
		if(CartDetails) {
			System.out.println("Items In Your Cart : " +apollopages.getItemsInYourcart().getText());
			System.out.println("Cart Total : " +apollopages.getCartTotal().getText());
			System.out.println("Discount On MRP : " +apollopages.getdiscountOnMRP().getText());
			System.out.println("To Pay : " +apollopages.getToPay().getText());
			captureScreenshot("ApolloPage");
			Assert.assertTrue(CartDetails);
		}
		else {
			System.out.println("Items In Your Cart : " +apollopages.getItemsInYourcart().getText());
			System.out.println("Cart Total : " +apollopages.getCartTotal().getText());
			System.out.println("Discount On MRP : " +apollopages.getdiscountOnMRP().getText());
			System.out.println("To Pay : " +apollopages.getToPay().getText());
			captureScreenshot("ApolloPage");
			Assert.assertTrue(CartDetails);	
		}
		Thread.sleep(6000);
		//driver.manage().deleteAllCookies();
		Thread.sleep(3000);
	}
}
