//
//  MDListCommandViewController.m
//  Diancai
//
//  Created by james on 03/12/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import "MDListCommandViewController.h"
#import "MDListCommandController.h"
#import "MDUserCommand.h"
#import "AFHTTPSessionManager.h"
#import "MDDish.h"

@interface MDListCommandViewController ()

@end

@implementation MDListCommandViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    
    self.preferredContentSize = CGSizeMake(400.0, 660.0);
    
    self.listCommandController = [[MDListCommandController alloc] init];
    
    self.listCommandController.userCommand = [MDUserCommand shared];
    
    
    [self.listCommandTable registerNib:[UINib nibWithNibName:@"MDListCommandCell"
                                                                  bundle:[NSBundle mainBundle]]
                            forCellReuseIdentifier:@"Cell"];

    
    _totalPriceLabel.text = [NSString stringWithFormat:@"%3f", [MDUserCommand shared].total_price];
    [_listCommandTable setDataSource:_listCommandController];
    [_listCommandTable setDelegate:_listCommandController];
    
    
}

- (IBAction)ConfirmeCommand:(id)sender {
    
    
    
    
    NSLog(@"%@",[[MDUserCommand shared]  toJSONString ]);
    
    
    [self dismissViewControllerAnimated:TRUE completion:nil];
    
    
    
//    NSString *baseURL = @"http://your-server.com/";
//    NSString *path = @"method/url/";
//    
//    NSMutableDictionary *parameters = [NSMutableDictionary dictionary];
//    [parameters setObject:@"value" forKey:@"key"];
//    
//    
//    AFHTTPSessionManager *manager = [[AFHTTPSessionManager alloc] initWithBaseURL:[NSURL URLWithString:baseURL]];
//    manager.requestSerializer = [AFJSONRequestSerializer serializer];
//    manager.responseSerializer = [AFJSONResponseSerializer serializer];
//    
//    [manager POST:path parameters:parameters success:^(NSURLSessionDataTask *task, id responseObject) {
//        
//        NSLog(@"JSON: %@", responseObject);
//        //here is place for code executed in success case
//        
//    } failure:^(NSURLSessionDataTask *task, NSError *error) {
//        
//        //here is place for code executed in success case
//        UIAlertView *alertView = [[UIAlertView alloc] initWithTitle:@"Error while sending POST"
//                                                            message:@"Sorry, try again."
//                                                           delegate:nil
//                                                  cancelButtonTitle:@"Ok"
//                                                  otherButtonTitles:nil];
//        [alertView show];
//        
//        NSLog(@"Error: %@", [error localizedDescription]);
//    }];
    
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
