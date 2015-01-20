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


-(void) setPopoverWithData:(MDDish*)dish {
    

    _dish = dish;
    
}

- (void)viewDidLoad {
    [super viewDidLoad];
//    [_dishQuantityTextField becomeFirstResponder];
//    [_dishQuantityTextField resignFirstResponder];
    // Do any additional setup after loading the view from its nib.
    
    self.preferredContentSize = CGSizeMake(400.0, 300.0);
    
    
    //设置名字
    _dishNameLabel.text = [_dish name];
    
    //设置价格
    _dishPriceLabel.text = [NSString stringWithFormat:@"%lu",[_dish price]];
    
    //设置数量 初始化为1
//    _dishQuantityTextField.text = [NSString stringWithFormat:@"%s","1"];
//    [_dishQuantityTextField setDelegate:self];
    //_dishQuantityTextField.keyboardType = UIKeyboardTypePhonePad;
    _dishQuantityLabel.text=@"1";
    
    //设置图片
    _imageView.image = [UIImage imageNamed:[NSString stringWithFormat:@"%@.jpg",[_dish name]]];

    
    
    
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
//    MDDish *dish = [[MDDish alloc] init];
//    [dish setName:_dishNameLabel.text];
//    [dish setPrice:[_dishPriceLabel.text integerValue]];
    
    [[MDUserCommand shared] addDish:_dish ];
    
    //dismiss the view controller
    [self dismissViewControllerAnimated:TRUE completion:nil];

}


//#pragma mark textfield delegate
//- (BOOL)textField:(UITextField *)textField shouldChangeCharactersInRange:(NSRange)range replacementString:(NSString *)string
//{
//    // allow backspace
//    if (!string.length)
//    {
//        return YES;
//    }
//    
//    // Prevent invalid character input, if keyboard is numberpad
//    if (textField.keyboardType == UIKeyboardTypeNumberPad)
//    {
//        if ([string rangeOfCharacterFromSet:[[NSCharacterSet decimalDigitCharacterSet] invertedSet]].location != NSNotFound)
//        {
//            // BasicAlert(@"", @"This field accepts only numeric entries.");
//            return NO;
//        }
//    }
//    
//    // verify max length has not been exceeded
//    NSString *updatedText = [textField.text stringByReplacingCharactersInRange:range withString:string];
//    
//    if (updatedText.length > 2) // 4 was chosen for SSN verification
//    {
//        // suppress the max length message only when the user is typing
//        // easy: pasted data has a length greater than 1; who copy/pastes one character?
//        if (string.length > 1)
//        {
//            // BasicAlert(@"", @"This field accepts a maximum of 4 characters.");
//        }
//        
//        return NO;
//    }
//    
//    // only enable the OK/submit button if they have entered all numbers for the last four of their SSN (prevents early submissions/trips to authentication server)
//    _ValidButton.enabled = (updatedText.length >1 );
//    
//    return YES;
//}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
