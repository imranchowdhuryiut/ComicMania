package com.coffietocode.comicapps.comicmania.view.dialog

import android.content.Context
import com.afollestad.materialdialogs.MaterialDialog
import com.coffietocode.comicapps.comicmania.R

class DialogHandler {

    private var mDialog: MaterialDialog? = null

    private var mContext: Context? = null

    fun initiate(context: Context) {
        mContext = context
    }

    fun showDialogWithTitle(title: String,
                            onOk: (() -> Unit)? = null,
                            onCancel: (() -> Unit)? = null): MaterialDialog? {
        mDialog?.dismiss()
        return MaterialDialog.Builder(mContext!!)
                .title(title)
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
                    onCancel?.invoke()
                }
                .onPositive { dialog, _ ->
                    dialog.dismiss()
                    onOk?.invoke()

                }
                .show()

    }
}