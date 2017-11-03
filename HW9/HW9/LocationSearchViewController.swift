//
//  LocationSearchViewController.swift
//  HW9
//
//  Created by X Code User on 11/3/17.
//  Copyright © 2017 CouturierCrowe. All rights reserved.
//

import UIKit
import Eureka
import GooglePlacePicker

class LocationSearchViewController: FormViewController {
    
    var startPoint:GMSPlace?
    var endPoint:GMSPlace?
    var selectedPoint: Int = 0
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
}
