from selenium.webdriver.common.by import By
from pages.base_page import BasePage

class FileUploadPage(BasePage):
    FILE_UPLOAD_LINK = (By.LINK_TEXT, "File Upload")
    HEADER_TEXT = (By.TAG_NAME, "h3")
    CHOOSE_FILE_BUTTON = (By.ID, "file-upload")
    UPLOAD_BUTTON = (By.ID, "file-submit")

    def navigate_to_file_upload(self):
        self.click_element(self.FILE_UPLOAD_LINK)

    def get_header_text(self):
        return self.get_text(self.HEADER_TEXT)

    def upload_file(self, file_path):
        self.find_element(self.CHOOSE_FILE_BUTTON).send_keys(file_path)
        self.click_element(self.UPLOAD_BUTTON)
