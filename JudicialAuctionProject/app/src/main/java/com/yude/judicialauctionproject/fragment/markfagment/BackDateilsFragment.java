package com.yude.judicialauctionproject.fragment.markfagment;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.yude.judicialauctionproject.R;

/**
 *  多选复选框
 */
public class BackDateilsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.checkbox);

    }
}
