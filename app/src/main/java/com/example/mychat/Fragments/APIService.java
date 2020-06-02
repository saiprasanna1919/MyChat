package com.example.mychat.Fragments;

import com.example.mychat.Notifications.MyResponse;
import com.example.mychat.Notifications.Sender;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {

    @Headers({

            "Content-Type:application/json",
            "Authorization:key = AAAAT49UWZY:APA91bF8pAgBK1C2GyIGzOuiLHRB2GLt3lSp6lNIVIMjwn3yLBJjct3MjhR3OtFHboo--r_iXdDfMWjDTIjUCHqRLzll7TCa18-FtBl-HV-tFoa5-jjXlZSv5N1yaT-Q_FWyS0Ar62hd"
    })

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);


}
