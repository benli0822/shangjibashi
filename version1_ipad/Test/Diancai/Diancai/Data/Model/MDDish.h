//
//  MDDish.h
//  Diancai
//
//  Created by james on 06/11/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface MDDish : NSObject

@property(readonly,nonatomic) NSUInteger id;
@property(readonly,nonatomic) NSString *name;
@property(readonly,nonatomic) NSUInteger type;
@property(readonly,nonatomic) BOOL is_typed;
@property(readonly,nonatomic) NSUInteger type_id;
@property(readonly,nonatomic) NSString *img_path;
@property(readonly,nonatomic) NSString *description;
@property(readonly,nonatomic) BOOL disabled;
@property(readonly,nonatomic) NSDate *start_time;
@property(readonly,nonatomic) NSDate *end_time;




@end
