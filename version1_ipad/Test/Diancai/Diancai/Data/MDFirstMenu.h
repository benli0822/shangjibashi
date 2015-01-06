//
//  MDFirstMenu.h
//  Diancai
//
//  Created by james on 06/01/15.
//  Copyright (c) 2015 Xiaojun. All rights reserved.
//

#import <Foundation/Foundation.h>


@class MDSecondMenu;

@interface MDFirstMenu : NSObject


@property(readonly,nonatomic) NSUInteger type_id;
@property(readonly,nonatomic) NSString *name;
@property(readonly,nonatomic) NSString *description;



@property (nonatomic,strong) NSMutableArray *secondeMenu_list;

/**
 *  add a seconde menu to firstmenu
 *
 *  @param object MDsecondMenu
 */
-(void) addSecondeMenu_listObject:(MDSecondMenu *)object;

-(id)initWithKey:(NSUInteger)type_id name:(NSString*)name description:(NSString *)description;

@end
