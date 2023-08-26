package de.kisner.eap8.interfaces.facade;

import org.jeesl.interfaces.facade.JeeslFacade;

public interface EapFacade extends JeeslFacade
{
	@Deprecated
	public static String[] defaultLocales = {"en"};
	
	public enum LocaleCode {en,de}
	public static String[] defaults = {"en"};
	
	public enum IoSsiSystemCode {eap}
	public enum IoSsiCredentialDeepl {free}
	
	public enum TenantRealmCode {ssi,user};
	
	public enum SecurityViewCode{cMenu,
		ioAttTabG,ioAttTabT,ioCmsTable,ioCryptoTabG,ioDbTable,ioDmsTable,ioFrTable,
		ioMailTabG,ioMailNewsletterTabG,ioMailNewsletterTabT,
		ioMavenTabG,
		ioReportTable,ioLabelTabG,ioSsiTable,ioIotTabG,
		mAssetTable,mBbTable,
		mCalendarTabG,mCalendarTabT,
		mChecklistTabG,mChecklistTabT,
		mHdTabG,mHdTabT,mItsTabT,mItsTabG,mMmgTabG,
		mTafuTabG,mTafuTabT,
		mLfTabG,mLfTabT,
		mMdcTabG,mMdcTabT,mNewsTabT,
		mMapTable,mMsgTable,mTrainingTable,mTsTable,mSurveyTable,mWorkflowTable,mHydroTable,
		mRmmvTabG,mRmmvTabT,
		sysConstraintTable,
		sSysTable,sysHealthTable,sSecTable,sysJobTable, ioDashTable,adminDashboards}
}