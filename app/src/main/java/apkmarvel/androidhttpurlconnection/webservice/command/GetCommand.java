package apkmarvel.androidhttpurlconnection.webservice.command;


import apkmarvel.androidhttpurlconnection.webservice.interfaces.WebCommand;
import apkmarvel.androidhttpurlconnection.webservice.model.WebResponse;
import apkmarvel.androidhttpurlconnection.webservice.model.WebServiceInfo;

public class GetCommand implements WebCommand {
	private WebServiceInfo webInfo;
	public GetCommand(WebServiceInfo webInfo) {
		this.webInfo=webInfo;
	}
	@Override
	public WebResponse execute() {
		WebResponse response = new WebResponse();
		/*set data*/
		return response;
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setProgessListener() {
		// TODO Auto-generated method stub
		
	}


}
