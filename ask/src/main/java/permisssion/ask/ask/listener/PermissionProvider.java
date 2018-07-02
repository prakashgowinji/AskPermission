package permisssion.ask.ask.listener;

public class PermissionProvider {

    private String requiredPermission;
    private int permissionRequestCode;
    private PermissionListener listener;

    public PermissionProvider(String requiredPermission, int permissionRequestCode, PermissionListener listener) {
        this.requiredPermission = requiredPermission;
        this.permissionRequestCode = permissionRequestCode;
        this.listener = listener;
    }

    public String getRequiredPermission() {
        return requiredPermission;
    }

    public void setRequiredPermission(String requiredPermission) {
        this.requiredPermission = requiredPermission;
    }

    public int getPermissionRequestCode() {
        return permissionRequestCode;
    }

    public void setPermissionRequestCode(int permissionRequestCode) {
        this.permissionRequestCode = permissionRequestCode;
    }

    public PermissionListener getListener() {
        return listener;
    }

    public void setListener(PermissionListener listener) {
        this.listener = listener;
    }
}
