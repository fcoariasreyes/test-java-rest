package cl.test.tbk.fcoarias;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.IOException;
import java.util.List;

import org.apache.http.entity.ContentType;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;



/**
 * RestAssured testing examples.
 *
 * @see 'https://github.com/FutureProcessing/spring-boot-security-example/blob/master/src/test/java/com/futureprocessing/integration/SecurityTest.java'
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppBoot.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class RestAssuredTests {

	 private static final Logger logger = LoggerFactory.getLogger(RestAssuredTests.class);

	  @Value("${local.server.port}")
	  int localServerPort;

	  @Before
	  public void setup() {
	    RestAssured.baseURI = "http://localhost";
	    RestAssured.port = localServerPort;
	  }

	  @Test
	  public void contextLoads() {
	  }

	  /*@Test
	  public void errorRegister() {
	     
		  RequestSpecification spec =
			      given()
			        .parameters("message", "How are you doing?");

			    spec.when()
			      .post("/user/register")
			      .then()
			      .statusCode(405);
	  }*/


}
