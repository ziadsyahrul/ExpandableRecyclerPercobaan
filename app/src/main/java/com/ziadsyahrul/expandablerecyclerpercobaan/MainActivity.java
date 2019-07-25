package com.ziadsyahrul.expandablerecyclerpercobaan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mindorks.placeholderview.ExpandablePlaceHolderView;
import com.ziadsyahrul.expandablerecyclerpercobaan.model.ChildLinkItem;
import com.ziadsyahrul.expandablerecyclerpercobaan.model.ResponseHome;
import com.ziadsyahrul.expandablerecyclerpercobaan.model.ServeItem;
import com.ziadsyahrul.expandablerecyclerpercobaan.network.ApiClient;
import com.ziadsyahrul.expandablerecyclerpercobaan.network.ApiInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Map<String, List<ServeItem>> categoryMap;
    private List<ServeItem> serveItems;
    private List<ChildLinkItem> childLinkItems;
    private ExpandablePlaceHolderView expandablePlaceHolderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        serveItems = new ArrayList<>();
        categoryMap = new HashMap<>();
        expandablePlaceHolderView = (ExpandablePlaceHolderView)findViewById(R.id.expandablePlaceHolder);

        loadData();

        expandablePlaceHolderView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Clicked", v.getId()).show();
            }
        });

    }

    private void loadData() {
        String id = "25";
        String mobile = "2y10s6ZYEuThB8IkZ0sl1ucOOeJFYf4DmGNbeIyB6j4l9lPpwdu41n5K";
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImM4MWMyMWYyNzIzNTVjYjZjMWJkOGY2ZWE4NzcxMTkwYTc0ZTYzMDc3ZWU4OWI1YjUxNzM4MDQxMjI3NGRhNzM3ZjgwNTEzZmVjYTU5ZmVmIn0.eyJhdWQiOiIxIiwianRpIjoiYzgxYzIxZjI3MjM1NWNiNmMxYmQ4ZjZlYTg3NzExOTBhNzRlNjMwNzdlZTg5YjViNTE3MzgwNDEyMjc0ZGE3MzdmODA1MTNmZWNhNTlmZWYiLCJpYXQiOjE1NjQwMjYwMjIsIm5iZiI6MTU2NDAyNjAyMiwiZXhwIjoxNTk1NjQ4NDIyLCJzdWIiOiIyMSIsInNjb3BlcyI6W119.EmmtnBEIMaOKqlQLjQ_GgDleLFcCNBRDDUrc3NfrulsF5nDnzkAbys5AtgqcRpEEKMhVjKG1MyELWKaymXiwELeT0o6ahzw-bmPDE4TBUve8-0iaJfKM60QbVVvx9AfpYILjHFvuTRQowBSVrhcHfyvBtFOHMDjLQcbSZlh402sJeMbJQlqgLl2rYT6JNJecq4VNixVYxmlPtJmzQDNy2m2AFt_izW0ahzKV71M8MQGRnZodns_tAnr7uwtBL0TG3Ht-g5lt3Jvp4TOfzLvYGlaC3wh6CIZx3FURzBePMKetlmYjFZkbqM01UnYgPEY8aq24UoA7O6ceEUkf4oBTT8L_Q020wwv_c7czbcTxBsUniJNOiDrIQloCwT5Gz1n2-WwkNXOa2O1oxzdyv_NlHsPIi42WLWjvP21_eTnCg6ig6uiT8SHShgp2Yc-9zXSj38kOsBtvJ5e_gCp5tT0PdZDIy96JTke2_1gLiGIDJ5uunrjJm_vF1Usha2gy6d7K3ChR5vAWOvO-GrO9gbk-lJ9xY6MeVVW2AogIXOvaB6y5WX5qiEqIHDM306U3tVyt9E2szAnE6t3SJGUJYyZTQtckt3UDXTk-dYiR21QotcFi2KEelOHo_uqfVXgBr7rg-WicQ0-T93ki4VMDrzUTcodTTt3jxTy8vwYK15eP0mc";
        String auth = "Bearer " + token;

        ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        apiInterface.getList(id, mobile, auth).enqueue(new Callback<ResponseHome>() {
            @Override
            public void onResponse(Call<ResponseHome> call, Response<ResponseHome> response) {
                if (response.body() != null){
                    ResponseHome responseHome = response.body();
                    List<ServeItem> serveItems = responseHome.getServe();
                    getData(serveItems);
                }
            }

            @Override
            public void onFailure(Call<ResponseHome> call, Throwable t) {

            }
        });

    }

    private void getData(List<ServeItem> serveItems) {
        for (ServeItem serveItem : serveItems) {
            List<ServeItem> serveItems1 = categoryMap.get(serveItem.getTitle());
            if (serveItems1 == null) {
                serveItems1 = new ArrayList<>();
            }

            serveItems1.add(serveItem);
            categoryMap.put(serveItem.getTitle(), serveItems1);
        }

        Iterator iterator = categoryMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry pair = (Map.Entry)iterator.next();
            expandablePlaceHolderView.addView(new HeaderView(this, pair.getKey().toString()));
            List<ServeItem> serveItemList = (List<ServeItem>)pair.getValue();

            for (ServeItem serveItem : serveItemList) {
                expandablePlaceHolderView.addView(new ChildView(this, childLinkItems));
            }

            iterator.remove();
        }
    }
}
