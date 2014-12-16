//
//  MDListCommandViewController.m
//  Diancai
//
//  Created by james on 03/12/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import "MDListCommandViewController.h"
#import "MDListCommandController.h"
#import "MDUserCommand.h"

@interface MDListCommandViewController ()

@end

@implementation MDListCommandViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    
    self.preferredContentSize = CGSizeMake(400.0, 560.0);
    
    self.listCommandController = [[MDListCommandController alloc] init];
    
    self.listCommandController.userCommand = [MDUserCommand shared];
    
    
    [self.listCommandTable registerNib:[UINib nibWithNibName:@"MDListCommandCell"
                                                                  bundle:[NSBundle mainBundle]]
                            forCellReuseIdentifier:@"Cell"];

    
    [_listCommandTable setDataSource:_listCommandController];
    [_listCommandTable setDelegate:_listCommandController];
    
    
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
