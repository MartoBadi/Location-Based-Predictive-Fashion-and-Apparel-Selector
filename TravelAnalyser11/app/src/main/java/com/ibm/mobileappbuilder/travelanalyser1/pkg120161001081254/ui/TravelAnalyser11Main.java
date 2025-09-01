package com.ibm.mobileappbuilder.travelanalyser1.pkg120161001081254.ui;

import android.support.v4.app.Fragment;
import android.util.SparseArray;

import ibmmobileappbuilder.ui.DrawerActivity;

import com.ibm.mobileappbuilder.travelanalyser1.pkg120161001081254.R;

public class TravelAnalyser11Main extends DrawerActivity {

    private final SparseArray<Class<? extends Fragment>> sectionFragments = new SparseArray<>();
    {
                sectionFragments.append(R.id.entry0, TravelDestinationScreen1Fragment.class);
            sectionFragments.append(R.id.entry1, SuggestedclothingFragment.class);
    }

    @Override
    public SparseArray<Class<? extends Fragment>> getSectionFragmentClasses() {
      return sectionFragments;
    }

}

