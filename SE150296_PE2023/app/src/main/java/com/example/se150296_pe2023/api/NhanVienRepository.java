package com.example.se150296_pe2023.api;

public class NhanVienRepository {
    public static NhanVienService getTraineeService(){
        return APIClient.getClient().create(NhanVienService.class);
    }
}
