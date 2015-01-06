
    alter table md_activity_dish 
        drop 
        foreign key FK_fca1mxwv70d4g6mtxcc605de3;

    alter table md_activity_dish 
        drop 
        foreign key FK_qnn4ka7n67ogibdbu8e0ld26u;

    alter table md_command_activity 
        drop 
        foreign key FK_jphj63p2d1katowlu0fl0mp2w;

    alter table md_command_activity 
        drop 
        foreign key FK_dhnn5rdhperdum34pdbywtow0;

    alter table md_command_dish 
        drop 
        foreign key FK_87gfn9o28ydt4d2ehd26ly6cu;

    alter table md_command_dish 
        drop 
        foreign key FK_5he7tk4aqy2h4o4u41rydp0ri;

    alter table md_command_menu 
        drop 
        foreign key FK_a0spdn5136xb390gvhk69edlb;

    alter table md_command_menu 
        drop 
        foreign key FK_5bpastl320j2ieptm5i0gu6g6;

    alter table md_conflict_dish_type 
        drop 
        foreign key FK_hrhqbc2to0j9pd6659y7q40rs;

    alter table md_conflict_dish_type 
        drop 
        foreign key FK_7l29pyhbwdqr0s3f3c3vhs9g2;

    alter table md_dish_option 
        drop 
        foreign key FK_c1mc1njiql8y4ygb5qu40f0fu;

    alter table md_dish_option 
        drop 
        foreign key FK_qpeno45svkhoesq2nglgtv1sr;

    alter table md_dish_type 
        drop 
        foreign key FK_sf3eavoq0madm97kcee4ub805;

    alter table md_dish_type 
        drop 
        foreign key FK_5ur6442324o17l93d5ver12kv;

    alter table md_file_activity 
        drop 
        foreign key FK_sa3xf5bx6jxrefv9adqwmsf12;

    alter table md_file_activity 
        drop 
        foreign key FK_eiy0dtcto3sy9mtxcpassrwr0;

    alter table md_file_dish 
        drop 
        foreign key FK_s3kty0nwmwadoio4qnddnys4q;

    alter table md_file_dish 
        drop 
        foreign key FK_evetyu9f8fhdtc3o8xihbprud;

    alter table md_file_menu 
        drop 
        foreign key FK_nr88fx9yva9qtpk3c2xo9js5;

    alter table md_file_menu 
        drop 
        foreign key FK_1fugvnn5myjthfr9w636ixjhv;

    alter table md_menu_dish 
        drop 
        foreign key FK_9k9xnq29a10ajdd51x4gc97e4;

    alter table md_menu_dish 
        drop 
        foreign key FK_8x45y71h3232yrgs8p1jxtt9a;

    drop table if exists md_activity;

    drop table if exists md_activity_dish;

    drop table if exists md_command;

    drop table if exists md_command_activity;

    drop table if exists md_command_dish;

    drop table if exists md_command_menu;

    drop table if exists md_conflict_dish_type;

    drop table if exists md_dish;

    drop table if exists md_dish_option;

    drop table if exists md_dish_type;

    drop table if exists md_file;

    drop table if exists md_file_activity;

    drop table if exists md_file_dish;

    drop table if exists md_file_menu;

    drop table if exists md_menu;

    drop table if exists md_menu_dish;

    drop table if exists md_options;

    drop table if exists md_types;

    drop table if exists md_user;

    create table md_activity (
        id bigint not null auto_increment,
        description varchar(255),
        end_date date,
        end_time time,
        name varchar(255),
        start_date date,
        start_time time,
        primary key (id)
    );

    create table md_activity_dish (
        id bigint not null auto_increment,
        quantity integer,
        activity_id bigint,
        dish_id bigint,
        primary key (id)
    );

    create table md_command (
        id bigint not null auto_increment,
        client_no integer,
        msg_extra varchar(255),
        order_date date,
        order_time time,
        table_no integer,
        title varchar(255),
        primary key (id)
    );

    create table md_command_activity (
        id bigint not null auto_increment,
        quantity integer,
        activity_id bigint,
        command_id bigint,
        primary key (id)
    );

    create table md_command_dish (
        id bigint not null auto_increment,
        quantity integer,
        command_id bigint,
        dish_id bigint,
        primary key (id)
    );

    create table md_command_menu (
        id bigint not null auto_increment,
        quantity integer,
        command_id bigint,
        menu_id bigint,
        primary key (id)
    );

    create table md_conflict_dish_type (
        type_id bigint not null,
        conflict_id bigint not null,
        primary key (type_id, conflict_id)
    );

    create table md_dish (
        id bigint not null auto_increment,
        description varchar(255),
        disabled bit,
        end_date date,
        end_time time,
        is_typed bit,
        name varchar(255),
        price float,
        start_date date,
        start_time time,
        primary key (id)
    );

    create table md_dish_option (
        option_id bigint not null,
        dish_id bigint not null,
        primary key (dish_id, option_id)
    );

    create table md_dish_type (
        type_id bigint not null,
        dish_id bigint not null,
        primary key (dish_id, type_id)
    );

    create table md_file (
        id bigint not null auto_increment,
        location varchar(255),
        name varchar(255),
        size bigint,
        type varchar(255),
        primary key (id)
    );

    create table md_file_activity (
        file_id bigint not null,
        activity_id bigint not null,
        primary key (activity_id, file_id)
    );

    create table md_file_dish (
        file_id bigint not null,
        dish_id bigint not null,
        primary key (dish_id, file_id)
    );

    create table md_file_menu (
        menu_id bigint not null,
        file_id bigint not null,
        primary key (file_id, menu_id)
    );

    create table md_menu (
        id bigint not null auto_increment,
        description varchar(255),
        end_date date,
        end_time time,
        name varchar(255),
        start_date date,
        start_time time,
        primary key (id)
    );

    create table md_menu_dish (
        id bigint not null auto_increment,
        quantity integer,
        dish_id bigint,
        menu_id bigint,
        primary key (id)
    );

    create table md_options (
        id bigint not null auto_increment,
        name varchar(255),
        primary key (id)
    );

    create table md_types (
        id bigint not null auto_increment,
        description varchar(255),
        firstmenu_id bigint,
        is_firstmenu bit,
        is_for_customize bit,
        is_secondmenu bit,
        name varchar(255),
        primary key (id)
    );

    create table md_user (
        id bigint not null auto_increment,
        passwd varchar(255),
        type varchar(255),
        name varchar(255),
        primary key (id)
    );

    alter table md_activity_dish 
        add constraint FK_fca1mxwv70d4g6mtxcc605de3 
        foreign key (activity_id) 
        references md_activity (id);

    alter table md_activity_dish 
        add constraint FK_qnn4ka7n67ogibdbu8e0ld26u 
        foreign key (dish_id) 
        references md_dish (id);

    alter table md_command_activity 
        add constraint FK_jphj63p2d1katowlu0fl0mp2w 
        foreign key (activity_id) 
        references md_activity (id);

    alter table md_command_activity 
        add constraint FK_dhnn5rdhperdum34pdbywtow0 
        foreign key (command_id) 
        references md_command (id);

    alter table md_command_dish 
        add constraint FK_87gfn9o28ydt4d2ehd26ly6cu 
        foreign key (command_id) 
        references md_command (id);

    alter table md_command_dish 
        add constraint FK_5he7tk4aqy2h4o4u41rydp0ri 
        foreign key (dish_id) 
        references md_dish (id);

    alter table md_command_menu 
        add constraint FK_a0spdn5136xb390gvhk69edlb 
        foreign key (command_id) 
        references md_command (id);

    alter table md_command_menu 
        add constraint FK_5bpastl320j2ieptm5i0gu6g6 
        foreign key (menu_id) 
        references md_menu (id);

    alter table md_conflict_dish_type 
        add constraint FK_hrhqbc2to0j9pd6659y7q40rs 
        foreign key (conflict_id) 
        references md_types (id);

    alter table md_conflict_dish_type 
        add constraint FK_7l29pyhbwdqr0s3f3c3vhs9g2 
        foreign key (type_id) 
        references md_types (id);

    alter table md_dish_option 
        add constraint FK_c1mc1njiql8y4ygb5qu40f0fu 
        foreign key (dish_id) 
        references md_dish (id);

    alter table md_dish_option 
        add constraint FK_qpeno45svkhoesq2nglgtv1sr 
        foreign key (option_id) 
        references md_options (id);

    alter table md_dish_type 
        add constraint FK_sf3eavoq0madm97kcee4ub805 
        foreign key (dish_id) 
        references md_dish (id);

    alter table md_dish_type 
        add constraint FK_5ur6442324o17l93d5ver12kv 
        foreign key (type_id) 
        references md_types (id);

    alter table md_file_activity 
        add constraint FK_sa3xf5bx6jxrefv9adqwmsf12 
        foreign key (activity_id) 
        references md_activity (id);

    alter table md_file_activity 
        add constraint FK_eiy0dtcto3sy9mtxcpassrwr0 
        foreign key (file_id) 
        references md_file (id);

    alter table md_file_dish 
        add constraint FK_s3kty0nwmwadoio4qnddnys4q 
        foreign key (dish_id) 
        references md_dish (id);

    alter table md_file_dish 
        add constraint FK_evetyu9f8fhdtc3o8xihbprud 
        foreign key (file_id) 
        references md_file (id);

    alter table md_file_menu 
        add constraint FK_nr88fx9yva9qtpk3c2xo9js5 
        foreign key (file_id) 
        references md_file (id);

    alter table md_file_menu 
        add constraint FK_1fugvnn5myjthfr9w636ixjhv 
        foreign key (menu_id) 
        references md_menu (id);

    alter table md_menu_dish 
        add constraint FK_9k9xnq29a10ajdd51x4gc97e4 
        foreign key (dish_id) 
        references md_dish (id);

    alter table md_menu_dish 
        add constraint FK_8x45y71h3232yrgs8p1jxtt9a 
        foreign key (menu_id) 
        references md_menu (id);
