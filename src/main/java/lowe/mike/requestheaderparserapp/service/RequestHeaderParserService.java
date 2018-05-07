package lowe.mike.requestheaderparserapp.service;

import lowe.mike.requestheaderparserapp.model.ClientDetails;

import javax.servlet.http.HttpServletRequest;

public interface RequestHeaderParserService {

    ClientDetails parse(HttpServletRequest request);

}
