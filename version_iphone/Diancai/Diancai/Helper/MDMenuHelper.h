//
//  MDMenuHelper.h
//  Diancai
//
//  Created by james on 13/01/15.
//  Copyright (c) 2015 Xiaojun. All rights reserved.
//

#import <Foundation/Foundation.h>

@class MDFirstMenu;
@interface MDMenuHelper : NSObject



@property (nonatomic,strong) NSMutableArray *firstMenu_list;


+ (MDMenuHelper*)shared;


-(NSMutableArray *) getAllFirstMenuNames;


-(NSMutableArray *) getSecondeMenuNamesWithFirstMenu:(MDFirstMenu*) firstMenu;


-(void) setFirstMenu_list:(NSMutableArray *)firstMenu_list;
@end
