package com.devrangokalp.customarrayadapter

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tek_satir.*
import java.lang.reflect.Array

class MainActivity : AppCompatActivity() {
    lateinit var tumBurcBilgileri:ArrayList<Burc>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        veriKaynagiHazirla()


       // var myadapter = BurclarArrayAdapter(this, R.layout.tek_satir,R.id.tv_BurcAdi,burcAdi,burcTarihi,burcResimleri)
       // list_burclar.adapter = myadapter

        var mybaseadapter=BurclarBaseAdapter(this,tumBurcBilgileri)
        list_burclar.adapter=mybaseadapter

        list_burclar.setOnItemClickListener { parent, view, position, id ->
            var intent=Intent(this@MainActivity,DetayActivity::class.java)
            intent.putExtra("position",position)
            intent.putExtra("tumburcbilgileri",tumBurcBilgileri)
            startActivity(intent)

        }

    }
    public fun veriKaynagiHazirla() {

        tumBurcBilgileri=ArrayList<Burc>(12)

        var burcAdi = resources.getStringArray(R.array.BurclarDizisi)
        var burcTarihi = resources.getStringArray(R.array.TarihlerDizisi)
        var burcResimleri = arrayOf(R.drawable.koc1, R.drawable.boga2, R.drawable.ikizler3, R.drawable.yengec4, R.drawable.aslan5,
            R.drawable.basak6, R.drawable.terazi7, R.drawable.akrep8, R.drawable.yay9, R.drawable.oglak10, R.drawable.kova11, R.drawable.balik12
        )
        var burcBuyukResimler= arrayOf(R.drawable.b_koc1,R.drawable.b_boga2,R.drawable.b_ikizler3,R.drawable.b_yengec4,R.drawable.b_aslan5,
            R.drawable.b_basak6,R.drawable.b_terazi7,R.drawable.b_akrep8,R.drawable.b_yay9,R.drawable.b_oglak10,R.drawable.b_kova11,R.drawable.b_balik12)
        var burcGenelOzelikler=resources.getStringArray(R.array.burcGenelOzellikler)

        for (i in  0..11){
            var listeyeEklenecekOankiDeger:Burc= Burc(burcAdi[i],burcTarihi[i],burcResimleri[i],burcBuyukResimler[i],burcGenelOzelikler[i])
            tumBurcBilgileri.add(listeyeEklenecekOankiDeger)
        }
    }
}
