//
//  MDListCommandController.m
//  Diancai
//
//  Created by james on 03/12/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import "MDListCommandController.h"
#import "MDListCommandCell.h"
#import "MDUserCommand.h"
#import "MDDish.h"

@implementation MDListCommandController

#pragma mark 返回行数
-(NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section{
    
    return [_userCommand.dish_list count];
}

#pragma mark - tableView的代理方法
-(UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath{
    
    
    
    static NSString* CellIdentifier = @"Cell";
    
    MDListCommandCell* cell = [tableView dequeueReusableCellWithIdentifier:CellIdentifier];
    
    if (!cell) {
        
        cell = [[MDListCommandCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:CellIdentifier];
    }
    
    //设置数据
    //FCDoubleBet* doubleBet = _data[indexPath.row];
    //cell.firstMenuLabel.text = _data[indexPath.row];
    //cell.dishNameLabel.text = _data[indexPath.row];
    
    MDDish *dish = [_userCommand.dish_list objectAtIndex:indexPath.row];
    
    
    NSLog(@"user command tableview :%@", dish.name );

    
    cell.dishNameLabel.text = dish.name;
    
    return cell;
}


@end
