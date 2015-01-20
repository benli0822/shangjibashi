//
//  SettingViewController.m
//  Diancai
//
//  Created by james on 13/01/15.
//  Copyright (c) 2015 Xiaojun. All rights reserved.
//

#import "MDSettingViewController.h"
#import "AFURLSessionManager.h"
#import "AFHTTPRequestOperation.h"


@interface MDSettingViewController (){
    NSString *_databaseName;
    NSString *_databasePath;
}

@end

@implementation MDSettingViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    _urlTextField.text = @"http://172.19.145.127:9090/api/sync/getDbFile/database.sqlite";
    
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (IBAction)DownloadButtonClick:(id)sender {
    
    NSString *plicastConfigPath = [[NSBundle mainBundle] pathForResource:@"MDAppConfiguration" ofType:@"plist"];
    NSDictionary *DBConfigDictionary = [[NSDictionary alloc] initWithContentsOfFile:plicastConfigPath][@"DBConfiguration"] ;
    //NSLog(@"Dictionary value%@",DBConfigDictionary[@"DBName"]);
    
    _databaseName = DBConfigDictionary[@"DBName"];
    
    // recipere le chemain
    NSArray *documentPaths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES);
    NSString *documentDirs = [documentPaths objectAtIndex:0];
    _databasePath = [documentDirs stringByAppendingPathComponent:_databaseName];
    
    
    
    
    //start downloading
    NSURL *url = [NSURL URLWithString:_urlTextField.text];
    NSURLRequest *request = [NSURLRequest requestWithURL:url];
    
    AFHTTPRequestOperation *operation = [[AFHTTPRequestOperation alloc] initWithRequest:request];
    
    NSString *fullPath = [NSTemporaryDirectory() stringByAppendingPathComponent:[url lastPathComponent]];
    
    [operation setOutputStream:[NSOutputStream outputStreamToFileAtPath:fullPath append:NO]];
    
    [operation setDownloadProgressBlock:^(NSUInteger bytesRead, long long totalBytesRead, long long totalBytesExpectedToRead) {
        NSLog(@"bytesRead: %lu, totalBytesRead: %lld, totalBytesExpectedToRead: %lld", (unsigned long)bytesRead, totalBytesRead, totalBytesExpectedToRead);
    }];
    
    [operation setCompletionBlockWithSuccess:^(AFHTTPRequestOperation *operation, id responseObject) {
        
        NSLog(@"RES: %@", [[[operation response] allHeaderFields] description]);
        
        NSError *error;
        NSDictionary *fileAttributes = [[NSFileManager defaultManager] attributesOfItemAtPath:fullPath error:&error];
        
        if (error) {
            NSLog(@"ERR: %@", [error description]);
        } else {
           // NSNumber *fileSizeNumber = [fileAttributes objectForKey:NSFileSize];
            //long long fileSize = [fileSizeNumber longLongValue];
            NSLog(@"download success");
            
            //[[_downloadFile titleLabel] setText:[NSString stringWithFormat:@"%lld", fileSize]];
        }
        
        
    } failure:^(AFHTTPRequestOperation *operation, NSError *error) {
        NSLog(@"ERR: %@", [error description]);
    }];
    
    [operation start];

    
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
