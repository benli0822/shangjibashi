//
//  MDDish.h
//  Diancai
//
//  Created by james on 06/11/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "JSONModel.h"

@interface MDDish : JSONModel

@property(assign,nonatomic) NSUInteger id_dish;
@property(strong,nonatomic) NSString* name;
@property(assign,nonatomic) NSUInteger price;
@property(assign,nonatomic) BOOL is_typed;
@property(assign,nonatomic) NSUInteger type_id;
@property(strong,nonatomic) NSString *description;
@property(assign,nonatomic) BOOL disabled;
@property(strong,nonatomic) NSDate *start_date;
@property(strong,nonatomic) NSDate *end_date;
@property(strong,nonatomic) NSDate *start_time;
@property(strong,nonatomic) NSDate *end_time;



@property(strong,nonatomic) NSMutableArray *dishActivities;

//第一个init方法, 以后可以继续加init方法
-(id) init;

-(id)initWithKey:(NSUInteger)id_dish name:(NSString*)name  is_typed:(BOOL)is_typed  description:(NSString*)description disabled:(BOOL)disabled start_date:(NSDate*)start_date end_date:(NSDate*)end_date start_time:(NSDate*)start_time end_time:(NSDate *)end_time price:(NSUInteger)price;


-(void) setName:(NSString*)name;
-(void) setPrice:(NSUInteger)price;

@end
