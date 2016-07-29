package apkmarvel.androidhttpurlconnection.webservice.command;


import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;

import apkmarvel.androidhttpurlconnection.webservice.UtilNetConnection;
import apkmarvel.androidhttpurlconnection.webservice.interfaces.WebCommand;
import apkmarvel.androidhttpurlconnection.webservice.model.WebResponse;
import apkmarvel.androidhttpurlconnection.webservice.model.WebServiceInfo;

public class PostCommand implements WebCommand {
	private WebServiceInfo webInfo;
	private HttpURLConnection con;
	public PostCommand(WebServiceInfo webInfo) {
		this.webInfo=webInfo;
	}
	@Override
	public WebResponse execute() {
		WebResponse response = new WebResponse();
		try {
			 con = UtilNetConnection.buildConnection(webInfo.getUrl());
			UtilNetConnection.writeParam(con,UtilNetConnection.getPostDataString(webInfo.getParam()));
			/*get data*/
			int responseCode = con.getResponseCode();
			String result = UtilNetConnection.inputStreamToString(con.getInputStream());
			/*set data*/
			response.setResponseCode(responseCode);
			response.setStringResponse(result);
			Log.e("PostCommand", result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}
	@Override
	public void cancel() {
		if(con!=null)con.disconnect();
	}
	@Override
	public void setProgessListener() {
		// TODO Auto-generated method stub
	}

}