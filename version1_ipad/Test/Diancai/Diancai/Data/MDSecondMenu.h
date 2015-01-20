//
//  MDSecondMenu.h
//  Diancai
//
//  Created by james on 06/01/15.
//  Copyright (c) 2015 Xiaojun. All rights reserved.
//

#import <Foundation/Foundation.h>

@class MDDish;
@interface MDSecondMenu : NSObject


@property(readonly,nonatomic) NSUInteger type_id;

@property(readonly,nonatomic) NSString *name;
@property(readonly,nonatomic) NSString *description;



@property (nonatomic,strong) NSMutableArray *dish_list;



/**
 *  add a dish to secondMenu
 *
 *  @param object MDDish
 */
-(void) addSecondeMenu_listObject:(MDDish *)object;
-(void) addObjectWithArray:(NSMutableArray*) array;

-(id)initWithKey:(NSUInteger)type_id name:(NSString*)name description:(NSString *)description;



@end
