//
//  SettingViewController.h
//  Diancai
//
//  Created by james on 13/01/15.
//  Copyright (c) 2015 Xiaojun. All rights reserved.
//

#import <UIKit/UIKit.h>


@interface MDSettingViewController : UIViewController
@property (weak, nonatomic) IBOutlet UIButton *DownloadButton;
@property (weak, nonatomic) IBOutlet UIProgressView *progressIndicator;
@property (weak, nonatomic) IBOutlet UITextField *urlTextField;



@end
