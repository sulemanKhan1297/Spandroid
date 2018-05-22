package spandroid.dev.base.kotlin

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.app.Activity
import android.support.annotation.Nullable
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import spandroid.dev.R
import spandroid.dev.base.java.BaseFragment
import spandroid.dev.base.java.base_adapter.UsersAdapter
import spandroid.dev.base.java.base_adapter.model.UserModelForAdapter
import spandroid.dev.common.FragmentUtil
import spandroid.dev.kotlin.base.BaseKotlinFragment


class HomeKotlinFragment : BaseKotlinFragment() {

    var toolbarTitle: String = "";

    val listUser = ArrayList<UserModelForAdapter>()

    companion object {
        val TAG: String = "HomeKotlinFragment"
        fun newInstance(param1: String): HomeKotlinFragment {
            val fragment = HomeKotlinFragment()
            val args = Bundle()
            args.putString("title", param1)
            fragment.arguments = args
            return fragment
        }
    }

    override fun initializeResources() {
    }

    override fun setListeners() {
    }

    override fun getToolBarTitle(): String {
        return toolbarTitle
    }

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //mPresenter = new ProductDetailPresenterImpl(this);
        setHasOptionsMenu(true)

        if (arguments != null && arguments!!.containsKey("title")) {
            toolbarTitle = arguments!!.getString("title")
        }
    }

    @Nullable
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var fragmentView:View = inflater.inflate(R.layout.fragment_common, container, false)

        var recyclerviewCommon: RecyclerView = fragmentView.findViewById(R.id.recyclerviewCommon)


        // setLayout(R.layout.fragment_common)

        for ( i in 1..20){
            listUser.add(UserModelForAdapter("name ${i}", "https://homepages.cae.wisc.edu/~ece533/images/monarch.png", ""))
        }

        var adapter = UsersAdapter(activity)
        //  adapter.setListener(this);
        recyclerviewCommon.setAdapter(adapter);
        recyclerviewCommon.setLayoutManager( LinearLayoutManager(getActivity()));

        adapter.items = listUser



        return fragmentView
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(@Nullable savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    fun setEmptyView(text: String) {
        hideProgress()
    }
}
