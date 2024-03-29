//
//  SecondMenuViewController.m
//  Diancai
//
//  Created by james on 01/02/15.
//  Copyright (c) 2015 Xiaojun. All rights reserved.
//

#import "MDSecondMenuViewController.h"

#import "iCarousel.h"
#import "XTSegmentControl.h"
#import "MDDishView.h"
#import "MDSecondMenu.h"
#import "MDFirstMenu.h"
#import "MDMenuHelper.h"





@interface MDSecondMenuViewController ()<iCarouselDataSource,iCarouselDelegate>
@property (nonatomic , strong) XTSegmentControl *segmentControl;
@property (nonatomic , strong) iCarousel *carousel;

@end

@implementation MDSecondMenuViewController

@synthesize carousel = _carousel;
@synthesize segmentControl = _segmentControl;


- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    
    //DISABLE GESTURE
    if ([self.navigationController respondsToSelector:@selector(interactivePopGestureRecognizer)]) {
        self.navigationController.interactivePopGestureRecognizer.enabled = NO;
    }
    
    _carousel = [[iCarousel alloc] initWithFrame:CGRectMake(0, 40+23 + 35, 375, 560)];
    _carousel.backgroundColor = [UIColor whiteColor];
    _carousel.dataSource = self;
    _carousel.delegate = self;
    _carousel.decelerationRate = 0.7;
    
    
    _carousel.type = iCarouselTypeLinear;
    _carousel.pagingEnabled = YES;
    
    // _carousel.edgeRecognition = YES;
    //solve overflowing problem
    _carousel.clipsToBounds = YES;
    
    _carousel.bounceDistance = 0.5;
    [self.view addSubview:_carousel];
    
    
#pragma mark carousel header setting
    
    __weak typeof(_carousel) weakCarousel = _carousel;
    
    _segmentControl = [[XTSegmentControl alloc] initWithFrame:CGRectMake(0, 63, 375, 35) Items:_sousMenuList selectedBlock:^(NSInteger index) {
        
        [weakCarousel scrollToItemAtIndex:index animated:NO];
    }];
    _segmentControl.backgroundColor = [UIColor whiteColor];
    [self.view addSubview:_segmentControl];
    

    
    
#pragma mark command list table setting
    

    

    
    
}


-(void) refreshDataWithFirstMenuNumber:(NSInteger)number{
    NSLog(@"click at row : %@", [[_firstMenuList objectAtIndex:number] name]);
    
    [self setDishArrayWithFirstMenu:[_firstMenuList objectAtIndex:number] ];
    
#pragma mark maybe add last view object
    
    
    [_carousel reloadData];
    [_segmentControl reloadSegsWithItems:_sousMenuList];
    
}
#pragma mark dish data setting
/**
 *  setup all the data(dishnames)
 */
-(void) setDishArrayWithFirstMenu : (MDFirstMenu*)firstMenu{
    
    //set dish data
    _sousMenuList = [[MDMenuHelper shared] getSecondeMenuNamesWithFirstMenu:firstMenu];
    
    
    
    //初始化字典
    _dishDictionary = [NSMutableDictionary dictionaryWithCapacity: [[firstMenu secondeMenu_list] count] ];
    
    
    
    
    //先阶段设置死不同的菜单
    
    
    
    for (MDSecondMenu* secondMenu in [firstMenu secondeMenu_list]) {
        [_dishDictionary setValue:secondMenu forKey:secondMenu.name];
    }
    
    //     NSArray *allDishs = [NSArray arrayWithObjects:@"angry_birds_cake.jpg", @"creme_brelee.jpg", @"egg_benedict.jpg", @"full_breakfast.jpg", @"green_tea.jpg", @"ham_and_cheese_panini.jpg", @"ham_and_egg_sandwich.jpg", @"hamburger.jpg", @"instant_noodle_with_egg.jpg", @"japanese_noodle_with_pork.jpg", @"mushroom_risotto.jpg", @"noodle_with_bbq_pork.jpg", @"starbucks_coffee.jpg", @"thai_shrimp_cake.jpg", @"vegetable_curry.jpg", @"white_chocolate_donut.jpg", nil];
    //
    //
    //    NSArray *dessertArray = [NSArray arrayWithObjects:@"angry_birds_cake.jpg", @"creme_brelee.jpg",@"white_chocolate_donut.jpg",nil];
    //    NSArray *mainPlatArray = [NSArray arrayWithObjects:@"egg_benedict.jpg", @"full_breakfast.jpg", @"green_tea.jpg", @"ham_and_cheese_panini.jpg", @"ham_and_egg_sandwich.jpg", @"hamburger.jpg", @"instant_noodle_with_egg.jpg", @"japanese_noodle_with_pork.jpg", @"mushroom_risotto.jpg", @"noodle_with_bbq_pork.jpg", @"thai_shrimp_cake.jpg", @"vegetable_curry.jpg",nil ];
    //
    //    NSArray *drinkArray = [NSArray arrayWithObjects:@"starbucks_coffee.jpg",nil];
    //
    //
    //    [_dishDictionary setValue:allDishs forKey:@"tout"];
    //
    //    [_dishDictionary setValue:dessertArray forKey:@"Hamburgers"];
    //
    //    [_dishDictionary setValue:mainPlatArray forKey:@"Poissons"];
    //
    //
    //    [_dishDictionary setValue:drinkArray forKey:@"Viande"];
    
    
}

#pragma mark carousel 设置


- (NSInteger)numberOfItemsInCarousel:(iCarousel *)carousel
{
    return _sousMenuList.count;
}


- (UIView *)carousel:(iCarousel *)carousel viewForItemAtIndex:(NSInteger)index reusingView:(UIView *)view
{
    
    MDDishView *listView = nil;
    
    if (view == nil)
    {
        view = [[UIView alloc] initWithFrame:carousel.bounds];
        listView = [[MDDishView alloc] initWithFrame:view.bounds];
        listView.tag = 1;
        listView.parentNavigationController = [self navigationController];
        //listView.delegate = self;
        [view addSubview:listView];
        
    }else{
        
        listView = (MDDishView *)[view viewWithTag:1];
        listView.parentNavigationController = [self navigationController];
    }
    
    MDSecondMenu* secondMenu =[_dishDictionary objectForKey:[_sousMenuList objectAtIndex:index]];
    
    [listView loadCollectionViewWithData:[secondMenu dish_list]];
    
    
    
    return  view;
    
    
}

- (void)carouselDidScroll:(iCarousel *)carousel
{
    if (_segmentControl) {
        
        float offset = carousel.scrollOffset;
        
        if (offset > 0) {
            
            [_segmentControl moveIndexWithProgress:offset];
        }
    }
}

- (void)carouselDidEndScrollingAnimation:(iCarousel *)carousel
{
    if (_segmentControl) {
        
        [_segmentControl endMoveIndex:carousel.currentItemIndex];
    }
}
- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
