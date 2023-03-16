package com.example.se150296_pe2023.api;

public class PhongBanRepository {
    public static PhongbanService getPhongBanService(){
        return APIClient.getClient().create(PhongbanService.class);
    }
}
