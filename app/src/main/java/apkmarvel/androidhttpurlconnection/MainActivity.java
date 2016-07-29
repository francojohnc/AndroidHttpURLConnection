package apkmarvel.androidhttpurlconnection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import apkmarvel.androidhttpurlconnection.webservice.WebServiceRequest;
import apkmarvel.androidhttpurlconnection.webservice.command.PostCommand;
import apkmarvel.androidhttpurlconnection.webservice.model.WebServiceInfo;

public class MainActivity extends AppCompatActivity {
    private PostCommand postCommand;
    public static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void cancel(View v){
        postCommand.cancel();
    }
    public void post(View v) {
        WebServiceInfo webServiceInfo = new WebServiceInfo();
        String url="http://mcdodev.mobext.ph/app/api/v2/User/reset_password";
        webServiceInfo.setUrl(url);
        webServiceInfo.addParam("email", "johncarlo_franco@yahoo.com");
        webServiceInfo.addParam("source", "mobapps");
        postCommand = new PostCommand(webServiceInfo);
        WebServiceRequest webServiceRequest = new WebServiceRequest(postCommand);
        webServiceRequest.execute();
    }
}
