package com.example.studyplan.util

import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AlertDialog

/**
 * <p>作者：Night  2019/4/29 15:28
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：弹窗工具类
 */
object DialogUtil {

    fun showDialog(
        ctx: Context, str: String,
        posListener: (dialog: DialogInterface, which: Int) -> Unit,
        negListener: (dialog: DialogInterface, which: Int) -> Unit
    ) {
        AlertDialog.Builder(ctx)
            .setMessage(str)
            .setPositiveButton("确定", posListener)
            .setNegativeButton("取消", negListener)
            .show()
    }
}