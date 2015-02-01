//
//  FirstMenuTableController.h
//  Diancai
//
//  Created by james on 01/02/15.
//  Copyright (c) 2015 Xiaojun. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>


@interface MDFirstMenuTableController : NSObject <UITableViewDelegate,UITableViewDataSource>

@property(strong, nonatomic) NSMutableArray* data; //存放列表的数据，每个元素都是Menu对象


@end
