package f2_1461700099.daskom.untag.ta4_rizal;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRetrofitInterface {
    @GET("nbi_ganjil.php")
    Call<ArrayList<Data>> getData();
}

