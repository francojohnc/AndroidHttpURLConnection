package apkmarvel.androidhttpurlconnection.webservice;

import android.os.AsyncTask;
import android.util.Log;

public abstract class NetworkTask<Params,Progress,Result> extends AsyncTask<Params,Progress,Result> {
    public String TAG = this.getClass().getSimpleName();
    @Override
    protected Result doInBackground(Params... paramses) {
        return doNetworkTask();
    }
    public abstract Result doNetworkTask();

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        long time = System.currentTimeMillis();
        Log.e(TAG,"onPreExecute:"+time);
    }

    @Override
    protected void onPostExecute(Result result) {
        super.onPostExecute(result);
        long time = System.currentTimeMillis();
        Log.e(TAG,"onPostExecute:"+time);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }
}
