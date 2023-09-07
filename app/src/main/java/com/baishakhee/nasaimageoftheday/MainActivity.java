package com.baishakhee.nasaimageoftheday;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.baishakhee.nasaimageoftheday.api.APIClient;
import com.baishakhee.nasaimageoftheday.api.APIInterface;
import com.baishakhee.nasaimageoftheday.databinding.ActivityMainBinding;
import com.baishakhee.nasaimageoftheday.model.MainModelResponse;
import com.baishakhee.nasaimageoftheday.util.Constants;
import com.baishakhee.nasaimageoftheday.util.DateUtils;
import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private APIInterface apiInterface;
    private String uri = "";
    boolean isProgressVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        apiInterface = APIClient.getClient().create(APIInterface.class);
        loadData();
        binding.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
                binding.refreshLayout.setRefreshing(false);
            }
        });
    }

    private void getProgerssStatus() {
        if (isProgressVisible) {

            binding.progressBar.setVisibility(View.GONE);

            isProgressVisible = false;


        } else {

            isProgressVisible = true;

            binding.progressBar.setVisibility(View.VISIBLE);
        }
    }

    private void loadData() {

        getProgerssStatus();
        isProgressVisible = true;

        binding.progressBar.setVisibility(View.VISIBLE);
        Call<MainModelResponse> call = apiInterface.getData(Constants.NASA_API_KEY);

        call.enqueue(new Callback<MainModelResponse>() {
            @Override
            public void onResponse(Call<MainModelResponse> call, Response<MainModelResponse> response) {
                binding.progressBar.setVisibility(View.GONE);
                isProgressVisible = false;

                if (response.isSuccessful()) {
                    MainModelResponse mainModelResponse = response.body();
                    if (mainModelResponse != null) {
                        updateUI(mainModelResponse);
                    }
                } else {
                    // Handle API request failure
                }
            }

            @Override
            public void onFailure(Call<MainModelResponse> call, Throwable t) {
                binding.progressBar.setVisibility(View.GONE);

                // Handle network errors
                Log.e("MainActivity", "Network error: " + t.getMessage());
            }
        });
    }

    private void updateUI(MainModelResponse mainModelResponse) {
        binding.titleTextView.setText(mainModelResponse.getTitle());
        binding.dateTextView.setText(DateUtils.formatDate(mainModelResponse.getDate()));
        binding.descriptionTextView.setText(mainModelResponse.getExplanation());
        uri = mainModelResponse.getUrl();

        if ("image".equals(mainModelResponse.getMediaType())) {
            binding.imageView.setVisibility(View.VISIBLE);
            binding.playImage.setVisibility(View.GONE);
            Glide.with(this).load(mainModelResponse.getUrl()).into(binding.imageView);
        } else if ("video".equals(mainModelResponse.getMediaType())) {
            binding.imageView.setVisibility(View.VISIBLE);
            binding.playImage.setVisibility(View.VISIBLE);
            Glide.with(this).load(R.drawable.nasaimage).error(R.drawable.nasaimage).into(binding.imageView);

            uri = mainModelResponse.getUrl();
            binding.playImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getApplicationContext(),WebViewVedioActivity.class);
                    intent.putExtra("vedioUrl",uri);
                    startActivity(intent);
                }
            });

        } else {
            binding.imageView.setVisibility(View.VISIBLE);
            Glide.with(this).load(R.drawable.nasaimage).error(R.drawable.nasaimage).into(binding.imageView);

            binding.playImage.setVisibility(View.GONE);

        }
    }


}
