package lowe.mike.requestheaderparserapp.controller;

import static java.util.Objects.requireNonNull;

import javax.servlet.http.HttpServletRequest;
import lowe.mike.requestheaderparserapp.model.ClientDetails;
import lowe.mike.requestheaderparserapp.service.RequestHeaderParserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
  public RequestHeaderParserController(RequestHeaderParserService requestHeaderParserService) {
    this.requestHeaderParserService =
        requireNonNull(requestHeaderParserService, "request header parser service is null");
  }

  @RequestMapping("/")
  public ClientDetails home(HttpServletRequest request) {
    return requestHeaderParserService.parse(request);
  }

}
