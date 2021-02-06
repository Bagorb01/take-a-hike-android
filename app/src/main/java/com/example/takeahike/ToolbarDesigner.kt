package com.example.takeahike

import android.graphics.PorterDuff
import android.view.View
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_main.*

class ToolbarDesigner {

    companion object {
        const val TRANSPARENT_TOOLBAR: Int = 1
    }

    fun useWhiteToolbar(activity: FragmentActivity, title: String) {
        activity.toolbarContainer.visibility = View.VISIBLE
        activity.toolbarContainer.elevation = 4f

        activity.mainToolbar.title = title
        activity.mainToolbar.setBackgroundColor(
            activity.resources.getColor(R.color.white, null)
        )
        activity.mainToolbar.elevation = 4f
        activity.mainToolbar.setTitleTextColor(
            activity.resources.getColor(R.color.charcoal, null)
        )
        setUpBackIndicator(activity)
    }

    fun setup(activity: FragmentActivity, visibility: Int, title: String, toolbarType: Int) {
        activity.toolbarContainer.visibility = visibility
        activity.toolbarContainer.elevation = 0f
        activity.mainToolbar.title = title
        activity.mainToolbar.background = null
        activity.mainToolbar.elevation = 0f
        activity.mainToolbar.setTitleTextColor(
            activity.resources.getColor(R.color.charcoal, null)
        )
        setUpBackIndicator(activity)
    }

    private fun setUpBackIndicator(activity: FragmentActivity) {
        val icon = activity.getDrawable(R.drawable.ic_baseline_arrow_back)
        icon?.setColorFilter(
            activity.resources.getColor(R.color.charcoal, null),
            PorterDuff.Mode.SRC_ATOP
        )
        (activity as MainActivity).supportActionBar?.setHomeAsUpIndicator(icon)
    }
}