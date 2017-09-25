//
//  ViewController.swift
//  HW3
//
//  Created by Mitchell Couturier on 9/19/17.
//  Copyright © 2017 CouturierCrowe. All rights reserved.
//

import UIKit
import Foundation
import CoreLocation

class ViewController: UIViewController, SettingsViewControllerDelegate {
    @IBOutlet weak var latp1: UITextField!
    @IBOutlet weak var latp2: UITextField!
    @IBOutlet weak var longp1: UITextField!
    @IBOutlet weak var longp2: UITextField!
    @IBOutlet weak var distance: UILabel!
    @IBOutlet weak var bearing: UILabel!
    
    var distanceUnit: String = ""
    var bearingUnit: String = ""

    override func viewDidLoad() {
        super.viewDidLoad()
        let detectTouch = UITapGestureRecognizer(target: self, action: #selector(self.dismissKB))
        self.view.addGestureRecognizer(detectTouch)
        
        distanceUnit = "kilometers"
        bearingUnit = "degrees"
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    // implements the settings delegate
    func settingsChanged(distanceUnits: String, bearingUnits: String){
        self.distanceUnit = distanceUnits
        self.bearingUnit = bearingUnits
        calculateData(UIStoryboardSegue.self)
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "segueToSettings" {
            if let dest = segue.destination.childViewControllers[0] as? SettingsViewController {
                dest.delegate = self
            }
        }
    }

    @IBAction func clearData(_ sender: UIButton) {
        self.dismissKB()
        // Clear all text fields and data labels
        self.latp1.text = ""
        self.latp2.text = ""
        self.longp1.text = ""
        self.longp2.text = ""
        self.distance.text = ""
        self.bearing.text = ""
    }

    @IBAction func calculateData(_ sender: Any) {
        self.dismissKB()
        if self.checkIfEmptyValues() {
            self.distance.text = "Please enter data in all fields"
            self.bearing.text = "Please enter data in all fields"
            return
        }
        // set values
        let latitude1:Double = deg2rad(Double(self.latp1.text!)!)
        let latitude2:Double = deg2rad(Double(self.latp2.text!)!)
        let longitude1:Double = deg2rad(Double(self.longp1.text!)!)
        let longitude2:Double = deg2rad(Double(self.longp2.text!)!)
        // set radius of Earth
        let R: Double = 6371.0
        
        // calculate distance
        let dlat = latitude2 - latitude1
        let dlong = longitude2 - longitude1
        let a = pow(sin(dlat/2),2) + cos(latitude1) * cos(latitude2) * pow(sin(dlong/2),2)
        let c = 2 * atan2(sqrt(a), sqrt(1-a))
        var d = R * c
        // convert distance units if necessary
        if distanceUnit == "miles" {
            d = d * 0.621371
        }
        
        // calculate bearing
        let y = sin(dlong) * cos(latitude2)
        let x = cos(latitude1) * sin(latitude2) - sin(latitude1) * cos(latitude2) * cos(dlong)
        var b = atan2(y,x)
        b = rad2deg(b)
        b = (b + 360).truncatingRemainder(dividingBy: 360)
        // convert bearing units if necessary
        if bearingUnit == "mils" {
            b = b * 17.777777
        }
        
        
        //set data labels
        self.distance.text = "\(String(format: "%.2f",d)) \(distanceUnit)"
        self.bearing.text = "\(String(format: "%.2f",b)) \(bearingUnit)"
    }
    
    func checkIfEmptyValues() -> Bool{
        if(self.latp1.text! == ""){
            return true
        }
        if(self.latp2.text! == ""){
            return true
        }
        if(self.longp1.text! == ""){
            return true
        }
        if(self.longp2.text! == ""){
            return true
        }
        return false
    }
    
    func deg2rad(_ deg: Double) -> Double {
        return deg * (Double.pi / 180)
    }
    
    func rad2deg(_ rad: Double) -> Double {
        return rad * (180 / Double.pi)
    }
    
    func dismissKB(){
        self.view.endEditing(true)
    }
    
}

