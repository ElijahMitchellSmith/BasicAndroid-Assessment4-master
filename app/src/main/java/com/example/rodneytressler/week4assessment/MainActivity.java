package com.example.rodneytressler.week4assessment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.input_team)
    protected EditText teamInput;

    @BindView(R.id.input_number)
    protected EditText numberInput;

    @BindView(R.id.input_name)
    protected EditText nameInput;

    private List<Player> playerList;

    public static final String TAG = "PLAYER_LIST_TAG";

    @OnClick(R.id.button_add_player)
    protected void onAddPlayerButtonClicked() {
        if (teamInput.toString().isEmpty() || numberInput.toString().isEmpty() || nameInput.toString().isEmpty()) {
            Toast.makeText(this, "Please Complete all fields", Toast.LENGTH_LONG).show();
        } else {
            String playerTeam = teamInput.getText().toString();
            String playerName = nameInput.getText().toString();
            String teamNumber = numberInput.getText().toString();
            addPlayerToList(playerTeam,teamNumber,playerName);
            Toast.makeText(this, "Player Added!", Toast.LENGTH_LONG).show();


        }

    }

//Made a new method to make new instance and add players to list
    private void addPlayerToList(final String playerTeam, final String teamNumber, final String playerName) {
        Player player = new Player(playerTeam, teamNumber, playerName);
        playerList.add(player);
    }


    @OnClick(R.id.button_view_players)
    protected void onViewPlayersButtonClicked() {
        if (playerList.isEmpty()) {
            Toast.makeText(this, "Please add Players in order to view", Toast.LENGTH_LONG).show();
        } else {
            //Creation of the New Intent and connecting the 2 activities.
            Intent intent = new Intent(MainActivity.this, PlayersActivity.class);
            //Getting Intnetn and adding the ArrayListExtra
            getIntent().getStringArrayListExtra(TAG);
            //Starting the Activity
            startActivity(intent);


        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        playerList = new ArrayList<>();
    }


    
}
