//
//  MDDishView.h
//  Diancai
//
//  Created by james on 01/02/15.
//  Copyright (c) 2015 Xiaojun. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface MDDishView : UIView<UICollectionViewDataSource, UICollectionViewDelegate, UICollectionViewDelegateFlowLayout>

- (id)initWithFrame:(CGRect)frame ;
- (void)loadCollectionViewWithData:(NSArray *)array;



@property (nonatomic, strong) NSMutableArray *dish_data;

@property (nonatomic , strong) UICollectionView *contentCollectionView;


@end
