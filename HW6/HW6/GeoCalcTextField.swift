//
//  GeoCalcTextField.swift
//  HW6
//
//  Created by X Code User on 10/16/17.
//  Copyright © 2017 CouturierCrowe. All rights reserved.
//

import UIKit

class GeoCalcTextField: DecimalMinusTextField {

    override func awakeFromNib() {
        self.backgroundColor = UIColor.clear
        self.layer.borderWidth = 1.0
        self.layer.borderColor = FOREGROUND_COLOR.cgColor
        self.layer.cornerRadius = 5.0
        self.textColor = FOREGROUND_COLOR
        
        guard let ph = self.placeholder else {
            return
        }
        
        self.attributedPlaceholder = NSAttributedString(string: ph, attributes: [NSForegroundColorAttributeName : FOREGROUND_COLOR])
    }

}
