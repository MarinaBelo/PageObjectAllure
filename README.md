**Requirements:**
-Chrome browser version - 90
``````
**Overview**
Create Test framework based
- Java;
- Maven;
- Junit - version - 5.7.1;
- Selenium Webdriver - version - 4.0.0-beta-3;

**Test Cases**
    **_Case 1: Welcome page: all required elements are displayed_**
1. Go to Welcome page: https://www.yellowtailwine.com
2. Verify that “I am of legal drinking age in” is displayed
3. Verify that checkbox before “I am of legal drinking age in” is displayed
4. Verify that dropdown with Select is displayed
5. Verify that “Welcome” button is displayed and is inactive
   
   **_Case 2: Welcome page: navigate to  main page as European customer_**
1. Tick on checkbox
2. Select “Europe” from dropbox
3. Press “Welcome” button
4. Main page should be displayed
   
   **_Case 3: Main page: all required elements are displayed_**
1. Navigate to main page
2. Verify that the following elements are displayed:
- menu button
- WELCOME TO THE WORLD OF [Yellow tail]
- We are passionate about creating great tasting, quality wines for everyone to
  enjoy
- find your wine button
- footer
  
    _**Case 4: Main page: Menu button logic (open header)_**
1. Navigate to main page
2. Click on Menu button
3. Verify that header with all needed links is appeared
4. Click on [yellow tail]
5. Verify that Menu button is visible
   
   **_Case 5: Main page: Menu button logic (close header)_**
1. Navigate to main page
2. Click on Menu button
3. Click on [yellow tail]
4. Verify that Menu button is visible
   
    **_Case 6: Main page: Global Nav logic_**
1. Navigate to main page
2. Click on Menu button
3. Click on Globe icon
4. Select China in popup and click on it
5. Verify that language is changed
   
    **_Case 7:  Main page: Global Nav logic (CHINA - separate site is open)_**
1. Navigate to main page
2. Click on Menu button
3. Click on Globe icon
4. Select China in popup and click on it
5. Click on icon ( in white square on screenshot)
6. Verify that “https://www.weibo.com/yellowtailChina” site is open in new tab
   
   **_Case 8: Where to buy:  enter valid postal code_**
1. Navigate to “Where to buy” page
2. Enter valid data in “Your location” field
3. Click on Search button
4. Verify that the results of search are displayed
   
    **_Case 9: Cocktails: Select one wine_**
1. Navigate to “Cocktails” page
2. Select “Red wine cocktails”
3. Verify that 7 recipes are displayed
   
    **_Case 10: Cocktails: Navigate to Cocktail recipe page_**
1. Navigate to “Cocktails” page
2. Scroll to “RASPBERRY ROSЙ” recipe
3. Click on “RASPBERRY ROSЙ” recipe
4. Verify that new page is displayed:
- ingredients section is displayed
  
    **_Case 11: Cocktails: Select several wines_**
1. Navigate to “Cocktails” page
2. Select  “Red wine cocktails”
3. Select “Sparkling wine cocktails”
4. Verify that “Multiple” word is displayed in “Type” dropdown
5. Verify that 18 recipes are displayed

