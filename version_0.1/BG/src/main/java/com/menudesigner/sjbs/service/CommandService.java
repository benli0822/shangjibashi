package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.domain.Command;

/**
 * Created by JIN Benli on 22/12/14.
 */
public interface CommandService {

    /**
     * Make sure that the command added is unique
     * @param command
     * @return
     */
    long addCommand(Command command);

    /**
     * This is where we create the basic command object
     * @param title
     * @param msg_extra
     * @param table_no
     * @param client_no
     * @return
     */
    long addCommand(String title, String msg_extra, int table_no, int client_no);

    /**
     * Remove command by reservation title
     * @param title
     * @return
     */
    boolean removeCommand(String title);

}
