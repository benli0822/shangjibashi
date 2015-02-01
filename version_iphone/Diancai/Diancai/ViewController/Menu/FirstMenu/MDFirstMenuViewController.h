//
//  FirstMenuViewController.h
//  Diancai
//
//  Created by james on 01/02/15.
//  Copyright (c) 2015 Xiaojun. All rights reserved.
//

#import <UIKit/UIKit.h>

@class MDFirstMenuTableController;
@class MDCommand;
@class MDDish;
@class MDFirstMenu;

@interface MDFirstMenuViewController : UIViewController


@property (weak, nonatomic) IBOutlet UISearchBar *dishSearchBar;
@property (weak, nonatomic) IBOutlet UITableView *firstMenuTableViewController;


//NSDictionary 就像java 里面的 map. 这里一个字典key存放一个list菜单
@property(nonatomic, strong) NSMutableDictionary *dishDictionary;

//NSArray 存放次级菜单的string list
@property(nonatomic, strong) NSArray *sousMenuList;

//first menu table controller
@property(nonatomic, strong) MDFirstMenuTableController *firstMenuTableController;

//显示已点按钮
@property (weak, nonatomic) IBOutlet UIButton *showCommandButton;

//用户订单
@property (nonatomic, strong) MDCommand* userCommand;

//the data
@property(nonatomic, strong) NSMutableArray *firstMenuList;


-(void) refreshDataWithFirstMenuNumber:(NSInteger)number;



@end
