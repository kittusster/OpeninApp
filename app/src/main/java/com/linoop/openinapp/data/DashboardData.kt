package com.linoop.openinapp.data


import com.google.gson.annotations.SerializedName

data class DashboardData(
    @SerializedName("applied_campaign")
    val appliedCampaign: Int?,
    @SerializedName("data")
    val data: Data?,
    @SerializedName("extra_income")
    val extraIncome: Double?,
    @SerializedName("links_created_today")
    val linksCreatedToday: Int?,
    @SerializedName("message")
    val message: String,
    @SerializedName("startTime")
    val startTime: String?,
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("statusCode")
    val statusCode: Int?,
    @SerializedName("support_whatsapp_number")
    val supportWhatsappNumber: String?,
    @SerializedName("today_clicks")
    val todayClicks: Int?,
    @SerializedName("top_location")
    val topLocation: String?,
    @SerializedName("top_source")
    val topSource: String?,
    @SerializedName("total_clicks")
    val totalClicks: Int?,
    @SerializedName("total_links")
    val totalLinks: Int?
) {
    data class Data(
        @SerializedName("overall_url_chart")
        val overallUrlChart: OverallUrlChart,
        @SerializedName("recent_links")
        val recentLinks: List<RecentLink>,
        @SerializedName("top_links")
        val topLinks: List<TopLink>
    ) {
        data class OverallUrlChart(
            @SerializedName("2023-04-27")
            val x20230427: Int,
            @SerializedName("2023-04-28")
            val x20230428: Int,
            @SerializedName("2023-04-29")
            val x20230429: Int,
            @SerializedName("2023-04-30")
            val x20230430: Int,
            @SerializedName("2023-05-01")
            val x20230501: Int,
            @SerializedName("2023-05-02")
            val x20230502: Int,
            @SerializedName("2023-05-03")
            val x20230503: Int,
            @SerializedName("2023-05-04")
            val x20230504: Int,
            @SerializedName("2023-05-05")
            val x20230505: Int,
            @SerializedName("2023-05-06")
            val x20230506: Int,
            @SerializedName("2023-05-07")
            val x20230507: Int,
            @SerializedName("2023-05-08")
            val x20230508: Int,
            @SerializedName("2023-05-09")
            val x20230509: Int,
            @SerializedName("2023-05-10")
            val x20230510: Int,
            @SerializedName("2023-05-11")
            val x20230511: Int,
            @SerializedName("2023-05-12")
            val x20230512: Int,
            @SerializedName("2023-05-13")
            val x20230513: Int,
            @SerializedName("2023-05-14")
            val x20230514: Int,
            @SerializedName("2023-05-15")
            val x20230515: Int,
            @SerializedName("2023-05-16")
            val x20230516: Int,
            @SerializedName("2023-05-17")
            val x20230517: Int,
            @SerializedName("2023-05-18")
            val x20230518: Int,
            @SerializedName("2023-05-19")
            val x20230519: Int,
            @SerializedName("2023-05-20")
            val x20230520: Int,
            @SerializedName("2023-05-21")
            val x20230521: Int,
            @SerializedName("2023-05-22")
            val x20230522: Int,
            @SerializedName("2023-05-23")
            val x20230523: Int,
            @SerializedName("2023-05-24")
            val x20230524: Int,
            @SerializedName("2023-05-25")
            val x20230525: Int,
            @SerializedName("2023-05-26")
            val x20230526: Int,
            @SerializedName("2023-05-27")
            val x20230527: Int
        )

        data class RecentLink(
            @SerializedName("app")
            val app: String,
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("domain_id")
            val domainId: String,
            @SerializedName("original_image")
            val originalImage: String,
            @SerializedName("smart_link")
            val smartLink: String,
            @SerializedName("thumbnail")
            val thumbnail: Any,
            @SerializedName("times_ago")
            val timesAgo: String,
            @SerializedName("title")
            val title: String,
            @SerializedName("total_clicks")
            val totalClicks: Int,
            @SerializedName("url_id")
            val urlId: Int,
            @SerializedName("url_prefix")
            val urlPrefix: Any,
            @SerializedName("url_suffix")
            val urlSuffix: String,
            @SerializedName("web_link")
            val webLink: String
        )

        data class TopLink(
            @SerializedName("app")
            val app: String,
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("domain_id")
            val domainId: String,
            @SerializedName("original_image")
            val originalImage: String,
            @SerializedName("smart_link")
            val smartLink: String,
            @SerializedName("thumbnail")
            val thumbnail: Any,
            @SerializedName("times_ago")
            val timesAgo: String,
            @SerializedName("title")
            val title: String,
            @SerializedName("total_clicks")
            val totalClicks: Int,
            @SerializedName("url_id")
            val urlId: Int,
            @SerializedName("url_prefix")
            val urlPrefix: String,
            @SerializedName("url_suffix")
            val urlSuffix: String,
            @SerializedName("web_link")
            val webLink: String
        )
    }
}