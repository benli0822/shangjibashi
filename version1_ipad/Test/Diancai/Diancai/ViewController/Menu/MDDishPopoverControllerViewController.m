//
//  DishPopoverControllerViewController.m
//  Diancai
//
//  Created by james on 30/10/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import "MDDishPopoverControllerViewController.h"
#import "MDDish.h"
#import "MDUserCommand.h"

@interface MDDishPopoverControllerViewController ()

@end

@implementation MDDishPopoverControllerViewController


-(void) setPopoverWithData:(NSString *)imageName {
    

    _imageName = imageName;
    
}

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    
    self.preferredContentSize = CGSizeMake(400.0, 300.0);
    
    
    //设置名字
    _dishNameLabel.text = [_imageName substringToIndex:[_imageName length] -4 ];
    
    //设置价格
    _dishPriceLabel.text = [NSString stringWithFormat:@"%lu",(unsigned long)[_imageName length]];
    
    //设置数量 初始化为1
    _dishQuantityLabel.text = [NSString stringWithFormat:@"%s","1"];
    
    //设置图片
    _imageView.image = [UIImage imageNamed:_imageName];

    
    
    
}

- (void)awakeFromNib {
    // Initialization code
}
- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}


#pragma mark 进行点菜操作
- (IBAction)selectOrder:(id)sender{
    MDDish *dish = [[MDDish alloc] init];
    [dish setName:_dishNameLabel.text];
    [dish setPrice:[_dishPriceLabel.text integerValue]];
    
    [[MDUserCommand shared] addDish:dish ];
    
    //dismiss the view controller
    [self dismissViewControllerAnimated:TRUE completion:nil];

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
