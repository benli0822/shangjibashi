//
//  DishCollectionViewCell.m
//  Diancai
//
//  Created by james on 24/09/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import "DishCollectionViewCell.h"

@implementation DishCollectionViewCell


@synthesize imageView = _imageView;
- (void)awakeFromNib {
    // Initialization code
}


-(void)setImage:(NSString *)imagename{
   
    _imageView.image = [UIImage imageNamed:imagename];
    self.backgroundView = [[UIImageView alloc] initWithImage:[UIImage imageNamed:@"photo-frame.png"]];
    
   
    
}
@end
