package org.mozilla.focus.telemetry

import android.content.Context
import android.preference.PreferenceManager

class Stats {

    companion object {
        const val RC_READY_REMOTE_CONFIG_FETCHED = "rc_firebase_fetched"
        const val RC_READY_FIRST_RUN_SHOWN = "rc_first_show"
        const val RC_READY_FIRST_RUN_END = "rc_first_end"
        const val RC_READY_FIRST_SHOW_HOME = "rc_home1_show"
        const val RC_READY_FIRST_SHOW_HOME_MEU = "rc_home2_show"
        const val RC_READY_FIRST_SHOW_BROWSER = "rc_browser1_show"
        const val RC_READY_FIRST_SHOW_BROWSER_MENU = "rc_browser2_show"

        fun collectOnce(context: Context?, key: String, function: () -> Unit) {
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            if (preferences.getBoolean(key, true)) {
                function()
                preferences.edit().putBoolean(key, false).apply()
            }
        }
    }
}
