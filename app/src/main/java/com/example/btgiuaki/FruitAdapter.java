package com.example.btgiuaki;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends BaseAdapter {
    private Context context;
    private  int layout;
    private List<Fruit> fruitList;

    public FruitAdapter(Context context, int layout, List<Fruit> fruitList) {
        this.context = context;
        this.layout = layout;
        this.fruitList = fruitList;
    }

    @Override
    public int getCount() {
        return fruitList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);

        //anhxa
        TextView txtten = (TextView) view.findViewById(R.id.tvten);
        TextView txtmota = (TextView) view.findViewById(R.id.tvmota);
        ImageView imghinh =(ImageView) view.findViewById(R.id.imagehinh);

        //giatri
        Fruit fruit = fruitList.get(i);

        txtten.setText(fruit.getTen());
        txtmota.setText(fruit.getMota());
        imghinh.setImageResource(fruit.getHinh());


        return view;
    }
}
