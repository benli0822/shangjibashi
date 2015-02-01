//
//  SecondMenuViewController.h
//  Diancai
//
//  Created by james on 01/02/15.
//  Copyright (c) 2015 Xiaojun. All rights reserved.
//

#import <UIKit/UIKit.h>

@class MDDish;
@class MDFirstMenu;

@interface MDSecondMenuViewController : UIViewController


//NSDictionary 就像java 里面的 map. 这里一个字典key存放一个list菜单
@property(nonatomic, strong) NSMutableDictionary *dishDictionary;


//NSArray 存放次级菜单的string list
@property(nonatomic, strong) NSArray *sousMenuList;
//the data
@property(nonatomic, strong) NSMutableArray *firstMenuList;


-(void) refreshDataWithFirstMenuNumber:(NSInteger)number;
@end
