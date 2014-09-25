//
//  MenuViewController.m
//  Diancai
//
//  Created by james on 22/09/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import "MenuViewController.h"
#import "MenuCollectionView.h"

@interface MenuViewController ()

@end

@implementation MenuViewController
@synthesize  MenuDishCollectionViewController = _MenuDishCollectionViewController;
@synthesize ColletionView = _ColletionView;

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    //设置背景
       
    self.MenuDishCollectionViewController = [[MenuCollectionView alloc] init];
    //[self.MenuDishCollectionViewController setRecipeImages:[NSArray arrayWithObjects:@"angry_birds_cake.jpg", @"creme_brelee.jpg", @"egg_benedict.jpg", @"full_breakfast.jpg", @"green_tea.jpg", @"ham_and_cheese_panini.jpg", @"ham_and_egg_sandwich.jpg", @"hamburger.jpg", @"instant_noodle_with_egg.jpg", @"japanese_noodle_with_pork.jpg", @"mushroom_risotto.jpg", @"noodle_with_bbq_pork.jpg", @"starbucks_coffee.jpg", @"thai_shrimp_cake.jpg", @"vegetable_curry.jpg", @"white_chocolate_donut.jpg", nil]];
    
    
    self.MenuDishCollectionViewController.recipeImages = [NSArray arrayWithObjects:@"angry_birds_cake.jpg", @"creme_brelee.jpg", @"egg_benedict.jpg", @"full_breakfast.jpg", @"green_tea.jpg", @"ham_and_cheese_panini.jpg", @"ham_and_egg_sandwich.jpg", @"hamburger.jpg", @"instant_noodle_with_egg.jpg", @"japanese_noodle_with_pork.jpg", @"mushroom_risotto.jpg", @"noodle_with_bbq_pork.jpg", @"starbucks_coffee.jpg", @"thai_shrimp_cake.jpg", @"vegetable_curry.jpg", @"white_chocolate_donut.jpg", nil];

    [_ColletionView registerNib:[UINib nibWithNibName:@"DishCollectionViewCell" bundle:[NSBundle mainBundle]] forCellWithReuseIdentifier:@"Cell"];
    [_ColletionView setDelegate:self.MenuDishCollectionViewController];
    [_ColletionView setDataSource:self.MenuDishCollectionViewController];
    
    
    
    NSLog(@"123");
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
