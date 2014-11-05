//
//  MenuViewController.m
//  Diancai
//
//  Created by james on 22/09/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//



//为了实现转动切换标签效果我可能要用 https://github.com/nicklockwood/iCarousel


#import "MenuViewController.h"
#import "iCarousel.h"
#import "XTSegmentControl.h"
#import "DishView.h"

//

@interface MenuViewController ()<iCarouselDataSource,iCarouselDelegate>
@property (nonatomic , strong) XTSegmentControl *segmentControl;
@property (nonatomic , strong) iCarousel *carousel;

@end

@implementation MenuViewController
@synthesize  MenuDishCollectionViewController = _MenuDishCollectionViewController;

@synthesize carousel = _carousel;
@synthesize segmentControl = _segmentControl;
@synthesize dishDictionary = _dishDictionary;


- (void)viewDidLoad {
    [super viewDidLoad];
 
    [self initDishArray];
    
    //关闭ios7以上后退手势
    if ([self.navigationController respondsToSelector:@selector(interactivePopGestureRecognizer)]) {
        self.navigationController.interactivePopGestureRecognizer.enabled = NO;
    }
    
    _carousel = [[iCarousel alloc] initWithFrame:CGRectMake(172, 112+36, 780, 600)];
    _carousel.backgroundColor = [UIColor whiteColor];
    _carousel.dataSource = self;
    _carousel.delegate = self;
    _carousel.decelerationRate = 0.7;
    _carousel.type = iCarouselTypeLinear;
    _carousel.pagingEnabled = YES;
    //_carousel.edgeRecognition = YES;
    //solve overflowing problem
    _carousel.clipsToBounds = YES;
    
    _carousel.bounceDistance = 0.4;
    [self.view addSubview:_carousel];
    
    
#pragma mark carousel 头设置
        
    __weak typeof(_carousel) weakCarousel = _carousel;
    
    _segmentControl = [[XTSegmentControl alloc] initWithFrame:CGRectMake(175, 112, 780, 36) Items:_sousMenuList selectedBlock:^(NSInteger index) {
        
        [weakCarousel scrollToItemAtIndex:index animated:NO];
    }];
    
    [self.view addSubview:_segmentControl];



    
    
    
    //[_ColletionView registerNib:[UINib nibWithNibName:@"DishCollectionViewCell" bundle:[NSBundle mainBundle]] forCellWithReuseIdentifier:@"Cell"];
    
    //[_ColletionView setDelegate:self.MenuDishCollectionViewController];
    //[_ColletionView setDataSource:self.MenuDishCollectionViewController];
   

}

#pragma mark dish data 设置
/**
 *  setup all the data(dishnames)
 */
-(void) initDishArray{
    NSArray *allDishs = [NSArray arrayWithObjects:@"angry_birds_cake.jpg", @"creme_brelee.jpg", @"egg_benedict.jpg", @"full_breakfast.jpg", @"green_tea.jpg", @"ham_and_cheese_panini.jpg", @"ham_and_egg_sandwich.jpg", @"hamburger.jpg", @"instant_noodle_with_egg.jpg", @"japanese_noodle_with_pork.jpg", @"mushroom_risotto.jpg", @"noodle_with_bbq_pork.jpg", @"starbucks_coffee.jpg", @"thai_shrimp_cake.jpg", @"vegetable_curry.jpg", @"white_chocolate_donut.jpg", nil];
    
    NSLog(@"try to init dict");
    
    _sousMenuList = @[@"全部",@"甜点",@"正餐",@"饮料"];
    
    
    
    //初始化字典
    _dishDictionary = [NSMutableDictionary dictionaryWithCapacity:10];
    
    
    
    
    //先阶段设置死4个不同的菜单
    NSArray *dessertArray = [NSArray arrayWithObjects:@"angry_birds_cake.jpg", @"creme_brelee.jpg",@"white_chocolate_donut.jpg",nil];
    NSArray *mainPlatArray = [NSArray arrayWithObjects:@"egg_benedict.jpg", @"full_breakfast.jpg", @"green_tea.jpg", @"ham_and_cheese_panini.jpg", @"ham_and_egg_sandwich.jpg", @"hamburger.jpg", @"instant_noodle_with_egg.jpg", @"japanese_noodle_with_pork.jpg", @"mushroom_risotto.jpg", @"noodle_with_bbq_pork.jpg", @"thai_shrimp_cake.jpg", @"vegetable_curry.jpg",nil ];
    
    NSArray *drinkArray = [NSArray arrayWithObjects:@"starbucks_coffee.jpg",nil];
    
    
    [_dishDictionary setValue:allDishs forKey:@"全部"];

    [_dishDictionary setValue:dessertArray forKey:@"甜点"];
    
    [_dishDictionary setValue:mainPlatArray forKey:@"正餐"];
    
    
    [_dishDictionary setValue:drinkArray forKey:@"饮料"];
    
    
}

#pragma mark carousel 设置


- (NSInteger)numberOfItemsInCarousel:(iCarousel *)carousel
{
    return _sousMenuList.count;
}


- (UIView *)carousel:(iCarousel *)carousel viewForItemAtIndex:(NSInteger)index reusingView:(UIView *)view
{    
   
    DishView *listView = nil;
    
    if (view == nil)
    {
        view = [[UIView alloc] initWithFrame:carousel.bounds];
        listView = [[DishView alloc] initWithFrame:view.bounds];//修改此处的类型
        listView.tag = 1;
        //listView.delegate = self;
        [view addSubview:listView];
        
    }else{
        
        listView = (DishView *)[view viewWithTag:1];
    }
    
    [listView loadCollectionViewWithArray:[_dishDictionary objectForKey:[_sousMenuList objectAtIndex:index]]];

    
    
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
