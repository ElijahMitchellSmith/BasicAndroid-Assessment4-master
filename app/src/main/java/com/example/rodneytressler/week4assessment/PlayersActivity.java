package com.example.rodneytressler.week4assessment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayersActivity extends AppCompatActivity {
    public static final String TAG = "PLAYER_LIST_TAG";


    @BindView(R.id.recycler_view)
    protected RecyclerView recyclerView;

    private List<Player> playerList;

    private PlayerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);
        ButterKnife.bind(this);
        playerList = getIntent().getParcelableArrayListExtra(TAG);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        //Attempted to use bundles. Got upset and figured it was wrong.
       // Bundle bundle = new Bundle();
      //  bundle.putParcelableArrayList(TAG,playerList);
        populateRecyclerView();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter.notifyDataSetChanged();

    }

    private void populateRecyclerView() {
        adapter = new PlayerAdapter(playerList);


    }
}
