package com.example.pe.api;

public class PersonRepository {
    public static PersonService getPersonService() {
        return APIClient.getClient().create(PersonService.class);
    }
}
