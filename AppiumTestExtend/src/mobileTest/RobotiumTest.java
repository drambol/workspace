//package mobileTest;
//
//import android.test.ActivityInstrumentationTestCase2;
//
//import com.jayway.android.robotium.solo.Solo;
//
//@SuppressWarnings("rawtypes")
//public class RobotiumTest extends ActivityInstrumentationTestCase2 {
//	private static final String TARGET_PACKAGE_ID = "com.mozy.mobile.android";
//	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.mozy.mobile.android.activities.startup.FirstRun";
//	String debugstatus = "DEBUG_STATUS";
//
//	private static Class<?> launcherActivityClass;
//
//	static {
//		try {
//			launcherActivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	@SuppressWarnings("unchecked")
//	public RobotiumTest() throws ClassNotFoundException {
//		super(TARGET_PACKAGE_ID, launcherActivityClass);
//	}
//
//	private Solo solo;
//
//	@Override
//	protected void setUp() throws Exception {
//		solo = new Solo(getInstrumentation(), getActivity());
//	}
//
//	public void testCanOpenSettings() {
//		String SyncDownloadFile = "IMG_20140724_100936.jpg";
//		// signIn();
//		// signOut();
//		// downloadSyncFile(SyncDownloadFile);
//		downloadBackupFile(SyncDownloadFile);
//	}
//
//	public void signIn() {
//		solo.clickOnButton("Sign in to Mozy");
//		solo.enterText(0, "fangyuanren@gmail.com");
//		solo.enterText(1, "test1234");
//		solo.clickOnButton("Sign In");
//		solo.sleep(9000);
//		solo.clickOnButton("No");
//		solo.sleep(2000);
//	}
//
//	public void signOut() {
//		solo.pressMenuItem(1);
//		solo.sleep(1000);
//		solo.clickOnText("Sign Out");
//		solo.sleep(1000);
//		solo.clickOnButton("OK");
//		solo.sleep(1000);
//	}
//
//	public void downloadSyncFile(String DownloadFile) {
//		boolean expected = true;
//
//		solo.clickOnText("All Files");
//		solo.clickOnText("Sync", 2);
//		solo.sleep(2000);
//		solo.clickOnText("Mobile Uploads");
//		solo.sleep(2000);
//		solo.clickLongOnText(DownloadFile);
//		solo.sleep(1000);
//		solo.clickOnText("Download");
//		solo.sleep(6000);
//
//		/*
//		 * solo.clickOnText("My Mozy"); solo.sleep(2000);
//		 * solo.clickOnText("Downloaded"); solo.sleep(2000);
//		 * //solo.clickOnText("Sync", 0); solo.sleep(2000); boolean actual =
//		 * solo.searchText(DownloadFile);
//		 * assertEquals("This is not found",expected,actual); solo.sleep(2000);
//		 * solo.clickOnText(DownloadFile); solo.sleep(2000);
//		 */
//	}
//
//	public void downloadBackupFile(String DownloadFile) {
//		boolean expected = true;
//
//		solo.clickOnText("All Files");
//		solo.clickOnText("WIN-FLR830RECG2");
//		solo.sleep(2000);
////		Activity a = getActivity();
////		String tab1c1 = a.getString(R.string.tab1_content1);
////		solo.clickOnScreen(100, 100);
//		solo.sleep(3000);
//		solo.clickOnText("Users");
//		solo.sleep(2000);
//
//		/*
//		 * solo.clickOnText("Mobile Uploads"); solo.sleep(2000);
//		 * solo.clickLongOnText(DownloadFile); solo.sleep(1000);
//		 * solo.clickOnText("Download"); solo.sleep(6000);
//		 */
//
//		/*
//		 * solo.clickOnText("My Mozy"); solo.sleep(2000);
//		 * solo.clickOnText("Downloaded"); solo.sleep(2000);
//		 * //solo.clickOnText("Sync", 0); solo.sleep(2000); boolean actual =
//		 * solo.searchText(DownloadFile);
//		 * assertEquals("This is not found",expected,actual); solo.sleep(2000);
//		 * solo.clickOnText(DownloadFile); solo.sleep(2000);
//		 */
//	}
//
//	@Override
//	public void tearDown() throws Exception {
//		try {
//			solo.finalize();
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
//		getActivity().finish();
//		super.tearDown();
//
//	}
//}
//
