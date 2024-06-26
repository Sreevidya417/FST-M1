from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import time

service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # initialize the wait object
    wait = WebDriverWait(driver, 10)
    # Navigate to the URL
    driver.get("https://v1.training-support.net/selenium/dynamic-attributes")
    # Print the title of the page
    driver.maximize_window()
    print("Page title is: ", driver.title)

    # Find the username field
    username = driver.find_element(By.XPATH, "//input[contains(@class, '-username')]")
    # Find the password field
    password = driver.find_element(By.XPATH, "//input[contains(@class, '-password')]")
    confirmPasswor = driver.find_element(By.XPATH,"//label[text() = 'Confirm Password']/following-sibling::input");   
    email = driver.find_element(By.XPATH, "//input[contains(@class, 'email-')]")
    # Enter the credentials
    username.send_keys("Rajkumar")
    password.send_keys("Vishnuvardhan")
    confirmPasswor.send_keys("Vishnuvardhan")
    email.send_keys("jame@bond.com")
    # Find the login button and click it
    time.sleep(8)
    driver.find_element(By.XPATH, "//button[contains(text(), 'Sign Up')]").click()

    # wait for the login message to appear
    wait.until(EC.visibility_of_element_located((By.ID, "action-confirmation")))

    # Print the confirmation message
    message = driver.find_element(By.ID, "action-confirmation").text
    print("Login message: ", message)