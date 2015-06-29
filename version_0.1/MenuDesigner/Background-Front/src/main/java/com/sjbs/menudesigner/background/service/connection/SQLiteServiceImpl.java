package com.sjbs.menudesigner.background.service.connection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * Created by JIN Benli on 06/01/15.
 */
@Service
@Component("SQLiteService")
public class SQLiteServiceImpl implements SQLiteService {

  private static final Logger logger = LoggerFactory.getLogger(SQLiteServiceImpl.class);

  @Override
  public void generateDB() {
    try {
      String file = this.getClass().getClassLoader().getResource("shell/export2sqlite.sh").getPath();
      assert file != null;
      System.out.println(file);

      ProcessBuilder pb =
          new ProcessBuilder("/bin/sh", file);
//            Map<String, String> env = pb.environment();
//            env.put("VAR1", System.getenv("PATH"));
      System.out.println(System.getenv("PATH"));
//            env.remove("OTHERVAR");
//            env.put("VAR2", env.get("VAR1") + "suffix");
      System.out.println(new File(this.getClass().getClassLoader().getResource("shell").getPath()));
      pb.directory(new File(this.getClass().getClassLoader().getResource("shell").getPath()));
      File log = new File(new File(this.getClass().getClassLoader().getResource("shell").getPath()) +
          "/sqlite_export.log");
      pb.redirectErrorStream(true);
      pb.redirectOutput(ProcessBuilder.Redirect.appendTo(log));
      Process p = pb.start();
      assert pb.redirectInput() == ProcessBuilder.Redirect.PIPE;
      assert pb.redirectOutput().file() == log;
      assert p.getInputStream().read() == -1;

      int rc = p.waitFor();

      StringBuffer output = new StringBuffer();

      BufferedReader reader =
          new BufferedReader(new InputStreamReader(p.getInputStream()));

      String line = "";
      while ((line = reader.readLine()) != null) {
        output.append(line + "\n");
      }

      logger.debug("Script executed successfully " + rc + "\n" + output);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    SQLiteServiceImpl s = new SQLiteServiceImpl();
    s.generateDB();
  }
}
