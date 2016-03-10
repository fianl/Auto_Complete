package com.mine_series.kkc.autocompletetest;

/**
 * Created by dev13 on 2016. 3. 9..
 */
public class TempData implements CustomData{

    String first;
    String second;
    String third;
    String fourth;

    public TempData(String f, String s, String t, String fo)
    {
        first = f;
        second = s;
        third = t;
        fourth = fo;
    }

    @Override
    public String makeWillBeFilteredString() {
        if(fourth.equals(""))
        {
            return first+"/"+second+"/"+third;
        }else{
            return first+"/"+second+"/"+third+"/"+fourth;
        }
    }
}
