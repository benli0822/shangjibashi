//
//  MDMapViewController.h
//  Diancai
//
//  Created by james on 02/02/15.
//  Copyright (c) 2015 Xiaojun. All rights reserved.
//

#import <MapKit/MapKit.h>
#import <CoreLocation/CoreLocation.h>
#import <UIKit/UIKit.h>

@interface MDMapViewController : UIViewController
@property (weak, nonatomic) IBOutlet MKMapView *mapView;
@property (strong,nonatomic) MKRoute *currentRoute;
@property (strong,nonatomic) CLLocationManager* locationManager;
@property (strong,nonatomic) MKPolyline *routeOverlay;
@property (weak, nonatomic) IBOutlet UIActivityIndicatorView *activityIndicator;


@end
