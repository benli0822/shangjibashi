//
//  MDReserveViewController.h
//  Diancai
//
//  Created by james on 02/02/15.
//  Copyright (c) 2015 Xiaojun. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface MDReserveViewController : UIViewController
@property (weak, nonatomic) IBOutlet UIDatePicker *datePicker;
@property (weak, nonatomic) IBOutlet UITextField *nameTextField;
@property (weak, nonatomic) IBOutlet UITextField *telephoneTextField;
@property (weak, nonatomic) IBOutlet UIStepper *personPicker;
@property (weak, nonatomic) IBOutlet UILabel *personLabel;

@end
