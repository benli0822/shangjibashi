//
//  MDListCommandController.h
//  Diancai
//
//  Created by james on 03/12/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>

@class MDUserCommand;


@interface MDListCommandController : NSObject <UITableViewDelegate,UITableViewDataSource>

@property(strong, nonatomic) NSMutableArray* data; //存放列表的数据，每个元素一个commande中的一个菜的信息 或者是一个activity 或者是菜单的信息

@property(strong, nonatomic) MDUserCommand *userCommand;

@end
