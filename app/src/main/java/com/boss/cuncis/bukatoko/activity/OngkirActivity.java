package com.boss.cuncis.bukatoko.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.boss.cuncis.bukatoko.R;
import com.boss.cuncis.bukatoko.data.Constant;
import com.boss.cuncis.bukatoko.data.model.Cost;
import com.boss.cuncis.bukatoko.data.retrofit.ApiClient;
import com.boss.cuncis.bukatoko.data.retrofit.ApiInterface;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OngkirActivity extends AppCompatActivity {

    @BindView(R.id.linearSave)
    LinearLayout linearSave;
    @BindView(R.id.linearTrans)
    LinearLayout linearTrans;
    @BindView(R.id.edtDestination)
    EditText edtDestination;

    @OnClick(R.id.btnSave) void clickSave() {       // jika ingin mengubah text/color di button
        linearTrans.setVisibility(View.VISIBLE);    // pake BindView
        linearSave.setVisibility(View.GONE);
    }

    @OnClick(R.id.edtDestination) void clickDestination() {
        startActivity(new Intent(this, CityActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ongkir);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle("Cek Ongkos Kirim");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (!Constant.DESTINATION.equals("")) {
            edtDestination.setText(Constant.DESTINATION_NAME);

            getServices();
        }
    }

    private void getServices() {
        ApiInterface apiInterface = new ApiClient().getClientRajaOngkir(Constant.BASE_URL_RAJAONGKIR_STARTER).create(ApiInterface.class);
        Call<Cost> call = apiInterface.getCost(Constant.KEY_RAJAONGKIR,
                "444",      // toko = tempat drmana asal barang yg punya tokoonline mengirimkan
                Constant.DESTINATION,     // tujuan
                "1000",     // dlm hitungan gram, bisa dicustom dgn edittext.getText().toString()
                "jne");
        call.enqueue(new Callback<Cost>() {
            @Override
            public void onResponse(Call<Cost> call, Response<Cost> response) {
                Cost.RajaOngkir ongkir = response.body().getRajaOngkir();

                List<Cost.RajaOngkir.Results> results = ongkir.getResults();
                for (int i = 0; i < results.size(); i++) {
                    Log.d("_logServiceCode", "onResponse: " + results.get(i).getCode());

                    List<Cost.RajaOngkir.Results.Costs> costs = results.get(i).getCosts();
                    for (int j = 0; j < costs.size(); j++) {
                        Log.d("_logServiceDesc", "onResponse: " + costs.get(j).getDescription());

                        List<Cost.RajaOngkir.Results.Costs.Data> cost = costs.get(j).getCost();
                        for (int k = 0; k < cost.size(); k++) {
                            Log.d("_logServiceCost", "onResponse: " + cost.get(k).getValue());

                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<Cost> call, Throwable t) {

            }
        });
    }
}













