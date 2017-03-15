package servicetest.zkk.com.myapplication;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.util.TypedValue;

import java.util.List;

/**
 * Function:<br>
 * <p/>
 * date: 2017/2/10.
 *
 * @author GuJian
 */
public class CommUtils {
    public static int sp2px(float spValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spValue, Resources
                .getSystem().getDisplayMetrics());
    }

    public static int dp2px(float dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, Resources.getSystem().getDisplayMetrics());
    }

    public static void getPhoneInformation(){
        Logger.v("brand:"+ Build.BRAND);
        Logger.v("MODEL:"+ Build.MODEL);
        Logger.v("PRODUCT:"+ Build.PRODUCT);
        Logger.v("SDK_INT:"+ Build.VERSION.SDK_INT);
    }

    public static void getAppInfo(Context context){
        PackageManager pm  = context.getPackageManager();
        List<ApplicationInfo> applicationInfoList = pm.getInstalledApplications(PackageManager.GET_UNINSTALLED_PACKAGES);
        if(applicationInfoList!=null&&applicationInfoList.size()>0){
            for(ApplicationInfo info:applicationInfoList) {
                Logger.v("packageName:"+info.packageName);
            }
        }

    }



//    public void printAppInfo(List<ApplicationInfo> applicationInfos){
//        if(applicationInfos!=null&&applicationInfos.size()>0){
//            for(ApplicationInfo info:applicationInfos) {
//                Logger.v("packageName:"+info.packageName);
//            }
//        }
//    }

}
