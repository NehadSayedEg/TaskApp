package com.nehad.android.taskapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nehad.android.taskapp.Model.HousingList;
import com.squareup.picasso.Picasso;

public class HousingAdapter extends RecyclerView.Adapter<HousingAdapter.ViewHolder> {

    private Context context;
    private HousingList housingList;

    public HousingAdapter(Context context, HousingList housingList){
         this.context = context;
         this.housingList = housingList;

    }

    @NonNull
    @Override
    public HousingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_housing,viewGroup,false);
        return new HousingAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HousingAdapter.ViewHolder viewHolder, int i) {

        Log.v("HousingAdapter", "binding");
        viewHolder.houseName.setText(housingList.getData().get(i).getName());
        Log.v("HousingAdapter", " " +housingList.getData().get(i).getName());

        String houseId = Integer.toString(housingList.getData().get(i).getId());
        viewHolder.houseId.setText(houseId);


        Log.v("HousingAdapter", "path " +housingList.getData().get(i).getImage());
        Picasso.get().load(housingList.getData().get(i).getImage()).placeholder(R.drawable.loading).into(viewHolder.HouseImage);

    }

    @Override
    public int getItemCount() {
        if(housingList.getData() != null) {
            return housingList.getData().size();
        }
        else{
            Log.i("Errorrr"," getHousing is null");
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView houseId, houseName;
        public ImageView HouseImage;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
                houseId = itemView.findViewById(R.id.HouseID);
                houseName =  itemView.findViewById(R.id.HouseName);
            HouseImage= itemView.findViewById(R.id.houseImage);
        }
    }
}
