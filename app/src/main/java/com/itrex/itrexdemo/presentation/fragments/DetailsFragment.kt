package com.itrex.itrexdemo.presentation.fragments

import android.content.Context
import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.itrex.itrexdemo.R
import com.itrex.itrexdemo.logic.presenters.DetailsPresenter
import com.itrex.itrexdemo.presentation.views.DetailsMvpView
import kotlinx.android.synthetic.main.action_bar_layout.*
import kotlinx.android.synthetic.main.fragment_details_layout.*
import java.util.*

class DetailsFragment : BaseFragment<DetailsMvpView, DetailsPresenter>(), DetailsMvpView {

    @InjectPresenter
    lateinit var presenter: DetailsPresenter

    override fun getLayoutId(): Int {
        return R.layout.fragment_details_layout
    }

    override fun initActions() {
        initViews()
        presenter.initData(arguments)
    }

    private fun initViews() {
        setTitle()

        vListBack.setOnClickListener {
            activity?.onBackPressed()
        }

        presenter.loadData(activity as Context)
    }

    /**
     * Title of the screen
     */
    private fun setTitle() {
        vTitle.text = getString(R.string.details)
    }

    override fun setKey(key: String) {
        vTvKeyDetails.text = key
    }

    override fun setValue(value: Float) {
        vTvValueProduct.text = String.format("%.2f", value)
    }

    override fun showFields(resIdString: Int) {
        animate(vDetailsLayout)
        vPrDetails.visibility = View.GONE
        groupDetails.visibility = View.VISIBLE
        vTvDescription.text = getString(resIdString)
    }

    override fun showChartData(
        data: LineData,
        minX: Float,
        maxX: Float
    ) {
        val xAxis = chart1.xAxis
        //X
        xAxis.axisMaximum = maxX
        xAxis.axisMinimum = minX

        // set data
        chart1.data = data
        chart1.invalidate()
    }

    override fun setChartUI(values2: ArrayList<Entry>) {
        val dataSets = ArrayList<LineDataSet>()
        dataSets.add(getSet(values2)) // add the data sets

        // create a data object with the data sets
        val data = LineData(dataSets as List<ILineDataSet>?)
        data.setDrawValues(false)

        showChartData(data, 0f, 20f)
        showFields(R.string.description)
    }

    /**
     * UI settings
     */
    private fun getSet(
        values2: ArrayList<Entry>
    ): LineDataSet {

        val set1 = LineDataSet(values2, activity?.getString(R.string.dataset))

        set1.mode = LineDataSet.Mode.HORIZONTAL_BEZIER

        //border of line (middle)
        set1.color = ContextCompat.getColor(activity!!, R.color.white)

        set1.setDrawCircles(false)
        set1.lineWidth = 2f
        set1.circleRadius = 3f
        set1.fillAlpha = 255
        set1.valueTextColor = ContextCompat.getColor(activity, R.color.white)
        set1.setDrawFilled(true)

        val drawable = ContextCompat.getDrawable(activity, R.drawable.fade_red)
        set1.fillDrawable = drawable

        //above
        set1.highLightColor = Color.rgb(255, 255, 255)

        set1.setDrawCircleHole(false)

        return set1
    }
}