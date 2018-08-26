package lowe.mike.requestheaderparserapp.model;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

/**
 * Stores client details.
 *
 * @author Mike Lowe
 */
public class ClientDetails {

  private final String ipAddress;
  private final String language;
  private final String software;

  /**
   * Creates a new {@code ClientDetails} instance.
   *
   * @param ipAddress the ip address
   * @param language  the language
   * @param software  the software
   * @throws NullPointerException if {@code ipAddress}, {@code language} or
   *                              {@code software} are {@code null}
   */
  public ClientDetails(final String ipAddress, final String language, final String software) {
    this.ipAddress = requireNonNull(ipAddress, "ip address cannot be null");
    this.language = requireNonNull(language, "language cannot be null");
    this.software = requireNonNull(software, "software cannot be null");
  }

  /**
   * @return the ip address
   */
  public String getIpAddress() {
    return ipAddress;
  }

  /**
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * @return the software
   */
  public String getSoftware() {
    return software;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final ClientDetails that = (ClientDetails) o;
    return Objects.equals(ipAddress, that.ipAddress) &&
        Objects.equals(language, that.language) &&
        Objects.equals(software, that.software);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ipAddress, language, software);
  }

  @Override
  public String toString() {
    return "ClientDetails{" +
        "ipAddress='" + ipAddress + '\'' +
        ", language='" + language + '\'' +
        ", software='" + software + '\'' +
        '}';
  }

}
