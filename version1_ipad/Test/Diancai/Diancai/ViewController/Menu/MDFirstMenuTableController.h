//
//  MDFirstMenuTableController.h
//  Diancai
//
//  Created by james on 11/11/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import <Foundation/Foundation.h>

#import <UIKit/UIKit.h>


@class MDMenuViewController;
@interface MDFirstMenuTableController : NSObject <UITableViewDelegate,UITableViewDataSource>

@property(strong, nonatomic) NSMutableArray* data; //存放列表的数据，每个元素都是Menu对象


@property(strong, nonatomic) MDMenuViewController* parentViewController;

@end
