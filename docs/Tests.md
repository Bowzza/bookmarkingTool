
# Tests


## Bookmark URL

###Test 1
Description:
Test for bookmarking a valid url with https

Input:
URL = https://www.fh-campuswien.ac.at/

###Test 2
Description:
Test for bookmarking with null

Input:
URL = null

###Test 3
Description:
Test for bookmarking with no protocol

Input: 
URL = ://www.fh-campuswien.ac.at/

###Test 4
Description:
Test for bookmarking with unknown protocol

Input:
URL = htt://www.fh-campuswien.ac.at/

###Test 5
Description:
Test for bookmarking with no scheme

Input:
URL = httpswww.fh-campuswien.ac.at/

###Test 6
Description:
Test for bookmarking with wrong scheme

Input:
URL = https/:/www.fh-campuswien.ac.at/

###Test 7
Description:
Test for bookmarking with illegal character

Input: 
URL = https://www.fh-campuswi^n.ac.at/

###Test 8
Description:
Test for bookmarking a valid url with http

Input:
URL = http://www.fh-campuswien.ac.at/

###Test 9
Description:
Test for bookmarking with only a blank space

Input:
URL = " "

###Test 10
Description:
Test for bookmarking with a space in the url

Input: 
URL = https://www.fh-cam puswien.ac.at/

###Test 11
Description:
Test for bookmarking without any data

Input:
URL = ""


## Tag a URL with a keyword

###Test 1
Description:
Test for adding a valid keyword to an URL

Input:
URL = https://www.fh-campuswien.ac.at/
keyword = fh campus

###Test 2
Description:
Test for adding a null keyword to an URL

Input:
URL = https://www.fh-campuswien.ac.at/
keyword = null

###Test 3
Description:
Test for adding a keyword without any data to an URL

Input:
URL = https://www.fh-campuswien.ac.at/
keyword = ""

###Test 4
Description:
Test for adding a keyword with a space to an URL

Input:
URL = https://www.fh-campuswien.ac.at/
keyword = " "
