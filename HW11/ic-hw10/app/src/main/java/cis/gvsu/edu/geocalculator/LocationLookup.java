package cis.gvsu.edu.geocalculator;

import org.parceler.Parcel;

/**
 * Created by engeljo on 3/30/17.
 */

@Parcel
public class LocationLookup {
    double origLat;
    double origLng;
    double endLat;
    double endLng;
    String _key;
    String timestamp;

    public double getOrigLat() {
        return origLat;
    }

    public void setOrigLat(double origLat) {
        this.origLat = origLat;
    }

    public double getOrigLng() {
        return origLng;
    }

    public void setOrigLng(double origLng) {
        this.origLng = origLng;
    }

    public double getEndLat() {
        return endLat;
    }

    public void setEndLat(double endLat) {
        this.endLat = endLat;
    }

    public double getEndLng() {
        return endLng;
    }

    public void setEndLng(double endLng) {
        this.endLng = endLng;
    }

    public String get_key() {
        return _key;
    }

    public void set_key(String _key) {
        this._key = _key;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
