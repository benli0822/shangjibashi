//
//  DishCollectionViewCell.h
//  Diancai
//
//  Created by james on 24/09/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface DishCollectionViewCell : UICollectionViewCell

@property (weak,nonatomic) IBOutlet UIImageView *imageView;

@property (weak, nonatomic) IBOutlet UILabel *platNameLabel;
@property (weak, nonatomic) IBOutlet UILabel *platPriceLabel;
@property (nonatomic, strong) NSString* platName;

-(void)setImage:(NSString *)imagename;
@end
