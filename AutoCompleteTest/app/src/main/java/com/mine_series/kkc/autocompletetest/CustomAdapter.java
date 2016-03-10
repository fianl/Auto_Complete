package com.mine_series.kkc.autocompletetest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev13 on 2016. 3. 9..
 */
public class CustomAdapter extends ArrayAdapter {
    Context mContext;
    public ArrayList<String> list;
    public ArrayList<String> filterResult;
    public CustomAdapter(Context context, int resource, ArrayList<String> list) {
        super(context, resource);
        mContext = context;
        this.list = list;
        filterResult = new ArrayList<String>();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        String data = (String)filterResult.get(position);
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.item_custom_adapter, parent, false);
        TextView tvContent = (TextView)convertView.findViewById(R.id.tv_custom_adapter_content);
        tvContent.setText(data);
        return convertView;
    }

    @Override
    public Object getItem(int position)
    {
        return filterResult.get(position);
    }

    @Override
    public Filter getFilter()
    {
        return nameFilter;
    }

    Filter nameFilter = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            if (constraint != null) {
                Log.d("GET_KEYWORD2", constraint.toString());
                filterResult.clear();
                for (String data : list) {
                    String keyword = constraint.toString();

                    if(data.contains(keyword))
                    {
                        filterResult.add(data);
                    }

                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filterResult;
                filterResults.count = filterResult.size();
                return filterResults;
            } else {
                return new FilterResults();
            }
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            List<String> filterList = (ArrayList<String>) results.values;
            if (results != null && results.count > 0) {
                clear();
                for (String data : filterList) {
                    add(data);
                    notifyDataSetChanged();
                }
            }
        }
    };
}
