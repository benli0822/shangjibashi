//package com.menudesigner.sjbs.service;
//
//import com.menudesigner.sjbs.Application;
//import com.menudesigner.sjbs.domain.Command;
//import com.menudesigner.sjbs.domain.Dish;
//import com.menudesigner.sjbs.service.repository.CommandRepository;
//import com.menudesigner.sjbs.service.repository.DishRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.transaction.TransactionConfiguration;
//
//import javax.transaction.Transactional;
//import java.sql.Date;
//import java.sql.Time;
//import java.util.List;
//
//import static org.hamcrest.Matchers.is;
//import static org.hamcrest.Matchers.notNullValue;
//import static org.junit.Assert.assertThat;
//import static org.junit.Assert.assertTrue;
//
///**
// * Created by JIN Benli on 22/12/14.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ActiveProfiles(value = "test")
//@Transactional
//@TransactionConfiguration(defaultRollback = true)
//@SpringApplicationConfiguration(classes = Application.class)
//public class CommandServiceTest {
//    private static final Logger logger = LoggerFactory.getLogger(CommandServiceTest.class);
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//    @Autowired
//    private CommandRepository commandRepository;
//    @Autowired
//    private DishRepository dishRepository;
//    @Autowired
//    private CommandService commandService;
//
//    @Test
//    public void addDishToCommandTest() {
//        Command command = new Command();
//
//        command.setTitle("Bob");
//        command.setMsg_extra("test");
//        command.setOrder_date(new Date(2014, 10 ,12));
//        command.setOrder_time(new Time(20, 20, 20));
//        command.setTable_no(1);
//        command.setClient_no(5);
//
//        Dish newDish = new Dish();
//        newDish.setName("coca");
//        newDish.setIs_typed(false);
//        newDish.setImg_path("abc");
//        newDish.setPrice(5);
//        newDish.setDescription("abc");
//        newDish.setDisabled(false);
//        newDish.setStart_time(new Time(10,10,10));
//        newDish.setEnd_time(new Time(10,11,10));
//        newDish.setStart_date(new Date(2014,10,12));
//        newDish.setEnd_date(new Date(2014,11,12));
//
//        Dish theDish = dishRepository.save(newDish);
//        Command theCommand = commandRepository.save(command);
//
//        boolean res = commandService.addDishToCommand(theDish.getId(), theCommand.getId(), 2);
//
//        String SQL = "SELECT quantity FROM jb_menu_design.md_command_dish WHERE command_id = ? AND dish_id = ?";
//        List<Integer> quantityList = jdbcTemplate.queryForList(SQL, Integer.class, theCommand.getId(), theDish.getId());
//
//        assertThat(theDish, notNullValue());
//        assertThat(theCommand, notNullValue());
//        assertTrue(res);
//        assertThat(quantityList.size(), is(0));
//        assertThat(quantityList.get(0) == 2, is(Boolean.TRUE));
//    }
//}
