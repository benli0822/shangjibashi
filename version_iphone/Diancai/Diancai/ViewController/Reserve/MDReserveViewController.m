//
//  MDReserveViewController.m
//  Diancai
//
//  Created by james on 02/02/15.
//  Copyright (c) 2015 Xiaojun. All rights reserved.
//

#import "MDReserveViewController.h"

@interface MDReserveViewController ()

@end

@implementation MDReserveViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    _personLabel.text = @"1";
    
    //设置stepper
    
    [_personPicker addTarget:self action:@selector(valueChanged:) forControlEvents:UIControlEventValueChanged];
    _personPicker.maximumValue = 15;
    _personPicker.minimumValue = 1;
    _personPicker.stepValue=1.0;

    //dismiss keyboard
    UITapGestureRecognizer *tap = [[UITapGestureRecognizer alloc]
                                   initWithTarget:self
                                   action:@selector(dismissKeyboard)];
    
    [self.view addGestureRecognizer:tap];
    
}

-(void)dismissKeyboard {
    [_nameTextField resignFirstResponder];
    [_telephoneTextField resignFirstResponder];
}


- (IBAction)valueChanged:(UIStepper *)sender {
    double value = [sender value];
    
    [_personLabel setText:[NSString stringWithFormat:@"%d", (int)value]];
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
