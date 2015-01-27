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
    
    
//        self.layer.shadowColor = [UIColor blackColor].CGColor;//shadowColor阴影颜色
//        self.layer.shadowOffset = CGSizeMake(4,4);//shadowOffset阴影偏移,x向右偏移4，y向下偏移4，默认(0, -3),这个跟shadowRadius配合使用
//        self.layer.shadowOpacity = 0.1;//阴影透明度，默认0
//        self.layer.shadowRadius = 3;//阴影半径，默认3
//        self.layer.masksToBounds = NO;
//        self.layer.shouldRasterize = YES;
//        self.layer.borderWidth = 0.1f;
    
    
    
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
        [gradientLayer setBorderWidth:0];
        [[_GardienView layer] insertSublayer:gradientLayer atIndex:0];
        
    
        
    }
    
    
   
    
    
}
@end
