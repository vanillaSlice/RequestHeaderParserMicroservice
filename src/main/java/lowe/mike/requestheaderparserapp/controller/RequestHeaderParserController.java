package lowe.mike.requestheaderparserapp.controller;

import lowe.mike.requestheaderparserapp.model.ClientDetails;
import lowe.mike.requestheaderparserapp.service.RequestHeaderParserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RequestHeaderParserController {

    private final RequestHeaderParserService requestHeaderParserService;

    public RequestHeaderParserController(RequestHeaderParserService requestHeaderParserService) {
        this.requestHeaderParserService = requestHeaderParserService;
    }

    @RequestMapping("/")
    public ClientDetails home(HttpServletRequest request) {
        return requestHeaderParserService.parse(request);
    }

}
