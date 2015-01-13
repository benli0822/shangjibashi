DROP TABLE IF EXISTS "md_activity";
CREATE TABLE "md_activity" (
  "id" bigint(10) NOT NULL ,
  "name" varchar(45) DEFAULT NULL,
  "description" varchar(300) DEFAULT NULL,
  "start_time" time DEFAULT NULL,
  "end_time" time DEFAULT NULL,
  "start_date" date DEFAULT NULL,
  "end_date" date DEFAULT NULL,
  PRIMARY KEY ("id")
);
DROP TABLE IF EXISTS "md_activity_dish";
CREATE TABLE "md_activity_dish" (
  "id" bigint(10) NOT NULL ,
  "dish_id" bigint(10) NOT NULL,
  "activity_id" bigint(10) NOT NULL,
  "quantity" int(11) DEFAULT NULL,
  PRIMARY KEY ("id")
  CONSTRAINT "ad_activity_key" FOREIGN KEY ("activity_id") REFERENCES "md_activity" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "ad_dish_key" FOREIGN KEY ("dish_id") REFERENCES "md_dish" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
);
DROP TABLE IF EXISTS "md_command";
CREATE TABLE "md_command" (
  "id" bigint(10) NOT NULL ,
  "title" varchar(45) DEFAULT NULL,
  "msg_extra" varchar(150) DEFAULT NULL,
  "order_date" date DEFAULT NULL,
  "order_time" time DEFAULT NULL,
  "table_no" int(11) DEFAULT NULL,
  "client_no" int(11) DEFAULT NULL,
  PRIMARY KEY ("id")
);
DROP TABLE IF EXISTS "md_command_activity";
CREATE TABLE "md_command_activity" (
  "id" bigint(10) NOT NULL ,
  "command_id" bigint(10) NOT NULL,
  "activity_id" bigint(10) NOT NULL,
  "quantity" int(11) DEFAULT NULL,
  PRIMARY KEY ("id")
  CONSTRAINT "ca_command_key" FOREIGN KEY ("command_id") REFERENCES "md_command" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "ca_activity_key" FOREIGN KEY ("activity_id") REFERENCES "md_activity" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
);
DROP TABLE IF EXISTS "md_command_dish";
CREATE TABLE "md_command_dish" (
  "id" bigint(10) NOT NULL ,
  "command_id" bigint(10) NOT NULL,
  "dish_id" bigint(10) NOT NULL,
  "quantity" int(11) DEFAULT NULL,
  PRIMARY KEY ("id")
  CONSTRAINT "cd_command_key" FOREIGN KEY ("command_id") REFERENCES "md_command" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "cd_dish_key" FOREIGN KEY ("dish_id") REFERENCES "md_dish" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
);
DROP TABLE IF EXISTS "md_command_menu";
CREATE TABLE "md_command_menu" (
  "id" bigint(10) NOT NULL ,
  "command_id" bigint(10) NOT NULL,
  "menu_id" bigint(10) NOT NULL,
  "quantity" int(11) DEFAULT NULL,
  PRIMARY KEY ("id")
  CONSTRAINT "cm_command_key" FOREIGN KEY ("command_id") REFERENCES "md_command" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "cm_menu_key" FOREIGN KEY ("menu_id") REFERENCES "md_menu" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
);
DROP TABLE IF EXISTS "md_conflict_dish_type";
CREATE TABLE "md_conflict_dish_type" (
  "id" bigint(10) NOT NULL ,
  "type_id" bigint(10) NOT NULL,
  "conflict_id" bigint(10) NOT NULL,
  PRIMARY KEY ("id")
  CONSTRAINT "cdt_type_key" FOREIGN KEY ("type_id") REFERENCES "md_types" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "cdt_conflict_type_key" FOREIGN KEY ("conflict_id") REFERENCES "md_types" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
);
DROP TABLE IF EXISTS "md_dish";
CREATE TABLE "md_dish" (
  "id" bigint(10) NOT NULL ,
  "name" varchar(45) NOT NULL,
  "is_typed" tinyint(1) NOT NULL DEFAULT '0',
  "price" float DEFAULT NULL,
  "description" varchar(300) NOT NULL,
  "disabled" tinyint(1) NOT NULL DEFAULT '0',
  "start_date" date DEFAULT NULL,
  "end_date" date DEFAULT NULL,
  "start_time" time DEFAULT NULL,
  "end_time" time DEFAULT NULL,
  PRIMARY KEY ("id")
);
INSERT INTO "md_dish" VALUES(1,'thai_shrimp_cake',0,12,'thai_shrimp_cake',0,NULL,NULL,NULL,NULL);
INSERT INTO "md_dish" VALUES(2,'angry_birds_cake',0,30,'angry_birds_cake',0,NULL,NULL,NULL,NULL);
INSERT INTO "md_dish" VALUES(3,'starbucks_coffee',0,21,'starbucks_coffee',0,NULL,NULL,NULL,NULL);
INSERT INTO "md_dish" VALUES(4,'ham_and_cheese_panini',0,20,'ham_and_cheese_panini',0,NULL,NULL,NULL,NULL);
INSERT INTO "md_dish" VALUES(5,'japanese_noodle_with_pork',0,20,'japanese_noodle_with_pork',0,NULL,NULL,NULL,NULL);
INSERT INTO "md_dish" VALUES(6,'creme_brelee',0,12,'creme_brelee',0,NULL,NULL,NULL,NULL);
INSERT INTO "md_dish" VALUES(7,'ham_and_egg_sandwich',0,28,'ham_and_egg_sandwich',0,NULL,NULL,NULL,NULL);
INSERT INTO "md_dish" VALUES(8,'full_breakfast',0,40,'full_breakfast',0,NULL,NULL,NULL,NULL);
INSERT INTO "md_dish" VALUES(9,'green_tea',0,8,'green_tea',0,NULL,NULL,NULL,NULL);
INSERT INTO "md_dish" VALUES(10,'hamburger',0,8,'hamburger',0,NULL,NULL,NULL,NULL);
INSERT INTO "md_dish" VALUES(11,'instant_noodle_with_egg',0,11,'instant_noodle_with_egg',0,NULL,NULL,NULL,NULL);
INSERT INTO "md_dish" VALUES(12,'mushroom_risotto',0,15,'mushroom_risotto',0,NULL,NULL,NULL,NULL);
INSERT INTO "md_dish" VALUES(13,'noodle_with_bbq_pork',0,8,'noodle_with_bbq_pork',0,NULL,NULL,NULL,NULL);
INSERT INTO "md_dish" VALUES(14,'vegetable_curry',0,10,'vegetable_curry',0,NULL,NULL,NULL,NULL);
INSERT INTO "md_dish" VALUES(15,'white_chocolate_donut',0,7,'white_chocolate_donut',0,NULL,NULL,NULL,NULL);
DROP TABLE IF EXISTS "md_dish_option";
CREATE TABLE "md_dish_option" (
  "id" bigint(10) NOT NULL ,
  "dish_id" bigint(10) NOT NULL,
  "option_id" bigint(10) NOT NULL,
  PRIMARY KEY ("id")
  CONSTRAINT "do_option_key" FOREIGN KEY ("option_id") REFERENCES "md_options" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "do_dish_key" FOREIGN KEY ("dish_id") REFERENCES "md_dish" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
);
DROP TABLE IF EXISTS "md_dish_type";
CREATE TABLE "md_dish_type" (
  "id" bigint(10) NOT NULL ,
  "dish_id" bigint(10) NOT NULL,
  "type_id" bigint(10) NOT NULL,
  PRIMARY KEY ("id")
  CONSTRAINT "dt_dish_key" FOREIGN KEY ("dish_id") REFERENCES "md_dish" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "dt_type_key" FOREIGN KEY ("type_id") REFERENCES "md_types" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
);
INSERT INTO "md_dish_type" VALUES(1,1,3);
INSERT INTO "md_dish_type" VALUES(2,2,3);
INSERT INTO "md_dish_type" VALUES(3,3,9);
INSERT INTO "md_dish_type" VALUES(4,4,8);
INSERT INTO "md_dish_type" VALUES(5,4,3);
INSERT INTO "md_dish_type" VALUES(6,5,3);
INSERT INTO "md_dish_type" VALUES(7,5,7);
INSERT INTO "md_dish_type" VALUES(8,1,10);
INSERT INTO "md_dish_type" VALUES(9,2,10);
INSERT INTO "md_dish_type" VALUES(10,3,10);
INSERT INTO "md_dish_type" VALUES(11,4,10);
INSERT INTO "md_dish_type" VALUES(12,5,10);
INSERT INTO "md_dish_type" VALUES(13,6,10);
INSERT INTO "md_dish_type" VALUES(14,7,10);
INSERT INTO "md_dish_type" VALUES(15,8,10);
INSERT INTO "md_dish_type" VALUES(16,9,10);
INSERT INTO "md_dish_type" VALUES(17,10,10);
INSERT INTO "md_dish_type" VALUES(18,11,10);
INSERT INTO "md_dish_type" VALUES(19,12,10);
INSERT INTO "md_dish_type" VALUES(20,13,10);
INSERT INTO "md_dish_type" VALUES(21,14,10);
INSERT INTO "md_dish_type" VALUES(22,15,10);
INSERT INTO "md_dish_type" VALUES(23,5,5);
INSERT INTO "md_dish_type" VALUES(24,11,5);
INSERT INTO "md_dish_type" VALUES(25,13,5);
INSERT INTO "md_dish_type" VALUES(26,10,3);
INSERT INTO "md_dish_type" VALUES(27,7,3);
INSERT INTO "md_dish_type" VALUES(28,4,3);
INSERT INTO "md_dish_type" VALUES(29,10,6);
INSERT INTO "md_dish_type" VALUES(30,7,6);
INSERT INTO "md_dish_type" VALUES(31,4,6);
DROP TABLE IF EXISTS "md_file";
CREATE TABLE "md_file" (
  "id" bigint(10) NOT NULL ,
  "name" varchar(45) DEFAULT NULL,
  "location" varchar(45) DEFAULT NULL,
  "size" bigint(10) DEFAULT NULL,
  "type" varchar(45) DEFAULT NULL,
  PRIMARY KEY ("id")
);
DROP TABLE IF EXISTS "md_file_activity";
CREATE TABLE "md_file_activity" (
  "id" bigint(10) NOT NULL ,
  "file_id" bigint(10) NOT NULL,
  "activity_id" bigint(10) NOT NULL,
  PRIMARY KEY ("id")
  CONSTRAINT "fa_file_key" FOREIGN KEY ("file_id") REFERENCES "md_file" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "fa_activity_key" FOREIGN KEY ("activity_id") REFERENCES "md_activity" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
);
DROP TABLE IF EXISTS "md_file_dish";
CREATE TABLE "md_file_dish" (
  "id" bigint(10) NOT NULL ,
  "file_id" bigint(10) NOT NULL,
  "dish_id" bigint(10) NOT NULL,
  PRIMARY KEY ("id")
  CONSTRAINT "fd_file_key" FOREIGN KEY ("file_id") REFERENCES "md_file" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "fd_dish_key" FOREIGN KEY ("dish_id") REFERENCES "md_dish" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
);
DROP TABLE IF EXISTS "md_file_menu";
CREATE TABLE "md_file_menu" (
  "id" bigint(10) NOT NULL ,
  "file_id" bigint(10) NOT NULL,
  "menu_id" bigint(10) NOT NULL,
  PRIMARY KEY ("id")
  CONSTRAINT "fm_file_key" FOREIGN KEY ("file_id") REFERENCES "md_file" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "fm_menu_key" FOREIGN KEY ("menu_id") REFERENCES "md_menu" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
);
DROP TABLE IF EXISTS "md_menu";
CREATE TABLE "md_menu" (
  "id" bigint(10) NOT NULL ,
  "name" varchar(45) DEFAULT NULL,
  "description" varchar(300) DEFAULT NULL,
  "start_time" time DEFAULT NULL,
  "end_time" time DEFAULT NULL,
  "start_date" date DEFAULT NULL,
  "end_date" date DEFAULT NULL,
  PRIMARY KEY ("id")
);
DROP TABLE IF EXISTS "md_menu_dish";
CREATE TABLE "md_menu_dish" (
  "id" bigint(10) NOT NULL ,
  "dish_id" bigint(10) NOT NULL,
  "menu_id" bigint(10) NOT NULL,
  "quantity" int(11) DEFAULT NULL,
  PRIMARY KEY ("id")
  CONSTRAINT "md_dish_key" FOREIGN KEY ("dish_id") REFERENCES "md_dish" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "md_menu_key" FOREIGN KEY ("menu_id") REFERENCES "md_menu" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
);
DROP TABLE IF EXISTS "md_options";
CREATE TABLE "md_options" (
  "id" bigint(10) NOT NULL ,
  "name" varchar(45) DEFAULT NULL,
  PRIMARY KEY ("id")
);
DROP TABLE IF EXISTS "md_types";
CREATE TABLE "md_types" (
  "id" bigint(10) NOT NULL ,
  "is_firstmenu" tinyint(1) DEFAULT NULL,
  "is_secondmenu" tinyint(1) DEFAULT NULL,
  "firstmenu_id" bigint(10) NOT NULL,
  "name" varchar(45) DEFAULT NULL,
  "description" varchar(45) DEFAULT NULL,
  "is_for_customize" tinyint(1) DEFAULT NULL,
  PRIMARY KEY ("id")
);
INSERT INTO "md_types" VALUES(1,1,0,'','choix de chef',NULL,0);
INSERT INTO "md_types" VALUES(2,1,0,'','Entree',NULL,0);
INSERT INTO "md_types" VALUES(3,1,0,'','Plat',NULL,0);
INSERT INTO "md_types" VALUES(4,1,0,'','Dessert',NULL,0);
INSERT INTO "md_types" VALUES(5,1,0,'','nouilles',NULL,0);
INSERT INTO "md_types" VALUES(6,0,1,3,'Hamburgers',NULL,NULL);
INSERT INTO "md_types" VALUES(7,0,1,3,'Poissons',NULL,NULL);
INSERT INTO "md_types" VALUES(8,0,1,3,'viande',NULL,NULL);
INSERT INTO "md_types" VALUES(9,1,0,'','drink','
',NULL);
INSERT INTO "md_types" VALUES(10,1,0,'','all_data',NULL,NULL);
DROP TABLE IF EXISTS "md_user";
CREATE TABLE "md_user" (
  "id" bigint(10) NOT NULL ,
  "name" varchar(45) DEFAULT NULL,
  "passwd" varchar(45) DEFAULT NULL,
  "type" varchar(45) DEFAULT '0',
  PRIMARY KEY ("id")
);
CREATE INDEX "md_activity_dish_ad_activity_key_idx" ON "md_activity_dish" ("activity_id");
CREATE INDEX "md_activity_dish_ad_dish_key_idx" ON "md_activity_dish" ("dish_id");
CREATE INDEX "md_activity_dish_id_UNIQUE" ON "md_activity_dish" ("id");
CREATE INDEX "md_activity_id_UNIQUE" ON "md_activity" ("id");
CREATE INDEX "md_command_activity_ca_activity_key_idx" ON "md_command_activity" ("activity_id");
CREATE INDEX "md_command_activity_ca_command_key_idx" ON "md_command_activity" ("command_id");
CREATE INDEX "md_command_activity_id_UNIQUE" ON "md_command_activity" ("id");
CREATE INDEX "md_command_dish_cd_command_key_idx" ON "md_command_dish" ("command_id");
CREATE INDEX "md_command_dish_cd_dish_key_idx" ON "md_command_dish" ("dish_id");
CREATE INDEX "md_command_dish_id_UNIQUE" ON "md_command_dish" ("id");
CREATE INDEX "md_command_id_UNIQUE" ON "md_command" ("id");
CREATE INDEX "md_command_menu_cm_command_key_idx" ON "md_command_menu" ("command_id");
CREATE INDEX "md_command_menu_cm_menu_key_idx" ON "md_command_menu" ("menu_id");
CREATE INDEX "md_command_menu_id_UNIQUE" ON "md_command_menu" ("id");
CREATE INDEX "md_conflict_dish_type_cdt_conflict_type_key_idx" ON "md_conflict_dish_type" ("conflict_id");
CREATE INDEX "md_conflict_dish_type_cdt_type_key_idx" ON "md_conflict_dish_type" ("type_id");
CREATE INDEX "md_conflict_dish_type_id_UNIQUE" ON "md_conflict_dish_type" ("id");
CREATE INDEX "md_dish_id_UNIQUE" ON "md_dish" ("id");
CREATE INDEX "md_dish_option_do_dish_key_idx" ON "md_dish_option" ("dish_id");
CREATE INDEX "md_dish_option_do_option_key_idx" ON "md_dish_option" ("option_id");
CREATE INDEX "md_dish_option_id_UNIQUE" ON "md_dish_option" ("id");
CREATE INDEX "md_dish_type_dt_dish_key_idx" ON "md_dish_type" ("dish_id");
CREATE INDEX "md_dish_type_dt_type_key_idx" ON "md_dish_type" ("type_id");
CREATE INDEX "md_dish_type_id_UNIQUE" ON "md_dish_type" ("id");
CREATE INDEX "md_file_activity_fa_activity_key_idx" ON "md_file_activity" ("activity_id");
CREATE INDEX "md_file_activity_fa_file_key_idx" ON "md_file_activity" ("file_id");
CREATE INDEX "md_file_activity_id_UNIQUE" ON "md_file_activity" ("id");
CREATE INDEX "md_file_dish_fd_dish_key_idx" ON "md_file_dish" ("dish_id");
CREATE INDEX "md_file_dish_fd_file_key_idx" ON "md_file_dish" ("file_id");
CREATE INDEX "md_file_dish_id_UNIQUE" ON "md_file_dish" ("id");
CREATE INDEX "md_file_id_UNIQUE" ON "md_file" ("id");
CREATE INDEX "md_file_menu_fm_file_key_idx" ON "md_file_menu" ("file_id");
CREATE INDEX "md_file_menu_fm_menu_key_idx" ON "md_file_menu" ("menu_id");
CREATE INDEX "md_file_menu_id_UNIQUE" ON "md_file_menu" ("id");
CREATE INDEX "md_menu_dish_id_UNIQUE" ON "md_menu_dish" ("id");
CREATE INDEX "md_menu_dish_md_dish_key_idx" ON "md_menu_dish" ("dish_id");
CREATE INDEX "md_menu_dish_md_menu_key_idx" ON "md_menu_dish" ("menu_id");
CREATE INDEX "md_menu_id_UNIQUE" ON "md_menu" ("id");
CREATE INDEX "md_options_id_UNIQUE" ON "md_options" ("id");
CREATE INDEX "md_types_id_UNIQUE" ON "md_types" ("id");
CREATE INDEX "md_user_id_UNIQUE" ON "md_user" ("id");
