package com.devrangokalp.customarrayadapter

import android.content.Context
import android.text.method.TextKeyListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.tek_satir.view.*
import java.util.zip.Inflater

class BurclarBaseAdapter(context: Context,tumBurcBilgileri:ArrayList<Burc>) : BaseAdapter() {

    var tumBurclar = ArrayList<Burc>()
    var mycontext: Context

    init {
        this.tumBurclar = tumBurcBilgileri
        this.mycontext = context

 /*       var burcAdlari = mycontext.resources.getStringArray(R.array.BurclarDizisi)
        var burcTarihleri = mycontext.resources.getStringArray(R.array.TarihlerDizisi)
        var burcResimleri = arrayOf(
            R.drawable.koc1,
            R.drawable.boga2,
            R.drawable.ikizler3,
            R.drawable.yengec4,
            R.drawable.aslan5,
            R.drawable.basak6,
            R.drawable.terazi7,
            R.drawable.akrep8,
            R.drawable.yay9,
            R.drawable.oglak10,
            R.drawable.kova11,
            R.drawable.balik12
        )

        for (i in 0..11) {
            var listedeBulunanOAnkiBurc: Burclar = Burclar(burcAdlari[i], burcTarihleri[i], burcResimleri[i])
            tumBurclar.add(listedeBulunanOAnkiBurc)
        }

        */
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        var tek_satir_view=convertView
        var myViewHolder:viewHolder2

            if (tek_satir_view==null){
                var inflater = LayoutInflater.from(mycontext)
                tek_satir_view = inflater.inflate(R.layout.tek_satir, parent, false)
                myViewHolder=viewHolder2(tek_satir_view)
                tek_satir_view.tag=myViewHolder
            }
                else
            {
                myViewHolder=tek_satir_view.getTag() as viewHolder2
            }

        myViewHolder.burcResim.setImageResource(tumBurclar.get(position).burcunSembolu)
        myViewHolder.burcAdi.setText(tumBurclar.get(position).burcunAdi)
        myViewHolder.burcTarihi.setText(tumBurclar.get(position).burcunTarihi)


        return tek_satir_view

    }

    override fun getItem(position: Int): Any {
        return tumBurclar.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return tumBurclar.size
    }

}


class  viewHolder2(tek_satir_view:View)
{
    var burcAdi:TextView
    var burcTarihi:TextView
    var burcResim:ImageView

    init {
        this.burcAdi=tek_satir_view.tv_BurcAdi
        this.burcTarihi=tek_satir_view.tv_BurcTarihi
        this.burcResim=tek_satir_view.imgBurcResimleri
    }

}