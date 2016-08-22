require 'selenium-webdriver'

#tested with firefox v47.0.1

searchText = ARGV[0] #type in something to look for as the first param
requiredLang = ARGV[1] #type in a language e.g svenska as the second param

#incase no args given
if ARGV.empty?
	searchText = "FiReFOX"
	requiredLang = "Deutsch"
end

	#Navigate to the Wikipedia home page
driver = Selenium::WebDriver.for :firefox
driver.navigate.to "http://www.wikipedia.org/"

	#Type in a string given as parameter in the search input field? 
search = driver.find_element(:id, 'searchInput')
search.send_keys(searchText)
	#Select English as the search language.
dropdown = driver.find_element(:id, 'searchLanguage')
select_list = Selenium::WebDriver::Support::Select.new(dropdown)
select_list.select_by(:text, 'English')

	#Click the search button.
search.submit

	# Validate that the ?rst heading of the search results page matches the search string (ignoring case).
if driver.find_element(:id => "firstHeading").text.downcase.include?(searchText.downcase)
	print "heading found #{searchText}\n"
else
	print "text #{searchText} not found"
end

	#Verify that the search results page is available in a language given as parameter
list = driver.find_elements(:id => "p-lang") #working

list.each do |element|
	if element.text.include? requiredLang
	puts "found #{requiredLang} language in list"
	end
end


	#Navigate to the search results page in that language.
langItem = driver.find_element(:xpath, "//*[@id=\"p-lang\"]/div/ul/li[contains(.,\"#{requiredLang}\")]")
puts "link text found for: #{langItem.text}"
#langItemLink = driver.find_element(:xpath, '//*[@id="p-lang"]/div/ul/li[contains(.,"Deutsch")]/a') #works
langItem = driver.find_element(:xpath, "//*[@id=\"p-lang\"]/div/ul/li[contains(.,\"#{requiredLang}\")]/a")
langItem.click

	#Validate that the search results page in the new language includes a link to the version in English.
list = driver.find_elements(:id => "p-lang") #working

list.each do |element|
	if element.text.include? "English"
	puts "found English language in list"
	end
end


driver.quit
