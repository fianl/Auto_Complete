package com.mine_series.kkc.autocompletetest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;

/**
 * Created by dev13 on 2016. 3. 8..
 */
public class CustomAutoCompleteTextView extends AutoCompleteTextView {
    Context mContext;
    CustomAdapter adapter;
    public CustomAutoCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    public CustomAutoCompleteTextView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    /**
     * set search list item click listener
     *
     */
    private void init()
    {
        setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String searchedText = (String)adapter.getItem(position);
                setText(searchedText);
            }
        });
    }

    /**
     * set custom adapter
     * @param adapter
     */
    public void setAdapter(CustomAdapter adapter)
    {
        this.adapter = adapter;
        super.setAdapter(this.adapter);
    }
}
