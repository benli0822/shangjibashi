//
//  MDUserCommand.m
//  Diancai
//
//  Created by james on 10/12/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import "MDUserCommand.h"
#import "MDDish.h"

@implementation MDUserCommand





-(id) init{
    self = [super init];
    _dish_list = [[NSMutableArray alloc] init];
    _menu_list = [[NSMutableArray alloc] init];
    _activity_list = [[NSMutableArray alloc] init];
    
    _dish_dictionary = [[NSMutableDictionary alloc] init];
    _menu_dictionary = [[NSMutableDictionary alloc] init];
    _activity_dictionary = [[NSMutableDictionary alloc] init];
    
    return self;
    
}

-(void) addDish:(MDDish *)object{
    
    
    //treat quantities
    //if this is the first time we add a dish, then we will create a dictionary else we will update the quantities of this dish
    
    if(![_dish_dictionary objectForKey:object.name]){
        [_dish_dictionary setObject:[NSNumber numberWithInt:1] forKey:object.name];
        if(!_dish_list){
            _dish_list = [[NSMutableArray alloc] init];
        }
        [_dish_list addObject:object];

    }
    else{
        //update the quantities
        NSNumber *num = [_dish_dictionary objectForKey:object.name];
        NSNumber *newNum = [NSNumber numberWithInt:[num intValue] + 1];
        [_dish_dictionary setObject:newNum forKey:object.name];
        
    }
    
    
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


-(void) setTable:(NSUInteger)table{
    _table = table;
}

#pragma mark - singleton

+(MDUserCommand *)shared
{
    static dispatch_once_t pred = 0;
    __strong static id _sharedObject = nil;
    dispatch_once(&pred , ^{
        _sharedObject = [[self alloc]init];
    });
    
    return _sharedObject;
}


@end
