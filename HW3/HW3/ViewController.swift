//
//  ViewController.swift
//  HW3
//
//  Created by Mitchell Couturier on 9/19/17.
//  Copyright © 2017 CouturierCrowe. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var latp1: UITextField!
    @IBOutlet weak var latp2: UITextField!
    @IBOutlet weak var longp1: UITextField!
    @IBOutlet weak var longp2: UITextField!

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    @IBAction func clearData(_ sender: UIButton) {
        // Clear all text fields
        self.latp1.text = ""
        self.latp2.text = ""
        self.longp1.text = ""
        self.longp2.text = ""
    }

}

