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




- (CGFloat)tableView:(UITableView *)tableView
estimatedHeightForRowAtIndexPath:(NSIndexPath *)indexPath {
    return 70;
}

- (CGFloat)tableView:(UITableView *)tableView
heightForRowAtIndexPath:(NSIndexPath *)indexPath {
    return 80;
}


//#pragma mark 表单setion
//- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView
//{
//    // Return the number of sections.
//    return 1;
//}

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
    

    
    if([_userCommand.dish_list count] >= 1){
  
    
    MDDish *dish = [_userCommand.dish_list objectAtIndex:indexPath.row];
    cell.dishNameLabel.text = dish.name;
    cell.dishQuantityLabel.text = [NSString stringWithFormat:@"%ld", (long)[(NSNumber*)[_userCommand.dish_dictionary objectForKey:[NSString stringWithFormat:@"%lu", (unsigned long)dish.id_dish]] integerValue]];
    cell.dishPriceLabel.text = [NSString stringWithFormat:@"%ld", (long)[(NSNumber*)[_userCommand.dish_dictionary objectForKey:[NSString stringWithFormat:@"%lu", (unsigned long)dish.id_dish]] integerValue] * dish.price];
      cell.dishStausLabel.text = @"";  
    }
    
      return cell;
}

- (BOOL)tableView:(UITableView *)tableView canEditRowAtIndexPath:(NSIndexPath *)indexPath {
    return YES;
}

- (void)tableView:(UITableView *)tableView commitEditingStyle:(UITableViewCellEditingStyle)editingStyle forRowAtIndexPath:(NSIndexPath *)indexPath {
    
    if (editingStyle == UITableViewCellEditingStyleDelete) {
        // Delete the row from the data source.
        [_userCommand deleteDish:indexPath.row];
        //[[MDUserCommand shared] deleteDish:indexPath.row];
        [tableView deleteRowsAtIndexPaths:[NSArray arrayWithObject:indexPath] withRowAnimation:UITableViewRowAnimationFade];
        [tableView reloadData];
    }
    else if (editingStyle == UITableViewCellEditingStyleInsert) {
        // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view.
    }
}

@end
