package lowe.mike.requestheaderparserapp.service;

import lowe.mike.requestheaderparserapp.model.ClientDetails;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RequestHeaderParserServiceImplTests {

    @Test
    public void test_parse_returnsClientDetails() {
        RequestHeaderParserService service = new RequestHeaderParserServiceImpl();

        HttpServletRequest request = mock(HttpServletRequest.class);

        when(request.getRemoteAddr()).thenReturn("127.0.0.1");
        when(request.getLocale()).thenReturn(new Locale("en"));
        when(request.getHeader("User-Agent")).thenReturn("Macintosh; Intel Mac OS X 10_13_4");

        ClientDetails actualResponse = service.parse(request);
        ClientDetails expectedResponse = new ClientDetails("127.0.0.1", "en", "Macintosh; Intel Mac OS X 10_13_4");

        assertEquals(expectedResponse, actualResponse);
    }

}
