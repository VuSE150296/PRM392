package com.example.se150296_pe2023.api;

import com.example.se150296_pe2023.models.Phongban;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PhongbanService {
    String PHONGBAN = "Phongban";

    @GET(PHONGBAN)
    Call<ArrayList<Phongban>> getAllPhongBan();

    @GET(PHONGBAN + "/{id}")
    Call<Phongban> getPhongBanById(@Path("id") Object id);

    @POST(PHONGBAN)
    Call<Phongban> createPhongBan(@Body Phongban phongban);

    @PUT(PHONGBAN + "/{id}")
    Call<Phongban> updatePhongBan(@Path("id") Object id, @Body Phongban phongban);

    @DELETE(PHONGBAN + "/{id}")
    Call<Phongban> deletePhongBan(@Path("id") Object id);
}
