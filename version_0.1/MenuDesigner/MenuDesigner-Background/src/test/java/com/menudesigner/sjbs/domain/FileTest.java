package com.menudesigner.sjbs.domain;

import com.menudesigner.sjbs.Application;
import com.menudesigner.sjbs.service.repository.FileRepository;
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
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by JIN Benli on 28/12/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(value = "test")
@Transactional
@TransactionConfiguration(defaultRollback = true)
@SpringApplicationConfiguration(classes = Application.class)
public class FileTest {

    private static final Logger logger = LoggerFactory.getLogger(FileTest.class);

    @Autowired
    private FileRepository fileRepository;

    @Test
    public void addSimpleFileTest() {

        File file = new File();

        file.setName("test");
        file.setLocation("test");
        file.setSize(100L);
        file.setType("media");

        File theFile = fileRepository.save(file);

        List<File> newAddedFile = fileRepository.findFileByName(file.getName());

        assertThat(theFile.getId(), notNullValue());
        assertThat(newAddedFile.size(), is(1));
        assertThat(newAddedFile.get(0).getName(), is(theFile.getName()));
    }

    @Test
    public void removeSimpleFileTest() {

        File file = new File();

        file.setName("test");
        file.setLocation("test");
        file.setSize(100L);
        file.setType("media");

        File res1 = fileRepository.save(file);

        fileRepository.delete(res1);

        File res2 = fileRepository.findOne(res1.getId());

        assertThat(res1, notNullValue());
        assertThat(res2, nullValue());
    }

}
