package apkmarvel.androidhttpurlconnection.webservice.interfaces;


import apkmarvel.androidhttpurlconnection.webservice.model.WebResponse;

public interface WebCommand {
	 WebResponse execute();
	 void cancel();
	 void setProgessListener();
//	public void setProgessListener(OnServiceListener listener);
}
