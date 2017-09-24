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
            distUnit.text = dUnits[row]
        }
        else {
            bearUnit.text = bUnits[row]
        }
    }

    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
