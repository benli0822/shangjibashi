package com.menudesigner.sjbs.web.controllers;

import com.menudesigner.sjbs.domain.File;
import com.menudesigner.sjbs.service.FileService;
import com.menudesigner.sjbs.service.repository.FileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by JIN Benli on 28/12/14.
 */
@Controller
public class FileUploadController
{
    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public
    @ResponseBody
    List<File> upload(MultipartHttpServletRequest request,
                      HttpServletResponse response) throws IOException
    {
        // Getting uploaded files from the request object
        Map<String, MultipartFile> fileMap = request.getFileMap();

        // Maintain a list to send back the files info. to the client side
        List<File> uploadedFiles = new ArrayList<File>();

        // Iterate through the map
        for (MultipartFile multipartFile : fileMap.values())
        {

            // if already existed, directly return files info
            if (fileRepository.findFileByName(multipartFile.getOriginalFilename()).size() != 0)
            {
                List<File> files = fileRepository.findFileByName(multipartFile.getOriginalFilename());
                for (File f : files)
                {
                    uploadedFiles.add(f);
                }
            } else
            {

                // Save the file to local disk
                saveFileToLocalDisk(multipartFile);

                File fileInfo = saveFileToDatabase(multipartFile);

                // adding the file info to the list
                uploadedFiles.add(fileInfo);
            }
        }

        return uploadedFiles;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public
    @ResponseBody
    boolean delete(@RequestParam("id") String filename)
    {
        try
        {

            java.io.File file = new java.io.File(getDestinationLocation() + "" + filename);

            if (file.delete())
            {
                fileService.removeFile(filename);

                logger.info(file.getName() + " is deleted!");
                return true;
            } else
            {
                logger.info("Delete operation is failed.");
                return false;
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }


    private File saveFileToDatabase(MultipartFile multipartFile)
            throws IOException
    {

        // save upload file to repository and return it
        long file_id = fileService.saveFile(
                multipartFile.getOriginalFilename(),
                getDestinationLocation(),
                multipartFile.getSize(),
                multipartFile.getContentType());

        return fileRepository.findOne(file_id);
    }

    private String getDestinationLocation()
    {
        return "images/";
    }

    private void saveFileToLocalDisk(MultipartFile multipartFile)
            throws IOException, FileNotFoundException
    {

        String outputFileName = getOutputFilename(multipartFile);

        FileCopyUtils.copy(multipartFile.getBytes(), new FileOutputStream(
                outputFileName));
    }

    private String getOutputFilename(MultipartFile multipartFile)
    {
        URL url = this.getClass().getResource("/static/");
        return url.getPath() + getDestinationLocation() + multipartFile.getOriginalFilename();
    }


    @RequestMapping(value = {"/img_list"})
    public String listBooks(Map<String, Object> map)
    {

        map.put("fileList", fileRepository.findAll());

        // will be resolved to /views/listFiles.jsp
        // TODO need change
        return "/listFiles";
    }

}
