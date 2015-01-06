//
//  MDSecondMenu.m
//  Diancai
//
//  Created by james on 06/01/15.
//  Copyright (c) 2015 Xiaojun. All rights reserved.
//

#import "MDSecondMenu.h"

@implementation MDSecondMenu


-(id) init{
    self = [super init];
    _dish_list = [[NSMutableArray alloc] init];
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
@end
