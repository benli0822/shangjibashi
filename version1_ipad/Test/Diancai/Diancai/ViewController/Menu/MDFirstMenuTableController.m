//
//  MDFirstMenuTableController.m
//  Diancai
//
//  Created by james on 11/11/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import "MDFirstMenuTableController.h"
#import  "MDFirstMenuTableCell.h"
#import "MDMenuViewController.h"

@implementation MDFirstMenuTableController

- (CGFloat)tableView:(UITableView *)tableView
estimatedHeightForRowAtIndexPath:(NSIndexPath *)indexPath {
    return 64;
}

- (CGFloat)tableView:(UITableView *)tableView
heightForRowAtIndexPath:(NSIndexPath *)indexPath {
    return 64;
}



#pragma mark 返回行数
-(NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section{
    
    return [_data count];
}

#pragma mark - tableView的代理方法
-(UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath{
    
    static NSString* CellIdentifier = @"Cell";
    
    MDFirstMenuTableCell* cell = [tableView dequeueReusableCellWithIdentifier:CellIdentifier];
    
    if (!cell) {
        
        cell = [[MDFirstMenuTableCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:CellIdentifier];
    }
    
    //设置数据
    //FCDoubleBet* doubleBet = _data[indexPath.row];
    cell.firstMenuLabel.text = _data[indexPath.row];
    
    //设置背景色
    //UIColor *backColor = [UIColor colorWithRed:0 green:0 blue:1 alpha:1];
    //cell.backgroundColor = backColor;
    UIColor *foreColor = [UIColor colorWithRed:237.0/255.0 green:85.0/255.0 blue:56.0/255.0 alpha:1];
    cell.firstMenuLabel.textColor = foreColor;
    
    //set selected
    cell.firstMenuLabel.highlightedTextColor = [UIColor whiteColor];
    UIView *mySelectedBgView = [[UIView alloc] initWithFrame:cell.frame];
    mySelectedBgView.backgroundColor =[UIColor colorWithRed:237.0/255.0 green:85.0/255.0 blue:56.0/255.0 alpha:1];
    cell.selectedBackgroundView = mySelectedBgView;
    
    
    return cell;
}

#pragma mark 点击cell的事件
-(void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath{
    
    [_parentViewController refreshDataWithFirstMenuNumber:indexPath.row];
}
@end
