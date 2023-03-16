package com.example.se150296_pe2023.api;

import com.example.se150296_pe2023.models.Nhanvien;
import com.example.se150296_pe2023.models.Nhanvien;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface NhanVienService {
    String NHANVIEN = "Nhanvien";

    @GET(NHANVIEN)
    Call<ArrayList<Nhanvien>> getAllNhanVien();

    @GET(NHANVIEN + "/{id}")
    Call<Nhanvien> getNhanVienById(@Path("id") Object id);

    @POST(NHANVIEN)
    Call<Nhanvien> createNhanVien(@Body Nhanvien nhanvien);

    @PUT(NHANVIEN + "/{id}")
    Call<Nhanvien> updateNhanVien(@Path("id") Object id, @Body Nhanvien nhanvien);

    @DELETE(NHANVIEN + "/{id}")
    Call<Nhanvien> deleteNhanVien(@Path("id") Object id);
}
