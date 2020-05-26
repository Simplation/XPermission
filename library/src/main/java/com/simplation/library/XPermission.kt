package com.simplation.library

import androidx.fragment.app.FragmentActivity

/**
 * @作者: W ◕‿-｡ Z
 * @日期: 2020/5/25 19:50
 * @描述:
 * @更新:
 */
object XPermission {
    private const val TAG = "InvisibleFragment"

    fun request(
        activity: FragmentActivity,
        vararg permission: String,
        callback: PermissionCallback
    ) {
        val fragmentManager = activity.supportFragmentManager
        val exitFragment = fragmentManager.findFragmentByTag(TAG)

        val fragment = if (exitFragment != null) {
            exitFragment as InvisibleFragment
        } else {
            val invisibleFragment = InvisibleFragment()
            fragmentManager.beginTransaction().add(invisibleFragment, TAG).commitNow()
            invisibleFragment
        }

        // 这里在 permission 前面加个星号的意思是：将数组转化为可变长度参数传递过去
        fragment.requestNow(callback, *permission)
    }
}