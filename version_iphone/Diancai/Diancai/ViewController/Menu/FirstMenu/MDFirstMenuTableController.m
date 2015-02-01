//
//  FirstMenuTableController.m
//  Diancai
//
//  Created by james on 01/02/15.
//  Copyright (c) 2015 Xiaojun. All rights reserved.
//

#import "MDFirstMenuTableController.h"
#import  "MDFirstMenuTableViewCell.h"



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
    
    MDFirstMenuTableViewCell* cell = [tableView dequeueReusableCellWithIdentifier:CellIdentifier];
    
    if (!cell) {
        
        cell = [[MDFirstMenuTableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:CellIdentifier];
    }
    
    //设置数据
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
    
    //[_parentViewController refreshDataWithFirstMenuNumber:indexPath.row];
}


@end
