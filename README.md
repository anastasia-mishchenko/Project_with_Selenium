Requirements:
-Chrome Version 93.0.4577.82 (Official Build) (64-bit)
-Selenium 3.141.59
-TestNg 7.4.0


Test cases:

Case 1: Welcome page: all required elements are displayed
1. Go to Welcome page: https://www.yellowtailwine.com
2. Verify that “I am of legal drinking age in” is displayed
3. Verify that checkbox before “I am of legal drinking age in” is displayed
4. Verify that dropdown with Select is displayed
5. Verify that “Welcome” button is displayed and is inactive

Case 2: Welcome page: navigate to main page as European customer
1. Tick on checkbox
2. Select “Europe” from dropbox
3. Press “Welcome” button
4. Main page should be displayed

Case 3: Main page: all required elements are displayed
1. Navigate to main page
2. Verify that the following elements are displayed:
- menu button
- WELCOME TO THE WORLD OF [Yellow tail]
- We are passionate about creating great tasting, quality wines for everyone to enjoy
- find your wine button
- footer

Case 4: Main page: Menu button logic (open header)
1. Navigate to main page
2. Click on Menu button
3. Verify that header with all needed links is appeared

Case 5: Main page: Menu button logic (close header)
1. Navigate to main page
2. Click on Menu button
3. Click on [yellow tail]
4. Verify that Menu button is visible

Case 8: Where to buy: enter valid postal code
1. Navigate to “Where to buy” page
2. Enter valid data in “Your location” field
3. Click on Search button
4. Verify that the results of search are displayed
