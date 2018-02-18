/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.android.android_me.R;

// This activity is responsible for displaying the master list of all images
// Implement the MasterListFragment callback, OnImageClickListener
public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener{


    // JB: variables to hold body parts indexes
    private int mHeadIndex;
    private int mBodyIndex;
    private int mLegIndex;

    public static final String KEY_HEAD_INDEX = "head_index";
    public static final String KEY_BODY_INDEX = "body_index";
    public static final String KEY_LEG_INDEX = "leg_index";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // Define the behavior for onImageSelected
    public void onImageSelected(int position) {
        // Create a Toast that displays the position that was clicked
        Toast.makeText(this, "Position clicked = " + position, Toast.LENGTH_SHORT).show();

        // DONE (2) Based on where a user has clicked, store the selected list index for the head, body, and leg BodyPartFragments

        int bodyPartNumber = position / 12;

        int listIndex = position - (bodyPartNumber * 12);

        switch (bodyPartNumber) {
            case 0:
                mHeadIndex = listIndex;
                break;
            case 1:
                mBodyIndex = listIndex;
                break;
            case 2:
                mLegIndex = listIndex;
                break;
            default:
                break;
        }

        // DONE (3) Put this information in a Bundle and attach it to an Intent that will launch an AndroidMeActivity
        Bundle b = new Bundle();
        b.putInt(KEY_HEAD_INDEX, mHeadIndex);
        b.putInt(KEY_BODY_INDEX, mBodyIndex);
        b.putInt(KEY_LEG_INDEX, mLegIndex);

        final Intent intent = new Intent(this, AndroidMeActivity.class);
        intent.putExtras(b);

        // DONE (4) Get a reference to the "Next" button and launch the intent when this button is clicked
        View nextButton = findViewById(R.id.btn_master_list_next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

    }

}
