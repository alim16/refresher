import suds
import sys

county = sys.argv[1] or "West Midlands" #parameter input 1 or default value 
location = sys.argv[2] or "Birmingham" #parameter input 2 or default value
url = "http://www.webservicex.net/uklocation.asmx?WSDL"


client = suds.client.Client(url)

response = client.service.GetUKLocationByCounty(county)
if location in response:
    print "found location " + location + " in reponse"
else:
    print "location " +location+ " not found in response"

