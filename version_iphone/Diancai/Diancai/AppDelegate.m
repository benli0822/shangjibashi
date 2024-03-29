//
//  AppDelegate.m
//  Diancai
//
//  Created by james on 01/02/15.
//  Copyright (c) 2015 Xiaojun. All rights reserved.
//

#import "AppDelegate.h"
#import "SQLiteManager.h"

@interface AppDelegate ()

@end

@implementation AppDelegate


- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {
    
    
    // Override point for customization after application launch.
    
    //load sqlite data
    //[[SQLiteManager shared] getTestReadDataFromDB];
    
    UITabBarController *tabBarController = (UITabBarController *)self.window.rootViewController;
    
    
    [tabBarController.tabBar setTintColor:[UIColor colorWithRed:237.0/255.0 green:85.0/255.0 blue:56.0/255.0 alpha:1]];
    
    UIImage *homeImage = [UIImage imageNamed:@"menu"];
    [homeImage imageWithRenderingMode:UIImageRenderingModeAlwaysOriginal];
    ((UITabBarItem *)tabBarController.tabBar.items[0]).image = homeImage;
    ((UITabBarItem *)tabBarController.tabBar.items[0]).selectedImage = homeImage;
    
    UIImage *reserveImage = [UIImage imageNamed:@"reserve"];
    [reserveImage imageWithRenderingMode:UIImageRenderingModeAlwaysOriginal];
    ((UITabBarItem *)tabBarController.tabBar.items[1]).image = reserveImage;
    ((UITabBarItem *)tabBarController.tabBar.items[1]).selectedImage = reserveImage;
    
    
    
    UIImage *menuImage = [UIImage imageNamed:@"menu"];
    [menuImage imageWithRenderingMode:UIImageRenderingModeAlwaysOriginal];
    
    ((UITabBarItem *)tabBarController.tabBar.items[2]).image = menuImage;
    
    ((UITabBarItem *)tabBarController.tabBar.items[2]).selectedImage = menuImage;

    
    UIImage *map = [UIImage imageNamed:@"map"];
    [map imageWithRenderingMode:UIImageRenderingModeAlwaysOriginal];
    
    ((UITabBarItem *)tabBarController.tabBar.items[3]).image = map;
    
    ((UITabBarItem *)tabBarController.tabBar.items[3]).selectedImage = map;
    
  
    
    UIImage *settingImage = [UIImage imageNamed:@"settings"];
    [settingImage imageWithRenderingMode:UIImageRenderingModeAlwaysOriginal];
    
    ((UITabBarItem *)tabBarController.tabBar.items[4]).image = settingImage;
    
    ((UITabBarItem *)tabBarController.tabBar.items[4]).selectedImage = settingImage;

    
    return YES;
}

- (void)applicationWillResignActive:(UIApplication *)application {
    // Sent when the application is about to move from active to inactive state. This can occur for certain types of temporary interruptions (such as an incoming phone call or SMS message) or when the user quits the application and it begins the transition to the background state.
    // Use this method to pause ongoing tasks, disable timers, and throttle down OpenGL ES frame rates. Games should use this method to pause the game.
}

- (void)applicationDidEnterBackground:(UIApplication *)application {
    // Use this method to release shared resources, save user data, invalidate timers, and store enough application state information to restore your application to its current state in case it is terminated later.
    // If your application supports background execution, this method is called instead of applicationWillTerminate: when the user quits.
}

- (void)applicationWillEnterForeground:(UIApplication *)application {
    // Called as part of the transition from the background to the inactive state; here you can undo many of the changes made on entering the background.
}

- (void)applicationDidBecomeActive:(UIApplication *)application {
    // Restart any tasks that were paused (or not yet started) while the application was inactive. If the application was previously in the background, optionally refresh the user interface.
}

- (void)applicationWillTerminate:(UIApplication *)application {
    // Called when the application is about to terminate. Save data if appropriate. See also applicationDidEnterBackground:.
}

@end
