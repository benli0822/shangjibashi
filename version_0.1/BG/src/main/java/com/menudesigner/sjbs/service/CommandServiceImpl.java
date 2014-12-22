package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.domain.Command;
import com.menudesigner.sjbs.service.repository.CommandRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by JIN Benli on 22/12/14.
 */
@Component("commandService")
@Transactional
public class CommandServiceImpl implements CommandService {
    private static final Logger logger = LoggerFactory.getLogger(CommandServiceImpl.class);

    private final CommandRepository commandRepository;

    @Autowired
    public CommandServiceImpl(CommandRepository commandRepository) {
        this.commandRepository = commandRepository;
    }

    @Override
    public long addCommand(Command command) {
        logger.debug("Try adding command: " + command.toString());

        if (commandRepository.findCommandByTitle(command.getTitle()).size() == 0) {
            Command theCommand = commandRepository.save(command);
            logger.info("Command " + command.toString() + " added!");
            return theCommand.getId();
        } else {
            logger.error("Command " + command.toString() + " existed!");
            return -1L;
        }
    }

    @Override
    public long addCommand(String title, String msg_extra, int table_no, int client_no) {
        logger.debug("Try adding command");

        Command command = new Command();
        command.setTitle(title);
        command.setMsg_extra(msg_extra);
        command.setTable_no(table_no);
        command.setClient_no(client_no);

        return this.addCommand(command);
    }

    @Override
    public boolean removeCommand(String title) {
        logger.debug("Removing command title " + title);

        List<Command> commands = commandRepository.findCommandByTitle(title);

        if (commands.size() == 0) {
            logger.debug("Command not found!");
            return false;
        }

        for (Command c : commands) {
            logger.debug("Removing command " + c.toString());
            commandRepository.delete(c);
        }

        logger.debug("Remove finish");
        return true;
    }
}
