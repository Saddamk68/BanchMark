package com.example.saddam.banchmark;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();;

    private int[] array;
    private int size;

    private GridLayout gridLayoutId;

    private RadioGroup radioGroupId;
    private RadioButton rbtnSelected;
    private EditText etEnterArraySize;
    private TextView tvArrayGenerated;

    private TextView tvBubbleTime;
    private TextView tvSelectionTime;
    private TextView tvInsertionTime;
    private TextView tvMergeTime;
    private TextView tvHeapTime;
    private TextView tvQuickTime;

    private Button btnBubble;
    private Button btnSelection;
    private Button btnInsertion;
    private Button btnMerge;
    private Button btnHeap;
    private Button btnQuick;
    private Button btnBenchmark;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridLayoutId = (GridLayout) findViewById(R.id.gridLayout);

        etEnterArraySize = (EditText) findViewById(R.id.etEnterSize);
        tvArrayGenerated = (TextView) findViewById(R.id.tvGeneratedArray);

        tvBubbleTime = (TextView) findViewById(R.id.tvBubbleTime);
        tvSelectionTime = (TextView) findViewById(R.id.tvSelectionTime);
        tvInsertionTime = (TextView) findViewById(R.id.tvInsertionTime);
        tvMergeTime = (TextView) findViewById(R.id.tvMergeTime);
        tvHeapTime = (TextView) findViewById(R.id.tvHeapTime);
        tvQuickTime = (TextView) findViewById(R.id.tvQuickTime);

        btnBubble = (Button) findViewById(R.id.btnBubble);
        btnInsertion = (Button) findViewById(R.id.btnInsertion);
        btnSelection  = (Button) findViewById(R.id.btnSelection);
        btnMerge = (Button) findViewById(R.id.btnMerge);
        btnHeap = (Button) findViewById(R.id.btnHeap);
        btnQuick  = (Button) findViewById(R.id.btnQuick);
        btnBenchmark  = (Button) findViewById(R.id.btnBenchmark);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(1,1,1,"Setting");
        menu.add(1,2,1,"Help");
        menu.add(1,3,1,"About");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case 1:
                Toast.makeText(getBaseContext(),"Setting",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(getBaseContext(),"Help",Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(getBaseContext(),"About",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //generating the array of given size
    public void genArray(View view) {

        Log.i(TAG, "We r inside genArray");

        radioGroupId = (RadioGroup)findViewById(R.id.radioGroup);
        int radioId = radioGroupId.getCheckedRadioButtonId();
        rbtnSelected = (RadioButton)findViewById(radioId);


        try {
            size = Integer.parseInt(etEnterArraySize.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(getBaseContext(), "Please Enter the size of the Array", Toast.LENGTH_SHORT).show();
            return;
        }
        if (size < 3) {

            Toast.makeText(getBaseContext(), "Please Enter the Valid  size of the Array", Toast.LENGTH_SHORT).show();
            return;
        }
        //making button visible
        gridLayoutId.setVisibility(View.VISIBLE);
        btnBenchmark.setVisibility(View.VISIBLE);

        //setting button Enabled
        btnBubble.setEnabled(true);
        btnInsertion.setEnabled(true);
        btnSelection.setEnabled(true);
        btnMerge.setEnabled(true);
        btnHeap.setEnabled(true);
        btnQuick.setEnabled(true);
        btnBenchmark.setEnabled(true);

        //selecting the Complexcity
        switch(radioId){

            case R.id.rbtnBestCase:
                array = ComplexcitySenario.bestCase(size);
                tvArrayGenerated.setText("Best Case array of size "+size+" is generated");
                break;
            case R.id.rbtnAvgCase:
                array = ComplexcitySenario.averageCase(size);
                tvArrayGenerated.setText("Average Case array of size "+size+" is generated");
                break;
            case R.id.rbtnWorstCase:
                array = ComplexcitySenario.worstCase(size);
                tvArrayGenerated.setText("Worst Case array of size "+size+" is generated");
                break;

        }
    }

    //setting button disabled
    public void disableAll() {

        btnBubble.setEnabled(false);
        btnInsertion.setEnabled(false);
        btnSelection.setEnabled(false);
        btnMerge.setEnabled(false);
        btnHeap.setEnabled(false);
        btnQuick.setEnabled(false);
        btnBenchmark.setEnabled(false);
    }

    //performed the selected sorting algorithm
    public void sortArray(View view) {

        switch(view.getId()) {

            case R.id.btnBubble:
                tvBubbleTime.setText(Double.toString(Sorting.bubbleSort(array.clone())));
                disableAll();
                break;

            case R.id.btnSelection:
                tvSelectionTime.setText(Double.toString(Sorting.selectionSort(array.clone())));
                disableAll();
                break;

            case R.id.btnMerge:
                tvMergeTime.setText(Double.toString(Sorting.mergeSort(array.clone())));
                disableAll();
                break;

            case R.id.btnQuick:
                tvQuickTime.setText(Double.toString(Sorting.quickSort(array.clone())));
                disableAll();
                break;

            case R.id.btnInsertion:
                tvInsertionTime.setText(Double.toString(Sorting.insertionSort(array.clone())));
                disableAll();
                break;

            case R.id.btnHeap:
                tvHeapTime.setText(Double.toString(Sorting.heapSort(array.clone())));
                disableAll();
                break;

            case R.id.btnBenchmark:
                tvBubbleTime.setText(Double.toString(Sorting.bubbleSort(array.clone())));
                tvSelectionTime.setText(Double.toString(Sorting.selectionSort(array.clone())));
                tvInsertionTime.setText(Double.toString(Sorting.insertionSort(array.clone())));
                tvMergeTime.setText(Double.toString(Sorting.mergeSort(array.clone())));
                tvHeapTime.setText(Double.toString(Sorting.heapSort(array.clone())));
                tvQuickTime.setText(Double.toString(Sorting.quickSort(array.clone())));
                disableAll();
                break;
        }
    }

}
