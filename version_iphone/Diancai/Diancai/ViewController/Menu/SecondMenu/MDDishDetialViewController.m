//
//  MDDishDetialViewController.m
//  Diancai
//
//  Created by james on 03/02/15.
//  Copyright (c) 2015 Xiaojun. All rights reserved.
//

#import "MDDishDetialViewController.h"
#import "MDDish.h"

@interface MDDishDetialViewController ()

@end

@implementation MDDishDetialViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    
    
    _dishImage.image  =  [UIImage imageNamed:[NSString stringWithFormat:@"%@.jpg", _dish.name]];
    
    _dishNameLabel.text = _dish.name;
    _dishPriceLabel.text = [NSString stringWithFormat:@"%lu", (unsigned long)_dish.price];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}


-(void)setPopoverWithData:(MDDish*)dish{
    _dish = dish;
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
