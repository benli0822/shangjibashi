//
//  MenuCollectionView.h
//  Diancai
//
//  Created by james on 23/09/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface MenuCollectionView : NSObject <UICollectionViewDataSource, UICollectionViewDelegate, UICollectionViewDelegateFlowLayout>

@property (nonatomic, strong) NSArray *recipeImages;


@end
