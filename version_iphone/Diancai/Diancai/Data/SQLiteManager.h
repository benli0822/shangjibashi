//
//  SQLiteManager.h
//  Diancai
//
//  Created by james on 10/12/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface SQLiteManager : NSObject



+ (SQLiteManager*)shared;

@property (nonatomic,retain) NSString *testData;
@property(nonatomic,strong) NSString *databaseName;
@property(nonatomic,strong) NSString *databasePath;



-(NSString*) getTestReadDataFromDB;

-(NSMutableArray *) readAllDataFromDB;


@end
