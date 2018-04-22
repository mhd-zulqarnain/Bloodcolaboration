package zulqarnain.suuet.acadmy.com.bloodcolaboration.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import zulqarnain.suuet.acadmy.com.bloodcolaboration.R;
import zulqarnain.suuet.acadmy.com.bloodcolaboration.model.BloodRequest;

/**
 * Created by Zul Qarnain on 4/22/2018.
 */

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.MyViewHolder> {
    ArrayList<BloodRequest> data;
    Context ctx;
    public FeedAdapter(ArrayList<BloodRequest> data) {
        this.data = data;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_feed_row_view,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bindView(data.get(position));

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        TextView txt_bottle;
        TextView txt_urgency;
        TextView txt_contact;
        TextView txt_addtional;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_name);
            txt_bottle = itemView.findViewById(R.id.txt_bottle);
            txt_urgency = itemView.findViewById(R.id.txt_urgency);
            txt_contact = itemView.findViewById(R.id.txt_contact);
            txt_addtional = itemView.findViewById(R.id.txt_addtional);
        }
        public void bindView(final BloodRequest request) {
            txt_bottle.setText(request.getEd_num_unit()+" units of "+request.getSpinner_blood_group()+" required");
            txt_urgency.setText("Urgency: "+request.getSpinner_urgency());
            txt_contact.setText("Contact at: "+request.getEd_contact());
            txt_addtional.setText("Additional instruction: "+request.getEd_contact());
        }
    }
}
