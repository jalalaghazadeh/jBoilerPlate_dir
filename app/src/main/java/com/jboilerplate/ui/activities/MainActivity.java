package com.jboilerplate.ui.activities;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.Toast;

import com.jboilerplate.R;
import com.jboilerplate.events.DrawerItem;
import com.jboilerplate.ui.adapters.DrawerItemsAdapter;
import com.jboilerplate.ui.fragments.HomeFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv_drawer_items)
    RecyclerView rvDrawerItems;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.iv_drawer_menu)
    ImageView ivDrawerMenu;

    String[] drawerItemTitleIds;
    TypedArray drawerItemIconIds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupToolbar();
        setupDrawer();

        // add fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_main_activity_container, new HomeFragment()).commit();
    }

    void setupToolbar() {
//            toolbar.setLogo(R.drawable.ic_logo_toolbar);
        toolbar.setTitle("");
//            toolbar.setNavigationIcon(R.drawable.ic_action_menu);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    private void setupDrawer() {
        rvDrawerItems.setLayoutManager(new LinearLayoutManager(this));
        rvDrawerItems.hasFixedSize();
        rvDrawerItems.setAdapter(new DrawerItemsAdapter(getDrawerItems()));
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                toggleDrawer();
//            }
//        });
    }

    private ArrayList<DrawerItem> getDrawerItems() {
        ArrayList<DrawerItem> drawerItems = new ArrayList<>();
        drawerItemTitleIds = getResources().getStringArray(R.array.drawer_item_title_ids);
        drawerItemIconIds = getResources().obtainTypedArray(R.array.drawer_item_icon_ids);

        for (int position = 0; position < drawerItemTitleIds.length; position++) {
            drawerItems.add(new DrawerItem(position, drawerItemIconIds.getResourceId(position, -1), drawerItemTitleIds[position]));
        }

        return drawerItems;
    }

    /**
     * to handle on drawer item clicks
     *
     * @param drawerItem
     */
    public void onEvent(DrawerItem drawerItem) {
        Toast.makeText(this, "item (" + drawerItem.getId() + ") clicked", Toast.LENGTH_SHORT).show();
    }

    private void toggleDrawer() {
        if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
            drawerLayout.closeDrawer(Gravity.RIGHT);
        } else {
            drawerLayout.openDrawer(Gravity.RIGHT);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
            drawerLayout.closeDrawer(Gravity.RIGHT);
        } else {
            super.onBackPressed();
        }
    }

    // enable calligraphy in all activities
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @OnClick(R.id.iv_drawer_menu)
    public void onViewClicked() {
        toggleDrawer();
    }
}
