// Copyright (c) Microsoft Corporation
// Licensed under the MIT license. See LICENSE file in the project root for full license information.

package xbl.sample.android.layers;

import xbl.sample.android.MainActivity;
import xbl.sample.android.R;
import xbl.sample.android.views.MenuView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Button;
import android.graphics.Color;

public class SocialGroupsLayer
{
    private static final String TAG = "Social Groups Layer";

    public native void InitializeNativeVars();

    // Add Sub Layers
    public SocialGroupViewLayer m_groupViewLayer;

    private MainActivity m_activity;

    private Button m_buttonUsers;
    private Button m_buttonGroups;

    public SocialGroupsLayer(MainActivity activity)
    {
        m_activity = activity;

        m_groupViewLayer = new SocialGroupViewLayer(m_activity);

        // Create User Button
        {
            m_buttonUsers = new Button(m_activity);
            m_buttonUsers.setText(R.string.button_socialFriendsGroup);
            m_buttonUsers.setTextColor(Color.BLACK);
            m_buttonUsers.setBackgroundResource(android.R.drawable.btn_default);
            m_buttonUsers.setHeight(48);
            m_buttonUsers.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {

                }
            });
        }

        // Create Group Button
        {
            m_buttonGroups = new Button(m_activity);
            m_buttonGroups.setText(R.string.button_socialFavoritesGroup);
            m_buttonGroups.setTextColor(Color.BLACK);
            m_buttonGroups.setBackgroundResource(android.R.drawable.btn_default);
            m_buttonGroups.setHeight(48);
            m_buttonGroups.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {

                }
            });
        }

        InitializeNativeVars();
    }

    public void Update(double dt)
    {

    }

    public void show(LinearLayout layout)
    {
        layout.addView(m_buttonUsers);
        layout.addView(m_buttonGroups);

        // Bind Menu Button
        {
            Button buttonMenuBack = m_activity.findViewById(R.id.button_MenuBack);
            buttonMenuBack.setText(R.string.button_socialMenu);
            buttonMenuBack.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    m_activity.menuView.changeLayer(MenuView.MVL_SOCIAL);
                }
            });

            buttonMenuBack.setVisibility(View.VISIBLE);
        }
    }
}