//
//  MDMapViewController.m
//  Diancai
//
//  Created by james on 02/02/15.
//  Copyright (c) 2015 Xiaojun. All rights reserved.
//

#import "MDMapViewController.h"
@import CoreLocation;

#define IS_OS_8_OR_LATER ([[[UIDevice currentDevice] systemVersion] floatValue] >= 8.0)


@interface MDMapViewController ()<MKMapViewDelegate,CLLocationManagerDelegate>{
}

@end

@implementation MDMapViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    
    self.locationManager = [[CLLocationManager alloc] init];
    self.locationManager.delegate = self;
    // Check for iOS 8. Without this guard the code will crash with "unknown selector" on iOS 7.
    if ([self.locationManager respondsToSelector:@selector(requestWhenInUseAuthorization)]) {
        [self.locationManager requestWhenInUseAuthorization];
    }
    [self.locationManager startUpdatingLocation];
    self.locationManager.pausesLocationUpdatesAutomatically = YES;
    // Do any additional setup after loading the view.
    self.mapView.delegate = self;
     self.activityIndicator.hidden = YES;
    
    
    
    [self setUpMap];
    
 
    
}
- (IBAction)findWayAction:(id)sender {
    [self.locationManager stopUpdatingLocation];
}

//zoom
- (void)setZoomLevel:(NSUInteger)zoomLevel {
    [self setCenterCoordinate:self.mapView.centerCoordinate zoomLevel:zoomLevel animated:NO];
}

- (NSUInteger)zoomLevel {
    return log2(360 * ((self.mapView.frame.size.width/256) / self.mapView.region.span.longitudeDelta)) + 1;
}

- (void)setCenterCoordinate:(CLLocationCoordinate2D)centerCoordinate
                  zoomLevel:(NSUInteger)zoomLevel animated:(BOOL)animated {
    MKCoordinateSpan span = MKCoordinateSpanMake(0, 360/pow(2, zoomLevel)*self.mapView.frame.size.width/256);
    [self.mapView setRegion:MKCoordinateRegionMake(centerCoordinate, span) animated:animated];
}
//end zoom
// Location Manager Delegate Methods
- (void)locationManager:(CLLocationManager *)manager didUpdateLocations:(NSArray *)locations
{
    
}
- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

-(void) setUpMap{
    //@50.6142967,3.1413188,12z
    
    
    self.activityIndicator.hidden = NO;
    [self.activityIndicator startAnimating];
    
    
    // Make a directions request
    MKDirectionsRequest *directionsRequest = [MKDirectionsRequest new];
    // Start at our current location
    MKMapItem *source = [MKMapItem mapItemForCurrentLocation];
    [directionsRequest setSource:source];
    // Make the destination
    CLLocationCoordinate2D destinationCoords = CLLocationCoordinate2DMake(50.6142967, 3.1413188);
    MKPlacemark *destinationPlacemark = [[MKPlacemark alloc] initWithCoordinate:destinationCoords addressDictionary:nil];
    MKMapItem *destination = [[MKMapItem alloc] initWithPlacemark:destinationPlacemark];
    
    [directionsRequest setDestination:destination];
    
    MKDirections *directions = [[MKDirections alloc] initWithRequest:directionsRequest];
    [directions calculateDirectionsWithCompletionHandler:^(MKDirectionsResponse *response, NSError *error) {
        // We're done
        self.activityIndicator.hidden = YES;
        [self.activityIndicator stopAnimating];
        //self.routeButton.enabled = YES;
        
        // Now handle the result
        if (error) {
            NSLog(@"There was an error getting your directions");
            return;
        }
        
        // So there wasn't an error - let's plot those routes
        //self.routeDetailsButton.enabled = YES;
        //self.routeDetailsButton.hidden = NO;
        _currentRoute = [response.routes firstObject];
        [self plotRouteOnMap:_currentRoute];
        
        //zoom
        [self setCenterCoordinate:self.mapView.userLocation.location.coordinate zoomLevel:13 animated:YES];
           }];
}

- (MKOverlayRenderer *)mapView:(MKMapView *)mapView rendererForOverlay:(id<MKOverlay>)overlay
{
    MKPolylineRenderer *renderer = [[MKPolylineRenderer alloc] initWithPolyline:overlay];
    renderer.strokeColor = [UIColor redColor];
    renderer.lineWidth = 4.0;
    return  renderer;
}

- (void)plotRouteOnMap:(MKRoute *)route
{
    if(_routeOverlay) {
        [self.mapView removeOverlay:_routeOverlay];
    }
    
    // Update the ivar
    _routeOverlay = route.polyline;
    
    // Add it to the map
    [self.mapView addOverlay:_routeOverlay];
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
