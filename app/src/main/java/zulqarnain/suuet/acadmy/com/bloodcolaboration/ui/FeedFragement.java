package zulqarnain.suuet.acadmy.com.bloodcolaboration.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import zulqarnain.suuet.acadmy.com.bloodcolaboration.R;

/**
 * Created by Zul Qarnain on 4/22/2018.
 */

public class FeedFragement extends Fragment {
    TextView tv;
    private ImageButton addBtn;
    DatabaseReference ref;
    private String area;
    //    private ArrayList<ParkPlace> pList;
    RecyclerView rv;

    public static FeedFragement newInstance() {
        Bundle args = new Bundle();
        FeedFragement fragment = new FeedFragement();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_feed_fragment_view, container, false);
        rv= v.findViewById(R.id.feed_recycler);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }

}
