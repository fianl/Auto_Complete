package com.mine_series.kkc.autocompletetest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ArrayList<TempData> list = new ArrayList<TempData>();
        list.add(new TempData("groceries", "processed food", "processed food", ""));
        list.add(new TempData("groceries", "processed food", "ice", ""));
        list.add(new TempData("groceries", "processed food", "beverage", "beverage"));
        list.add(new TempData("groceries", "processed food", "beverage", "health drink"));
        list.add(new TempData("groceries", "processed food", "water", ""));
        list.add(new TempData("groceries", "processed food", "mineral water", ""));
        list.add(new TempData("groceries", "processed food", "milk", "milk"));
        list.add(new TempData("groceries", "processed food", "milk", "milk product"));
        list.add(new TempData("groceries", "processed food", "tea,coffee", "tea"));
        list.add(new TempData("groceries", "processed food", "tea,coffee", "coffee"));
        list.add(new TempData("groceries", "processed food", "tea,coffee", "green tea"));
        list.add(new TempData("groceries", "processed food", "tea,coffee", "chinese tea"));
        list.add(new TempData("groceries", "processed food", "tea,coffee", "brewed coffee"));
        list.add(new TempData("groceries", "processed food", "liquor", "liquor"));
        list.add(new TempData("groceries", "processed food", "liquor", "beer"));
        list.add(new TempData("groceries", "processed food", "liquor", "soju"));
        list.add(new TempData("groceries", "processed food", "liquor", "maggolli"));
        list.add(new TempData("groceries", "processed food", "liquor", "traditional liquor"));
        list.add(new TempData("groceries", "processed food", "liquor", "wine"));
        list.add(new TempData("groceries", "processed food", "liquor", "japanese liquor"));
        list.add(new TempData("groceries", "processed food", "liquor", "whisky"));

        ArrayList<String> data = new ArrayList<String>();

        for(int i=0; i<list.size(); i++)
        {
            data.add(list.get(i).makeWillBeFilteredString());
        }

        CustomAutoCompleteTextView actvTest = (CustomAutoCompleteTextView)findViewById(R.id.actv_test);
        CustomAdapter adapter = new CustomAdapter(this, R.layout.activity_main, data);
        actvTest.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
