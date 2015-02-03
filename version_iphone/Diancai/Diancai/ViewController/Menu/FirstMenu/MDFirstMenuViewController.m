//
//  FirstMenuViewController.m
//  Diancai
//
//  Created by james on 01/02/15.
//  Copyright (c) 2015 Xiaojun. All rights reserved.
//

#import "MDFirstMenuViewController.h"
#import "SQLiteManager.h"
#import "MDMenuHelper.h"
#import "MDFirstMenuTableController.h"
#import "MDSecondMenuViewController.h"



@interface MDFirstMenuViewController ()

@end

@implementation MDFirstMenuViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    
#pragma mark read data section
    _firstMenuList = [[NSMutableArray alloc] initWithArray:[[SQLiteManager shared] readAllDataFromDB]];
    [[MDMenuHelper shared] setFirstMenu_list:_firstMenuList];

#pragma mark first menu table setting
    
    [self.firstMenuTableViewController registerNib:[UINib nibWithNibName:@"MDFirstMenuTableViewCell"
                                                                  bundle:[NSBundle mainBundle]]
                            forCellReuseIdentifier:@"Cell"];
    
    _firstMenuTableController = [[MDFirstMenuTableController alloc] init];
    
    
    _firstMenuTableController.data = [[MDMenuHelper shared] getAllFirstMenuNames];
    
    _firstMenuTableViewController.separatorColor = [UIColor clearColor];
    [_firstMenuTableViewController setDataSource:self.firstMenuTableController];
    [_firstMenuTableViewController setDelegate:self.firstMenuTableController];
    _firstMenuTableController.parentViewController = self;
    
    //set section
    NSIndexPath *indexPath=[NSIndexPath indexPathForRow:2 inSection:0];
    [_firstMenuTableViewController selectRowAtIndexPath:indexPath animated:YES  scrollPosition:UITableViewScrollPositionBottom];
    

    
    
}



-(void) refreshDataWithFirstMenuNumber:(NSInteger)number{
    MDSecondMenuViewController *secondMenuVC = [[MDSecondMenuViewController alloc] init];
    secondMenuVC.dishDictionary = _dishDictionary;
    secondMenuVC.firstMenuList = _firstMenuList;
    [secondMenuVC refreshDataWithFirstMenuNumber:number];
    [self.navigationController pushViewController:secondMenuVC animated:TRUE];
    
}
- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
