//
//  SQLiteManager.m
//  Diancai
//
//  Created by james on 10/12/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import "SQLiteManager.h"
#import  <sqlite3.h>
#import "FMDatabase.h"
#import "FMResultSet.h"
#import "MDFirstMenu.h"
#import "MDSecondMenu.h"
#import "MDDish.h"



@implementation SQLiteManager

-(void) initDatabase
{
 
    
    _databaseName = @"MDDB.sqlite";
    
    //recipere le chemain
    NSArray *documentPaths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES);
    NSString *documentDirs = [documentPaths objectAtIndex:0];
    
    _databasePath = [documentDirs stringByAppendingPathComponent:_databaseName];
    
    //verfie si la BDD a deja sauvegardee dans l'iphone
    BOOL success;
    
    //cree un objet FileManager qui va servir a verifer le statut
    NSFileManager *fileManager = [NSFileManager defaultManager];
    success = [fileManager fileExistsAtPath:_databasePath];
    
    if(!success){
        NSString *databasePathFromApp = [[[NSBundle mainBundle] resourcePath] stringByAppendingPathComponent:_databaseName];
         //NSLog(@"path %@",_databasePath);
        [fileManager copyItemAtPath:databasePathFromApp toPath:_databasePath error:nil];
    }
}

-(id) init{
    self = [super init];
    
    if (self) {
        [self initDatabase];
    }
    return  self;
}

#pragma mark - singleton

+(SQLiteManager *)shared
{
    static dispatch_once_t pred = 0;
    __strong static id _sharedObject = nil;
    dispatch_once(&pred , ^{
        _sharedObject = [[self alloc]init];
    });
    
    return _sharedObject;
}

-(NSString*) getTestReadDataFromDB{
    FMDatabase *db = [[FMDatabase alloc] initWithPath:_databasePath];
    
    
  
    
    if([db open]  == NO){
        NSLog(@"Error of open the database");
        return [NSString stringWithFormat:@"@Error of open the database"];
    }
    
    db.logsErrors = YES;
    FMResultSet *fResult = [db executeQuery:@"select * from md_dish", [NSNumber numberWithInt:1]];
    while ([fResult next]){
    NSLog(@"DB Data %@", [fResult stringForColumn:@"name"]);
    }
    return @"opened";

}

#pragma marks read data from DB
-(NSMutableArray *) readAllDataFromDB{
    
    NSMutableArray* data = [[NSMutableArray alloc] init];
    
    //get DB
    FMDatabase *db = [[FMDatabase alloc] initWithPath:_databasePath];
    
    //open DB
    if([db open]  == NO)
        NSLog(@"Error of open the database");
    db.logsErrors = YES;
    
    //get all firstmenu
    FMResultSet *fFirstMenuResult = [db executeQuery:@"select * from md_types where is_firstmenu = (?)" , [NSNumber numberWithInt:1]];
    
    while ([fFirstMenuResult next]) {
        //get this firstmenu basic information
        NSUInteger type_id = [fFirstMenuResult intForColumn:@"id"];
        NSString *name = [fFirstMenuResult stringForColumn:@"name"];
        NSString *description = [fFirstMenuResult stringForColumn:@"description"];
        MDFirstMenu *newFirstMenu = [[MDFirstMenu alloc] initWithKey:type_id name:name description:description];
        
        //get the all the second menu associed with the first menu
         FMResultSet *fSecondMenuResult = [db executeQuery:@"select * from md_types where is_secondmenu = (?) and firstmenu_id = (?)" , [NSNumber numberWithInt:1], type_id];
        
        while ([fSecondMenuResult next]) {
            //get this secondMenu basic information
            
        }
        
        
        //add the first menu to list
        [data addObject:newFirstMenu];
        
        
    }
    
    return data;
    
}


-(void) readAllFirstMenuData{
    
}

-(void) readAllSecondMenuDate{
    
}

@end
