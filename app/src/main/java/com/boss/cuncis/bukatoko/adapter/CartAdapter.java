package com.boss.cuncis.bukatoko.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.boss.cuncis.bukatoko.R;
import com.boss.cuncis.bukatoko.data.model.Cart;
import com.boss.cuncis.bukatoko.utils.Converter;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartHolder> {

    private List<Cart> cartList;
    private Context context;

    public CartAdapter(List<Cart> cartList, Context context) {
        this.cartList = cartList;
        this.context = context;
    }

    @NonNull
    @Override
    public CartHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cart, parent, false);
        return new CartHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartHolder holder, int position) {
//        holder.tvName.setText(cartList.get(position).getProduct());
        Cart cart = cartList.get(position);
        cart.setQty(1);
        cart.setTotal(cart.getTotal());

        holder.tvName.setText(cart.getProduct());
        holder.tvPrice.setText(Converter.rupiah(cart.getPrice()));
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    class CartHolder extends RecyclerView.ViewHolder {
        ImageView imgProduct;
        TextView tvName, tvPrice;
        ImageButton btnDelete;

        public CartHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.img_product);
            tvName = itemView.findViewById(R.id.tv_name);
            tvPrice = itemView.findViewById(R.id.tv_price);
            btnDelete = itemView.findViewById(R.id.btn_delete);
        }
    }

}
