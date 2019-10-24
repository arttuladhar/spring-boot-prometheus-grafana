import requests
import time


def performGetRequest(url):
  try:
    result = requests.get(url)
    if result.status_code == 200:
      print('.', end='', flush=True)
      time.sleep(5)
    else:
      print ("Request Failed")
      exit(1)
  except:
    print ("Something Went Wrong, Retry in 5 sec")
    time.sleep(5)


print ("Performing Load Testing")

while (True):
  performGetRequest("http://localhost:8080/")
  performGetRequest("http://localhost:8080/countries")
  performGetRequest("http://localhost:8080/country/US")

