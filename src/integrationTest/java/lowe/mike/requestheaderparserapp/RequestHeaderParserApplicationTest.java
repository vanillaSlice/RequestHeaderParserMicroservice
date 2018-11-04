package lowe.mike.requestheaderparserapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import lowe.mike.requestheaderparserapp.model.ClientDetails;
import lowe.mike.requestheaderparserapp.service.RequestHeaderParserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * {@link RequestHeaderParserApplication} tests.
 *
 * @author Mike Lowe
 */
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SpringExtension.class)
public class RequestHeaderParserApplicationTest {

  @Autowired
  private Environment environment;

  @Autowired
  private TestRestTemplate template;

  @MockBean
  private RequestHeaderParserService service;

  private static final String IP_ADDRESS = "127.0.0.1";
  private static final String LANGUAGE = "en";
  private static final String SOFTWARE = "Macintosh; Intel Mac OS X 10_13_4";

  @BeforeEach
  public void setUp() {
    when(service.parse(any())).thenReturn(new ClientDetails(IP_ADDRESS, LANGUAGE, SOFTWARE));
  }

  @Test
  public void home_returnsClientDetails() {
    ResponseEntity<String> response = template.getForEntity("/", String.class);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals("{"
        + "\"ipAddress\":\"" + IP_ADDRESS + "\","
        + "\"language\":\"" + LANGUAGE + "\","
        + "\"software\":\"" + SOFTWARE + "\""
        + "}", response.getBody());
  }

}
