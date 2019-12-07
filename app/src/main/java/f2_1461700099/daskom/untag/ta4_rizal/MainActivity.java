package f2_1461700099.daskom.untag.ta4_rizal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainActivityView {
    private Context mContext;
    private RecyclerView rvList;
    private LinearLayoutManager mLayoutManager;
    private MainActivityAdapter mAdapter;
    private MainActivityPresenter mPresenter;
    private ArrayList<Data> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        rvList = (RecyclerView) findViewById(R.id.rvList);
        mPresenter = new MainActivityPresenter(this);
        mPresenter.getResult();
    }

    @Override
    public void onGetResult(ArrayList<Data> data) {
        mAdapter = new MainActivityAdapter(mContext, data, mPresenter);
        mLayoutManager = new LinearLayoutManager(mContext);
        rvList.setLayoutManager(mLayoutManager);
        rvList.setAdapter(mAdapter);
        this.mData = data;
    }

    @Override
    public void onGetData(int position) {
        Intent intent = new Intent(mContext, DetailActivity.class);
        intent.putExtra("nama", mData.get(position).getNama());
        intent.putExtra("mobile", mData.get(position).getMobile());
        intent.putExtra("email", mData.get(position).getEmail());
        startActivity(intent);
    }
}
