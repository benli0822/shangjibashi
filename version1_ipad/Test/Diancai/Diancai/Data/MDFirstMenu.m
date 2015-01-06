//
//  MDFirstMenu.m
//  Diancai
//
//  Created by james on 06/01/15.
//  Copyright (c) 2015 Xiaojun. All rights reserved.
//

#import "MDFirstMenu.h"

@implementation MDFirstMenu



-(id) init{
    self = [super init];
       _secondeMenu_list = [[NSMutableArray alloc] init];
    return self;
}

-(void) addSecondeMenu_listObject:(MDSecondMenu *)object{
    [_secondeMenu_list addObject:object];
}



@end
