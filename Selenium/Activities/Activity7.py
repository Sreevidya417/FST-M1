from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.keys import Keys



service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as mockbrowser:
    
    mockbrowser.get("https://v1.training-support.net/selenium/drag-drop")
    print("Title of this page is -> ", mockbrowser.title)

    actor = ActionChains(mockbrowser)

    ball = mockbrowser.find_element(By.CLASS_NAME, "ui-draggable")
    pickup=mockbrowser.find_element(By.ID,"droppable")
    drop=mockbrowser.find_element(By.ID,"dropzone2")

    actor.drag_and_drop(ball, pickup).perform
    if(drop.text.find("Dropped")):
        print("Drop zone activated")
    



