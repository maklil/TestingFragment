package com.andro.testingfragment;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ListFrag.ChessPieceListener {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tvDetails);

        // portrait
        if (findViewById(R.id.layout_default) != null){

            FragmentManager fragmentManager = this.getSupportFragmentManager();
            fragmentManager.beginTransaction()
            .hide(fragmentManager.findFragmentById(R.id.detailFrag))
            .show(fragmentManager.findFragmentById(R.id.listFrag))
            .commit();
        }

        // landscape
        if (findViewById(R.id.layout_land) != null){

            FragmentManager fragmentManager = this.getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .show(fragmentManager.findFragmentById(R.id.listFrag))
                    .show(fragmentManager.findFragmentById(R.id.detailFrag))
                    .commit();
        }
    }

    @Override
    public void onChessPieceSelected(int index) {

        if (findViewById(R.id.layout_default) != null){
            FragmentManager fragmentManager = this.getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .hide(fragmentManager.findFragmentById(R.id.listFrag))
                    .show(fragmentManager.findFragmentById(R.id.detailFrag))
                    .addToBackStack(null)
                    .commit();
        }

        String[] descriptions = getResources().getStringArray(R.array.descriptions);
        textView.setText(descriptions[index]);

    }
}
