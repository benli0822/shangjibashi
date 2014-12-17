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

#pragma mark 表单setion
- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView
{
    // Return the number of sections.
    return 2;
}

#pragma mark 返回行数
-(NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section{
    if(section == 1){
    return [_userCommand.dish_list count];
    }
    else return 1;
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
    
   
    
    
  
    if(indexPath.section == 1){
         MDDish *dish = [_userCommand.dish_list objectAtIndex:indexPath.row];
    cell.dishNameLabel.text = dish.name;
    cell.dishQuantityLabel.text = [NSString stringWithFormat:@"%ld", (long)[(NSNumber*)[_userCommand.dish_dictionary objectForKey:dish.name] integerValue]];
    cell.dishPriceLabel.text = [NSString stringWithFormat:@"%ld", (long)[(NSNumber*)[_userCommand.dish_dictionary objectForKey:dish.name] integerValue] * dish.price];
      cell.dishStausLabel.text = @"";  
    }
    else{
        cell.dishNameLabel.text = @"name";
        cell.dishQuantityLabel.text = @"quantity";
        cell.dishPriceLabel.text = @"price";
        cell.dishStausLabel.text = @"";

    }
    return cell;
}


@end
