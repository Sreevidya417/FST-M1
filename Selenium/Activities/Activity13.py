from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:
    driver.get("https://v1.training-support.net/selenium/tables")

    print("Tile of the page is -> ", driver.title)
    rows =  driver.find_elements(By.XPATH, "//table[contains(@class, 'striped')]/tbody/tr")
            
    print("Number of rows in the talbe :- ", len(rows))

    columns = driver.find_elements(By.XPATH, "//table[contains(@class, 'striped')]/tbody/tr[1]/td")

    print("Number of columns in the table :- ", len(columns))

    third_row = driver.find_elements(By.XPATH, "//table[contains(@class, 'striped')]/tbody/tr[3]/td")

    print("Values in 3rd row")
    for row in third_row:
        i = 1
        print(i,"th Column's  Value -> ", row.text) 
        i = i+1
    
    sec_row_sec_col = driver.find_elements(By.XPATH, "//table[contains(@class, 'striped')]/tbody/tr[2]/td[2]")
    print("Value at second row, second column is none other than -> ", sec_row_sec_col)


