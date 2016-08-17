package com.bwf.tuanche.selectcity.cityadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.tuanche.R;
import com.bwf.tuanche.selectcity.citylistresultbean.openCitysBean;

import java.util.List;

/**
 * Created by ZWP on 2016/8/17.
 * Explain:所有城市的adapter
 */
public class AllCityAdapter extends BaseAdapter {

    private Context context;
    private List<openCitysBean> data;


    public AllCityAdapter(Context context, List<openCitysBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public Object getItem(int i) {
        return data == null ? null : data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View conventview, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (conventview == null ){
            viewHolder = new ViewHolder();
            conventview = View.inflate(context, R.layout.item_allcity,null);
            viewHolder.item_AllCity = (TextView) conventview.findViewById(R.id.item_AllCity);
            conventview.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) conventview.getTag();
        }
        if (data != null)
        viewHolder.item_AllCity.setText(data.get(position).name);
        return conventview;
    }
    public class ViewHolder{
        TextView item_AllCity;
    }
}
