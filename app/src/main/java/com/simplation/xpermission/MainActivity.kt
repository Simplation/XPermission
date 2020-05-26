package com.simplation.xpermission

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.simplation.library.XPermission
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        makeCallBtn.setOnClickListener {
            XPermission.request(
                this,
                // 申请多个权限需要使用 `,` 隔开
                Manifest.permission.CALL_PHONE,
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) { allGranted, deniedList ->
                /**
                 * allGranted：一个 boolean 类型的变量，若为 true ,则所有权限申请通过
                 * deniedList：一个 List 类型的变量，表示用户拒绝权限列表
                 */
                if (allGranted) {
                    call()
                } else {
                    Toast.makeText(this, "You defined $deniedList", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    @SuppressLint("MissingPermission")
    private fun call() {
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel:10086")
        startActivity(intent)
    }
}
