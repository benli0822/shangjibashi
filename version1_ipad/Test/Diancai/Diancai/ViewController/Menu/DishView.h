//
//  DishView.h
//  Diancai
//
//  Created by james on 05/10/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface DishView :  UIView<UICollectionViewDataSource, UICollectionViewDelegate, UICollectionViewDelegateFlowLayout>



- (id)initWithFrame:(CGRect)frame recipeList:(NSArray *)array;


@property (nonatomic, strong) NSArray *recipeImages;

@property (nonatomic , strong) UICollectionView *contentCollectionView;


@end
