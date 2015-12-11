package com.example.user.myapplication.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.myapplication.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by user on 12/4/2015.
 */
public class PagerFragment extends Fragment {
    FragmentPagerAdapter adapterViewPager;
    ViewPager viewPager;
    FragmentManager fm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fm = getActivity().getSupportFragmentManager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.header_pager, parent, false);

        viewPager = (ViewPager) view.findViewById(R.id.pager);
        adapterViewPager = new PasAdapterPager(fm);
        viewPager.setAdapter(adapterViewPager);

        return view;
    }

    public class PasAdapterPager extends FragmentPagerAdapter {

        List<Fragment> fragments;
        ArrayList<Stack<Fragment>> history;
        List<String> title;
        private int NUM_ITEMS = 2;

        public PasAdapterPager(FragmentManager fm) {
            super(fm);
            fragments = new ArrayList<>();
            fragments.add(new SearchRouteFragment());
            fragments.add(new SearchAngkotFragment());
            history = new ArrayList<>();

            for (int i = 0; i < NUM_ITEMS; ++i) {
                history.add(new Stack<Fragment>());
            }

            title = new ArrayList<>();
            title.add("Search Route");
            title.add("Search Angkot");
        }

        public void replaceFragment(int position, Fragment newFragment) {
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
        public CharSequence getPageTitle(int position) {
            return title.get(position);
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
//
//        @Override
//        public Object instantiateItem(ViewGroup container, int position) {
//            Log.d("huba", "instantiateItem(" + position + ")" + " yang hidup = " + viewPager.getCurrentItem());
//            Fragment fragment = (Fragment) super.instantiateItem(container, position);
//            fragments.set(position, fragment);
//            return fragment;
//        }
//
//        @Override
//        public void destroyItem(ViewGroup container, int position, Object object) {
//            Log.d("huba", "destroyItem(" + position + ")");
//            fragments.set(position, null);
//            super.destroyItem(container, position, object);
//        }
    }
}
