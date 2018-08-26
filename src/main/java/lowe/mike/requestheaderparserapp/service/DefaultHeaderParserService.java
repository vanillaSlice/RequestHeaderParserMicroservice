package lowe.mike.requestheaderparserapp.service;

import lowe.mike.requestheaderparserapp.model.ClientDetails;

import javax.servlet.http.HttpServletRequest;

import static java.util.Objects.requireNonNull;

/**
 * Default implementation of {@link RequestHeaderParserService}
 * extract details from a {@link HttpServletRequest}.
 *
 * @author Mike Lowe
 */
public class DefaultHeaderParserService implements RequestHeaderParserService {

  @Override
  public ClientDetails parse(final HttpServletRequest request) {
    requireNonNull(request, "request cannot be null");

    final String ipAddress = request.getRemoteAddr();
    final String language = request.getLocale().toLanguageTag();
    final String software = request.getHeader("User-Agent");

    return new ClientDetails(ipAddress, language, software);
  }

}
