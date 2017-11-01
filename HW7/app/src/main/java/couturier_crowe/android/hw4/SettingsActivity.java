package couturier_crowe.android.hw4;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class SettingsActivity extends AppCompatActivity {

    private String distanceSelected;
    private String bearingSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        distanceSelected = getResources().getStringArray(R.array.distances)[0];
        bearingSelected = getResources().getStringArray(R.array.bearings)[0];

        FloatingActionButton saveSettingsButton = (FloatingActionButton) findViewById(R.id.saveSettingsButton);

        //set up spinners
        Spinner distanceSpinner = (Spinner) findViewById(R.id.distanceSpinner);
        Spinner bearingSpinner = (Spinner) findViewById(R.id.bearingSpinner);

        ArrayAdapter<CharSequence> distanceAdapter = ArrayAdapter.createFromResource(this, R.array.distances, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> bearingAdapter = ArrayAdapter.createFromResource(this, R.array.bearings, android.R.layout.simple_spinner_item);
        distanceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bearingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        distanceSpinner.setAdapter(distanceAdapter);
        bearingSpinner.setAdapter(bearingAdapter);

        distanceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                distanceSelected = (String) parent.getItemAtPosition(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        bearingSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bearingSelected = (String) parent.getItemAtPosition(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        //add button listener
        saveSettingsButton.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("distance", distanceSelected);
            intent.putExtra("bearing", bearingSelected);
            setResult(CalculateActivity.UNIT_SELECTION,intent);
            finish();
        });

    }
}
