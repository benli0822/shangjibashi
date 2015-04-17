package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.domain.File;

/**
 * Created by JIN Benli on 28/12/14.
 */
public interface FileService {

    /**
     * Make sure is the unique file created in repository
     *
     * @param file
     * @return
     */
    long saveFile(File file);

    /**
     * This is where we create a basic file with no association
     *
     * @param name
     * @param location
     * @param size
     * @param type
     * @return
     */
    long saveFile(String name, String location, long size, String type);

    /**
     * add an association between a file and a dish
     *
     * @param dish_id
     * @param file_id
     * @return
     */
    boolean addFileToDish(long dish_id, long file_id);

    /**
     * add an association between a file and a menu
     *
     * @param menu_id
     * @param file_id
     * @return
     */
    boolean addFileToMenu(long menu_id, long file_id);

    /**
     * add an association between a file and an activity
     *
     * @param activity_id
     * @param file_id
     * @return
     */
    boolean addFileToActivity(long activity_id, long file_id);

    /**
     * Remove a file and all its association
     *
     * @param fileName
     * @return
     */
    boolean removeFile(String fileName);
}
