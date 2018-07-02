package permisssion.ask.ask;

import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import permisssion.ask.ask.listener.PermissionProvider;

public class BaseActivity extends AppCompatActivity {

    private PermissionProvider permissionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected boolean hasPermission(String permission) {
        int permissionState = ActivityCompat.checkSelfPermission(this, permission);
        return permissionState == PackageManager.PERMISSION_GRANTED;
    }

    protected void getPermission(PermissionProvider permissionProvider) {
        this.permissionProvider = permissionProvider;
        if (!hasPermission(permissionProvider.getRequiredPermission())) {
            ActivityCompat.requestPermissions(this, new String[]{permissionProvider.getRequiredPermission()}, permissionProvider.getPermissionRequestCode());
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == permissionProvider.getPermissionRequestCode()) {
            if (grantResults.length <= 0) {
                permissionProvider.getListener().onInteractionCancelled();
            } else if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                permissionProvider.getListener().onPermissionGranted();
            } else {
                permissionProvider.getListener().onPermissionDenied();
            }
        }
    }
}
