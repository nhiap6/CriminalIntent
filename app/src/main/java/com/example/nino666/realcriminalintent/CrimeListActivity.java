package com.example.nino666.realcriminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by nino666 on 13.8.2016.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return new CrimeListFragment();
    }
}
