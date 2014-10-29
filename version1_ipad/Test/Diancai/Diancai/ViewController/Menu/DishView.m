//
//  DishView.m
//  Diancai
//
//  Created by james on 05/10/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import "DishView.h"
#import "DishCollectionViewCell.h"



@implementation DishView

@synthesize recipeImages = _recipeImages;

- (void)setRecipeImage:(NSArray *)array{
    self.recipeImages = [array copy];
}




- (id)initWithFrame:(CGRect)frame recipeList:(NSArray *)array
{
    
    self.recipeImages = [array copy];
    if (self = [super initWithFrame:frame]) {
        [self addContentView];
        
        
        [_contentCollectionView registerNib:[UINib nibWithNibName:@"DishCollectionViewCell" bundle:[NSBundle mainBundle]] forCellWithReuseIdentifier:@"Cell"];
        
    }
    
    return self;
    
}



-(void)addContentView{
    _contentCollectionView = ({
        
        
         UICollectionViewFlowLayout *layout=[[UICollectionViewFlowLayout alloc] init];
        UICollectionView *collectionView = [[UICollectionView alloc] initWithFrame:self.bounds collectionViewLayout:layout];
        collectionView.autoresizingMask = UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleHeight;
        collectionView.alwaysBounceVertical = YES;
        //collectionView.numColsPortrait = 2;
        collectionView.dataSource = self;
        collectionView.delegate = self;
       
        collectionView.backgroundColor = [UIColor whiteColor];
        [self addSubview:collectionView];
        collectionView;
    });

}

#pragma mark collection view DataSource

- (NSInteger)collectionView:(UICollectionView *)collectionView numberOfItemsInSection:(NSInteger)section{
    return self.recipeImages.count;
}


// 定义上下cell的最小间距
- (CGFloat)collectionView:(UICollectionView *)collectionView layout:(UICollectionViewLayout*)collectionViewLayout minimumLineSpacingForSectionAtIndex:(NSInteger)section {
    return 6;
}

// 定义左右cell的最小间距
- (CGFloat)collectionView:(UICollectionView *)collectionView layout:(UICollectionViewLayout*)collectionViewLayout minimumInteritemSpacingForSectionAtIndex:(NSInteger)section {
    return 6;
}

- (UICollectionViewCell *)collectionView:(UICollectionView *)collectionView cellForItemAtIndexPath:(NSIndexPath *)indexPath{
    
    static NSString *identifier = @"Cell";
    DishCollectionViewCell *cell = [collectionView dequeueReusableCellWithReuseIdentifier:identifier forIndexPath:indexPath];
    //UIImageView *recipeImageView = (UIImageView *)[cell viewWithTag:100];
    //recipeImageView.image = [UIImage imageNamed:[self.recipeImages objectAtIndex:indexPath.row]];
    //cell.backgroundView = [[UIImageView alloc] initWithImage:[UIImage imageNamed:@"photo-frame.png"]];
    cell.platNameLabel.text = [_recipeImages objectAtIndex:indexPath.row];
    [cell setImage:(NSString *)[_recipeImages objectAtIndex:indexPath.row]];
    return cell;
}

- (CGSize)collectionView:(UICollectionView *)collectionView layout:(UICollectionViewLayout*)collectionViewLayout sizeForItemAtIndexPath:(NSIndexPath *)indexPath
{
    return CGSizeMake(240, 220);
}


@end
