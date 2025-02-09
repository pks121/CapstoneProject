import pytest
from selenium.webdriver.common.by import By
from pages.checkboxes_page import CheckboxesPage
from pages.file_upload_page import FileUploadPage


BASE_URL = "http://the-internet.herokuapp.com/"

def test_checkboxes(driver):
    driver.get(BASE_URL)
    checkboxes_page = CheckboxesPage(driver)
    
    checkboxes_page.navigate_to_checkboxes()
    
    assert checkboxes_page.get_header_text() == "Checkboxes"
    
    assert not checkboxes_page.is_checkbox_1_selected(), "Checkbox 1 should be unchecked"
    assert checkboxes_page.is_checkbox_2_selected(), "Checkbox 2 should be checked"

def test_file_upload(driver):
    driver.get(BASE_URL)
    file_upload_page = FileUploadPage(driver)
    
    file_upload_page.navigate_to_file_upload()
    
    assert file_upload_page.get_header_text() == "File Uploader"
    
    file_upload_page.upload_file("C:/Users/pks66/Downloads/Capstone Project - SDET Basic 4.docx")
