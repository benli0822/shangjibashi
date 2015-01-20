//
//  DishCollectionViewCell.m
//  Diancai
//
//  This class is for each dish image cell
//  Created by james on 24/09/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import "DishCollectionViewCell.h"

@implementation DishCollectionViewCell{
    BOOL _setted;
}


@synthesize imageView = _imageView;
- (void)awakeFromNib {
    // Initialization code
}


-(void)setImage:(NSString *)imagename{
   // _imageView.image = [UIImage imageNamed:imagename];
    [_imageView setFrame:self.frame];
    self.backgroundView = [[UIImageView alloc] initWithImage:[UIImage imageNamed:imagename]];
    
    //we need to know where the gardienLayey is already added.
    if(!_setted){
        _setted = true;
    CAGradientLayer *gradientLayer=[CAGradientLayer layer];
    [gradientLayer setFrame:[_GardienView bounds]];
    [gradientLayer setColors:@[(id)[UIColor clearColor].CGColor,(id)[UIColor whiteColor].CGColor]];
    [gradientLayer setLocations:@[[NSNumber numberWithFloat:0.00f], [NSNumber numberWithFloat:1.0f]]];
    [[_GardienView layer] insertSublayer:gradientLayer atIndex:0];
    }
    
}
@end
