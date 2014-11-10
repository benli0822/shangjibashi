//
//  DishView.m
//  Diancai
//
//  Created by james on 05/10/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import "MDDishView.h"
#import "DishCollectionViewCell.h"
#import "MDDishPopoverControllerViewController.h"



@implementation MDDishView

@synthesize recipeImages = _recipeImages;
@synthesize contentCollectionView = _contentCollectionView;


- (void)loadCollectionViewWithArray:(NSArray *)array{
    
    [self.contentCollectionView setContentOffset:CGPointMake(0, 0)];
    
    [_recipeImages removeAllObjects];
    __weak typeof(self) weakSelf = self;

    [weakSelf reloadListViewDataSource:array];
    
}
- (void)reloadListViewDataSource:(NSArray *)array
{
    [_recipeImages addObjectsFromArray:array];
    [self.contentCollectionView reloadData];
}



- (id)initWithFrame:(CGRect)frame
{
    
    
    if (self = [super initWithFrame:frame]) {
        
        
        _recipeImages = @[].mutableCopy;

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
        collectionView.userInteractionEnabled = YES;
        collectionView.backgroundColor = [UIColor whiteColor];
        [self addSubview:collectionView];
        collectionView;
    });

}

#pragma mark collection view DataSource

//在这里加上search的方法
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
    return CGSizeMake(240, 200);
}

- (void)collectionView:(UICollectionView *)collectionView
didSelectItemAtIndexPath:(NSIndexPath *)indexPath{
    
    NSLog(@"click cell");
        static NSString *identifier = @"Cell";
     DishCollectionViewCell *cell = [collectionView dequeueReusableCellWithReuseIdentifier:identifier forIndexPath:indexPath];
    CGRect rect=CGRectMake(cell.bounds.origin.x+600, cell.bounds.origin.y+10, 50, 30);
    MDDishPopoverControllerViewController *PopoverView =[[MDDishPopoverControllerViewController alloc] initWithNibName:@"DishPopoverControllerViewController" bundle:nil];
    
#pragma 这里还有问题!!
    UIPopoverController *popOver =[[UIPopoverController alloc] initWithContentViewController:PopoverView];
    [popOver presentPopoverFromRect:rect inView:cell.contentView permittedArrowDirections:UIPopoverArrowDirectionAny animated:YES];
  
    //[popOver presentPopoverFromRect:rect inView:cell permittedArrowDirections:UIPopoverArrowDirectionAny animated:YES];
}

#pragma 在这里加搜索的方法
// NSPredicate *predicat = [NSPredicate predicateWithFormat:@[]]
//UISearchDisplatDelegate
@end
