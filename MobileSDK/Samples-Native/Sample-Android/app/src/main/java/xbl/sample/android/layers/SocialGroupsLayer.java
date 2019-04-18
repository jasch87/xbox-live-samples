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

    private Button m_buttonUser;
    private Button m_buttonGroup;

    public SocialGroupsLayer(MainActivity activity)
    {
        m_activity = activity;

        m_groupViewLayer = new SocialGroupViewLayer(m_activity);

        // Create User Button
        {
            m_buttonUser = new Button(m_activity);
            m_buttonUser.setText(R.string.button_socialUsers);
            m_buttonUser.setTextColor(Color.BLACK);
            m_buttonUser.setBackgroundResource(android.R.drawable.btn_default);
            m_buttonUser.setHeight(48);
            m_buttonUser.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {

                }
            });
        }

        // Create Group Button
        {
            m_buttonGroup = new Button(m_activity);
            m_buttonGroup.setText(R.string.button_socialGroups);
            m_buttonGroup.setTextColor(Color.BLACK);
            m_buttonGroup.setBackgroundResource(android.R.drawable.btn_default);
            m_buttonGroup.setHeight(48);
            m_buttonGroup.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {

                }
            });
        }

        InitializeNativeVars();
    }

    public void show(LinearLayout layout)
    {
        layout.addView(m_buttonUser);
        layout.addView(m_buttonGroup);

        // Bind Menu Button
        {
            Button buttonMenuBack = m_activity.findViewById(R.id.button_MenuBack);
            buttonMenuBack.setText(R.string.button_socialMenu);
            buttonMenuBack.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    m_activity.menuView.changeLayer(MenuView.MVL_MAIN_MENU);
                }
            });

            buttonMenuBack.setVisibility(View.VISIBLE);
        }
    }
}