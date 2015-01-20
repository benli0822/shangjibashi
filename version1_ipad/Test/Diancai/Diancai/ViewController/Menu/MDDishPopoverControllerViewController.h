//
//  DishPopoverControllerViewController.h
//  Diancai
//
//  Created by james on 30/10/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import <UIKit/UIKit.h>

@class MDDish;

@interface MDDishPopoverControllerViewController : UIViewController
@property (weak, nonatomic) IBOutlet UILabel *dishNameLabel;

@property (weak, nonatomic) IBOutlet UILabel *dishPriceLabel;


@property (weak, nonatomic) IBOutlet UIButton *ValidButton;
@property (weak, nonatomic) IBOutlet UIImageView *imageView;
@property (weak, nonatomic) IBOutlet NSString *imageName;
@property (weak, nonatomic) IBOutlet UILabel *dishQuantityLabel;

@property (strong, nonatomic) IBOutlet UIView *DetailView;

@property (weak, nonatomic) MDDish *dish;

//设置popvoer数据
-(void) setPopoverWithData:(MDDish *)dish;

#pragma mark 进行点菜操作
- (IBAction)selectOrder:(id)sender;

@end
