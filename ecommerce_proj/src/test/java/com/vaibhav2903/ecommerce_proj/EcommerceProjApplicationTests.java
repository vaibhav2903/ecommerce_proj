package com.vaibhav2903.ecommerce_proj;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaibhav2903.ecommerce_proj.dto.ProductRequest;
import com.vaibhav2903.ecommerce_proj.model.Product;
import com.vaibhav2903.ecommerce_proj.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
class EcommerceProjApplicationTests {

	@Container
	static MongoDBContainer mongoContainer = new MongoDBContainer("mongo:4.4.2");

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	ProductRepository productRepository;

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
		dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoContainer::getReplicaSetUrl);
	}

	@Test
	void shouldCreateProduct() throws Exception{
		
		ProductRequest productRequest = getProductRequest();
		String productRequestAsString = objectMapper.writeValueAsString(productRequest);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
				.contentType(MediaType.APPLICATION_JSON)
				.content(productRequestAsString))
				.andExpect(status().isCreated());

		Assertions.assertEquals(productRepository.findAll().size(),1);
	}

//	@Test
//	void shouldContainProduct() throws Exception{
//		String productAsString = objectMapper.writeValueAsString(getProduct());
//		mockMvc.perform(MockMvcRequestBuilders.get("api/product")
//				.contentType(MediaType.APPLICATION_JSON)
//				).andExpect(status().is2xxSuccessful())
//				.andExpect(jsonPath("$[0].name", is("Iphone 13")));
//	}

	private ProductRequest getProductRequest() {
		return ProductRequest.builder().name("Iphone 13")
				.price(BigDecimal.valueOf(1200))
				.description("Mobile Phone")
				.build();
	}

	private Product getProduct() {
		return Product.builder().name("Iphone 13")
				.price(BigDecimal.valueOf(1200))
				.description("Mobile Phone")
				.build();
	}


	@Test
	void contextLoads() {
	}

}
