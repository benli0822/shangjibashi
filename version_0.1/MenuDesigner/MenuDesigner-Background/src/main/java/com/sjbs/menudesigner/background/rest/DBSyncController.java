package com.sjbs.menudesigner.background.rest;

import com.sjbs.menudesigner.background.service.connection.SQLiteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by JIN Benli on 14/01/15.
 */
@Controller
@RequestMapping("/api/sync")
public class DBSyncController {
  private static final Logger logger = LoggerFactory.getLogger(DBSyncController.class);

  @Resource
  @Qualifier("SQLiteService")
  private SQLiteService sqLiteService;

  @RequestMapping(value = "/getDbFile/database.sqlite", method = RequestMethod.GET)
  public
  @ResponseBody
  FileSystemResource getDbFile(HttpServletRequest request,
                               HttpServletResponse response) throws URISyntaxException {
    URL url = this.getClass().getResource("/shell/database.sqlite");

    sqLiteService.generateDB();

    File file = new File(url.toURI());

    ServletContext context = request.getServletContext();

    // get MIME type of the file
    String mimeType = context.getMimeType(url.getPath());
    if (mimeType == null) {
      // set to binary type if MIME mapping not found
      mimeType = "application/octet-stream";
    }
    logger.info("MIME type: " + mimeType);

    // set content attributes for the response
    response.setContentType(mimeType);
    response.setContentLength((int) file.length());

    // set headers for the response
    String headerKey = "Content-Disposition";
    String headerValue = String.format("attachment; filename=\"%s\"",
        file.getName());
    response.setHeader(headerKey, headerValue);

    return new FileSystemResource(url.getFile());
  }
}
