package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 12/02/18.
 */

public class MasterListFragment extends Fragment {

    // Creates the ImageViews that are contained in the GridView
    // The adapter takes as parameters (Context context, List<Integer> mImageIds)
    private MasterListAdapter mMasterListAdapter;

    private final String IMAGE_IDS = "image_ids";
    private List<Integer> mImageIds = AndroidImageAssets.getAll();

    public MasterListFragment() {

    }

    /**
     * Called to have the fragment instantiate its user interface view.
     * This is optional, and non-graphical fragments can return null (which
     * is the default implementation).  This will be called between
     * {@link #onCreate(Bundle)} and {@link #onActivityCreated(Bundle)}.
     * <p>
     * <p>If you return a View from here, you will later be called in
     * {@link #onDestroyView} when the view is being released.
     *
     * @param inflater           The LayoutInflater object that can be used to inflate
     *                           any views in the fragment,
     * @param container          If non-null, this is the parent view that the fragment's
     *                           UI should be attached to.  The fragment should not add the view itself,
     *                           but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     *                           from a previous saved state as given here.
     * @return Return the View for the fragment's UI, or null.
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        GridView rootView = (GridView) inflater.inflate(R.layout.fragment_master_list, container, false);

        if (mMasterListAdapter == null) {

            if (savedInstanceState != null) {
                mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_IDS);
            }

            mMasterListAdapter = new MasterListAdapter(getContext(), mImageIds);

        }

        rootView.setAdapter(mMasterListAdapter);
        return rootView;
    }

    public void setImageIds(List<Integer> imageIds) {
        this.mImageIds = imageIds;
    }
}
