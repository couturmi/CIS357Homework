//
//  GeoCalcButton.swift
//  HW6
//
//  Created by X Code User on 10/16/17.
//  Copyright © 2017 CouturierCrowe. All rights reserved.
//

import UIKit

class GeoCalcButton: UIButton {

    override func awakeFromNib() {
        self.backgroundColor = FOREGROUND_COLOR
        self.tintColor = BACKGROUND_COLOR
        self.layer.cornerRadius = 5.0
    }

}
