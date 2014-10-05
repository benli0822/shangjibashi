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

-(void)setImage:(NSString *)imagename;
@end
