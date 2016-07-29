package apkmarvel.androidhttpurlconnection.webservice;


import apkmarvel.androidhttpurlconnection.webservice.interfaces.WebCommand;

public class WebServiceRequest extends NetworkTask{
	private WebCommand command;
	public WebServiceRequest(WebCommand command) {
		this.command=command;
	}

	@Override
	public Object doNetworkTask() {
		return command.execute();
	}
}
