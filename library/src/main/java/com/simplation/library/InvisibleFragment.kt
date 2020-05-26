package com.simplation.library

import android.content.pm.PackageManager
import androidx.fragment.app.Fragment

/**
 * @作者: W ◕‿-｡ Z
 * @日期: 2020/5/25 19:38
 * @描述: 运行时权限的实现思路，有以下三种：
 *          1. 将运行时权限的操作封装到 BaseActivity 中
 *          2. 提供一个透明的 Activity 来处理
 *          3. 提供一个隐藏的 Fragment 来处理  (使用)
 * @更新:
 */

typealias PermissionCallback = (Boolean, List<String>) -> Unit

class InvisibleFragment : Fragment() {

    private var callback: PermissionCallback? = null

    fun requestNow(cb: PermissionCallback, vararg permission: String) {
        callback = cb

        requestPermissions(permission, 1)
    }

    /**
     * 请求返回结果
     * @param requestCode Int 请求码
     * @param permissions Array<String> 权限
     * @param grantResults IntArray 请求结果
     */
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == 1) {
            val deniedList = ArrayList<String>()

            for ((index, result) in grantResults.withIndex()) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    deniedList.add(permissions[index])
                }
            }

            val allGranted = deniedList.isEmpty()

            // 对申请权限的结果进行回调
            callback?.let {
                it(allGranted, deniedList)
            }
        }
    }
}