package com.devrangokalp.customarrayadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.tek_satir.view.*

class BurclarArrayAdapter(
    var gelencontext: Context?,
    resource: Int,
    textViewResourceId: Int,
    var burcAdlari: Array<String>,
    var burcTarihleri: Array<String>,
    var burcResimleri: Array<Int>
) :
    ArrayAdapter<String>(gelencontext, resource, textViewResourceId, burcAdlari) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        var tek_satir_view=convertView
        var viewHolder:ViewHolder?=null

        if (tek_satir_view==null) {

            var inflater = LayoutInflater.from(gelencontext)
            tek_satir_view = inflater.inflate(R.layout.tek_satir, parent, false)

            viewHolder= ViewHolder(tek_satir_view)
            tek_satir_view.tag=viewHolder
        }
        else
        {
            viewHolder=tek_satir_view.getTag() as ViewHolder
        }


       /* var burcImageView = tek_satir_view.imgBurcResimleri
        var burcTarih = tek_satir_view.tv_BurcTarihi
        var burcAdi = tek_satir_view.tv_BurcAdi
*/
        viewHolder.burcResim.setImageResource(burcResimleri[position])
        viewHolder.BurcAd.setText(burcAdlari[position])
        viewHolder.BurcTarih.setText(burcTarihleri[position])

        return tek_satir_view

    }

}

class ViewHolder(tek_satir_view: View) {
    var burcResim:ImageView
    var BurcAd :TextView
    var BurcTarih :TextView

    init {
        this.burcResim=tek_satir_view.imgBurcResimleri
        this.BurcAd=tek_satir_view.tv_BurcAdi
        this.BurcTarih=tek_satir_view.tv_BurcTarihi
    }

}
