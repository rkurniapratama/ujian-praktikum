package f2_1461700099.daskom.untag.ta4_rizal;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityPresenter {
    private MainActivityView view;

    public MainActivityPresenter(MainActivityView view) {
        this.view = view;
    }

    public void getResult(){
        Call<ArrayList<Data>> call = RetrofitClient
                .getInstance()
                .getApi()
                .getData();
        call.enqueue(new Callback<ArrayList<Data>>() {
            @Override
            public void onResponse(Call<ArrayList<Data>> call,
                                   Response<ArrayList<Data>> response) {
                if (response.isSuccessful()&& response.body() != null){
                    view.onGetResult(response.body());
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Data>> call, Throwable t) {
            }
        });
    }
    public void getPosition(int position){
        view.onGetData(position);
    }
}
