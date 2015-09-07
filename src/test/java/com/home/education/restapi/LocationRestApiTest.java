package com.home.education.restapi;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.Test;

import com.home.education.mountains.config.AppConfig;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
@Test
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class LocationRestApiTest  extends AbstractTestNGSpringContextTests {

	@Autowired
	private WebApplicationContext context;
	
	//@Test
	public void locationGetById(){
		RestAssuredMockMvc.webAppContextSetup(context, springSecurity());
		given().
			postProcessors(httpBasic("username", "password")).
			param("admin", "123456").
		when().
			get("Mountains/location/2").
		then().
			statusCode(200).
			body("location.id", equalTo(2));
	}
}
