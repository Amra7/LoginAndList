package com.example.amrapoprzanovic.loginandlist.singletons.service;

import com.example.amrapoprzanovic.loginandlist.singletons.UserData;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

/**
 * Created by amrapoprzanovic on 14/04/15.
 */
public class ServiceRequest {

    public static void get(String url, Callback callback){
        request(url, null, callback, false);
    }

    public static void post(String url, String json, Callback callback){
        request(url, json, callback, true);
    }

    private static void request(String url, String json, Callback callback, boolean isPost){
        MediaType JSON = MediaType.parse("application/json");

        //ponasa se slicno browseru
        OkHttpClient client = new OkHttpClient();

        Request.Builder requestBuilder = new Request.Builder();
        RequestBody requestBody = RequestBody.create(JSON, json); // JSON  je tip, json je objekat
        if(isPost == true){
            requestBuilder.post(requestBody);
        } else {
            requestBuilder.get();
        }

        /*kada smo prosliedili POST ili GET onda posaljemo ostale podatke
        * ostali podaci su: URL, Authorization i jos jedan Header
        * nakon toga nabidamo request.
         */

        Request request =  requestBuilder
                .url(url)
                .header("Authorization", UserData.getInstance().getBaseAuth())
                .header("Accept" ,"application/json") //Accept govori koji tip podatka mi prihvatamo
                .build();

        Call call = client.newCall(request);
        //kada dobije odgovor pozov callback koji je prosljedjen
        call.enqueue(callback);



    }
}
