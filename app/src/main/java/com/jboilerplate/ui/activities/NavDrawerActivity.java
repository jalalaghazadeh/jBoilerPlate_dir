package com.jboilerplate.ui.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jboilerplate.R;
import com.jboilerplate.ui.fragments.BaseFragment;
import com.jboilerplate.ui.fragments.FavoritesFragment;
import com.jboilerplate.ui.fragments.FoodFragment;
import com.jboilerplate.ui.fragments.FriendsFragment;
import com.jboilerplate.ui.fragments.NearbyFragment;
import com.jboilerplate.ui.fragments.RecentsFragment;
import com.ncapdevi.fragnav.FragNavController;
import com.ncapdevi.fragnav.FragNavTransactionOptions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class NavDrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, BaseFragment.FragmentNavigation {
    private final String TAG = getClass().getSimpleName();
    //Better convention to properly name the indices what they are in your app
    private final int INDEX_RECENTS = FragNavController.TAB1;
    private final int INDEX_FAVORITES = FragNavController.TAB2;
    private final int INDEX_NEARBY = FragNavController.TAB3;
    private final int INDEX_FRIENDS = FragNavController.TAB4;
    private final int INDEX_FOOD = FragNavController.TAB5;
    private final int INDEX_RECENTS2 = FragNavController.TAB6;
    private final int INDEX_FAVORITES2 = FragNavController.TAB7;
    private final int INDEX_NEARBY2 = FragNavController.TAB8;
    private final int INDEX_FRIENDS2 = FragNavController.TAB9;
    private final int INDEX_FOOD2 = FragNavController.TAB10;
    private final int INDEX_RECENTS3 = FragNavController.TAB11;
    private final int INDEX_FAVORITES3 = FragNavController.TAB12;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.nav_view)
    NavigationView navView;

    TextView tvUsername;
    CircleImageView ivProfileImage;
    @BindView(R.id.btn_footer)
    Button btnFooter;

    private FragNavController mNavController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        setupNavigationView();
        navView.setNavigationItemSelectedListener(this);


        // fav-fragment init
        List<Fragment> fragments = new ArrayList<>(12);
        fragments.add(RecentsFragment.newInstance(0));
        fragments.add(FavoritesFragment.newInstance(0));
        fragments.add(NearbyFragment.newInstance(0));
        fragments.add(FriendsFragment.newInstance(0));
        fragments.add(FoodFragment.newInstance(0));
        fragments.add(RecentsFragment.newInstance(0));
        fragments.add(FavoritesFragment.newInstance(0));
        fragments.add(NearbyFragment.newInstance(0));
        fragments.add(FriendsFragment.newInstance(0));
        fragments.add(FoodFragment.newInstance(0));
        fragments.add(RecentsFragment.newInstance(0));
        fragments.add(FavoritesFragment.newInstance(0));

        mNavController = FragNavController.newBuilder(savedInstanceState, getSupportFragmentManager(), R.id.container)
                .rootFragments(fragments)
                .defaultTransactionOptions(FragNavTransactionOptions.newBuilder().customAnimations(R.anim.slide_in_from_right, R.anim.slide_out_to_left, R.anim.slide_in_from_left, R.anim.slide_out_to_right).build())
                .build();

    }

    private void setupNavigationView() {
        navView.inflateHeaderView(R.layout.nav_header_nav_drawer);
        ivProfileImage = navView.getHeaderView(0).findViewById(R.id.iv_profile_image);
        Glide.with(getApplicationContext())
                .load("https://www.circleof6app.com/wp-content/uploads/2015/12/thomas_cabus1.png")
                .into(ivProfileImage);
        tvUsername = navView.getHeaderView(0).findViewById(R.id.tv_username);
        tvUsername.setText("username");
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else if (mNavController.getCurrentStack() != null && mNavController.getCurrentStack().size() > 1) {
            mNavController.popFragment();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mNavController.onSaveInstanceState(outState);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bb_menu_recents:
                mNavController.switchTab(INDEX_RECENTS);
                break;
            case R.id.bb_menu_favorites:
                mNavController.switchTab(INDEX_FAVORITES);
                break;
            case R.id.bb_menu_nearby:
                mNavController.switchTab(INDEX_NEARBY);
                break;
            case R.id.bb_menu_friends:
                mNavController.switchTab(INDEX_FRIENDS);
                break;
            case R.id.bb_menu_food:
                mNavController.switchTab(INDEX_FOOD);
                break;
            case R.id.bb_menu_recents2:
                mNavController.switchTab(INDEX_RECENTS2);
                break;
            case R.id.bb_menu_favorites2:
                mNavController.switchTab(INDEX_FAVORITES2);
                break;
            case R.id.bb_menu_nearby2:
                mNavController.switchTab(INDEX_NEARBY2);
                break;
            case R.id.bb_menu_friends2:
                mNavController.switchTab(INDEX_FRIENDS2);
                break;
            case R.id.bb_menu_food2:
                mNavController.switchTab(INDEX_FOOD2);
                break;
            case R.id.bb_menu_recents3:
                mNavController.switchTab(INDEX_RECENTS3);
                break;
            case R.id.bb_menu_favorites3:
                mNavController.switchTab(INDEX_FAVORITES3);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void pushFragment(Fragment fragment) {
        mNavController.pushFragment(fragment);
    }

    @OnClick(R.id.btn_footer)
    public void onViewClicked() {
        Toast.makeText(this, "click footer", Toast.LENGTH_SHORT).show();
    }
}
