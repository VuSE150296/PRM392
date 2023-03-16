package com.example.pe.api;

import com.example.pe.models.Person;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PersonService {
    String PERSON = "person";

    @GET(PERSON)
    Call<ArrayList<Person>> getAllPerson();

    @GET(PERSON + "/{id}")
    Call<Person> getPersonByID(@Path("id") Object id);

    @POST(PERSON)
    Call<Person> createPerson(@Body Person person);

    @PUT(PERSON + "/{id}")
    Call<Person> updatePerson(@Path("id") Object id, @Body Person person);

    @DELETE(PERSON + "/{id}")
    Call<Person> deletePerson(@Path("id") Object id);
}
