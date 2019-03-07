package com.boss.cuncis.bukatoko.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.boss.cuncis.bukatoko.R;
import com.boss.cuncis.bukatoko.data.model.Product;
import com.boss.cuncis.bukatoko.utils.Converter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {

    private List<Product.Data> products;
    private Context context;

    public ProductAdapter(List<Product.Data> products, Context context) {
        this.products = products;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_main, parent, false);

        return new ProductHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int i) {
        holder.tvName.setText(products.get(i).getProduct());
        holder.tvPrice.setText("IDR " + Converter.rupiah(products.get(i).getPrice()));

        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.img_placeholder2)
                .error(R.drawable.img_placeholder_error)
                .priority(Priority.HIGH);


        Glide.with(context)
                .load(products.get(i).getImage())
                .apply(options)
                .into(holder.imgProduct);

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ProductHolder extends RecyclerView.ViewHolder {
        ImageView imgProduct;
        TextView tvPrice, tvName;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            tvPrice = itemView.findViewById(R.id.tv_price);
            tvName = itemView.findViewById(R.id.tv_name);
            imgProduct = itemView.findViewById(R.id.img_product);
        }
    }

}
