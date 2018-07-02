package permisssion.ask.ask.listener;

public interface PermissionListener {

    void onInteractionCancelled();

    void onPermissionGranted();

    void onPermissionDenied();

}
