package lowe.mike.requestheaderparserapp.service;

import lowe.mike.requestheaderparserapp.model.ClientDetails;

import javax.servlet.http.HttpServletRequest;

public class RequestHeaderParserServiceImpl implements RequestHeaderParserService {

    @Override
    public ClientDetails parse(HttpServletRequest request) {
        String ipaddress = request.getRemoteAddr();
        String language = request.getLocale().toLanguageTag();
        String software = request.getHeader("User-Agent");
        return new ClientDetails(ipaddress, language, software);
    }

}
