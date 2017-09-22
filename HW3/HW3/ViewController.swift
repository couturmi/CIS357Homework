//
//  ViewController.swift
//  HW3
//
//  Created by Mitchell Couturier on 9/19/17.
//  Copyright © 2017 CouturierCrowe. All rights reserved.
//

import UIKit
import Foundation

class ViewController: UIViewController {
    @IBOutlet weak var latp1: UITextField!
    @IBOutlet weak var latp2: UITextField!
    @IBOutlet weak var longp1: UITextField!
    @IBOutlet weak var longp2: UITextField!
    @IBOutlet weak var distance: UILabel!
    @IBOutlet weak var bearing: UILabel!

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    @IBAction func clearData(_ sender: UIButton) {
        // Clear all text fields and data labels
        self.latp1.text = ""
        self.latp2.text = ""
        self.longp1.text = ""
        self.longp2.text = ""
        self.distance.text = ""
        self.bearing.text = ""
    }

    @IBAction func calculateData(_ sender: Any) {
        // set values
        let latitude1:Double = Double(self.longp1.text!)!
        let latitude2:Double = Double(self.longp2.text!)!
        let longitude1:Double = Double(self.latp1.text!)!
        let longitude2:Double = Double(self.latp2.text!)!
        // set radius of Earth
        let R: Double = 6371.0
        
        // calculate distance
        let dlong = deg2rad(latitude2 - latitude1)
        let dlat = deg2rad(longitude1 - longitude2)
        let a = pow(sin(dlat/2),2) + cos(deg2rad(latitude1)) * cos(deg2rad(latitude2)) * pow(sin(dlong/2),2)
        let c = 2 * atan2(sqrt(a), sqrt(1-a))
        let d = R * c
        
        // calculate bearing
        
        let b = 0
        
        //set data labels
        self.distance.text = "\(String(format: "%.2f",d)) kilometers"
        self.bearing.text = "\(String(format: "%.2f",b)) degrees"
    }
    
    func deg2rad(_ deg: Double) -> Double {
        return deg * (Double.pi / 180)
    }
}

