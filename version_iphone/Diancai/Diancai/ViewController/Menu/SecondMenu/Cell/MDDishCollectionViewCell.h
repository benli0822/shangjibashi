//
//  MDDishCollectionViewCell.h
//  Diancai
//
//  Created by james on 01/02/15.
//  Copyright (c) 2015 Xiaojun. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface MDDishCollectionViewCell : UICollectionViewCell


@property (weak,nonatomic) IBOutlet UIImageView *imageView;

@property (weak, nonatomic) IBOutlet UILabel *platNameLabel;
@property (weak, nonatomic) IBOutlet UILabel *platPriceLabel;
@property (nonatomic, strong) NSString* platName;


@property (weak, nonatomic) IBOutlet UIView *GardienView;

-(void)setImage:(NSString *)imagename;


@end
