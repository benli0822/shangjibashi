//
//  MenuViewController.h
//  Diancai
//
//  Created by james on 22/09/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import <UIKit/UIKit.h>

@class  MenuCollectionViewControl;

@interface MenuViewController : UIViewController
@property(nonatomic,retain)  MenuCollectionViewControl *MenuDishCollectionViewController;

@property (weak, nonatomic) IBOutlet UICollectionView *ColletionView;

@end
