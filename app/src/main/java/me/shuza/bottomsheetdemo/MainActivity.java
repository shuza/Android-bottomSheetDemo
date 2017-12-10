package me.shuza.bottomsheetdemo;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private BottomSheetBehavior bottomSheetBehavior;
    private TextView bottomSheetHeading;

    private Button btnExpandBottomSheet;
    private Button btnCollapseBottomSheet;
    private Button btnHideBottomSheet;
    private Button btnShowBottomSheetDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initListeners();
    }

    private void initViews() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.bottomSheetLayout));
        bottomSheetHeading = findViewById(R.id.bottomSheetHeading);
        btnExpandBottomSheet = findViewById(R.id.expand_bottom_sheet_button);
        btnCollapseBottomSheet = findViewById(R.id.collapse_bottom_sheet_button);
        btnHideBottomSheet = findViewById(R.id.hide_bottom_sheet_button);
        btnShowBottomSheetDialog = findViewById(R.id.show_bottom_sheet_dialog_button);
    }

    private void initListeners() {
        btnExpandBottomSheet.setOnClickListener(this);
        btnCollapseBottomSheet.setOnClickListener(this);
        btnHideBottomSheet.setOnClickListener(this);
        btnShowBottomSheetDialog.setOnClickListener(this);

        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetHeading.setText(getString(R.string.text_collapse_me));
                } else {
                    bottomSheetHeading.setText(getString(R.string.text_expand_me));
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.collapse_bottom_sheet_button:
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                break;

            case R.id.expand_bottom_sheet_button:
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                break;

            case R.id.hide_bottom_sheet_button:
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                break;

            case R.id.show_bottom_sheet_dialog_button:

                break;
        }
    }
}
