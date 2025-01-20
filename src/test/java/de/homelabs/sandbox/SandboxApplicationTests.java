package de.homelabs.sandbox;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import de.homelabs.sandbox.controller.MainController;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class SandboxApplicationTests {
	
	@LocalServerPort
	private int port;
	

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	MainController mainController;
	
	@Test
	void testMainController() {
		assertThat(mainController).isNotNull();
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
				String.class)).contains("Hello World!");
	}

}
