package com.menudesigner.sjbs.service.connection;

import com.menudesigner.sjbs.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.transaction.Transactional;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import static org.junit.Assert.assertTrue;

/**
 * Created by JIN Benli on 06/01/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(value = "test")
@Transactional
@TransactionConfiguration(defaultRollback = true)
@SpringApplicationConfiguration(classes = Application.class)
public class SQLiteServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(SQLiteServiceTest.class);

    @Autowired
    private SQLiteService sqLiteService;

    @Test
    public void generateDBTest() throws URISyntaxException {
        sqLiteService.generateDB();

        URL url = this.getClass().getResource("/shell/database.sqlite");
        File file = new File(url.toURI());

        assertTrue(file.exists());
    }

}
