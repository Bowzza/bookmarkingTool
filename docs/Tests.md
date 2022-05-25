
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


## When adding duplicate bookmark it will not be added, instead the rating of that bookmark will be increased

###Test 1
Description:
Test for adding a duplicate bookmark

Input:
First URL = https://www.fh-campuswien.ac.at/
Second URL = https://www.fh-campuswien.ac.at/

###Test 2
Description:
Test if rating is increased when adding a duplicate bookmark

Input:
First URL = https://www.fh-campuswien.ac.at/
Second URL = https://www.fh-campuswien.ac.at/

###Test 3
Description:
Test if two different bookmarks exists when adding a second bookmark which is not the same

Input:
First URL = https://www.fh-campuswien.ac.at/
Second URL = https://moodle.fh-campuswien.ac.at/

###Test 4
Description:
Test if rating from first url doesn't change when different bookmark has been added

Input:
First URL = https://www.fh-campuswien.ac.at/
Second URL = https://moodle.fh-campuswien.ac.at/

###Test 5
Description:
Test if rating from second url doesn't change when different bookmark has been added

Input:
First URL = https://www.fh-campuswien.ac.at/
Second URL = https://moodle.fh-campuswien.ac.at/


## As a user I want to know how many of my bookmarks are secure URLs

###Test 1
Description:
Test if there is no secure url

Input:
First URL = http://www.fh-campuswien.ac.at/
Second URL = http://moodle.fh-campuswien.ac.at/

###Test 2
Description:
Test if there is one secure url

Input:
First URL = https://www.fh-campuswien.ac.at/
Second URL = http://moodle.fh-campuswien.ac.at/

###Test 3
Description:
Test if there are multiple secure urls

Input:
First URL = https://www.fh-campuswien.ac.at/
Second URL = http://moodle.fh-campuswien.ac.at/
Third URL = https://moodle.fh-campuswien.ac.at/


## As a user I want a new bookmark to become associated with other bookmarks that are from the same domain

###Test 1
Description:
Test if there are no domains which are associated with each other

Input:
First URL = http://www.fh-campuswien.ac.at/
Second URL = http://moodle.fh-campuswien.ac.at/
Third URL = http://portal.fh-campuswien.ac.at/

###Test 2
Description:
Test if there is one domain which is associated with another domain

Input:
First URL = http://www.fh-campuswien.ac.at/
Second URL = http://moodle.fh-campuswien.ac.at/
Third URL = http://www.fh-campuswien.ac.at/dd

###Test 3
Description:
Test if all domains are associated with each other even though they have different subdirectories

Input:
First URL = http://www.fh-campuswien.ac.at/studium-weiterbildung/studien-und-lehrgangsangebot.html
Second URL = http://www.fh-campuswien.ac.at/studium-weiterbildung/studien-und-lehrgangsangebot/detail/bioengineering-bachelor.html
Third URL = http://www.fh-campuswien.ac.at/studium-weiterbildung/bewerbung-und-aufnahme.html

###Test 4
Description:
Test if domains are associated with each other, even though they have different schemes

Input:
First URL = https://www.fh-campuswien.ac.at
Second URL = http://moodle.fh-campuswien.ac.at
Third URL = http://www.fh-campuswien.ac.at


## As a user I want to be able to filter bookmarks by one keyword

###Test 1
Description:
Test if you get no bookmark when filtering bookmarks by one keyword

Input:
First URL = http://www.fh-campuswien.ac.at/
First keyword = fh campus
Second URL = http://moodle.fh-campuswien.ac.at/
Second keyword = fh campus
Third URL = http://portal.fh-campuswien.ac.at/
Third keyword = fh campus
Filter keyword = fhcampus

###Test 2
Description:
Test if you get one bookmark when filtering bookmarks by one keyword

Input:
First URL = http://www.fh-campuswien.ac.at/
First keyword = fh campus
Second URL = http://moodle.fh-campuswien.ac.at/
Second keyword = moodle fh campus
Third URL = http://portal.fh-campuswien.ac.at/
Third keyword = portal fh campus
Filter keyword = moodle fh campus

###Test 3
Description:
Test if you get all bookmarks when filtering bookmarks by one keyword

Input:
First URL = http://www.fh-campuswien.ac.at/
First keyword = fh campus
Second URL = http://moodle.fh-campuswien.ac.at/
Second keyword = fh campus
Third URL = http://portal.fh-campuswien.ac.at/
Third keyword = fh campus
Filter keyword = fh campus


##As a user I want to be able to filter bookmarks by one or more keywordsMay, 202235TDD Workshop #3

###Test 1
Description:
Test if you get no bookmark when filtering bookmarks by multiple keywords

Input:
First URL = http://www.fh-campuswien.ac.at/
First keyword list = fh, campus
Second URL = http://moodle.fh-campuswien.ac.at/
Second keyword list = moodle, campus
Third URL = http://portal.fh-campuswien.ac.at/
Third keyword list = portal, campus
Filter keyword list = fh campus, wien

###Test 2
Description:
Test if you get one bookmark when filtering bookmarks by multiple keywords, one matching keyword

Input:
First URL = http://www.fh-campuswien.ac.at/
First keyword list = fh, campus
Second URL = http://moodle.fh-campuswien.ac.at/
Second keyword list = moodle, campus
Third URL = http://portal.fh-campuswien.ac.at/
Third keyword list = portal, campus
Filter keyword list = portal, wien

###Test 3
Description:
Test if you get one bookmark when filtering bookmarks by multiple keywords, three matching keywords

Input:
First URL = http://www.fh-campuswien.ac.at/
First keyword list = ac, at
Second URL = http://moodle.fh-campuswien.ac.at/
Second keyword list = moodle, campus, fh
Third URL = http://portal.fh-campuswien.ac.at/
Third keyword list = ac, at
Filter keyword list = moodle, campus, fh

###Test 4
Description:
Test if you get all bookmarks when filtering bookmarks by multiple keywords

Input:
First URL = http://www.fh-campuswien.ac.at/
First keyword list = fh, campus
Second URL = http://moodle.fh-campuswien.ac.at/
Second keyword list = moodle, campus
Third URL = http://portal.fh-campuswien.ac.at/
Third keyword list = portal, campus
Filter keyword list = fh, moodle, portal

###Test 5
Description:
Test if you get no bookmarks when filtering bookmarks by an empty list

Input:
First URL = http://www.fh-campuswien.ac.at/
First keyword list = fh, campus
Second URL = http://moodle.fh-campuswien.ac.at/
Second keyword list = moodle, campus
Third URL = http://portal.fh-campuswien.ac.at/
Third keyword list = portal, campus
Filter keyword list = []


###As a user I want to remove a TAG from a bookmark

##Test 1
Description:
Test if you can remove a keyword which is in the keyword list

Input:
First keyword = fh campus
Second keyword = moodle
Remove keyword = moodle

##Test 2
Description:
Test if you can remove a keyword which is not in the keyword list

Input:
First keyword = fh campus
Second keyword = moodle
Remove keyword = github

##Test 3
Description:
Test if you can remove a null keyword

Input:
First keyword = fh campus
Second keyword = moodle
Remove keyword = null