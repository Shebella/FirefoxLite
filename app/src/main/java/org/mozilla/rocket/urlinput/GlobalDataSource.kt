package org.mozilla.rocket.urlinput

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData

import org.mozilla.focus.R

import java.util.ArrayList

class GlobalDataSource : SearchPortalDataSource {

    override fun fetchPortals(): LiveData<List<SearchPortal>> {
        val liveData = MutableLiveData<List<SearchPortal>>()
        // TODO connect real global data source
        val list = ArrayList<SearchPortal>()
        list.add(SearchPortal("Facebook", R.drawable.youtube, "https://www.facebook.com/search/str/%s/keywords_search", "https://www.facebook.com"))
        list.add(SearchPortal("YouTube", R.drawable.youtube, "https://www.youtube.com/results?search_query=%s", "https://www.youtube.com"))
        list.add(SearchPortal("Instagram", R.drawable.youtube, "https://www.instagram.com/explore/tags/%s/", "https://www.instagram.com"))
        liveData.value = list

        return liveData
    }

    companion object {

        @Volatile private var INSTANCE: GlobalDataSource? = null

        @JvmStatic
        fun getInstance(): GlobalDataSource? =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: GlobalDataSource().also {
                        INSTANCE = it
                    }
                }
    }
}
