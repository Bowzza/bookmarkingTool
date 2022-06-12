
# Tests


##US01 Bookmark URL

###Test 1
Description:
Test for bookmarking a valid url with https

Input:
URL = https://www.fh-campuswien.ac.at/

Expected result:
URL = https://www.fh-campuswien.ac.at/

###Test 2
Description:
Test for bookmarking with null

Input:
URL = null

Expected result:
Exception = IllegalArgumentException
Message = Url must not be null

###Test 3
Description:
Test for bookmarking with no protocol

Input: 
URL = ://www.fh-campuswien.ac.at/

Expected result:
Exception = IllegalArgumentException
Message = no protocol: ://www.fh-campuswien.ac.at/

###Test 4
Description:
Test for bookmarking with unknown protocol

Input:
URL = htt://www.fh-campuswien.ac.at/

Expected result:
Exception = IllegalArgumentException
Message = unknown protocol: htt

###Test 5
Description:
Test for bookmarking with no scheme

Input:
URL = httpswww.fh-campuswien.ac.at/

Expected result:
Exception = IllegalArgumentException
Message = no protocol: httpswww.fh-campuswien.ac.at/

###Test 6
Description:
Test for bookmarking with wrong scheme

Input:
URL = https/:/www.fh-campuswien.ac.at/

Expected result:
Exception = IllegalArgumentException
Message = no protocol: https/:/www.fh-campuswien.ac.at/

###Test 7
Description:
Test for bookmarking with illegal character

Input: 
URL = https://www.fh-campuswi^n.ac.at/

Expected result:
Exception = IllegalArgumentException
Message = Illegal character in authority at index 8: https://www.fh-campuswi^n.ac.at/

###Test 8
Description:
Test for bookmarking a valid url with http

Input:
URL = http://www.fh-campuswien.ac.at/

Expected result:
URL = http://www.fh-campuswien.ac.at/

###Test 9
Description:
Test for bookmarking with only a blank space

Input:
URL = " "

Expected result:
Exception = IllegalArgumentException
Message = no protocol: 

###Test 10
Description:
Test for bookmarking with a space in the url

Input: 
URL = https://www.fh-cam puswien.ac.at/

Expected result:
Exception = IllegalArgumentException
Message = Illegal character in authority at index 8: https://www.fh-cam puswien.ac.at/

###Test 11
Description:
Test for bookmarking without any data

Input:
URL = ""

Expected result:
Exception = IllegalArgumentException
Message = no protocol:


##US02 Tag a URL with a keyword

###Test 1
Description:
Test for adding a valid keyword to an URL

Input:
URL = https://www.fh-campuswien.ac.at/
keyword = fh campus

Expected result:
keyword = fh campus

###Test 2
Description:
Test for adding a null keyword to an URL

Input:
URL = https://www.fh-campuswien.ac.at/
keyword = null

Expected result:
Exception = IllegalArgumentException
Message = Keyword must not be null

###Test 3
Description:
Test for adding a keyword without any data to an URL

Input:
URL = https://www.fh-campuswien.ac.at/
keyword = ""

Expected result:
Exception = IllegalArgumentException
Message = Keyword must not be empty

###Test 4
Description:
Test for adding a keyword with a space to an URL

Input:
URL = https://www.fh-campuswien.ac.at/
keyword = " "

Expected result:
Exception = IllegalArgumentException
Message = Keyword must not be empty


##US03 When adding duplicate bookmark it will not be added, instead the rating of that bookmark will be increased

###Test 1
Description:
Test for adding a duplicate bookmark

Input:
First URL = https://www.fh-campuswien.ac.at/
Second URL = https://www.fh-campuswien.ac.at/

Expected result:
List size = 1

###Test 2
Description:
Test if rating is increased when adding a duplicate bookmark

Input:
First URL = https://www.fh-campuswien.ac.at/
Second URL = https://www.fh-campuswien.ac.at/

Expected result:
Rating = 1

###Test 3
Description:
Test if two different bookmarks exists when adding a second bookmark which is not the same

Input:
First URL = https://www.fh-campuswien.ac.at/
Second URL = https://moodle.fh-campuswien.ac.at/

Expected result:
URL = https://moodle.fh-campuswien.ac.at/

###Test 4
Description:
Test if rating from first url doesn't change when different bookmark has been added

Input:
First URL = https://www.fh-campuswien.ac.at/
Second URL = https://moodle.fh-campuswien.ac.at/

Expected result:
Rating = 0

###Test 5
Description:
Test if rating from second url doesn't change when different bookmark has been added

Input:
First URL = https://www.fh-campuswien.ac.at/
Second URL = https://moodle.fh-campuswien.ac.at/

Expected result:
Rating = 0


##US04 As a user I want to know how many of my bookmarks are secure URLs

###Test 1
Description:
Test if there is no secure url

Input:
First URL = http://www.fh-campuswien.ac.at/
Second URL = http://moodle.fh-campuswien.ac.at/

Expected result:
Secure URL count = 0

###Test 2
Description:
Test if there is one secure url

Input:
First URL = https://www.fh-campuswien.ac.at/
Second URL = http://moodle.fh-campuswien.ac.at/

Expected result:
Secure URL count = 1

###Test 3
Description:
Test if there are multiple secure urls

Input:
First URL = https://www.fh-campuswien.ac.at/
Second URL = http://moodle.fh-campuswien.ac.at/
Third URL = https://moodle.fh-campuswien.ac.at/

Expected result:
Secure URL count = 2


##US05 As a user I want a new bookmark to become associated with other bookmarks that are from the same domain

###Test 1
Description:
Test if there are no domains which are associated with each other

Input:
First URL = http://www.fh-campuswien.ac.at/
Second URL = http://moodle.fh-campuswien.ac.at/
Third URL = http://portal.fh-campuswien.ac.at/

Expected result:
List()

###Test 2
Description:
Test if there is one domain which is associated with another domain

Input:
First URL = http://www.fh-campuswien.ac.at/
Second URL = http://moodle.fh-campuswien.ac.at/
Third URL = http://www.fh-campuswien.ac.at/dd

Expected result:
List(http://www.fh-campuswien.ac.at/, http://www.fh-campuswien.ac.at/dd)

###Test 3
Description:
Test if all domains are associated with each other even though they have different subdirectories

Input:
First URL = http://www.fh-campuswien.ac.at/studium-weiterbildung/studien-und-lehrgangsangebot.html
Second URL = http://www.fh-campuswien.ac.at/studium-weiterbildung/studien-und-lehrgangsangebot/detail/bioengineering-bachelor.html
Third URL = http://www.fh-campuswien.ac.at/studium-weiterbildung/bewerbung-und-aufnahme.html

Expected result:
List(http://www.fh-campuswien.ac.at/studium-weiterbildung/bewerbung-und-aufnahme.html, http://www.fh-campuswien.ac.at/studium-weiterbildung/studien-und-lehrgangsangebot.html, http://www.fh-campuswien.ac.at/studium-weiterbildung/studien-und-lehrgangsangebot/detail/bioengineering-bachelor.html)

###Test 4
Description:
Test if domains are associated with each other, even though they have different schemes

Input:
First URL = https://www.fh-campuswien.ac.at
Second URL = http://moodle.fh-campuswien.ac.at
Third URL = http://www.fh-campuswien.ac.at

Expected result:
List(http://www.fh-campuswien.ac.at, https://www.fh-campuswien.ac.at)


##US06 As a user I want to be able to filter bookmarks by one keyword

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

Expected result:
List()

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

Expected result:
List(http://moodle.fh-campuswien.ac.at/)

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

Expected result:
List(http://www.fh-campuswien.ac.at/, http://moodle.fh-campuswien.ac.at/, http://portal.fh-campuswien.ac.at/)


##US07 As a user I want to be able to filter bookmarks by one or more keywords

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

Expected result:
List()

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

Expected result:
List(http://portal.fh-campuswien.ac.at/)

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

Expected result:
List(http://moodle.fh-campuswien.ac.at/)

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

Expected result:
List(http://moodle.fh-campuswien.ac.at/, http://portal.fh-campuswien.ac.at/, http://www.fh-campuswien.ac.at/)

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

Expected result:
List()


###US08 As a user I want to remove a TAG from a bookmark

##Test 1
Description:
Test if you can remove a keyword which is in the keyword list

Input:
First keyword = fh campus
Second keyword = moodle
Remove keyword = moodle

Expected result:
List(fh campus)

##Test 2
Description:
Test if you can remove a keyword which is not in the keyword list

Input:
First keyword = fh campus
Second keyword = moodle
Remove keyword = github

Expected result:
List(fh campus, moodle)

##Test 3
Description:
Test if you can remove a null keyword

Input:
First keyword = fh campus
Second keyword = moodle
Remove keyword = null

Expected result:
Exception = IllegalArgumentException
Message = Keyword must not be null

##Test 4
Description:
Test if you can remove a keyword which is empty

Input:
First keyword = fh campus
Second keyword = moodle
Remove keyword = ""

Expected result:
Exception = IllegalArgumentException
Message = Keyword must not be empty

##Test 5
Description:
Test if you can remove a keyword which is a space

Input:
First keyword = fh campus
Second keyword = moodle
Remove keyword = " "

Expected result:
Exception = IllegalArgumentException
Message = Keyword must not be empty

##Test 6
Description:
Test if you can remove a keyword which is '\n'

Input:
First keyword = fh campus
Second keyword = moodle
Remove keyword = "'\n'"

Expected result:
Exception = IllegalArgumentException
Message = Keyword must not be empty

##Test 7
Description:
Test if you can remove a keyword which is \n

Input:
First keyword = fh campus
Second keyword = moodle
Remove keyword = "\n"

Expected result:
Exception = IllegalArgumentException
Message = Keyword must not be null


###US09 As a user I want to remove a URL bookmark

##Test 1
Description:
Test if you can remove a URL which is in the bookmark list

Input:
First URL = https://www.fh-campuswien.ac.at/
Second URL = https://moodle.fh-campuswien.ac.at/
Remove URL = https://moodle.fh-campuswien.ac.at/

Expected result:
List(https://www.fh-campuswien.ac.at/)

##Test 2
Description:
Test if you can remove a URL which is not in the bookmark list

Input:
First URL = https://www.fh-campuswien.ac.at/
Second URL = https://moodle.fh-campuswien.ac.at/
Remove URL = https://portal.fh-campuswien.ac.at/

Expected result:
List(https://www.fh-campuswien.ac.at/, https://moodle.fh-campuswien.ac.at/)

##Test 3
Description:
Test if you can remove a null bookmark URL

Input:
URL = https://www.fh-campuswien.ac.at/
Remove URL = null

Expected result:
Exception = IllegalArgumentException
Message = Url must not be null

##Test 4
Description:
Test if you can remove a bookmark URL which is empty

Input:
URL = https://www.fh-campuswien.ac.at/
Remove URL = ""

Expected result:
Exception = IllegalArgumentException
Message = Url must not be empty

##Test 5
Description:
Test if you can remove a bookmark URL which is a space

Input:
URL = https://www.fh-campuswien.ac.at/
Remove URL = " "

Expected result:
Exception = IllegalArgumentException
Message = Url must not be empty

##Test 6
Description:
Test if you can remove a bookmark URL which is '\n'

Input:
URL = https://www.fh-campuswien.ac.at/
Remove URL = "'\n'"

Expected result:
Exception = IllegalArgumentException
Message = Url must not be empty

##Test 7
Description:
Test if you can remove a bookmark URL which is \n

Input:
URL = https://www.fh-campuswien.ac.at/
Remove URL = "\n"

Expected result:
Exception = IllegalArgumentException
Message = Url must not be null


###US10 As a user I want to add a current date/time when I add a bookmark

##Test 1
Description:
Test if date gets added when adding a bookmark

Input: 
URL = https://www.fh-campuswien.ac.at/
Date time formatter = "yyyy-MM-dd HH:mm:ss"


###US11. As a user I want to list my bookmarks sorted by rating (highest to smallest)

##Test 1
Description:
Test if you can sort bookmarks by rating

Input:
First URL = https://www.fh-campuswien.ac.at/
Second URL = https://www.fh-campuswien.ac.at/
Third URL = https://www.fh-campuswien.ac.at/
Fourth URL = http://moodle.fh-campuswien.ac.at/
Fifth URL = http://moodle.fh-campuswien.ac.at/
Sixth URL = https://moodle.fh-campuswien.ac.at/

Expected result:
List(https://www.fh-campuswien.ac.at/, http://moodle.fh-campuswien.ac.at/, https://moodle.fh-campuswien.ac.at/)

##Test 2
Description:
Test if no error occurs when sorting an empty list

Input:


Expected result:
List()

##Test 3
Description:
Test if no error occurs when sorting a list with one element

Input:
First URL = https://www.fh-campuswien.ac.at/

Expected result:
List(https://www.fh-campuswien.ac.at/)

##Test 4
Description:
Test if you can sort bookmarks by rating even though they are added in a random order

Input:
First URL = https://www.fh-campuswien.ac.at/
Second URL = http://moodle.fh-campuswien.ac.at/
Third URL = https://www.fh-campuswien.ac.at/
Fourth URL = http://moodle.fh-campuswien.ac.at/
Fifth URL = https://www.fh-campuswien.ac.at/
Sixth URL = https://moodle.fh-campuswien.ac.at/

Expected result:
List(https://www.fh-campuswien.ac.at/, http://moodle.fh-campuswien.ac.at/, https://moodle.fh-campuswien.ac.at/)

##Test 5
Description:
Test if you can sort bookmarks by rating even though they are added at the end

Input:
First URL = https://moodle.fh-campuswien.ac.at/
Second URL = http://moodle.fh-campuswien.ac.at/
Third URL = http://moodle.fh-campuswien.ac.at/
Fourth URL = https://www.fh-campuswien.ac.at/
Fifth URL = https://www.fh-campuswien.ac.at/
Sixth URL = https://www.fh-campuswien.ac.at/

Expected result:
List(https://www.fh-campuswien.ac.at/, http://moodle.fh-campuswien.ac.at/, https://moodle.fh-campuswien.ac.at/)
