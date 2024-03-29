//
//  MenuViewController.m
//  Diancai
//
//  Created by james on 22/09/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//



//为了实现转动切换标签效果我可能要用 https://github.com/nicklockwood/iCarousel


#import "MDMenuViewController.h"
#import "iCarousel.h"
#import "XTSegmentControl.h"
#import "MDDishView.h"
#import "MDFirstMenuTableController.h"
#import "MDListCommandViewController.h"
#import "MDCommand.h"
#import "SQLiteManager.h"
#import "MDMenuHelper.h"
#import "MDFirstMenu.h"
#import "MDSecondMenu.h"

//

@interface MDMenuViewController ()<iCarouselDataSource,iCarouselDelegate>
@property (nonatomic , strong) XTSegmentControl *segmentControl;
@property (nonatomic , strong) iCarousel *carousel;

@end

@implementation MDMenuViewController


@synthesize carousel = _carousel;
@synthesize segmentControl = _segmentControl;
@synthesize dishDictionary = _dishDictionary;
@synthesize firstMenuTableViewController = _firstMenuTableViewController;
@synthesize firstMenuTableController = _firstMenuTableController;

- (void)viewDidLoad {
    [super viewDidLoad];
    
    
#pragma mark read data section
    _firstMenuList = [[NSMutableArray alloc] initWithArray:[[SQLiteManager shared] readAllDataFromDB]];
    [[MDMenuHelper shared] setFirstMenu_list:_firstMenuList];

    [self setDishArrayWithFirstMenu:[_firstMenuList objectAtIndex:2]];

    
 
    //[self initDishArray];
    
    //DISABLE GESTURE
    if ([self.navigationController respondsToSelector:@selector(interactivePopGestureRecognizer)]) {
        self.navigationController.interactivePopGestureRecognizer.enabled = NO;
    }
    
    _carousel = [[iCarousel alloc] initWithFrame:CGRectMake(195, 112+46, 800, 620)];
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
    
    _segmentControl = [[XTSegmentControl alloc] initWithFrame:CGRectMake(212, 102, 800, 46) Items:_sousMenuList selectedBlock:^(NSInteger index) {
        
        [weakCarousel scrollToItemAtIndex:index animated:NO];
    }];
    
    [self.view addSubview:_segmentControl];

    

#pragma mark first menu table setting
    
    [self.firstMenuTableViewController registerNib:[UINib nibWithNibName:@"MDFirstMenuTableCell"
                                               bundle:[NSBundle mainBundle]]
         forCellReuseIdentifier:@"Cell"];
    
    _firstMenuTableController = [[MDFirstMenuTableController alloc] init];
    
    
    _firstMenuTableController.data = [[MDMenuHelper shared] getAllFirstMenuNames];
    
    _firstMenuTableViewController.separatorColor = [UIColor clearColor];
    [_firstMenuTableViewController setDataSource:self.firstMenuTableController];
    [_firstMenuTableViewController setDelegate:self.firstMenuTableController];
    [_firstMenuTableController setParentViewController:self];
    
    
    //set section
    NSIndexPath *indexPath=[NSIndexPath indexPathForRow:2 inSection:0];
    [_firstMenuTableViewController selectRowAtIndexPath:indexPath animated:YES  scrollPosition:UITableViewScrollPositionBottom];
    
    
#pragma mark command list table setting
    
    self.navigationController.navigationBar.barTintColor = [UIColor colorWithRed:237.0/255.0 green:85.0/255.0 blue:56.0/255.0 alpha:1];
    self.navigationController.navigationBar.tintColor = [UIColor whiteColor];
    
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
        //listView.delegate = self;
        [view addSubview:listView];
        
    }else{
        
        listView = (MDDishView *)[view viewWithTag:1];
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


#pragma mark display menu
- (IBAction)showCommand:(id)sender {
    
    UIButton *button = (UIButton *)sender;
    
    CGRect rect = CGRectMake(button.frame.origin.x - 390.0,button.frame.origin.y + 10.0, 500, 660);
    MDListCommandViewController *PopoverView = [[MDListCommandViewController alloc]initWithNibName:@"MDListCommandViewController" bundle:nil];
    
    UIPopoverController *popOver =[[UIPopoverController alloc] initWithContentViewController:PopoverView];
    [popOver presentPopoverFromRect:rect inView:self.view permittedArrowDirections:0 animated:YES];
}





@end
