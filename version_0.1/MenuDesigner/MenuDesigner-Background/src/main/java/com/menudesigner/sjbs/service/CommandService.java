package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.domain.Command;

/**
 * Created by JIN Benli on 22/12/14.
 */
public interface CommandService {

    /**
     * Make sure that the command added is unique
     *
     * @param command
     * @return
     */
    long addCommand(Command command);

    /**
     * This is where we create the basic command object
     *
     * @param title
     * @param msg_extra
     * @param table_no
     * @param client_no
     * @return
     */
    long addCommand(String title, String msg_extra, float price, int table_no, int client_no);

    /**
     * Add an existed dish to command
     *
     * @param dish_id
     * @param command_id
     * @return
     */
    boolean addDishToCommand(long dish_id, long command_id, int quantity);

    /**
     * Add an existed activity to command
     *
     * @param activity_id
     * @param command_id
     * @return
     */
    boolean addActivityToCommand(long activity_id, long command_id, int quantity);

    /**
     * Add an existed menu to command
     *
     * @param menu_id
     * @param command_id
     * @return
     */
    boolean addMenuToCommand(long menu_id, long command_id, int quantity);

    /**
     * Remove command by reservation title
     *
     * @param title
     * @return
     */
    boolean removeCommand(String title);

}
