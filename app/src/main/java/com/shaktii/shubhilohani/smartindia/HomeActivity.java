package com.shaktii.shubhilohani.smartindia;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shaktii.shubhilohani.Constants.CommonUtilities;
import com.shaktii.shubhilohani.Constants.GlobalConstants;
import com.shaktii.shubhilohani.Fragment.AddProjectFragment;
import com.shaktii.shubhilohani.Fragment.HomeFragment;
import com.shaktii.shubhilohani.Pojo.Menu;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import net.simonvt.menudrawer.MenuDrawer;
import net.simonvt.menudrawer.Position;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements View.OnClickListener {

    public Dialog dialogLogout;

    public TextView txtMessageLogout, txtOkLogout, txtCancelLogout;

    @BindView(R.id.txt_title) public TextView txtTitle;

    @BindView(R.id.container) FrameLayout frameContainer;
    @BindView(R.id.layout_back) RelativeLayout layoutBack;
    @BindView(R.id.layout_title) RelativeLayout layoutTitle;
    @BindView(R.id.layout_menu) RelativeLayout layoutMenu;

    @BindView(R.id.img_user) ImageView imgUser;
    @BindView(R.id.layout_user) LinearLayout layoutUser;

    @BindView(R.id.layout_edit_profile) RelativeLayout layoutEditProfile;

    @BindView(R.id.txt_user_name) TextView txtUserName;
    @BindView(R.id.txt_user_email) TextView txtUserEmail;
    @BindView(R.id.recycler_view) RecyclerView recyclerView;

    public MenuDrawer menuDrawer;

    FragmentManager fragmentManager = getSupportFragmentManager();

    String[] menuTitle;

    TypedArray menuImage;

    ArrayList<Menu> menuArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setMenuDrawer();

        ButterKnife.bind(this);

        createDialog();

        viewInitialization();

        HomeFragment homeFragment = HomeFragment.newInstance("DashBoard");

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.container, homeFragment, homeFragment.getClass().getName());

        fragmentTransaction.commit();

    }

    private void setMenuDrawer() {

        View menuView = getLayoutInflater().inflate(R.layout.layout_menu, null);

        menuDrawer = MenuDrawer.attach(this, MenuDrawer.Type.BEHIND, Position.RIGHT);

        menuDrawer.setContentView(R.layout.activity_home);

        menuDrawer.setMenuView(menuView);

        menuDrawer.setMenuSize((int) (GlobalConstants.WIDTH * 0.7));

        menuDrawer.setTouchMode(MenuDrawer.TOUCH_MODE_NONE);

        dialogLogout = CommonUtilities.showDialog(currentActivity, R.layout.dialog_logout);

        loaderInitialization();
    }

    private void viewInitialization() {

        menuTitle = getResources().getStringArray(R.array.side_menu_title);

        menuImage = getResources().obtainTypedArray(R.array.side_menu_image);

        loadArrayList();

        if (sharedPreference.getUserName() != null && !sharedPreference.getUserName().contentEquals(""))
            txtUserName.setText(CommonUtilities.capitalize(sharedPreference.getUserName()));

//        Picasso.with(GlobalConstants.applicationContext)
//                .load("/image")
//                .memoryPolicy(MemoryPolicy.NO_CACHE)
//                .placeholder(R.drawable.img_user)
//                .into(imgUser, null);

        imgUser.setOnClickListener(this);

        layoutEditProfile.setOnClickListener(this);

        layoutUser.setOnClickListener(this);

        layoutBack.setOnClickListener(this);

        layoutMenu.setOnClickListener(this);
    }

    private void loadArrayList() {

        menuArrayList = new ArrayList<Menu>();

        for (int i = 0; i < menuTitle.length; i++) {

            Menu menu = new Menu(menuTitle[i], menuImage.getDrawable(i));

            menuArrayList.add(menu);
        }

        loadMenuList();
    }

    private void loadMenuList() {

        recyclerView.setLayoutManager(new LinearLayoutManager(currentActivity));

        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(new MenuAdapter(menuArrayList, HomeActivity.this));
    }

    private void createDialog() {

        dialogLogout = CommonUtilities.showDialog(currentActivity, R.layout.dialog_logout);

        txtMessageLogout = (TextView) dialogLogout.findViewById(R.id.txt_message_logout);

        txtOkLogout = (TextView) dialogLogout.findViewById(R.id.txt_ok_logout);

        txtCancelLogout = (TextView) dialogLogout.findViewById(R.id.txt_cancel_logout);

        txtOkLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                logout();

                dialogLogout.dismiss();

            }
        });

        txtCancelLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                dialogLogout.dismiss();
            }
        });

    }

    public void fragmentNavigation(Fragment navigateFragment) {

        String fragmentTag = navigateFragment.getClass().getName();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        boolean fragmentPopped = fragmentManager.popBackStackImmediate(fragmentTag, 0);

        if (!fragmentPopped) {

            fragmentTransaction.replace(R.id.container, navigateFragment);

            fragmentTransaction.addToBackStack(fragmentTag);

            fragmentTransaction.commit();
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.layout_menu:

                menuDrawer.toggleMenu();

                break;

            case R.id.layout_back:

                onBackPressed();

                break;

            case R.id.layout_edit_profile:

                Intent editProfileIntent = new Intent(currentActivity, ProjectActivity.class);

                editProfileIntent.putExtra("type", "E");

                currentActivity.startActivity(editProfileIntent);

                menuDrawer.closeMenu();

                break;

            case R.id.img_user:

                Intent editProfile = new Intent(currentActivity, ProjectActivity.class);

                editProfile.putExtra("type", "E");

                currentActivity.startActivity(editProfile);

                menuDrawer.closeMenu();

                break;

            case R.id.layout_user:

                menuDrawer.closeMenu();

                break;
        }
    }

    private void logout() {

        Intent intent = new Intent(currentActivity, LoginActivity.class);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        currentActivity.startActivity(intent);

        finish();
    }

    @Override
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);

        Log.d(TAG, "ON CONFIGURATION");
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        Log.d(TAG, "ON POST CREATE");
    }

    @Override
    public void onStart() {
        super.onStart();

        Log.d(TAG, "ON START");
    }

    @Override
    public void onStop() {
        super.onStop();

        Log.d(TAG, "ON STOP");
    }

    @Override
    public void onResume() {
        super.onResume();

        if (menuDrawer != null && menuDrawer.isMenuVisible()) {
            menuDrawer.closeMenu();
        }

        if (imgUser != null) {

            Picasso.with(GlobalConstants.applicationContext)
                    .load("/image")
                    .memoryPolicy(MemoryPolicy.NO_CACHE)
                    .placeholder(R.drawable.img_user)
                    .into(imgUser, null);
        }

        if (txtUserName != null) {
            txtUserName.setText(sharedPreference.getUserName());
        }
//
//        if (sharedPreference.getUserID() == null) {
//
//            finish();
//        }

        Log.d(TAG, "ON RESUME");
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.d(TAG, "ON PAUSE");
    }

    @Override
    public void onBackPressed() {

        hideKeyboard();

        if (menuDrawer.isMenuVisible()) {

            menuDrawer.closeMenu();

        } else {

            if (fragmentManager.getBackStackEntryCount() > 1) {

                fragmentManager.popBackStack();

            } else if (fragmentManager.getBackStackEntryCount() == 1) {

                fragmentManager.popBackStack();

                homeNavigate();

            } else {

                super.onBackPressed();
            }
        }

        Log.d(TAG, "ON BACK PRESSED");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "ON DESTROY");
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        try {

            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container);

            fragment.onActivityResult(requestCode, resultCode, data);

        } catch (Exception E) {

            E.printStackTrace();
        }

        Log.d(TAG, "ON ACTIVITY RESULT");
    }

    public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

        private final ArrayList<Menu> menuArrayList;

        HomeActivity homeActivity;

        private Context activityContext;

        public MenuAdapter(ArrayList<Menu> menuArrayList, Context context) {

            this.menuArrayList = menuArrayList;

            activityContext = context;
        }

        @Override
        public MenuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_menu, parent, false);

            homeActivity = (HomeActivity) activityContext;

            return new MenuAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {

            holder.mItem = menuArrayList.get(position);

            holder.txtMenu.setText(holder.mItem.getTitle());

            holder.imgMenuIcon.setImageDrawable(holder.mItem.getImage());

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (holder.mItem.getTitle().contentEquals("DashBoard")) {

                        HomeFragment homeFragment = HomeFragment.newInstance("DashBoard");

                        fragmentNavigation(homeFragment);

                    } else if (holder.mItem.getTitle().contentEquals("Add Project")) {

                        AddProjectFragment addProjectFragment = AddProjectFragment.newInstance("Add Project");

                        fragmentNavigation(addProjectFragment);

                    } else if (holder.mItem.getTitle().contentEquals("Logout")) {

                        txtMessageLogout.setText("Are you sure you want to logout?");

                        dialogLogout.show();
                    }

                    menuDrawer.closeMenu();
                }
            });
        }

        @Override
        public int getItemCount() {

            if (menuArrayList != null)
                return menuArrayList.size();
            else
                return 0;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public final View mView;

            public final ImageView imgMenuIcon;

            public final TextView txtMenu;

            public Menu mItem;

            public ViewHolder(View view) {
                super(view);

                mView = view;

                imgMenuIcon = (ImageView) view.findViewById(R.id.img_menu);

                txtMenu = (TextView) view.findViewById(R.id.txt_menu);
            }
        }
    }

    public void homeNavigate() {

        txtTitle.setText("Smart India");

        layoutMenu.setVisibility(View.VISIBLE);

        layoutTitle.setVisibility(View.VISIBLE);
        layoutBack.setVisibility(View.GONE);
    }

    public void menuNavigate(String title) {

        txtTitle.setText(title);

        layoutTitle.setVisibility(View.VISIBLE);
        layoutBack.setVisibility(View.VISIBLE);
        layoutMenu.setVisibility(View.VISIBLE);

    }

    public void fragmentNavigate(String title) {

        txtTitle.setText(title);

        layoutTitle.setVisibility(View.VISIBLE);
        layoutBack.setVisibility(View.VISIBLE);

        layoutMenu.setVisibility(View.GONE);
    }

    public void sashNavigate() {

        layoutBack.setVisibility(View.VISIBLE);

        layoutMenu.setVisibility(View.VISIBLE);

        layoutTitle.setVisibility(View.GONE);
    }
}
