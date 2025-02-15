package com.carlos.grabredenvelope

import android.app.ActivityManager
import android.app.Application
import android.content.Context
import android.os.Process
import com.carlos.cutils.CUtils
import com.carlos.cutils.util.LogUtils
import com.carlos.grabredenvelope.execption.MyUncaughtExceptionHandler
import io.sentry.Sentry


/**
 *                             _ooOoo_
 *                            o8888888o
 *                            88" . "88
 *                            (| -_- |)
 *                            O\  =  /O
 *                         ____/`---'\____
 *                       .'  \\|     |//  `.
 *                      /  \\|||  :  |||//  \
 *                     /  _||||| -:- |||||-  \
 *                     |   | \\\  -  /// |   |
 *                     | \_|  ''\---/''  |   |
 *                     \  .-\__  `-`  ___/-. /
 *                   ___`. .'  /--.--\  `. . __
 *                ."" '<  `.___\_<|>_/___.'  >'"".
 *               | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 *               \  \ `-.   \_ __\ /__ _/   .-` /  /
 *          ======`-.____`-.___\_____/___.-`____.-'======
 *                             `=---='
 *          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 *                     佛祖保佑        永无BUG
 *            佛曰:
 *                   写字楼里写字间，写字间里程序员；
 *                   程序人员写程序，又拿程序换酒钱。
 *                   酒醒只在网上坐，酒醉还来网下眠；
 *                   酒醉酒醒日复日，网上网下年复年。
 *                   但愿老死电脑间，不愿鞠躬老板前；
 *                   奔驰宝马贵者趣，公交自行程序员。
 *                   别人笑我忒疯癫，我笑自己命太贱；
 *                   不见满街漂亮妹，哪个归得程序员？
 */

/**
 * Github: https://github.com/xbdcc/.
 * Created by 小不点 on 2016/2/6.
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        LogUtils.d("onCreate")

        instance = this

        LogUtils.isShowLog = BuildConfig.DEBUG

        CUtils.init(this)

        AppInit()

        initSentry()

    }

    private fun initSentry() {
        Sentry.init {
            it.dsn = BuildConfig.SENTRY_DSN
            it.environment = BuildConfig.BUILD_TYPE
        }
        Thread.setDefaultUncaughtExceptionHandler(MyUncaughtExceptionHandler())
    }

    companion object {
        lateinit var instance: MyApplication
            private set
    }

}