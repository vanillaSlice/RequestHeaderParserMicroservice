package lowe.mike.requestheaderparserapp.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ClientDetailsTest {

  private static final String IP_ADDRESS = "127.0.0.1";
  private static final String LANGUAGE = "en";
  private static final String SOFTWARE = "Macintosh; Intel Mac OS X 10_13_4";

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Test
  public void constructor_nullIpAddress_throwsNullPointerException() {
    expectedException.expect(NullPointerException.class);
    expectedException.expectMessage("ip address cannot be null");

    new ClientDetails(null, LANGUAGE, SOFTWARE);
  }

  @Test
  public void constructor_nullLanguage_throwsNullPointerException() {
    expectedException.expect(NullPointerException.class);
    expectedException.expectMessage("language cannot be null");

    new ClientDetails(IP_ADDRESS, null, SOFTWARE);
  }

  @Test
  public void constructor_nullSoftware_throwsNullPointerException() {
    expectedException.expect(NullPointerException.class);
    expectedException.expectMessage("software cannot be null");

    new ClientDetails(IP_ADDRESS, LANGUAGE, null);
  }

  @Test
  public void equalsHashCodeContract() {
    EqualsVerifier.forClass(ClientDetails.class)
        .usingGetClass()
        .verify();
  }

}
