package com.example.amolgursali.googlemapautocompleteaddress;

import android.content.Context;
import android.location.Address;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.android.volley.Response;

import java.util.ArrayList;
import java.util.List;

import static com.example.amolgursali.googlemapautocompleteaddress.MainActivity.autocomplete;

/**
 * Created by AmolGursali on 7/11/2017.
 */
public class RecyclerviewAdapter extends ArrayAdapter<String> implements Filterable
{
//    private Filter fRecords;
//    View v;
    ArrayList<String> result;
    public RecyclerviewAdapter(Context context, int resid)
    {
        super(context,resid);
    }

    @Override
    public int getCount() {
        return result.size();
    }
    @Override
    public String getItem(int position) {
        return result.get(position);
    }

    @Override

    public Filter getFilter() {

        Filter filter = new Filter() {

            @Override

            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults filterResults = new FilterResults();

                if (constraint != null) {

                    // Retrieve the autocomplete results.

                    result = autocomplete(constraint.toString());



                    // Assign the data to the FilterResults

                    filterResults.values = result;

                    filterResults.count = result.size();

                }
                return filterResults;
            }



            @Override

            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results != null && results.count > 0) {

                    notifyDataSetChanged();

                } else {

                    notifyDataSetInvalidated();

                }

            }

        };

        return filter;

    }

}



