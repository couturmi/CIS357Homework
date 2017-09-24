//
//  SettingsViewController.swift
//  HW3
//
//  Created by X Code User on 9/24/17.
//  Copyright © 2017 CouturierCrowe. All rights reserved.
//

import UIKit

class SettingsViewController: UIViewController, UIPickerViewDelegate, UIPickerViewDataSource {
    
    @IBOutlet weak var distPicker: UIPickerView!
    @IBOutlet weak var bearPicker: UIPickerView!
    
    @IBOutlet weak var distUnit: UILabel!
    @IBOutlet weak var bearUnit: UILabel!
    
    let dUnits = ["kilometers", "miles"]
    let bUnits = ["degrees", "mils"]
    
    var selectedDist: String!
    var selectedBear: String!
    
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        if pickerView == distPicker {
            return dUnits[row]
        }
        else {
            return bUnits[row]
        }
    }
    
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        if pickerView == distPicker {
            return dUnits.count
        }
        else {
            return bUnits.count
        }
    }
    
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        if pickerView == distPicker {
            selectedDist = dUnits[row]
            distUnit.text = selectedDist
        }
        else {
            selectedBear = bUnits[row]
            bearUnit.text = selectedBear
        }
    }
    
    func returnDistanceUnit() -> String {
        return selectedDist
    }

    func returnBearingUnit() -> String {
        return selectedBear
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        selectedDist = "kilometers"
        distUnit.text = selectedDist
        selectedBear = "degrees"
        bearUnit.text = selectedBear
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
}
