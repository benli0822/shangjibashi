//
//  MDDishCollectionViewCell.m
//  Diancai
//
//  Created by james on 01/02/15.
//  Copyright (c) 2015 Xiaojun. All rights reserved.
//

#import "MDDishCollectionViewCell.h"

@implementation MDDishCollectionViewCell{
    BOOL _setted;
}

- (void)awakeFromNib {
    // Initialization code
}


-(void)setImage:(NSString *)imagename{
    // _imageView.image = [UIImage imageNamed:imagename];
    [_imageView setFrame:self.frame];
    self.backgroundView = [[UIImageView alloc] initWithImage:[UIImage imageNamed:imagename]];
    
    
    
    
    //we need to know whether the gardienLayey is already added.
    if(!_setted){
        _setted = true;
        CAGradientLayer *gradientLayer=[CAGradientLayer layer];
        [gradientLayer setFrame:CGRectMake(0, 14, 150, 79)];
        [gradientLayer setColors:@[(id)[UIColor clearColor].CGColor,(id)[UIColor whiteColor].CGColor]];
        [gradientLayer setLocations:@[[NSNumber numberWithFloat:0.00f], [NSNumber numberWithFloat:1.0f]]];
        [gradientLayer setBorderWidth:0];
        
        gradientLayer.shadowColor = nil;
        gradientLayer.shadowOpacity = 0.0;
        gradientLayer.shadowRadius = 0.0;
        [[_GardienView layer] insertSublayer:gradientLayer atIndex:0];
    }
    
    
    
    
    
}



@end
