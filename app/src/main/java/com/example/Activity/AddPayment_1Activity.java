package com.example.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.connekma.R;
import com.google.android.material.navigation.NavigationView;

public class AddPayment_1Activity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    TextView mText1, mText2, mText3, mText4;


    final Context context = this;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    ImageView mOpenSideNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_payment_1);
        mText1 = findViewById(R.id.card_name1);
        mText2 = findViewById(R.id.card_name2);
        mText3 = findViewById(R.id.card_name3);
        mText4 = findViewById(R.id.card_name4);

        mText4.setOnClickListener(this);
        mText3.setOnClickListener(this);
        mText2.setOnClickListener(this);
        mText1.setOnClickListener(this);

        mOpenSideNavigation = findViewById(R.id.iv_navigation3);

        mOpenSideNavigation.setOnClickListener(view -> {
            drawerLayout.openDrawer(GravityCompat.START);
        });


        drawerLayout = findViewById(R.id.drawer_layout4);

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        navigationView.getMenu().getItem(0).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(1).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(2).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(3).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(4).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(4).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(5).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(6).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(7).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(8).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(9).setActionView(R.layout.menu_image);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.card_name1:

            case R.id.card_name2:

            case R.id.card_name3:

            case R.id.card_name4:
                Intent one_intent = new Intent(AddPayment_1Activity.this, AddPasswordActivity.class);
                startActivity(one_intent);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }

    }

    public boolean onNavigationItemSelected(@Nullable MenuItem menuItem) {


        switch (menuItem.getItemId()) {

            case R.id.nav_profile: {

                Intent profile_intent = new Intent(AddPayment_1Activity.this, MyProfileActivity.class);
                startActivity(profile_intent);
                break;
            }
            case R.id.nav_trips: {
                Intent trips_intent = new Intent(AddPayment_1Activity.this, TripsActivity.class);
                startActivity(trips_intent);
                break;
            }
            case R.id.nav_payment: {
                Intent payment_intent = new Intent(AddPayment_1Activity.this, PaymentActivity.class);
                startActivity(payment_intent);
                break;
            }

            case R.id.nav_booking: {
                Intent bookings_intent = new Intent(AddPayment_1Activity.this, MyBookingsActivity.class);
                startActivity(bookings_intent);
                break;
            }

            case R.id.nav_invite_friend: {
                Intent invite_intent = new Intent(AddPayment_1Activity.this, InviteFriendsActivity.class);
                startActivity(invite_intent);
                break;
            }

            case R.id.nav_setting: {
                Intent settings_intent = new Intent(AddPayment_1Activity.this, SettingsActivity.class);
                startActivity(settings_intent);
                break;
            }

            case R.id.nav_contact: {
                Intent contact_intent = new Intent(AddPayment_1Activity.this, ContactActivity.class);
                startActivity(contact_intent);
                break;
            }

            case R.id.nav_emergency: {
                showDialogBox();
                break;
            }

            case R.id.nav_help: {
                Intent help_intent = new Intent(AddPayment_1Activity.this, HelpActivity.class);
                startActivity(help_intent);
                break;
            }

            case R.id.nav_logout: {
                Toast.makeText(context, "Logout ...", Toast.LENGTH_SHORT).show();
                break;
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    private void showDialogBox() {

        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.layout_dialog);

        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);

        ImageView dialogButton = (ImageView) dialog.findViewById(R.id.make_call);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                makeCall();
                Toast.makeText(context, "callCheck", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void makeCall() {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + 198));
        if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(callIntent);
    }


    @Override
    public void onBackPressed() {

        drawerLayout = findViewById(R.id.drawer_layout4);

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {

            super.onBackPressed();
        }

    }
}
