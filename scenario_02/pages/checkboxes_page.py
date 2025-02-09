from selenium.webdriver.common.by import By
from pages.base_page import BasePage

class CheckboxesPage(BasePage):
    CHECKBOXES_LINK = (By.LINK_TEXT, "Checkboxes")
    HEADER_TEXT = (By.TAG_NAME, "h3")
    CHECKBOX_1 = (By.XPATH, "//input[1]")
    CHECKBOX_2 = (By.XPATH, "//input[2]")

    def navigate_to_checkboxes(self):
        self.click_element(self.CHECKBOXES_LINK)

    def get_header_text(self):
        return self.get_text(self.HEADER_TEXT)

    def is_checkbox_1_selected(self):
        return self.is_element_selected(self.CHECKBOX_1)

    def is_checkbox_2_selected(self):
        return self.is_element_selected(self.CHECKBOX_2)
