package com.example.YUmarket.screen.home.homemain


import android.content.Context
import android.graphics.Typeface
import android.os.Looper
import android.os.Looper.*
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import com.example.YUmarket.util.provider.ResoucesProvider
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.YUmarket.R
import com.example.YUmarket.databinding.FragmentHomeMainBinding
import com.example.YUmarket.model.homelist.HomeItemModel
import com.example.YUmarket.model.homelist.SuggestItemModel
import com.example.YUmarket.model.homelist.TownMarketModel
import com.example.YUmarket.model.homelist.category.HomeListCategory
import com.example.YUmarket.screen.MainActivity
import com.example.YUmarket.screen.MainState
import com.example.YUmarket.screen.MainViewModel
import com.example.YUmarket.screen.base.BaseFragment
import com.example.YUmarket.widget.adapter.ModelRecyclerAdapter
import com.example.YUmarket.widget.adapter.listener.home.HomeItemListener
import com.example.YUmarket.widget.adapter.listener.home.SuggestListener
import com.example.YUmarket.widget.adapter.listener.home.TownMarketListener
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.logging.Handler


class HomeMainFragment
    : BaseFragment<FragmentHomeMainBinding>(),
    AdapterView.OnItemSelectedListener {


    private val viewModel by viewModel<HomeMainViewModel>()
    private val activityViewModel by sharedViewModel<MainViewModel>()

    private val resourcesProvider by inject<ResoucesProvider>()

    override fun getViewBinding(): FragmentHomeMainBinding =
        FragmentHomeMainBinding.inflate(layoutInflater)

    // Spinner에 사용될 HomeListCategory List
    // drop(1)을 하여 동네마켓 항목은 제외
    private val categories = HomeListCategory.values().drop(1)




    override fun observeData() = with(viewModel) {
        // marketData가 변경되면 update
        marketData.observe(viewLifecycleOwner) {
            when (it) {
                // TODO 22.01.19 add more state handle logics

                is HomeMainState.Uninitialized -> {

                }

                is HomeMainState.Loading -> {

                }

                is HomeMainState.Success<*> -> {
                    nearbyMarketAdapter.submitList(it.modelList)

                }

                is HomeMainState.Error -> {
                    Toast.makeText(
                        context,
                        R.string.cannot_load_data,
                        Toast.LENGTH_SHORT
                    ).show()
                }

                else -> Unit
            }
        }

//        itemData.observe(viewLifecycleOwner) {
//            when (it) {
//                // TODO 22.01.25 add more state handle logics
//                is HomeMainState.Uninitialized -> {
//
//                }
//
//                is HomeMainState.Loading -> {
//
//                }
//
//                is HomeMainState.ListLoaded -> with(binding.newSaleItemSpinner) {
//                    viewModel.setItemFilter(categories[selectedItemPosition])
//                }
//
//                is HomeMainState.Success<*> -> {
//                    newSaleItemsAdapter.submitList(it.modelList)
//                }
//
//                is HomeMainState.Error -> {
//                    Toast.makeText(
//                        context,
//                        R.string.cannot_load_data,
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//            }
//        }
        suggestData.observe(viewLifecycleOwner){
            when(it){
                // TODO 22.01.25 add more state handle logics
                is HomeMainState.Uninitialized -> {

                }

                is HomeMainState.Loading -> {

                }

                is HomeMainState.ListLoaded -> {

                }

                is HomeMainState.Success<*> -> {
                   suggestAdapter.submitList(it.modelList)
                }

                is HomeMainState.Error -> {
                    Toast.makeText(
                        context,
                        R.string.cannot_load_data,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
        seasonData.observe(viewLifecycleOwner){
            when(it){
                // TODO 22.01.25 add more state handle logics
                is HomeMainState.Uninitialized -> {

                }

                is HomeMainState.Loading -> {

                }

                is HomeMainState.ListLoaded -> {

                }

                is HomeMainState.Success<*> -> {
                    seasonAdapter.submitList(it.modelList)
                }

                is HomeMainState.Error -> {
                    Toast.makeText(
                        context,
                        R.string.cannot_load_data,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        // 위치 정보를 불러오고 fetchData
        activityViewModel.locationData.observe(viewLifecycleOwner) {
            // get list after get location
            if (it is MainState.Success) {
                viewModel.fetchData()
            }
        }
    }

    private val nearbyMarketAdapter by lazy {
        ModelRecyclerAdapter<TownMarketModel, HomeMainViewModel>(
            listOf(),
            viewModel,
            resourcesProvider,
            object : TownMarketListener {
                // RecyclerView의 Item을 클릭할때
                override fun onClickItem(model: TownMarketModel) {
                    // TODO 22.01.18 start detail market activity when clicked
                    Toast.makeText(context, model.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        )
    }

//    private val newSaleItemsAdapter by lazy {
//        ModelRecyclerAdapter<HomeItemModel, HomeMainViewModel>(
//            listOf(),
//            viewModel,
//            resourcesProvider,
//            object : HomeItemListener {
//                override fun onClickItem(model: HomeItemModel) {
//                    // TODO 22.01.25 start detail market activity when clicked
//                    Toast.makeText(context, model.toString(), Toast.LENGTH_SHORT).show()
//                }
//            }
//        )
//    }

    private val suggestAdapter by lazy {
        ModelRecyclerAdapter<SuggestItemModel, HomeMainViewModel>(
            listOf(),
            viewModel,
            resourcesProvider,
            object : SuggestListener {
                override fun onClickItem(model: SuggestItemModel) {
                    // TODO 22.01.25 start detail market activity when clicked
                    Toast.makeText(context, model.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        )
    }

    private val seasonAdapter by lazy{
        ModelRecyclerAdapter<SuggestItemModel,HomeMainViewModel>(
            listOf(),
            viewModel,
            resourcesProvider,
            object : SuggestListener {
                override fun onClickItem(model: SuggestItemModel) {
                    // TODO 22.01.25 start detail market activity when clicked
                    Toast.makeText(context, model.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        )
    }

    // 광고 viewPager
//    var currentPosition = 0;
//
//    val handler = android.os.Handler(getMainLooper()){
//        setPage()
//        true
//    }
//
//    inner class PagerRunnable : Runnable {
//        override fun run() {
//            while (true) {
//                Thread.sleep(3000)
//                handler.sendEmptyMessage(0)
//
//
//            }
//        }
//    }

//    private fun setPage() = with(binding) {
//        if (currentPosition == 5) currentPosition = 0
//        pager.setCurrentItem(currentPosition, true)
//        currentPosition += 1
//    }

    override fun initViews() {

        super.initViews()


        // Spinner의 Adapter에 사용할 List
        // 마켓의 업종을 나타내는 String
//        val adapterList = categories.map {
//            getString(it.categoryNameId)
//        }

        with(binding) {

            searchView.isSubmitButtonEnabled = true
            // 광고 auto slide
//            val adapter = ViewPagerAdapter()
//            pager.adapter = adapter
//
//            val thread = Thread(PagerRunnable())
//            thread.start()

           val spannable = SpannableStringBuilder(popular.text)
            spannable.setSpan(
                StyleSpan(Typeface.BOLD),
              10,
                13,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )

            popular.text = spannable
            // 근처 마켓 RecyclerView 설정
            nearbyMarketRecyclerView.adapter = nearbyMarketAdapter

            // 인기있는 취미
            popularRecycler.adapter = suggestAdapter

            popularRecycler.layoutManager = GridLayoutManager(
                requireContext(),
                1,
                GridLayoutManager.HORIZONTAL,
                false
            )

            // 계절별 인기있는

            seasonRecycler.adapter = seasonAdapter

            seasonRecycler.layoutManager = GridLayoutManager(
                requireContext(),
                1,
                GridLayoutManager.HORIZONTAL,
                false
            )

            // 한줄에 2개씩 띄우도록 설정(spanCount)
            nearbyMarketRecyclerView.layoutManager = GridLayoutManager(
                requireContext(),
                1,
                GridLayoutManager.HORIZONTAL,
                false
            )

            // 더보기를 누르면 마켓을 List로 띄워주는 Fragment로 이동
            showMoreTextView.setOnClickListener {
                findNavController().navigate(
                    HomeMainFragmentDirections.actionHomeMainFragmentToMap()
                )

            }

//            newSaleItemRecyclerView.adapter = newSaleItemsAdapter
//            newSaleItemRecyclerView.addItemDecoration(
//                DividerItemDecoration(
//                    context, LinearLayoutManager.HORIZONTAL
//                )
//            )




        }

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        TODO("Not yet implemented")
    }


//    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) =
//        viewModel.setItemFilter(categories[position])


    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    private fun backStack() {
        view?.let { it1 ->
            Navigation.findNavController(it1).popBackStack()
        }

    }
}

//검색 뒤로가기 할때 쓰임
//override fun onBackPressed() {
//    if (!home_search_searchView.isIconified) {
//        home_search_searchView.isIconified = true
//    } else {
//        super.onBackPressed()
//    }
//}