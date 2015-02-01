//  User command not syn with DB
//  MDUserCommand.h
//  Diancai
//
//  Created by james on 10/12/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "JSONModel.h"

@class MDDish;
@class MDMenu;
@class MDActivicy;


@interface MDUserCommand :  JSONModel




@property(assign,nonatomic) NSUInteger id_commande;
@property(assign,nonatomic) NSUInteger table_no;
@property(strong,nonatomic) NSDate *order_time;
@property(strong,nonatomic) NSString *title;




@property(strong,nonatomic) NSString *name;
@property(assign,nonatomic) NSUInteger table;
@property(assign,nonatomic) BOOL is_typed;
@property(assign,nonatomic) NSUInteger type_id;
@property(strong,nonatomic) NSString *img_path;
@property(assign,nonatomic) BOOL disabled;
@property(assign,nonatomic) float total_price;

/**
 *  list dishs, activities, menus
 */
@property (nonatomic,strong) NSMutableArray* dish_list;
@property (nonatomic,strong) NSMutableArray* activity_list;
@property (nonatomic,strong) NSMutableArray* menu_list;

/**
 *  dictionary for dishs, activities, menus
 *  each dictionary means each dishies, activies, menus and their quantities
 *  [key : humbergers , value : 2]
 */
@property (nonatomic,strong) NSMutableDictionary* dish_dictionary;
@property (nonatomic,strong) NSMutableDictionary* activity_dictionary;
@property (nonatomic,strong) NSMutableDictionary* menu_dictionary;



-(void) addDishWithQuantity:(MDDish *)object quantity:(NSUInteger)quantity;
-(void) addMenu:(MDMenu *)object;
-(void) addActivity:(MDActivicy *)object;




+ (MDUserCommand*)shared;

-(NSData*) getJasonDate;


@end
