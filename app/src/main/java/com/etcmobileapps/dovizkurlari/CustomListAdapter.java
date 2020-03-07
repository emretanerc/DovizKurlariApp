package com.etcmobileapps.dovizkurlari;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class CustomListAdapter extends ArrayAdapter<Repo> {

    private final LayoutInflater inflater;
    private final Context context;
    private ViewHolder holder;
    private final ArrayList<Repo> depremler;



    public CustomListAdapter(Context context, List<Repo> depremler) {
        super(context,0, depremler);
        this.context = context;
        this.depremler = (ArrayList<Repo>) depremler;
        inflater = LayoutInflater.from(context);


    }

    @Override
    public int getCount() {
        return depremler.size();
    }

    @Override
    public Repo getItem(int position) {
        return depremler.get(position);
    }

    @Override
    public long getItemId(int position) {
        return depremler.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.row_layout, null);

            holder = new ViewHolder();

            holder.dolarTv = (TextView) convertView.findViewById(R.id.dolarTV);
            holder.euroTv = (TextView) convertView.findViewById(R.id.euroTV);
            holder.sterlinTv = (TextView) convertView.findViewById(R.id.sterlinTV);
            holder.yenTv = (TextView) convertView.findViewById(R.id.yenTV);
            holder.frangTv = (TextView) convertView.findViewById(R.id.frangTV);
            holder.avusturalyaTv = (TextView) convertView.findViewById(R.id.avusturalyaTV);
            holder.canadaTv = (TextView) convertView.findViewById(R.id.kanadaTv);
            convertView.setTag(holder);

        }
        else{

            holder = (ViewHolder)convertView.getTag();
        }

        Repo value = depremler.get(position);
        if(value != null){


          //  holder.depremBuyukluk.setText(value.buyukluk);

            // 1 dolar kaç euro
            double guncelEuro = value.result.rates.eUR;
            //1 dolar kaç sterlin
            double guncelSterlin = value.result.rates.gBP;
            // 1 dolar kaç tl
            double guncelDolar = value.result.rates.tRY;
            // 1 japon yeni
            double guncelYen = value.result.rates.jPY;
            // 1 frang
             double guncelFrang = value.result.rates.cHF;
            // 1 kanada doları
            double guncelCanada = value.result.rates.cAD;
            // 1 avusturalya doları
            double guncelAvusturalya = value.result.rates.aUD;



            holder.dolarTv.setText(value.result.rates.tRY.toString());

            // Api bize TL'dışındaki para birimlerini dolar olarak gösteriyor bu yüzden işlem yapmamız gerek.
            // örneğin 1 dolar 7 TL, fakat 1 dolar 0,89 euro gibi bu yüzden 0,89 'u güncel TL değeriyle bölüyorum.

            String  sonucEuro = String.valueOf(guncelDolar / guncelEuro);
            sonucEuro = sonucEuro.substring(0,7); // Değer çok uzun olduğu için substring ile ilk 7 haneyi alıyoruz.
            holder.euroTv.setText(sonucEuro);
            String  sonucSterlin = String.valueOf(guncelDolar / guncelSterlin);
            sonucSterlin = sonucSterlin.substring(0,7);
            holder.sterlinTv.setText(sonucSterlin);
            String  sonucYen = String.valueOf(guncelDolar / guncelYen);
            sonucYen = sonucYen.substring(0,7);
            holder.yenTv.setText(sonucYen);
            String  frangSonuc = String.valueOf(guncelDolar / guncelFrang);
            frangSonuc = frangSonuc.substring(0,7);
            holder.frangTv.setText(frangSonuc);

            String  canadaSonuc = String.valueOf(guncelDolar / guncelCanada);
            canadaSonuc = canadaSonuc.substring(0,7);
            holder.canadaTv.setText(canadaSonuc);

            String  avusturalyaSonuc = String.valueOf(guncelDolar / guncelAvusturalya);
            avusturalyaSonuc = avusturalyaSonuc.substring(0,7);
            holder.avusturalyaTv.setText(avusturalyaSonuc);



        }
        return convertView;




    }


    //View Holder Pattern for better performance
    private static class ViewHolder {
        TextView dolarTv;
        TextView euroTv;
        TextView sterlinTv;
        TextView yenTv;
        TextView avusturalyaTv;
        TextView frangTv;
        TextView canadaTv;
    }



}