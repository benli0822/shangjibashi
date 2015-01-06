//
//  MDFirstMenu.m
//  Diancai
//
//  Created by james on 06/01/15.
//  Copyright (c) 2015 Xiaojun. All rights reserved.
//

#import "MDFirstMenu.h"

@implementation MDFirstMenu

@synthesize description = _description;
@synthesize secondeMenu_list = _secondeMenu_list;
@synthesize name = _name;
@synthesize type_id = _type_id;


-(id) init{
    self = [super init];
       _secondeMenu_list = [[NSMutableArray alloc] init];
    return self;
}

-(id)initWithKey:(NSUInteger)type_id name:(NSString*)name description:(NSString *)description{
    self = [super init];
    _secondeMenu_list = [[NSMutableArray alloc] init];
    _type_id = type_id;
    _name = name;
    _description = description;
    return self;
}



-(void) addSecondeMenu_listObject:(MDSecondMenu *)object{
    [_secondeMenu_list addObject:object];
}


@end
