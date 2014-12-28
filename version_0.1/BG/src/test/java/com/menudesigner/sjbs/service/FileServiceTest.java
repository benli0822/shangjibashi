package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.Application;
import com.menudesigner.sjbs.domain.File;
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

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by JIN Benli on 28/12/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(value = "test")
@Transactional
@TransactionConfiguration(defaultRollback = true)
@SpringApplicationConfiguration(classes = Application.class)
public class FileServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(FileServiceTest.class);

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private FileService fileService;

    @Test
    public void addSimpleFileTest() {
        long file_id = fileService.saveFile("test", "test", 20L, "media");

        File file = fileRepository.findOne(file_id);

        assertThat(file_id, notNullValue());
        assertThat(file, notNullValue());

        assertThat(file.getName(), is("test"));
        assertThat(file.getLocation(), is("test"));
        assertThat(file.getSize(), is(20L));
        assertThat(file.getType(), is("media"));
    }





}
