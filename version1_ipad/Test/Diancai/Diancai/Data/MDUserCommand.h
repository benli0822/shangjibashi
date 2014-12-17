//  User command not syn with DB
//  MDUserCommand.h
//  Diancai
//
//  Created by james on 10/12/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import <Foundation/Foundation.h>

@class MDDish;
@class MDMenu;
@class MDActivicy;

@interface MDUserCommand : NSObject




@property(readonly,nonatomic) NSUInteger id_commande;
@property(readonly,nonatomic) NSUInteger table_no;
@property(readonly,nonatomic) NSDate *order_time;
@property(readonly,nonatomic) NSString *title;




@property(readonly,nonatomic) NSString *name;
@property(readonly,nonatomic) NSUInteger table;
@property(readonly,nonatomic) BOOL is_typed;
@property(readonly,nonatomic) NSUInteger type_id;
@property(readonly,nonatomic) NSString *img_path;
@property(readonly,nonatomic) NSString *description;
@property(readonly,nonatomic) BOOL disabled;


/**
 *  list dishs, activities, menus
 */
@property (nonatomic,strong) NSMutableArray *dish_list;
@property (nonatomic,strong) NSMutableArray *activity_list;
@property (nonatomic,strong) NSMutableArray *menu_list;

/**
 *  dictionary for dishs, activities, menus
 *  each dictionary means each dishies, activies, menus and their quantities
 *  [key : humbergers , value : 2]
 */
@property (nonatomic,strong) NSMutableDictionary *dish_dictionary;
@property (nonatomic,strong) NSMutableDictionary *activity_dictionary;
@property (nonatomic,strong) NSMutableDictionary *menu_dictionary;



-(void) addDish:(MDDish *)object;
-(void) addMenu:(MDMenu *)object;
-(void) addActivity:(MDActivicy *)object;




+ (MDUserCommand*)shared;




@end
