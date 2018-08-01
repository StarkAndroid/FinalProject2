package com.udacity.gradle.builditbigger;

import android.content.Context;
        import android.content.Intent;
        import android.os.AsyncTask;
        import android.util.Log;
        import android.util.Pair;
        import android.widget.Toast;

        import com.google.api.client.extensions.android.http.AndroidHttp;
        import com.google.api.client.extensions.android.json.AndroidJsonFactory;
        import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
        import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
        import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

        import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;

    @Override
    protected void onPostExecute(String s) {
        MainActivity.setJoke(s);
        super.onPostExecute(s);
    }

    @Override
    protected String doInBackground(Void... voids) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.tellJoke().execute().getData();

        } catch (IOException e) {
            return e.getMessage();
        }
    }
}