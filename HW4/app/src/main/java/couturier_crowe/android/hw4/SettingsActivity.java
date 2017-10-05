package couturier_crowe.android.hw4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class SettingsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String distanceSelected;
    private String bearingSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Spinner distanceSpinner = (Spinner) findViewById(R.id.distanceSpinner);
        Spinner bearingSpinner = (Spinner) findViewById(R.id.bearingSpinner);
        distanceSpinner.setOnItemSelectedListener(this);
        bearingSpinner.setOnItemSelectedListener(this);

        List<String> distanceOptions = new ArrayList<String>();
        List<String> bearingOptions = new ArrayList<String>();
        distanceOptions.add("Kilometers");
        distanceOptions.add("Miles");
        bearingOptions.add("Degrees");
        bearingOptions.add("Mils");

        distanceSelected = distanceOptions.get(0);
        bearingSelected = bearingOptions.get(0);

        ArrayAdapter<String> distanceAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, distanceOptions);
        ArrayAdapter<String> bearingAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, bearingOptions);
        distanceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bearingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        distanceSpinner.setAdapter(distanceAdapter);
        bearingSpinner.setAdapter(bearingAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //Nothing
    }
}
