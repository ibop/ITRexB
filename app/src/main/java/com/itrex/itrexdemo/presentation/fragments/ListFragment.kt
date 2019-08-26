package com.itrex.itrexdemo.presentation.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.itrex.itrexdemo.R
import com.itrex.itrexdemo.data.PriceModel
import com.itrex.itrexdemo.logic.adapters.PriceAdapter
import com.itrex.itrexdemo.logic.presenters.DetailsPresenter
import com.itrex.itrexdemo.logic.presenters.ListPresenter
import com.itrex.itrexdemo.presentation.views.ListMvpView
import kotlinx.android.synthetic.main.action_bar_layout.*
import kotlinx.android.synthetic.main.fragment_list_layout.*
import java.util.*

/**
 * Class to show list of data
 */
class ListFragment : BaseFragment<ListMvpView, ListPresenter>(), ListMvpView {

    @InjectPresenter
    lateinit var presenter: ListPresenter

    override fun getLayoutId(): Int {
        return R.layout.fragment_list_layout
    }

    override fun initActions() {
        initViews()
    }

    private fun initViews() {
        presenter.initList()
        vListBack.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    override fun showListData(listData: ArrayList<PriceModel>) {
        vRvPrices.layoutManager = LinearLayoutManager(activity)
        vRvPrices.adapter = PriceAdapter(listData, View.OnClickListener {

            val bundle = Bundle()
            bundle.putParcelable(DetailsPresenter.ITEM, it.tag as PriceModel)
            openFragment(DetailsFragment::class.java, bundle)
        })
    }
}
