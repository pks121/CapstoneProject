package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ExcelUtils;

public class GetCountryTest {

    private static final String BASE_URL = "https://restcountries.com/v3.1/translation/";

    @DataProvider(name = "translations")
    public Object[][] getTranslationData() {
        String filePath = "src/test/resources/countries.xlsx";
        List<String> translations = ExcelUtils.getTranslations(filePath, "API_Data");

        Object[][] data = new Object[translations.size()][1];
        for (int i = 0; i < translations.size(); i++) {
            data[i][0] = translations.get(i);
        }
        return data;
    }

    @Test(dataProvider = "translations")
    public void testGetCountryByTranslation(String translation) {
        Response response = RestAssured.get(BASE_URL + translation);
        System.out.println("Response: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code!");
        Assert.assertTrue(response.getBody().asString().contains("name"), "Response does not contain 'name'");
    }
}
