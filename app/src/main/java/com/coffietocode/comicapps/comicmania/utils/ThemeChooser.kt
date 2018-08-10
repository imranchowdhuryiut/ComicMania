package com.coffietocode.comicapps.comicmania.utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.coffietocode.comicapps.comicmania.R
import com.coffietocode.comicapps.comicmania.data.repository.PrefRepository
import com.coffietocode.comicapps.comicmania.view.dialog.DialogHandler
import javax.inject.Inject

/**
 * Created by Imran Chowdhury on 8/7/2018
 */
class ThemeChooser @Inject
constructor(
        private val mDialog: DialogHandler,
        private val mPrefRepo: PrefRepository
) : View.OnClickListener {

    companion object {
        const val WHITE_THEME = "WHITE_THEME"
        const val DAEK_THEME = "DARK_THEME"
        const val DARKAMOLED_THEME = "DARKAMOLED_THEME"
    }

    private var mThemeName: Theme? = null

    fun showThemChooserDialog(mContext: Context, function: () -> Unit) {
        mDialog.initiate(mContext)
        val dialog = mDialog.showDialogWithTitle(
                "Themes",
                {
                    saveTheme()
                    function()
                },
                null
        )

        val view = dialog?.customView
        if (view != null) {
            view.findViewById<LinearLayout>(R.id.llWhiteTheme).setOnClickListener(this)
            view.findViewById<LinearLayout>(R.id.llDarkAmoledTheme).setOnClickListener(this)
            view.findViewById<LinearLayout>(R.id.llDarkTheme).setOnClickListener(this)
        }
    }

    private fun saveTheme() {
        if (mThemeName != null) {
            when (mThemeName) {
                Theme.White -> {
                    mPrefRepo.saveAppTheme(WHITE_THEME)
                }

                Theme.Dark -> {
                    mPrefRepo.saveAppTheme(DAEK_THEME)
                }

                Theme.DarkAmoled -> {
                    mPrefRepo.saveAppTheme(DARKAMOLED_THEME)
                }
            }
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
                    mThemeName = Theme.White
                }
                R.id.llDarkTheme -> {
                    view.rootView.findViewById<ImageView>(R.id.icWhiteThemeDone).visibility = View.GONE
                    view.findViewById<ImageView>(R.id.icDarkThemeDone).visibility = View.VISIBLE
                    view.rootView.findViewById<ImageView>(R.id.icDarkAlmThemeDone).visibility = View.GONE
                    mThemeName = Theme.Dark
                }
                R.id.llDarkAmoledTheme -> {
                    view.rootView.findViewById<ImageView>(R.id.icWhiteThemeDone).visibility = View.GONE
                    view.rootView.findViewById<ImageView>(R.id.icDarkThemeDone).visibility = View.GONE
                    view.findViewById<ImageView>(R.id.icDarkAlmThemeDone).visibility = View.VISIBLE
                    mThemeName = Theme.DarkAmoled
                }
            }
        }
    }

    enum class Theme {
        White,
        Dark,
        DarkAmoled
    }
}