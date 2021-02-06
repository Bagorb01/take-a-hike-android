package com.example.takeahike

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

open class NavigationFragment(
    private val bottomBarVisible: Boolean = false,
    private val topBarVisible: Boolean = false,
    private val topBarTitle: String = "",
    private val topBarStyle: Int = ToolbarDesigner.TRANSPARENT_TOOLBAR
): Fragment() {
    private val toolbarDesigner: ToolbarDesigner by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_entry, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbarDesigner.setup(requireActivity(), if(topBarVisible) View.VISIBLE else View.GONE, topBarTitle, topBarStyle)
    }

    override fun onResume() {
        super.onResume()

        requireActivity().bottomNavigation?.let {it.visibility = if(bottomBarVisible) View.VISIBLE else View.GONE}
    }
}