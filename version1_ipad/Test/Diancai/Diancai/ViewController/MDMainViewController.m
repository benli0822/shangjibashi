//
//  ViewController.m
//  Diancai
//
//  Created by james on 22/09/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import "MDMainViewController.h"
#import "MDMenuViewController.h"
#import "SQLiteManager.h"

@interface MDMainViewController ()

@end

@implementation MDMainViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    NSLocale* curentLocale = [NSLocale currentLocale];
    NSString *localId = [curentLocale localeIdentifier];
    //NSLog(@"%@",localId);
    
   
    
    
    
    // Do any additional setup after loading the view, typically from a nib.
    
    [[SQLiteManager shared] getTestReadDataFromDB];
    
}

#pragma mark 进行点菜操作
- (IBAction)selectOrder:(id)sender {
    
    MDMenuViewController* controller = [self.storyboard instantiateViewControllerWithIdentifier:@"MenuViewController"];
    [self.navigationController pushViewController:controller animated:YES];
}


- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
