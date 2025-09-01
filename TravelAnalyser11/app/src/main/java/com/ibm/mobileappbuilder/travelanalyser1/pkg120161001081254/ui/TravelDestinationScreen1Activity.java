

package com.ibm.mobileappbuilder.travelanalyser1.pkg120161001081254.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import ibmmobileappbuilder.ui.BaseDetailActivity;

/**
 * TravelDestinationScreen1Activity detail activity
 */
public class TravelDestinationScreen1Activity extends BaseDetailActivity {
  
  	@Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected Class<? extends Fragment> getFragmentClass() {
        return TravelDestinationScreen1Fragment.class;
    }
}


