package lowe.mike.requestheaderparserapp;

import lowe.mike.requestheaderparserapp.model.ClientDetails;
import lowe.mike.requestheaderparserapp.service.RequestHeaderParserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
@ContextConfiguration
public class RequestHeaderParserApplicationTests {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private RequestHeaderParserService service;

  private static final String IP_ADDRESS = "127.0.0.1";
  private static final String LANGUAGE = "en";
  private static final String SOFTWARE = "Macintosh; Intel Mac OS X 10_13_4";

  @Before
  public void setUp() {
    when(service.parse(any())).thenReturn(new ClientDetails(IP_ADDRESS, LANGUAGE, SOFTWARE));
  }

  @Test
  public void home_returnsClientDetails() throws Exception {
    mvc.perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(content().json("{" +
            "\"ipAddress\":\"" + IP_ADDRESS + "\"," +
            "\"language\":\"" + LANGUAGE + "\"," +
            "\"software\":\"" + SOFTWARE + "\"" +
            "}"));
  }

}
