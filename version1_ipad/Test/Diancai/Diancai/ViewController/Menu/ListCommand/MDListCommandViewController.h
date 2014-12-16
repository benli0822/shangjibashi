//
//  MDListCommandViewController.h
//  Diancai
//
//  Created by james on 03/12/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import <UIKit/UIKit.h>
@class MDCommand;
@class MDListCommandController;

@interface MDListCommandViewController : UIViewController
@property (weak, nonatomic) IBOutlet UITableView *listCommandTable;
@property (weak, nonatomic) IBOutlet UILabel *waitingTimeLabel;
@property (weak, nonatomic) IBOutlet UILabel *totalPriceLabel;
@property (weak, nonatomic) IBOutlet UILabel *topAlertLabel;

//list controller
@property(nonatomic, strong) MDListCommandController *listCommandController;

@property(weak, nonatomic) MDCommand  *userCommand;


@end
