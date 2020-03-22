package com.example.mvvmsearchapp.view

import android.content.Intent
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mvvmsearchapp.MainSearchRecyclerViewAdapter
import com.example.mvvmsearchapp.R
import com.example.mvvmsearchapp.base.BaseKotlinActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.mvvmsearchapp.databinding.ActivityMainBinding
import com.example.mvvmsearchapp.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : BaseKotlinActivity<ActivityMainBinding, MainViewModel>() {

    override val layoutResourceId: Int
        get() = R.layout.activity_main

    override val viewModel: MainViewModel by viewModel()

    private val mainSearchRecyclerViewAdapter : MainSearchRecyclerViewAdapter by inject()

    override fun initStartView() {
        main_activity_search_recycler_view.run {
            adapter = mainSearchRecyclerViewAdapter
            layoutManager = StaggeredGridLayoutManager(3,1).apply {
                gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
                orientation = StaggeredGridLayoutManager.VERTICAL
            }
            setHasFixedSize(true)
        }
    }

    override fun initDataBinding() {
        viewModel.imageSearchResponseLiveData.observe(this , Observer {
            it.documents.forEach{document ->
                mainSearchRecyclerViewAdapter.addImageItem(document.image_url , document.doc_url)
            }
            mainSearchRecyclerViewAdapter.notifyDataSetChanged()
        })
    }

    override fun initAfterBinding() {
        main_activity_search_button.setOnClickListener{
            viewModel.getImageSearch(main_activity_search_text_view.text.toString() , 1 , 80)
        }
    }
}
