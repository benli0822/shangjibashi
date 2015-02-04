//
//  MDDishDetialViewController.h
//  Diancai
//
//  Created by james on 03/02/15.
//  Copyright (c) 2015 Xiaojun. All rights reserved.
//

#import <UIKit/UIKit.h>

@class MDDish;
@interface MDDishDetialViewController : UIViewController


@property(strong, nonatomic) MDDish* dish;
@property (weak, nonatomic) IBOutlet UIImageView *dishImage;

@property (weak, nonatomic) IBOutlet UILabel *dishNameLabel;
@property (weak, nonatomic) IBOutlet UILabel *dishPriceLabel;
@property (weak, nonatomic) IBOutlet UITextView *dishDescriptionTextView;

-(void)setPopoverWithData:(MDDish*)dish;
@end
