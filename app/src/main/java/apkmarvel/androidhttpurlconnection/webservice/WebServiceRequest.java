package apkmarvel.androidhttpurlconnection.webservice;


import apkmarvel.androidhttpurlconnection.webservice.interfaces.OnServiceListener;
import apkmarvel.androidhttpurlconnection.webservice.interfaces.WebCommand;
import apkmarvel.androidhttpurlconnection.webservice.model.WebResponse;

public class WebServiceRequest extends NetworkTask<Void,Void,WebResponse>{
	private WebCommand command;
	public WebServiceRequest(WebCommand command) {
		this.command=command;
	}
	@Override
	public WebResponse doNetworkTask() {
		return command.execute();
	}
	@Override
	public void onPostSuccess(WebResponse webResponse) {
		if(onServiceListener!=null){
			onServiceListener.onServiceCallback(webResponse);
		}
	}

	@Override
	public void setOnServiceListener(OnServiceListener onServiceListener) {
		this.onServiceListener=onServiceListener;
	}
}
