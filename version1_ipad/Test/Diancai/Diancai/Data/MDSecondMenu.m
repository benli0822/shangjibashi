//
//  MDSecondMenu.m
//  Diancai
//
//  Created by james on 06/01/15.
//  Copyright (c) 2015 Xiaojun. All rights reserved.
//

#import "MDSecondMenu.h"

@implementation MDSecondMenu

@synthesize description = _description;
@synthesize name = _name;
@synthesize type_id = _type_id;


-(id) init{
    self = [super init];
    _dish_list = [[NSMutableArray alloc] init];
    return self;
}
-(id)initWithKey:(NSUInteger)type_id name:(NSString*)name description:(NSString *)description{
    self = [super init];
    _dish_list = [[NSMutableArray alloc] init];
    _type_id = type_id;
    _name = name;
    _description = description;
    return self;
}


/**
 *  add a seconde menu to firstmenu
 *
 *  @param object MDsecondMenu
 */
-(void) addSecondeMenu_listObject:(MDDish *)object{
    [_dish_list addObject:object];
    
}
-(void) addObjectWithArray:(NSMutableArray*) array{
    [_dish_list addObjectsFromArray:array];
}



@end
