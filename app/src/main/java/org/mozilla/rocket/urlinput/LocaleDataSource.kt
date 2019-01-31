package org.mozilla.rocket.urlinput

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData

import org.mozilla.focus.R

import java.util.ArrayList

class LocaleDataSource : SearchPortalDataSource {

    override fun fetchPortals(): LiveData<List<SearchPortal>> {
        val liveData = MutableLiveData<List<SearchPortal>>()
        // TODO connect real locale data source
        val list = ArrayList<SearchPortal>()
        list.add(SearchPortal("Tokopedia", R.drawable.youtube, "https://www.tokopedia.com/search?st=product&q=%s", "https://www.tokopedia.com"))
        list.add(SearchPortal("Buakalapak", R.drawable.youtube, "https://www.bukalapak.com/products?utf8=%E2%9C%93&source=navbar&from=omnisearch&search_source=omnisearch_organic&search%5Bhashtag%5D=&search%5Bkeywords%5D=%s", "https://www.bukalapak.com"))
        list.add(SearchPortal("Shopee", R.drawable.youtube, "https://shopee.co.id/search?keyword=%s", "https://shopee.co.id"))
        liveData.value = list
        return liveData
    }

    companion object {

        @Volatile private var INSTANCE: LocaleDataSource? = null

        @JvmStatic
        fun getInstance(): LocaleDataSource? =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: LocaleDataSource().also {
                        INSTANCE = it
                    }
                }
    }
}
