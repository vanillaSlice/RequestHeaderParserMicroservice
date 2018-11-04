package lowe.mike.requestheaderparserapp.service;

import static java.util.Objects.requireNonNull;

import javax.servlet.http.HttpServletRequest;
import lowe.mike.requestheaderparserapp.model.ClientDetails;

/**
 * Default implementation of {@link RequestHeaderParserService} extract details from a {@link
 * HttpServletRequest}.
 *
 * @author Mike Lowe
 */
public class DefaultHeaderParserService implements RequestHeaderParserService {

  @Override
  public ClientDetails parse(HttpServletRequest request) {
    requireNonNull(request, "request is null");

    String ipAddress = request.getRemoteAddr();
    String language = request.getLocale().toLanguageTag();
    String software = request.getHeader("User-Agent");

    return new ClientDetails(ipAddress, language, software);
  }

}
