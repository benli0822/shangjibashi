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
@synthesize is_typed = _is_typed;
@synthesize description = _description;
@synthesize disabled = _disabled;
@synthesize start_time = _start_time;
@synthesize end_time = _end_time;


-(id) init{
    self = [super init];
    
    return self;
}


-(id)initWithKey:(NSUInteger)id_dish name:(NSString*)name  is_typed:(BOOL)is_typed  description:(NSString*)description disabled:(BOOL)disabled start_date:(NSDate*)start_date end_date:(NSDate*)end_date start_time:(NSDate*)start_time end_time:(NSDate *)end_time price:(NSUInteger)price{
    
    
    self = [super init];
    
    if(self){
        _id_dish = id_dish;
        _name = name;
        _is_typed = is_typed;
        _description = description;
        _disabled = disabled;
        _start_date = start_date;
        _end_date = end_date;
        _start_time = start_time;
        _end_time = end_time;
        _price = price;
    }
    
    
    
    return self;
}

-(void) setName:(NSString*)name{
    _name = name;
}

-(void) setPrice:(NSUInteger)price{
    _price = price;
}

+(BOOL)propertyIsIgnored:(NSString *)propertyName{
    if ([propertyName isEqualToString:@"id_dish"]) {
        return NO;
    }
    return YES;
}
@end
