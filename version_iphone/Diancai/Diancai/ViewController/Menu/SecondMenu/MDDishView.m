//
//  MDDishView.m
//  Diancai
//
//  Created by james on 01/02/15.
//  Copyright (c) 2015 Xiaojun. All rights reserved.
//

#import "MDDishView.h"
#import "MDDishCollectionViewCell.h"
#import "MDDish.h"


@implementation MDDishView

@synthesize dish_data = _dish_data;
@synthesize contentCollectionView = _contentCollectionView;


- (void)loadCollectionViewWithData:(NSArray *)array{
    
    [self.contentCollectionView setContentOffset:CGPointMake(0, 0)];
    
    [_dish_data removeAllObjects];
    __weak typeof(self) weakSelf = self;
    
    [weakSelf reloadListViewDataSource:array];
    
}
- (void)reloadListViewDataSource:(NSArray *)array
{
    [_dish_data addObjectsFromArray:array];
    [self.contentCollectionView reloadData];
}



- (id)initWithFrame:(CGRect)frame
{
    
    
    if (self = [super initWithFrame:frame]) {
        
        
        _dish_data = @[].mutableCopy;
        
        [self addContentView];
        
        [_contentCollectionView registerNib:[UINib nibWithNibName:@"MDDishCollectionViewCell" bundle:[NSBundle mainBundle]] forCellWithReuseIdentifier:@"Cell"];
        
        
        
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
    
    //NSLog(@" recipe count @%lu", (unsigned long)self.dish_data.count);
    return self.dish_data.count;
}


// 定义上下cell的最小间距
- (CGFloat)collectionView:(UICollectionView *)collectionView layout:(UICollectionViewLayout*)collectionViewLayout minimumLineSpacingForSectionAtIndex:(NSInteger)section {
    return 30;
}

// 定义左右cell的最小间距
- (CGFloat)collectionView:(UICollectionView *)collectionView layout:(UICollectionViewLayout*)collectionViewLayout minimumInteritemSpacingForSectionAtIndex:(NSInteger)section {
    return 10;
}

//定义上左下右边距
- (UIEdgeInsets)collectionView:(UICollectionView *)collectionView layout:(UICollectionViewLayout*)collectionViewLayout insetForSectionAtIndex:(NSInteger)section
{
    return UIEdgeInsetsMake(10,25,0,25);
}

- (UICollectionViewCell *)collectionView:(UICollectionView *)collectionView cellForItemAtIndexPath:(NSIndexPath *)indexPath{
    
    static NSString *identifier = @"Cell";
    MDDishCollectionViewCell *cell = [collectionView dequeueReusableCellWithReuseIdentifier:identifier forIndexPath:indexPath];
    //UIImageView *recipeImageView = (UIImageView *)[cell viewWithTag:100];
    //recipeImageView.image = [UIImage imageNamed:[self.recipeImages objectAtIndex:indexPath.row]];
    //cell.backgroundView = [[UIImageView alloc] initWithImage:[UIImage imageNamed:@"photo-frame.png"]];
    
    
    
    
    MDDish* dish = [_dish_data objectAtIndex:indexPath.row];
    
    cell.platNameLabel.text =[dish name];
    //        cell.platNameLabel.text =[[_dish_data objectAtIndex:indexPath.row] substringToIndex:[[_dish_data objectAtIndex:indexPath.row] length] -4 ];
    
    //设置图片
    //[cell setImage:(NSString *)[_dish_data objectAtIndex:indexPath.row]];
    [cell setImage:[NSString stringWithFormat:@"%@.jpg",[dish name]]];
    
    
    //设置价格
    cell.platPriceLabel.text = [NSString stringWithFormat:@"%lu",(unsigned long)[dish price]];
    
    //corner setting
    
    
    //add shadow to layer
    cell.layer.shadowColor = [UIColor blackColor].CGColor;//shadowColor阴影颜色
    cell.layer.shadowOffset = CGSizeMake(2,1);//shadowOffset阴影偏移,x向右偏移4，y向下偏移4，默认(0, -3),这个跟shadowRadius配合使用
    cell.layer.shadowOpacity = 0.2;//阴影透明度，默认0
    cell.layer.shadowRadius = 1;//阴影半径，默认3
    cell.layer.masksToBounds = NO;
    //cell.layer.borderWidth = 0.1f;
    
    cell.GardienView.layer.shadowOpacity = 0;
    
    return cell;
}

- (CGSize)collectionView:(UICollectionView *)collectionView layout:(UICollectionViewLayout*)collectionViewLayout sizeForItemAtIndexPath:(NSIndexPath *)indexPath
{
    return CGSizeMake(150, 120);
}

//- (void)collectionView:(UICollectionView *)collectionView
//didSelectItemAtIndexPath:(NSIndexPath *)indexPath{
//    
//    [_contentCollectionView deselectItemAtIndexPath:indexPath animated:NO];
//    CGRect rect = CGRectMake(_contentCollectionView.frame.size.width/2, _contentCollectionView.frame.size.height/2, 1, 1);
//    
//    MDDishPopoverControllerViewController *PopoverView =[[MDDishPopoverControllerViewController alloc] initWithNibName:@"MDDishPopoverControllerViewController" bundle:nil];
//    
//#pragma 这里还有问题!!
//    
//    
//    [PopoverView setPopoverWithData:[_dish_data objectAtIndex:indexPath.row]];
//    UIPopoverController *popOver =[[UIPopoverController alloc] initWithContentViewController:PopoverView];
//    
//    
//    [popOver presentPopoverFromRect:rect inView:_contentCollectionView permittedArrowDirections:0 animated:YES];
//    
//    //[popOver presentPopoverFromRect:rect inView:cell permittedArrowDirections:UIPopoverArrowDirectionAny animated:YES];
//}

@end
