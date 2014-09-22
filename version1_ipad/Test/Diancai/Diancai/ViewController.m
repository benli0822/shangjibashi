//
//  ViewController.m
//  Diancai
//
//  Created by james on 22/09/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import "ViewController.h"
#import "MenuViewController.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
}

#pragma mark 进行点菜操作
- (IBAction)selectOrder:(id)sender {
    
    MenuViewController* controller = [self.storyboard instantiateViewControllerWithIdentifier:@"MenuViewController"];
    [self.navigationController pushViewController:controller animated:YES];
}


- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
