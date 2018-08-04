package com.coffietocode.comicapps.comicmania.view.dialog

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.afollestad.materialdialogs.MaterialDialog
import com.coffietocode.comicapps.comicmania.R

class DialogHandler : View.OnClickListener {

    private var mDialog: MaterialDialog? = null

    private var mContext: Context? = null

    fun initiate(context: Context) {
        mContext = context
    }

    fun showThemeChooserDialog() {
        mDialog?.dismiss()
        val dialog = MaterialDialog.Builder(mContext!!)
                .title("Theme")
                .customView(R.layout.dialog_choose_theme, false)
                .backgroundColorRes(R.color.colorPrimary)
                .titleColorRes(R.color.md_white_1000)
                .positiveColorRes(R.color.md_white_1000)
                .negativeColorRes(R.color.md_white_1000)
                .buttonRippleColorRes(R.color.md_white_1000)
                .positiveText("Ok")
                .negativeText("Cancel")
                .onNegative { dialog, _ ->
                    dialog.dismiss()
                }
                .onPositive { dialog, _ ->
                    dialog.dismiss()

                }
                .show()

        val view = dialog.customView
        if (view != null) {
            view.findViewById<LinearLayout>(R.id.llWhiteTheme).setOnClickListener(this)
            view.findViewById<LinearLayout>(R.id.llDarkAmoledTheme).setOnClickListener(this)
            view.findViewById<LinearLayout>(R.id.llDarkTheme).setOnClickListener(this)
        }
    }

    override fun onClick(view: View?) {
        if (view != null) {
            val viewId = view.id
            when (viewId) {
                R.id.llWhiteTheme -> {
                    view.findViewById<ImageView>(R.id.icWhiteThemeDone).visibility = View.VISIBLE
                    view.rootView.findViewById<ImageView>(R.id.icDarkThemeDone).visibility = View.GONE
                    view.rootView.findViewById<ImageView>(R.id.icDarkAlmThemeDone).visibility = View.GONE
                }
                R.id.llDarkTheme -> {
                    view.rootView.findViewById<ImageView>(R.id.icWhiteThemeDone).visibility = View.GONE
                    view.findViewById<ImageView>(R.id.icDarkThemeDone).visibility = View.VISIBLE
                    view.rootView.findViewById<ImageView>(R.id.icDarkAlmThemeDone).visibility = View.GONE
                }
                R.id.llDarkAmoledTheme -> {
                    view.rootView.findViewById<ImageView>(R.id.icWhiteThemeDone).visibility = View.GONE
                    view.rootView.findViewById<ImageView>(R.id.icDarkThemeDone).visibility = View.GONE
                    view.findViewById<ImageView>(R.id.icDarkAlmThemeDone).visibility = View.VISIBLE
                }
            }
        }
    }
}