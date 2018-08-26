package lowe.mike.requestheaderparserapp.controller;

import lowe.mike.requestheaderparserapp.model.ClientDetails;
import lowe.mike.requestheaderparserapp.service.RequestHeaderParserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static java.util.Objects.requireNonNull;

/**
 * Application controller.
 *
 * @author Mike Lowe
 */
@RestController
public class RequestHeaderParserController {

  private final RequestHeaderParserService requestHeaderParserService;

  /**
   * Creates a new {@code RequestHeaderParserController}.
   *
   * @param requestHeaderParserService the {@link RequestHeaderParserService}
   * @throws NullPointerException if {@code requestHeaderParserService} is {@code null}
   */
  public RequestHeaderParserController(final RequestHeaderParserService requestHeaderParserService) {
    this.requestHeaderParserService =
        requireNonNull(requestHeaderParserService, "request header parser service cannot be null");
  }

  @RequestMapping("/")
  public ClientDetails home(final HttpServletRequest request) {
    return requestHeaderParserService.parse(request);
  }

}
