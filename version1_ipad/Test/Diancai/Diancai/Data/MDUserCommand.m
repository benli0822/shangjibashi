//
//  MDUserCommand.m
//  Diancai
//
//  Created by james on 10/12/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import "MDUserCommand.h"

@implementation MDUserCommand





-(id) init{
    self = [super init];
    _dish_list = [[NSMutableArray alloc] init];
    _menu_list = [[NSMutableArray alloc] init];
    _activity_list = [[NSMutableArray alloc] init];
    
    return self;
    
}

-(void) addDish:(MDDish *)object{
    
    NSLog(@"add a dish");
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
