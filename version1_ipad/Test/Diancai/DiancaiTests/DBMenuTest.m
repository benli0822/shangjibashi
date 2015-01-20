//
//  DBMenuTest.m
//  Diancai
//
//  Created by james on 06/01/15.
//  Copyright (c) 2015 Xiaojun. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <XCTest/XCTest.h>
#import "SQLiteManager.h"

@interface DBMenuTest : XCTestCase

@end

@implementation DBMenuTest

- (void)setUp {
    [super setUp];
    // Put setup code here. This method is called before the invocation of each test method in the class.
}

- (void)tearDown {
    // Put teardown code here. This method is called after the invocation of each test method in the class.
    [super tearDown];
}

-(void)testDBOpen{
    XCTAssertEqualObjects([[SQLiteManager shared] getTestReadDataFromDB], @"opened");
}

-(void)testDBReadFirstMenu{
    XCTAssertEqual([[[SQLiteManager shared] readAllDataFromDB] count] > 2, true );
    
}
- (void)testPerformanceExample {
    // This is an example of a performance test case.
    [self measureBlock:^{
        // Put the code you want to measure the time of here.
    }];
}

@end
