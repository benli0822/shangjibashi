//
//  MDDish.h
//  Diancai
//
//  Created by james on 06/11/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface MDDish : NSObject

@property(readonly,nonatomic) NSUInteger id_dish;
@property(readonly,nonatomic) NSString *name;
@property(readonly,nonatomic) NSUInteger type;
@property(readonly,nonatomic) BOOL is_typed;
@property(readonly,nonatomic) NSUInteger type_id;
@property(readonly,nonatomic) NSString *img_path;
@property(readonly,nonatomic) NSString *description;
@property(readonly,nonatomic) BOOL disabled;
@property(readonly,nonatomic) NSDate *start_time;
@property(readonly,nonatomic) NSDate *end_time;



@property(readonly,nonatomic) NSMutableArray *dishActivities;

//第一个init方法, 以后可以继续加init方法
-(id) init;

-(id)initWithKey:(NSUInteger)id_dish name:(NSString*)name type:(NSUInteger)type is_typed:(BOOL)is_typed img_path:(NSString*)img_path description:(NSString*)description disabled:(BOOL)disabled start_time:(NSDate*)start_time end_time:(NSDate *)end_time;


-(void) setName:(NSString*)name;

@end
