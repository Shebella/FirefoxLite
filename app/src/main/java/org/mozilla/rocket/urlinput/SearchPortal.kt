package org.mozilla.rocket.urlinput

data class SearchPortal(var name: String, var iconResId: Int, var searchUrlPattern: String, var homeUrl: String) {

    override fun toString(): String {
        return "SearchPortal{" +
                "name='" + name + '\'' +
                ", iconResId=" + iconResId +
                ", searchUrlPattern='" + searchUrlPattern + '\'' +
                ", homeUrl='" + homeUrl + '\'' +
                '}'
    }
}
