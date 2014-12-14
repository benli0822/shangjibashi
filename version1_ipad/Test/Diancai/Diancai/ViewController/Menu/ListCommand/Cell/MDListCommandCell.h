//
//  MDListCommandCell.h
//  Diancai
//
//  Created by james on 03/12/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface MDListCommandCell : UITableViewCell


@property (weak, nonatomic) IBOutlet UILabel *dishNameLabel;

@property (weak, nonatomic) IBOutlet UILabel *dishStausLabel;
@property (weak, nonatomic) IBOutlet UILabel *dishQuantityLabel;
@property (weak, nonatomic) IBOutlet UILabel *dishPriceLabel;

@end
