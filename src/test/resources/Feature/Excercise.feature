Feature: Add Cart

Scenario: Verify user able to add book into Cart

Given user Open browser  
When user navigate to ebay.com
Then user should display with ebay shopping page and verify number of items in the cart
When user search for "book" in search box and click on search button
And user select an item form listing page
When user click on Add to cart 
Then the cart should be updated 
And verify the number of items in the cart page and cart symbol