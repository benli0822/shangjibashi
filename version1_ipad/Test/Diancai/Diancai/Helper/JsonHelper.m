//
//  JasonHelper.m
//  Diancai
//
//  Created by james on 28/01/15.
//  Copyright (c) 2015 Xiaojun. All rights reserved.
//

#import "JsonHelper.h"
#import "AFHTTPSessionManager.h"


@implementation JsonHelper



+(void)sendJsonDataWithDictionary : (NSDictionary*) data{
    
    
    
    

    
    NSString *baseURL = @"http://192.168.1.41:9090/api";
    NSString *path = @"postCommands";
    
    
    
    
    AFHTTPSessionManager *manager = [[AFHTTPSessionManager alloc] initWithBaseURL:[NSURL URLWithString:baseURL]];
    manager.requestSerializer = [AFJSONRequestSerializer serializer];
    manager.responseSerializer = [AFJSONResponseSerializer serializer];
    
    [manager POST:path parameters:data success:^(NSURLSessionDataTask *task, id responseObject) {
        
        NSLog(@"JSON: %@", responseObject);
        //here is place for code executed in success case
        
    } failure:^(NSURLSessionDataTask *task, NSError *error) {
        
        //here is place for code executed in success case
        UIAlertView *alertView = [[UIAlertView alloc] initWithTitle:@"Error while sending POST"
                                                            message:@"Sorry, try again."
                                                           delegate:nil
                                                  cancelButtonTitle:@"Ok"
                                                  otherButtonTitles:nil];
        [alertView show];
        
        NSLog(@"Error: %@", [error localizedDescription]);
    }];
    
    
    NSLog(@"try to send json");

    
}
@end
