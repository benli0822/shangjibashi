#!/bin/sh
sh mysql2sqlite.sh -u root -proot jb_menu_design | sqlite3 database.sqlite