//
//  MDMenuHelper.m
//  Diancai
//
//  Created by james on 13/01/15.
//  Copyright (c) 2015 Xiaojun. All rights reserved.
//

#import "MDMenuHelper.h"
#import "MDFirstMenu.h"

@implementation MDMenuHelper


-(void) setFirstMenu_list:(NSMutableArray *)firstMenu_list{
    _firstMenu_list = firstMenu_list;
}


+(MDMenuHelper *)shared
{
    static dispatch_once_t pred = 0;
    __strong static id _sharedObject = nil;
    dispatch_once(&pred , ^{
        _sharedObject = [[self alloc]init];
    });
    
    return _sharedObject;
}



-(NSMutableArray *) getAllFirstMenuNames{
    
    NSMutableArray *nameList = [[NSMutableArray alloc] init];
    
    for (MDFirstMenu* firstMenu in _firstMenu_list) {
        [nameList addObject:firstMenu.name];
    }
    
    
    return nameList;
}


-(NSMutableArray *) getSecondeMenuNamesWithFirstMenu:(MDFirstMenu*) firstMenu{
    NSMutableArray *nameList = [[NSMutableArray alloc] init];
    
    
    
    
    return nameList;
    
}



@end
