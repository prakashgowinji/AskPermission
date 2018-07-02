# AskPermission

Steps to use:
1. Clone the repository
2. Build the project and install it in a device
3. .aar file would be generated in the build directory of module ask
4. take this .aar file to your project's libs folder
5. Add the .arr to your app level gradle
6. Build the project
7. Extend BaseActivity from your Activity where you need to ask a dangerous permission
8. Implement the PermissionListener interface within your Activity
9. Enjoy!!
