package com.asamm.locus.addon.wear.gui.custom;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.wear.widget.drawer.WearableDrawerView;

/**
 * Created by Milan Cejnar on 14.11.2017.
 * Asamm Software, s.r.o.
 */

public class MainNavigationDrawer extends WearableDrawerView {

	private static final String TAG = "MainNavigationDrawer";

	private static final int DEFAULT_PEEK_DELAY = 1500;

	public MainNavigationDrawer(Context context) {
		this(context, null);
	}

	public MainNavigationDrawer(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public MainNavigationDrawer(Context context, AttributeSet attrs, int defStyleAttr) {
		this(context, attrs, defStyleAttr, 0);
	}

	public MainNavigationDrawer(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
	}

	@Override
	public void onDrawerStateChanged(int state) {
		super.onDrawerStateChanged(state);
		// manual hiding of peeking drawer, gets stuck otherwise
		if (state == DrawerLayout.STATE_IDLE && isPeeking()) {
			new Handler().postDelayed(() -> {
				if (isPeeking()) getController().closeDrawer();
			}, DEFAULT_PEEK_DELAY);
		}
	}

}
