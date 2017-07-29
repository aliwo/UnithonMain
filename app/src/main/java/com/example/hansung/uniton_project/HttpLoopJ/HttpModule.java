package com.example.hansung.uniton_project.HttpLoopJ;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.hansung.uniton_project.Login.User;
import com.example.hansung.uniton_project.MainActivity;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.protocol.HTTP;

/**
 * Created by aliwo on 2017-03-26.
 */

public class HttpModule
{
    private RestClient client;
    private Context mContext;
    private RequestParams params;
    private LoginResponseHandler loginResponseHandler;
    private RegisterResponseHandler registerResponseHandler;
    private RegionsResponseHandler regionsResponseHandler;

    public HttpModule(RestClient client, Context context)
    {
        this.client = client;
        mContext = context;
        loginResponseHandler = new LoginResponseHandler(mContext);
        registerResponseHandler = new RegisterResponseHandler(mContext);
        regionsResponseHandler = new RegionsResponseHandler(mContext);
    }

    public void register(String name, String account, String password)
    {
        JSONObject params = new JSONObject();
        try{
            params.put("email", account);
            params.put("name", name);
            params.put("password", password);
            StringEntity entity = new StringEntity(params.toString(), "utf-8");
            registerResponseHandler.insertInfo(account, name, password);
            client.post(mContext, "/api/user/", entity, "application/json" ,registerResponseHandler);
        }catch (JSONException e)
        {
            e.printStackTrace();
        }

    }

    public void login(String account, String password)
    {
        JSONObject params = new JSONObject();
        try{
            params.put("email", account);
            params.put("password", password);
            StringEntity entity = new StringEntity(params.toString(), "utf-8");
            loginResponseHandler.insertInfo(account, password);
            client.post(mContext, "/api/user/login", entity, "appplication/json" ,loginResponseHandler);
        }catch (JSONException e)
        {
            e.printStackTrace();
        }

    }

    public void getRegions()
    {
        client.get("/api/city", null, regionsResponseHandler);
    }

}

class RegisterResponseHandler extends JsonHttpResponseHandler
{
    private Context mContext;
    String name;
    String email;
    String password;


    public RegisterResponseHandler(Context context)
    {
        mContext = context;
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, JSONObject response)
    {
        super.onSuccess(statusCode, headers, response);
        Log.d("register Success", "JSON received");
        try {
            String token = response.getString("token");
            Log.d("register Success", token);
            if(token!=null)
            {
                User user = new User(mContext);
                user.register(email, password, name,token);
                Intent intent = new Intent(mContext, MainActivity.class);
                mContext.startActivity(intent);
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse)
    {
        super.onFailure(statusCode, headers, throwable, errorResponse);
        Log.d("register Failure", "JSON received");

    }

    public void insertInfo(String email, String name, String password)
    {
        this.email = email;
        this.name = name;
        this. password = password;

    }


}


class LoginResponseHandler extends JsonHttpResponseHandler
{
    private Context mContext;
    String name;
    String email;

    public LoginResponseHandler(Context context)
    {
        super();
        mContext =context;
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, JSONObject response)
    {
        super.onSuccess(statusCode, headers, response);
        Log.d("login Success", "JSON received");

        try {
            String token = response.getString("token");
            Log.d("login Success", token);
            Intent intent = new Intent(mContext, MainActivity.class);
            mContext.startActivity(intent);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse)
    {
        super.onFailure(statusCode, headers, throwable, errorResponse);
        Log.d("login Failure", "failed");

    }

    @Override
    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable)
    {
        super.onFailure(statusCode, headers, responseString, throwable);
        Log.d("login failure", responseString);
    }

    public void insertInfo(String email, String name)
    {
        this.email = email;
        this.name = name;

    }

}

class RegionsResponseHandler extends JsonHttpResponseHandler
{
    private Context mContext;

    public RegionsResponseHandler(Context context)
    {
        mContext = context;
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, JSONArray response)
    {
        super.onSuccess(statusCode, headers, response);
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, JSONObject response)
    {
        super.onSuccess(statusCode, headers, response);
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse)
    {
        super.onFailure(statusCode, headers, throwable, errorResponse);
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable)
    {
        super.onFailure(statusCode, headers, responseString, throwable);
    }
}
