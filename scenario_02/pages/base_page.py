from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

class BasePage:
    def __init__(self, driver):
        self.driver = driver

    def open_url(self, url):
        self.driver.get(url)

    def find_element(self, by_locator):
        return WebDriverWait(self.driver, 10).until(
            EC.presence_of_element_located(by_locator)
        )

    def click_element(self, by_locator):
        element = self.find_element(by_locator)
        element.click()

    def get_text(self, by_locator):
        return self.find_element(by_locator).text

    def is_element_selected(self, by_locator):
        return self.find_element(by_locator).is_selected()
