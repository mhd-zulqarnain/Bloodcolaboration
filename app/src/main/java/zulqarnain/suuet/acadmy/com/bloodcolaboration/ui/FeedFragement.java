package zulqarnain.suuet.acadmy.com.bloodcolaboration.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import zulqarnain.suuet.acadmy.com.bloodcolaboration.R;
import zulqarnain.suuet.acadmy.com.bloodcolaboration.model.BloodRequest;

import static android.content.ContentValues.TAG;

/**
 * Created by Zul Qarnain on 4/22/2018.
 */

public class FeedFragement extends Fragment {
    TextView tv;
    private ImageButton addBtn;
    DatabaseReference ref;
    private String area;
    private ArrayList<BloodRequest> data;
    RecyclerView rv;
    FeedAdapter adapter;

    public static FeedFragement newInstance() {
        Bundle args = new Bundle();
        FeedFragement fragment = new FeedFragement();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_feed_fragment_view, container, false);
        rv = v.findViewById(R.id.feed_recycler);
        data= new ArrayList<>();
        ref = FirebaseDatabase.getInstance().getReference("Requestdetails");
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new FeedAdapter(data);
        initUi();
        return v;
    }


    private void initUi() {
        data = new ArrayList<>();
        adapter = new FeedAdapter(data);
        rv.setAdapter(adapter);
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                BloodRequest plc = dataSnapshot.getValue(BloodRequest.class);
                Log.d(TAG, "onChildAdded: " + plc.getRequestId());
                Log.d(TAG, "onChildAdded: " + dataSnapshot);
                    data.add(plc);
                    adapter.notifyDataSetChanged();

            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                BloodRequest br = dataSnapshot.getValue(BloodRequest.class);
                Log.d(TAG, "onChildAdded: " + area);
                int index =getIndexOf(br.getRequestId());
                if (index!=-1 ) {
                    data.remove(index);
                    adapter.notifyItemRemoved(index);
                }
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    public int getIndexOf(String key) {
        for (int i = 0; i < data.size(); i++) {
            BloodRequest mj = data.get(i);
            if (mj.getRequestId().equals(key)) {
                return data.indexOf(mj);
            }
        }
        return -1;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }

}
