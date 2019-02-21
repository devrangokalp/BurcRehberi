package com.devrangokalp.customarrayadapter

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.graphics.Palette
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detay.*

class DetayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        var position=intent.extras.get("position") as Int
        var tumburcbilgileri=intent.extras.get("tumburcbilgileri") as ArrayList<Burc>

        tv_burcOzellikleri.setText(tumburcbilgileri.get(position).burcgenelOzelikleri)
        img_detayburc.setImageResource(tumburcbilgileri.get(position).burcbuyukresim)

        setSupportActionBar(anim_toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        collapsing_toolbar.title=tumburcbilgileri.get(position).burcunAdi


        var bitmap=BitmapFactory.decodeResource(resources,tumburcbilgileri.get(position).burcbuyukresim)
        Palette.from(bitmap).generate(object :Palette.PaletteAsyncListener {
            override fun onGenerated(palette: Palette) {

            var color=palette.getDarkVibrantColor(R.attr.colorAccent)
                collapsing_toolbar.setContentScrimColor(color)
                window.statusBarColor=color
            }


        })

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
