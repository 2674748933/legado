package io.legado.app.data.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "rssSources", indices = [(Index(value = ["sourceUrl"], unique = false))])
data class RssSource(
    @PrimaryKey
    var sourceUrl: String = "",
    var sourceName: String = "",
    var sourceIcon: String = "",
    var sourceGroup: String? = null,
    var enabled: Boolean = true,
    //列表规则
    var ruleArticles: String? = null,
    var ruleNextPage: String? = null,
    var ruleTitle: String? = null,
    var rulePubDate: String? = null,
    //webView规则
    var ruleDescription: String? = null,
    var ruleImage: String? = null,
    var ruleLink: String? = null,
    var ruleContent: String? = null,
    var enableJs: Boolean = false,
    var loadWithBaseUrl: Boolean = false,
    var customOrder: Int = 0
) : Parcelable {

    fun equal(source: RssSource): Boolean {
        return equal(sourceUrl, source.sourceUrl)
                && equal(sourceIcon, source.sourceIcon)
                && enabled == source.enabled
                && equal(sourceGroup, source.sourceGroup)
                && equal(ruleArticles, source.ruleArticles)
                && equal(ruleNextPage, source.ruleNextPage)
                && equal(ruleTitle, source.ruleTitle)
                && equal(rulePubDate, source.rulePubDate)
                && equal(ruleDescription, source.ruleDescription)
                && equal(ruleLink, source.ruleLink)
                && equal(ruleContent, source.ruleContent)
                && enableJs == source.enableJs
                && loadWithBaseUrl == source.loadWithBaseUrl
    }

    private fun equal(a: String?, b: String?): Boolean {
        return a == b || (a.isNullOrEmpty() && b.isNullOrEmpty())
    }

}