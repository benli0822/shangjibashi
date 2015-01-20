//
//  DishView.h
//  Diancai
//
//  Created by james on 05/10/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface MDDishView :  UIView<UICollectionViewDataSource, UICollectionViewDelegate, UICollectionViewDelegateFlowLayout>



- (id)initWithFrame:(CGRect)frame ;
- (void)loadCollectionViewWithData:(NSArray *)array;



@property (nonatomic, strong) NSMutableArray *dish_data;

@property (nonatomic , strong) UICollectionView *contentCollectionView;


@end
