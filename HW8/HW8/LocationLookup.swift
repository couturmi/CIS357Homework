//
//  LocationLookup.swift
//  HW8
//
//  Created by X Code User on 10/30/17.
//  Copyright © 2017 CouturierCrowe. All rights reserved.
//

import Foundation

struct LocationLookup {
    var origLat:Double
    var origLng:Double
    var destLat:Double
    var destLng:Double
    var timestamp:Date
    
    init(origLat:Double, origLng:Double, destLat:Double, destLng:Double, timestamp:Date) {
        self.origLat = origLat
        self.origLng = origLng
        self.destLat = destLat
        self.destLng = destLng
        self.timestamp = timestamp
    }
}
