package com.armandroid.presupuesto.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.armandroid.presupuesto.R;
import com.armandroid.presupuesto.holders.ItemViewHolder;
import com.armandroid.presupuesto.model.MenuItem;

/**
 * Created by armando.dominguez on 29/12/2015.
 */
public class GridViewAdapter extends BaseAdapter {

    private Context adapterContext;
    private MenuItem itemsArray[];

    public GridViewAdapter(Context adapterContext, MenuItem[] itemsArray) {
        this.adapterContext = adapterContext;
        this.itemsArray = itemsArray;
    }

    @Override
    public int getCount() {
        return itemsArray.length;
    }

    @Override
    public Object getItem(int position) {
        return itemsArray[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemViewHolder mItem;
        if(convertView == null){
            LayoutInflater mInflater = LayoutInflater.from(adapterContext);
            convertView = mInflater.inflate(R.layout.gridview_item, parent,false);

            mItem               = new ItemViewHolder();
            mItem.icon          = (ImageView) convertView.findViewById(R.id.iconElement);
            mItem.description   = (TextView) convertView.findViewById(R.id.textViewDesc);

            convertView.setTag(mItem);

        }else{
            mItem = (ItemViewHolder) convertView.getTag();
        }

        mItem.description.setText(itemsArray[position].description);
        mItem.icon.setImageResource(itemsArray[position].menuIcon);

        return convertView;
    }
}
