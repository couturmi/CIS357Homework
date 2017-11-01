//
//  SettingsViewController.swift
//  HW3
//
//  Created by X Code User on 9/24/17.
//  Copyright © 2017 CouturierCrowe. All rights reserved.
//

import UIKit

protocol SettingsViewControllerDelegate {
    func settingsChanged(distanceUnits: String, bearingUnits: String)
}

class SettingsViewController: UIViewController {
    
    @IBOutlet weak var distPicker: UIPickerView!
    @IBOutlet weak var bearPicker: UIPickerView!
    
    @IBOutlet weak var distUnit: UILabel!
    @IBOutlet weak var bearUnit: UILabel!
    
    let dUnits = ["kilometers", "miles"]
    let bUnits = ["degrees", "mils"]
    
    var selectedDist: String!
    var selectedBear: String!
    
    var delegate : SettingsViewControllerDelegate?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        selectedDist = "kilometers"
        distUnit.text = selectedDist
        selectedBear = "degrees"
        bearUnit.text = selectedBear
        
        self.distPicker.delegate = self
        self.distPicker.dataSource = self
        self.distPicker.isHidden = true
        self.bearPicker.delegate = self
        self.bearPicker.dataSource = self
        self.bearPicker.isHidden = true
        
        // add gesture recognizers
        self.distUnit.isUserInteractionEnabled = true
        self.bearUnit.isUserInteractionEnabled = true
        let distancePickerSelected = UITapGestureRecognizer(target: self, action: #selector(self.toggleDistPicker))
        let bearingPickerSelected = UITapGestureRecognizer(target: self, action: #selector(self.toggleBearPicker))
        self.distUnit.addGestureRecognizer(distancePickerSelected)
        self.bearUnit.addGestureRecognizer(bearingPickerSelected)
        
        let detectTouch = UITapGestureRecognizer(target: self, action: #selector(self.hidePickers))
        self.view.addGestureRecognizer(detectTouch)
    }
    
    // cancel button pressed
    @IBAction func cancelButtonPress(_ sender: UIBarButtonItem){
        self.dismiss(animated: true, completion: nil)
    }
    
    // save button pressed
    @IBAction func saveButtonPress(_ sender: UIBarButtonItem){
        if let d = self.delegate {
            d.settingsChanged(distanceUnits: selectedDist, bearingUnits: selectedBear)
        }
        self.dismiss(animated: true, completion: nil)
    }
    
//    override func viewWillDisappear(_ animated: Bool) {
//        print("view disappeared")
//        super.viewWillDisappear(animated)
//        if let d = self.delegate {
//            d.settingsChanged(distanceUnits: selectedDist, bearingUnits: selectedBear)
//        }
//    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func toggleDistPicker() {
        self.distPicker.isHidden = !self.distPicker.isHidden
        self.bearPicker.isHidden = true
    }
    
    func toggleBearPicker() {
        self.bearPicker.isHidden = !self.bearPicker.isHidden
        self.distPicker.isHidden = true
    }
    
    func hidePickers() {
        self.distPicker.isHidden = true
        self.bearPicker.isHidden = true
    }
    
    
}

extension SettingsViewController : UIPickerViewDataSource, UIPickerViewDelegate {
    
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
    
}

