package com.sap.core.odata.fit.ref;

import static org.junit.Assert.assertTrue;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.core.odata.api.commons.HttpStatusCodes;
import com.sap.core.odata.core.commons.ContentType;

/**
 * @author SAP AG
 */
public class ContentNegotiationTest extends AbstractRefTest {

  @Test
  public void formatOverwriteAcceptHeader() throws Exception {
    final HttpResponse response = callUri("?$format=xml", HttpHeaders.ACCEPT, "image/gif", HttpStatusCodes.OK);
    checkMediaType(response, ContentType.APPLICATION_XML);
  }

  @Test
  public void formatXml() throws Exception {
    final HttpResponse response = callUri("?$format=xml");
    checkMediaType(response, ContentType.APPLICATION_XML);
  }

  @Test
  @Ignore("JSON is currently not supported")
  public void formatJson() throws Exception {
    final HttpResponse response = callUri("?$format=json");
    checkMediaType(response, ContentType.APPLICATION_JSON);
  }

  @Test
  public void formatAtom() throws Exception {
    final HttpResponse response = callUri("Rooms('1')?$format=atom");
    checkMediaType(response, ContentType.APPLICATION_ATOM_XML_ENTRY);
  }

  @Test
  public void formatNotSupported() throws Exception {
    callUri("?$format=XXXML", HttpStatusCodes.NOT_ACCEPTABLE);
  }

  @Test
  public void contentTypeMetadata() throws Exception {
    final HttpResponse response = callUri("$metadata");
    checkMediaType(response, ContentType.APPLICATION_XML, false);
  }

  @Test
  public void contentTypeMetadataNotAccepted() throws Exception {
    callUri("$metadata", HttpHeaders.ACCEPT, "image/gif", HttpStatusCodes.NOT_ACCEPTABLE);
  }

  @Test
  public void browserAcceptHeader() throws Exception {
    final HttpResponse response = callUri("$metadata",
        HttpHeaders.ACCEPT, "text/html, application/xhtml+xml, application/xml;q=0.9, */*;q=0.8",
        HttpStatusCodes.OK);
    checkMediaType(response, ContentType.APPLICATION_XML, false);
  }

  @Test
  public void contentTypeServiceDocumentWoAcceptHeader() throws Exception {
    final HttpResponse response = callUri("");
    checkMediaType(response, ContentType.APPLICATION_ATOM_SVC);
    final String body = getBody(response);
    assertTrue(body.length() > 100);
    log.debug(body);
  }

  @Test
  public void contentTypeServiceDocumentAcceptHeaders() throws Exception {
    final HttpResponse response = callUri("",
        HttpHeaders.ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
        HttpStatusCodes.OK);
    checkMediaType(response, ContentType.APPLICATION_XML);
    final String body = getBody(response);
    assertTrue(body.length() > 100);
    log.debug(body);
  }

}
