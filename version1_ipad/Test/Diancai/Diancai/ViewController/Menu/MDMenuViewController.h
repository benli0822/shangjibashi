//
//  MenuViewController.h
//  Diancai
//
//  Created by james on 22/09/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import <UIKit/UIKit.h>

@class  MenuCollectionViewControl;

@interface MDMenuViewController : UIViewController
@property(nonatomic,retain)  MenuCollectionViewControl *MenuDishCollectionViewController;
@property (weak, nonatomic) IBOutlet UISearchBar *dishSearchBar;


//NSDictionary 就像java 里面的 map. 这里一个字典key存放一个list菜单
@property(nonatomic, strong) NSMutableDictionary *dishDictionary;

//NSArray 存放次级菜单的string list
@property(nonatomic, strong) NSArray *sousMenuList;


@end
