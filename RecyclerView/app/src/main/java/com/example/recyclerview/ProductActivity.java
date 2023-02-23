package com.example.recyclerview;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.Adapter.ProductAdapter;
import com.example.recyclerview.Models.Product;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {

    private ArrayList<Product> productList;
    private RecyclerView rvProduct;
    private ProductAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        productList = new ArrayList<>();

        rvProduct = (RecyclerView) findViewById(R.id.recyclerViewUser);
        rvProduct.setHasFixedSize(true);
        rvProduct.setLayoutManager(new GridLayoutManager(this, 1));

        adapter = new ProductAdapter(productList);
        rvProduct.setAdapter(adapter);

        addProduct();
    }

    private void addProduct() {
        productList.add(new Product(R.drawable.shopping,"Shopping","Shopping cart","Available"));
        productList.add(new Product(R.drawable.pharmacy,"Pharmacy","Pharmacy","Available"));
        productList.add(new Product(R.drawable.gift1,"Gift","Gift cart","Not Available"));
        productList.add(new Product(R.drawable.shose,"Shoe","Shoe","Available"));
        productList.add(new Product(R.drawable.shopping,"Shopping","Shopping cart","Available"));
        productList.add(new Product(R.drawable.pharmacy,"Pharmacy","Pharmacy","Available"));
        productList.add(new Product(R.drawable.gift1,"Gift","Gift cart","Not Available"));
        productList.add(new Product(R.drawable.shose,"Shoe","Shoe","Available"));

    }
}
