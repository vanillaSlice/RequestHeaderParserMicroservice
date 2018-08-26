package lowe.mike.requestheaderparserapp.controller;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RequestHeaderParserControllerTest {

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Test
  public void constructor_nullRequestHeaderParserService_throwsNullPointerException() {
    expectedException.expect(NullPointerException.class);
    expectedException.expectMessage("request header parser service cannot be null");

    new RequestHeaderParserController(null);
  }

}
