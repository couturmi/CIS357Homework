package couturier_crowe.android.hw4;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class SettingsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String distanceSelected;
    private String bearingSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        FloatingActionButton saveSettingsButton = (FloatingActionButton) findViewById(R.id.saveSettingsButton);
        /* //The saveSettingsButton.setOnClickListener further below runs better than this.
        saveSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("distances", distanceSelected);
                intent.putExtra("degrees", bearingSelected);
                setResult(CalculateActivity.UNIT_SELECTION, intent);

                finish();
            }
        });
         */

        //set up spinners
        Spinner distanceSpinner = (Spinner) findViewById(R.id.distanceSpinner);
        Spinner bearingSpinner = (Spinner) findViewById(R.id.bearingSpinner);

        ArrayAdapter<CharSequence> distanceAdapter = ArrayAdapter.createFromResource(this, R.array.distances, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> bearingAdapter = ArrayAdapter.createFromResource(this, R.array.bearings, android.R.layout.simple_spinner_item);
        distanceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bearingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        distanceSpinner.setAdapter(distanceAdapter);
        bearingSpinner.setAdapter(bearingAdapter);

        //add button listener
        saveSettingsButton.setOnClickListener(v -> {
            Intent intent = new Intent(SettingsActivity.this, CalculateActivity.class);
            intent.putExtra("distances", distanceSelected);
            intent.putExtra("degrees", bearingSelected);
            startActivity(intent);
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner spinner = (Spinner) parent;
        if(spinner.getId() == R.id.distanceSpinner)
        {
            distanceSelected = (String) parent.getItemAtPosition(position);
        }
        else if(spinner.getId() == R.id.bearingSpinner)
        {
            bearingSelected = (String) parent.getItemAtPosition(position);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //Nothing
    }
}
