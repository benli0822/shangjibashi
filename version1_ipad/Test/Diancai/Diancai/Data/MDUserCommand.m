//
//  MDUserCommand.m
//  Diancai
//
//  Created by james on 10/12/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import "MDUserCommand.h"
#import "MDDish.h"

#define id_to_string [NSString stringWithFormat:@"%lu", (unsigned long)object.id_dish]
@implementation MDUserCommand





-(id) init{
    self = [super init];
    _dish_list = [[NSMutableArray alloc] init];
    _menu_list = [[NSMutableArray alloc] init];
    _activity_list = [[NSMutableArray alloc] init];
    
    _dishes = [[NSMutableDictionary alloc] init];
    _menu_dictionary = [[NSMutableDictionary alloc] init];
    _activity_dictionary = [[NSMutableDictionary alloc] init];
    
    return self;
    
}

-(void) addDishWithQuantity:(MDDish *)object quantity:(NSUInteger)quantity{
    
    
    //treat quantities
    //if this is the first time we add a dish, then we will create a dictionary else we will update the quantities of this dish
    
    if(![_dishes objectForKey:[NSString stringWithFormat:@"%lu", (unsigned long)object.id_dish]]){
        
        [_dishes setObject:[NSNumber numberWithInteger:quantity] forKey:[NSString stringWithFormat:@"%lu", (unsigned long)object.id_dish]];
        if(!_dish_list){
            _dish_list = [[NSMutableArray alloc] init];
        }
        [_dish_list addObject:object];
        
       
        
    }
    else{
        //update the quantities
        NSNumber *num = [_dishes objectForKey:[NSString stringWithFormat:@"%lu", (unsigned long)object.id_dish]];
        NSNumber *newNum = [NSNumber numberWithInteger:[num integerValue] + quantity ];
        [_dishes setObject:newNum forKey:object.name];
        
    }
    
    //calcule price
    _total_price = _total_price + object.price * quantity;
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


//Json ignore option
+(BOOL)propertyIsIgnored:(NSString *)propertyName{
    if ([propertyName isEqualToString:@"dishes"]) {
        return NO;
    }
    if ([propertyName isEqualToString:@"table"]) {
        return NO;
    }
    if ([propertyName isEqualToString:@"total_price"]) {
        return NO;
    }
    
    return YES;
}

-(NSData*) getJasonDate{
    
    
//    
//    NSError *error;
//    NSData *jsonData = [NSJSONSerialization dataWithJSONObject:dictionaryOrArrayToOutput
//                                                       options:NSJSONWritingPrettyPrinted // Pass 0 if you don't care about the readability of the generated string
//                                                         error:&error];
//    
//    if (! jsonData) {
//        NSLog(@"Got an error: %@", error);
//    } else {
//        NSString *jsonString = [[NSString alloc] initWithData:jsonData encoding:NSUTF8StringEncoding];
//    }
    return  nil;
}



@end
