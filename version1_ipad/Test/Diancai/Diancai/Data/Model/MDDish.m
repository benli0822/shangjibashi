//
//  MDDish.m
//  Diancai
//
//  Created by james on 06/11/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import "MDDish.h"

@implementation MDDish

@synthesize id_dish = _id_dish;
@synthesize name = _name;
@synthesize type = _type;
@synthesize is_typed = _is_typed;
@synthesize img_path = _img_path;
@synthesize description = _description;
@synthesize disabled = _disabled;
@synthesize start_time = _start_time;
@synthesize end_time = _end_time;



-(id)initWithKey:(NSUInteger)id_dish name:(NSString*)name type:(NSUInteger)type is_typed:(BOOL)is_typed img_path:(NSString*)img_path description:(NSString*)description disabled:(BOOL)disabled start_time:(NSDate*)start_time end_time:(NSDate *)end_time{
    
    
    self = [super init];
    
    if(self){
        _id_dish = id_dish;
        _name = name;
        _type = type;
        _is_typed = is_typed;
        _img_path = img_path;
        _description = description;
        _disabled = disabled;
        _start_time = start_time;
        _end_time = end_time;
    }
    
    
    
    return self;
}


@end
