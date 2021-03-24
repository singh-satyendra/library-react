package com.ibm.library.cucumber;

/**
import java.io.IOException;
import static org.junit.Assert.assertNotNull;
import org.springframework.web.client.RestTemplate;
import com.ibm.library.model.BookData;
import cucumber.api.java.en.*;

public class CucumberStepDefinitions {

   private BookData bookData;
   private RestTemplate restTemplate;

   public CucumberStepDefinitions() {
      this.restTemplate = new RestTemplate();
   }

   @Given("^Library and BookInventory services are running and BookInventory's db has isbn, (.*?), in it$")
   public void libraryBookInventoryRunningIsbnInBookDb(String isbn) throws Exception {
   }

   @When("^The Library Microservice receives a request for isbn, (.*?)$")
   public void libraryReceivesGetBookRequest(String isbn) throws IOException {
      String libraryServiceRESTRequest = "http://localhost:9001/library/book/" + isbn;
      this.bookData = this.restTemplate.getForObject(libraryServiceRESTRequest, BookData.class); 
   }

   @Then("^The Library microservice should return book information for isbn, (.*?)$")
   public void libraryGetBookReturnsBookData(String isbn) {
      assertNotNull("book data should not be null", this.bookData);
   }
}

*/