package com.example.user.myapplication;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.ViewGroup;

import com.example.user.myapplication.Fragment.SearchAngkotFragment;
import com.example.user.myapplication.Fragment.SearchRouteFragment;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MainActivity extends ActionBarActivity {
    FragmentPagerAdapter adapterViewPager;
    ViewPager viewPager;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentManager fm = getSupportFragmentManager();
//        android.support.v4.app.FragmentTransaction fragment = fm.beginTransaction().replace(R.id.container, new SearchAngkotFragment());
//        fragment.commit();

        viewPager = (ViewPager) findViewById(R.id.pager);
        adapterViewPager = new PasAdapterPager(fm);
        viewPager.setAdapter(adapterViewPager);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.user.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.user.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    public class PasAdapterPager extends FragmentPagerAdapter {

        List<Fragment> fragments;
        ArrayList<Stack<Fragment>> history;
        private int NUM_ITEMS = 2;

        public PasAdapterPager(FragmentManager fm) {
            super(fm);
            fragments = new ArrayList<>();
            fragments.add(new SearchRouteFragment(0, this));
            fragments.add(new SearchAngkotFragment(0, this));
            history = new ArrayList<>();

            for (int i = 0; i < NUM_ITEMS; ++i) {
                history.add(new Stack<Fragment>());
            }
        }

        public void replaceFragment(int position, Fragment newFragment){
            FragmentManager fm = getSupportFragmentManager();

            //set history
            history.get(position).push(fragments.get(position));

            //update
//            fm.beginTransaction().remove(fragments.get(position)).commit();
            fm.beginTransaction().addToBackStack(null).commit();
            fragments.set(position, newFragment);

            Log.d("huba", "replaced nih with " + newFragment.getClass().getName());
            notifyDataSetChanged();
        }

        @Override
        public Fragment getItem(int position) {
            Log.d("huba", "getItem(" + position + ") = " + fragments.get(position).getClass().getName());
            return fragments.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position){
            switch (position){
                case 0: return "Search Route";
                case 1: return "Search Angkot";
                default: return "Pas Angkot";
            }
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public int getItemPosition(final Object object) {
            int pos = POSITION_NONE;
            for (Fragment fragment : fragments) {
                if (fragment != null && fragment.getClass().getName().equals(object.getClass().getName())) {
                    pos = POSITION_UNCHANGED;
                }
            }
            Log.d("huba", "getItemPosition(" + object.getClass().getName() + ") = " + (pos == POSITION_NONE ? "POSITION_NONE" : "POSITION_UNCHANGED"));
            return pos;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Log.d("huba", "instantiateItem(" +position + ")" + " yang hidup = " + viewPager.getCurrentItem());
            Fragment fragment = (Fragment) super.instantiateItem(container, position);
            fragments.set(position, fragment);
            return fragment;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            Log.d("huba", "destroyItem(" +position + ")");
            fragments.set(position, null);
            super.destroyItem(container, position, object);
        }

        public boolean onBackPress() {
            try {
                OnBackPressListener currentFragmentListener = (OnBackPressListener)fragments.get(viewPager.getCurrentItem());
                return currentFragmentListener.onBackPressed();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }
}
