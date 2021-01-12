package decorator.pages.checkoutpage;

import decorator.core.BasePage;
import decorator.core.Driver;
import decorator.data.PurchaseInfo;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage<CheckoutElements, CheckoutAssertions> {
    public CheckoutPage() {
        super("http://demos.bellatrix.solutions/checkout/");
    }

    public void fillBillingInfo(PurchaseInfo purchaseInfo) {
        if (purchaseInfo.getCouponCode() != null) {
            elements().couponCodeShowInputButton().click();
            Driver.getBrowserWait().until(ExpectedConditions.elementToBeClickable(elements().couponCodeInput()));
            elements().couponCodeInput().sendKeys(purchaseInfo.getCouponCode());
            elements().couponCodeApplyButton().click();
        }
        elements().billingFirstName().sendKeys(purchaseInfo.getFirstName());
        elements().billingLastName().sendKeys(purchaseInfo.getLastName());
        elements().billingCompany().sendKeys(purchaseInfo.getCompany());
        elements().billingCountryWrapper().click();
        elements().billingCountryFilter().sendKeys(purchaseInfo.getCountry());
        elements().getCountryOptionByName(purchaseInfo.getCountry()).click();
        elements().billingAddress1().sendKeys(purchaseInfo.getAddress1());
        elements().billingAddress2().sendKeys(purchaseInfo.getAddress2());
        elements().billingCity().sendKeys(purchaseInfo.getCity());
        elements().billingZip().sendKeys(purchaseInfo.getZip());
        elements().billingPhone().sendKeys(purchaseInfo.getPhone());
        elements().billingEmail().sendKeys(purchaseInfo.getEmail());
        if (purchaseInfo.getShouldCreateAccount()) {
            elements().createAccountCheckBox().click();
        }

        if (purchaseInfo.getShouldCheckPayment()) {
            elements().checkPaymentsRadioButton().click();
        }

        Driver.waitForAjax();
        elements().placeOrderButton().click();
    }
}
