package ApiTests;

import BaseTest.BaseTestClass;
import io.restassured.response.Response;
import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.CSVReaderUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.*;

public class ApiTests extends BaseTestClass {
    String filePath = System.getProperty("user.dir") + "/testData/testdata.csv";
    @DataProvider(name = "apiData")
    public Iterator<Object[]> dataProvider() throws Exception {
        List<CSVRecord> records = CSVReaderUtil.readCSV(filePath);
        List<Object[]> data = new ArrayList<>();
        for (CSVRecord record : records) {
            data.add(new Object[]{
                    record.get("method"),
                    record.get("endpoint"),
                    Integer.parseInt(record.get("expectedStatus")),
                    record.get("expectedKey"),
                    record.get("expectedValue")
            });
        }
        return data.iterator();
    }

    @Test(dataProvider = "apiData")
    public void testAPI(String method, String endpoint, int expectedStatus, String expectedKey, String expectedValue) {
        Response response = null;
        switch (method.toUpperCase()) {
            case "GET":
                response = request.get(endpoint);
                break;
            case "POST":
                response = request.body("{\"title\":\"foo\", \"body\":\"bar\", \"userId\":1}").post(endpoint);
                break;
        }

        assertNotNull(response, "No response returned");
        assertEquals(response.getStatusCode(), expectedStatus, "Status code mismatch");

        if (!expectedKey.isEmpty()) {
            String actualValue = response.jsonPath().getString(expectedKey);
            assertTrue(actualValue.contains(expectedValue), "Expected key-value not found.");
        }
    }
}
