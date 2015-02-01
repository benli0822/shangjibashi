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
    NSString *plicastConfigPath = [[NSBundle mainBundle] pathForResource:@"MDAppConfiguration" ofType:@"plist"];
    NSDictionary *DBConfigDictionary = [[NSDictionary alloc] initWithContentsOfFile:plicastConfigPath][@"DBConfiguration"] ;
    NSLog(@"Dictionary value : %@",DBConfigDictionary[@"DBName"]);
    
    _databaseName = DBConfigDictionary[@"DBName"];
    
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
         NSLog(@"path %@",_databasePath);
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
    //NSLog(@"DB Data %@", [fResult stringForColumn:@"name"]);
    }
    return @"opened";

}

#pragma marks read data from DB
/**
 *  get the list of MDFirstMenu with all datas(dishs)
 *
 *  @return NSMutableArray , in this list we have all first menu
 */
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
        
        //get the option all dishes for second menu, 对于"所有"这个选项,我们要在dish_type 用一级菜单的type_id 这个表拿到所有的dish
       
        [newFirstMenu addSecondeMenu_listObject:[self readAllOptionForFirstMenu:type_id db:db]];
        //end get option all
        
        
        //get the all the second menu associed with the first menu
        FMResultSet *fSecondMenuResult = [db executeQuery:@"select * from md_types where is_secondmenu = (?) and firstmenu_id = (?)" , [NSNumber numberWithInt:1], [NSNumber numberWithInteger: type_id]];
        
        while ([fSecondMenuResult next]) {
            //get this secondMenu basic information
            NSUInteger type_id = [fSecondMenuResult intForColumn:@"id"];
            NSString *name = [fSecondMenuResult stringForColumn:@"name"];
            NSString *description = [fSecondMenuResult stringForColumn:@"description"];
            MDSecondMenu *newSecondMenu = [[MDSecondMenu alloc] initWithKey:type_id name:name description:description];
            
            
            [newSecondMenu addObjectWithArray:[self readAllDishsWithTypeID:type_id db:db]];
            [newFirstMenu addSecondeMenu_listObject:newSecondMenu];
        }
        

        
        //add the first menu to list
        [data addObject:newFirstMenu];
        
        
    }
    
    
    [self LogAllDishesOfDB:data];
    [db close];

    return data;
    
}

-(void)LogAllDishesOfDB:(NSMutableArray*) data{
    for (MDFirstMenu * fm in data) {
        NSLog(@" ------------------------------------");
        
        NSLog(@" first menu : name : %@", fm.name);
        
        
        
        for (MDSecondMenu* sm in fm.secondeMenu_list){
            NSLog(@" ---->");
            NSLog(@" second menu : name : %@", sm.name);
            
            for(MDDish* d in sm.dish_list){
                NSLog(@" >>>");
                NSLog(@" dish  : name : %@", d.name);
                
            }
            
        }
        
    }

}
-(MDSecondMenu*) readAllOptionForFirstMenu:(NSUInteger)menu_id db:(FMDatabase*)db{
    NSUInteger type_id = -1;
//needs to know the langage
    NSString *name = @"All";
    NSString *description = @"null";
    MDSecondMenu *newSecondMenu = [[MDSecondMenu alloc] initWithKey:type_id name:name description:description];
   
    //add all the dishs with type id
    [newSecondMenu addObjectWithArray:[self readAllDishsWithTypeID:menu_id db:db]];
    
    return newSecondMenu;
    
}

-(NSMutableArray*) readAllDishsWithTypeID:(NSUInteger) type_id db:(FMDatabase*)db{
    
    NSMutableArray* dishList = [[NSMutableArray alloc] init];
    
    //get all the dishs in this first menu
    FMResultSet *fDishesMenuResult = [db executeQuery:@"SELECT * FROM md_dish left join md_dish_type where md_dish.id = md_dish_type.dish_id and md_dish_type.type_id = (?)" , [NSNumber numberWithInteger: type_id]];
    while ([fDishesMenuResult next]) {
        NSUInteger id_dish = [fDishesMenuResult intForColumn:@"id"];
        NSString *name = [fDishesMenuResult stringForColumn:@"name"];
        NSUInteger price = [fDishesMenuResult intForColumn:@"price"];
        NSString *description = [fDishesMenuResult stringForColumn:@"description"];
        
        //need to change the get now method
        NSDate *start_date = [NSDate date];
        NSDate *end_date = [NSDate date];
        NSDate *start_time = [NSDate date];
        NSDate *end_time = [NSDate date];
        
        MDDish* newDish = [[MDDish alloc] initWithKey:id_dish name:name is_typed:TRUE description:description disabled:false start_date:start_date end_date:end_date start_time:start_time end_time:end_time price:price];
        
        
        //NSLog(@"add a dish with name : %@ , price : %ld",name,(unsigned long)price);
        [dishList addObject:newDish];
    }
    
       return dishList;

}

-(void) readAllFirstMenuData{
    
}

-(void) readAllSecondMenuDate{
    
}

@end
