package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spincat;
    Spinner spinsub;
    Button btngo;
    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spincat = findViewById(R.id.spinnercate);
        spinsub = findViewById(R.id.spinnersub);
        btngo = findViewById(R.id.buttonGo);

        //initialise the arraylist
        alNumbers = new ArrayList<>();

        //get the stirng-array and store as an array
        final String[] strNumber = getResources().getStringArray(R.array.spinnercate);

        //convert array to list and add to the arraylist
        alNumbers.addAll(Arrays.asList(strNumber));

        //create an array adapter using the default spinner layout and the arraylist
        aaNumbers = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alNumbers);

        //bind the arrayadapter to the spinner
        spinsub.setAdapter(aaNumbers);

        spincat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String[] strNumbers;

                switch (position) {

                    case 0:
                        alNumbers.clear();
                        strNumbers = getResources().getStringArray(R.array.spinnersubRP);
                        alNumbers.addAll(Arrays.asList(strNumbers));
                        break;

                    case 1:
                        alNumbers.clear();
                        strNumbers = getResources().getStringArray(R.array.spinnersubSOI);
                        alNumbers.addAll(Arrays.asList(strNumbers));
                        break;
                }
                aaNumbers.notifyDataSetChanged();
            }
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        btngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String post = spinsub.getSelectedItem().toString();
                Intent intent2 = new Intent(getBaseContext(), SecondActivity.class);

                String[][] sites = {
                        {
                            "http://www.rp.edu.sg",
                                "https://www.rp.edu.sg/student-life"
                        },
                        {
                            "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47",
                                "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12"
                        }
                };
                /*if(post.equals("Homepage")) {
                    intent2.putExtra("url", "https://www.rp.edu.sg/");
                } else if(post.equals("Student Life")){
                        intent2.putExtra("url","https://www.rp.edu.sg/student-life");
                } else if(post.equals("DMSD")) {
                    intent2.putExtra("url", "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47");
                }else if(post.equals("DIT")){
                    intent2.putExtra("url", "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12");
                }
                */

                String url = sites[spincat.getSelectedItemPosition()][spinsub.getSelectedItemPosition()];
                intent2.putExtra("url", url);
                startActivity(intent2);
            }
        });
    }
}
