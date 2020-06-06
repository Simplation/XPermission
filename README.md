<h1 align="center">Welcome to XPermission 👋</h1>
<p>
</p>

## XPermission 

[![](https://jitpack.io/v/Simplation/XPermission.svg)](https://jitpack.io/#Simplation/XPermission)

Start by encapsulating a simple permission application framework by yourself, and learn the whole process of publishing open source libraries to Jitpack / Jcenter.



## Usage

#### **1.** Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

```groovy
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

#### **2.** Add the dependency

```groovy
dependencies {
	implementation 'com.github.Simplation:XPermission:1.0.0'
}
```

#### 3. Use  in your project

```Kotlin
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
```



## About

👤 **Simplation**

- `Github` ： https://github.com/Simplation/
- 个人博客：http://www.simplation.wang/



## Show your support

Give a ⭐️ if this project helped you!

***
