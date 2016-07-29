package apkmarvel.androidhttpurlconnection.webservice.model;



public class WebResponse {
    private String stringResponse;
    private int responseCode;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getStringResponse() {
        return stringResponse;
    }
    public void setStringResponse(String stringResponse) {
        this.stringResponse = stringResponse;
    }



//	private Status mStatus 			= Status.FAILED;
//	private InputStream mResponse 	= null;
//	private String mMessage 		= "";
//	private String mResponseString;
//	
//	public void setStatus(Status status) {
//		mStatus = status;
//	}
//	
//	public Status getStatus() {
//		return mStatus;
//	}
//	
//	public void setMessage(String message) {
//		mMessage = message;
//	}
//	
//	public String getMessage() {
//		return mMessage;
//	}
//	
//	public void setResponse(InputStream response) {
//		// TODO Auto-generated method stub
//		mResponse = response;
//	}
//	
//	public InputStream getResponse() {
//		return mResponse;
//	}
//	
//	public void setResponse(String response) {
//		mResponseString = response;
//	}
//	
//	public String getResponseString() {
//		return mResponseString;
//	}
}
