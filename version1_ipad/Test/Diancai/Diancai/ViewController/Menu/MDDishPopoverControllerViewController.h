//
//  DishPopoverControllerViewController.h
//  Diancai
//
//  Created by james on 30/10/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface MDDishPopoverControllerViewController : UIViewController
@property (weak, nonatomic) IBOutlet UILabel *dishNameLabel;

@property (weak, nonatomic) IBOutlet UILabel *dishPriceLabel;

@property (weak, nonatomic) IBOutlet UILabel *dishQuantityLabel;
@property (weak, nonatomic) IBOutlet UIButton *ValidButton;
@property (weak, nonatomic) IBOutlet UIImageView *imageView;
@property (weak, nonatomic) IBOutlet NSString *imageName;



-(void) setPopoverWithData:(NSString *)imageName;
@end
