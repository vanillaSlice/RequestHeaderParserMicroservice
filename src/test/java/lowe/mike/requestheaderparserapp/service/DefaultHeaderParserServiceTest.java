package lowe.mike.requestheaderparserapp.service;

import lowe.mike.requestheaderparserapp.model.ClientDetails;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultHeaderParserServiceTest {

  private static final String IP_ADDRESS = "127.0.0.1";
  private static final String LOCALE = "en";
  private static final String USER_AGENT = "Macintosh; Intel Mac OS X 10_13_4";

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  private final RequestHeaderParserService service = new DefaultHeaderParserService();

  @Mock
  private HttpServletRequest request;

  @Before
  public void setUp() {
    when(request.getRemoteAddr()).thenReturn(IP_ADDRESS);
    when(request.getLocale()).thenReturn(new Locale(LOCALE));
    when(request.getHeader("User-Agent")).thenReturn(USER_AGENT);
  }

  @Test
  public void parse_nullRequest_throwsNullPointerException() {
    expectedException.expect(NullPointerException.class);
    expectedException.expectMessage("request cannot be null");

    service.parse(null);
  }

  @Test
  public void parse_validRequest_returnsClientDetails() {
    final ClientDetails actualResponse = service.parse(request);
    final ClientDetails expectedResponse = new ClientDetails(IP_ADDRESS, LOCALE, USER_AGENT);

    assertEquals(expectedResponse, actualResponse);
  }

}
