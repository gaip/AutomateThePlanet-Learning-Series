/*
 * Copyright 2021 Automate The Planet Ltd.
 * Author: Anton Angelov
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package bellatrixdemos;

import bellatrixdemos.data.PurchaseInfo;
import bellatrixdemos.pages.interfaces.CheckoutPage;
import bellatrixdemos.pages.interfaces.ItemPage;
import bellatrixdemos.pages.interfaces.ShoppingCartPage;

public class ShoppingCart {
    private final ItemPage itemPage;
    private final ShoppingCartPage shoppingCartPage;
    private final CheckoutPage checkoutPage;

    public ShoppingCart(ItemPage itempage, ShoppingCartPage shoppingCartPage, CheckoutPage checkoutPage) {
        this.itemPage = itempage;
        this.shoppingCartPage = shoppingCartPage;
        this.checkoutPage = checkoutPage;
    }

    public void purchaseItem(String itemUrl, double itemPrice, PurchaseInfo purchaseInfo) {
        itemPage.navigate(itemUrl);
        itemPage.assertPrice(itemPrice);
        itemPage.clickBuyNowButton();
        itemPage.clickViewShoppingCartButton();
        shoppingCartPage.clickProceedToCheckoutButton();
        shoppingCartPage.assertSubtotalAmount(itemPrice);
        checkoutPage.fillBillingInfo(purchaseInfo);
        checkoutPage.assertSubtotal(itemPrice);
    }
}
