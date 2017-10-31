//
//  HistoryTableViewController.swift
//  HW8
//
//  Created by X Code User on 10/30/17.
//  Copyright © 2017 CouturierCrowe. All rights reserved.
//

import UIKit

protocol HistoryTableViewControllerDelegate {
    func selectEntry(entry: LocationLookup)
}

class HistoryTableViewController: UITableViewController {
    
    var entries : [LocationLookup]?
    var historyDelegate:HistoryTableViewControllerDelegate?
    
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        if let ent = self.entries {
            return ent.count
        } else {
            return 0
        }
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "cellId", for: indexPath)
        if let entry = self.entries?[indexPath.row] {
            //        self.distance.text = "\(String(format: "%.2f",d)) \(distanceUnit)"
            cell.textLabel?.text = "(\(String(format: "%.4f",entry.origLat)), \(String(format: "%.4f",entry.origLng))) (\(String(format: "%.4f",entry.destLat)), \(String(format: "%.4f",entry.destLng)))"
            cell.detailTextLabel?.text = String(describing: entry.timestamp)
        }
        
        return cell
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath){
        if let del = self.historyDelegate{
            let ll = entries![indexPath.row]
            del.selectEntry(entry: ll)
        }
        
        _=self.navigationController?.popViewController(animated: true)
    }

 }
