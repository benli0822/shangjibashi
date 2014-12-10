//
//  MDCommand.m
//  Diancai
//
//  Created by james on 06/11/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import "MDCommand.h"

@implementation MDCommand


-(id) init{
    self = [super init];
    _dish_list = [[NSMutableArray alloc] init];
    _menu_list = [[NSMutableArray alloc] init];
    _activity_list = [[NSMutableArray alloc] init];
    
    return self;
    
}

-(void) addDish:(MDDish *)object{
    if(!_dish_list){
        _dish_list = [[NSMutableArray alloc] init];
    }
    [_dish_list addObject:object];
}
-(void) addMenu:(MDMenu *)object{
    if ((!_menu_list)) {
        _menu_list = [[NSMutableArray alloc] init];
    }
    [_menu_list addObject:object];
    
}
-(void) addActivity:(MDActivicy *)object{
    
    if(!_activity_list){
        _activity_list = [[NSMutableArray alloc] init];
    }
    [_activity_list addObject:object];
    
    
}



@end
