package permisssion.ask.askpermission;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;

import permisssion.ask.ask.BaseActivity;
import permisssion.ask.ask.listener.PermissionListener;
import permisssion.ask.ask.listener.PermissionProvider;

public class MainActivity extends BaseActivity implements PermissionListener {

    private TextView txtImei;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtImei = (TextView) findViewById(R.id.imeiNo);
        if (hasPermission(android.Manifest.permission.READ_PHONE_STATE)) {
            txtImei.setText(getIMEINumber());
        } else {
            getPermission(new PermissionProvider(android.Manifest.permission.READ_PHONE_STATE, 10, this));
        }
    }

    private String getIMEINumber() {
        String imeiNo = "";
        TelephonyManager telephonyManager = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
        if (hasPermission(android.Manifest.permission.READ_PHONE_STATE)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                imeiNo = telephonyManager.getImei();
            } else {
                imeiNo = telephonyManager.getDeviceId();
            }
        }

        return imeiNo;
    }

    @Override
    public void onInteractionCancelled() {
        txtImei.setText("interactino Cancelled");
    }

    @Override
    public void onPermissionGranted() {
        txtImei.setText(getIMEINumber());
    }

    @Override
    public void onPermissionDenied() {
        txtImei.setText("Permission Denied");
    }
}
