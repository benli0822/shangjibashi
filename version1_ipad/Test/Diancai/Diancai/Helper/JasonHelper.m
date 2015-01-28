//
//  JasonHelper.m
//  Diancai
//
//  Created by james on 28/01/15.
//  Copyright (c) 2015 Xiaojun. All rights reserved.
//

#import "JasonHelper.h"
#import "AFHTTPSessionManager.h"


@implementation JasonHelper



+(void)sendJsonDataWithDictionary : (NSDictionary*) data{
    
    
    
    
    //test send json
    
    NSDictionary *params = @ {@"content" :@"this is a article created by rest", @"title" :@"rest artcile",  @"username": @"lemattmatt" };
    
    
    NSString *baseURL = @"http://127.0.0.1:8080/api/";
    NSString *path = @"article/restPostArticle";
    
    
    
    
    AFHTTPSessionManager *manager = [[AFHTTPSessionManager alloc] initWithBaseURL:[NSURL URLWithString:baseURL]];
    manager.requestSerializer = [AFJSONRequestSerializer serializer];
    manager.responseSerializer = [AFJSONResponseSerializer serializer];
    
    [manager POST:path parameters:params success:^(NSURLSessionDataTask *task, id responseObject) {
        
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
