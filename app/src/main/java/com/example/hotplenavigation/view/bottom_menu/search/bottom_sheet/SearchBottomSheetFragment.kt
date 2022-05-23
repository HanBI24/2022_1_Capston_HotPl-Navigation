package com.example.hotplenavigation.view.bottom_menu.search.bottom_sheet

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import coil.load
import coil.request.CachePolicy
import coil.transform.CircleCropTransformation
import com.example.hotplenavigation.R
import com.example.hotplenavigation.databinding.FragmentSearchBottomSheetBinding
import com.example.hotplenavigation.view.bottom_menu.bookmark.webview.WebViewActivity
import com.example.hotplenavigation.view.bottom_menu.search.SearchFragmentViewModel
import com.github.heyalex.bottomdrawer.BottomDrawerFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchBottomSheetFragment : BottomDrawerFragment() {
    private var _binding: FragmentSearchBottomSheetBinding? = null
    private val binding get() = _binding!!
    private val searchFragmentViewModel: SearchFragmentViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBottomSheetBinding.inflate(inflater, container, false)

        initTextView()

        return binding.root
    }

    private fun initTextView() {
        binding.apply {
            when(searchFragmentViewModel.getNumber.value) {
                1 -> {
                    tvTitle.text = searchFragmentViewModel.getDuruData1.value?.get(0)?.response?.body?.items?.item?.themeNm!!
                    tvLineMsg.text = searchFragmentViewModel.getDuruData1.value?.get(0)?.response?.body?.items?.item?.linemsg!!
                    tvDesc.text = removeHtmlTag(searchFragmentViewModel.getDuruData1.value?.get(0)?.response?.body?.items?.item?.themedesc!!)
                }
                2 -> {
                    tvTitle.text = searchFragmentViewModel.getDuruData1.value?.get(1)?.response?.body?.items?.item?.themeNm!!
                    tvLineMsg.text = searchFragmentViewModel.getDuruData1.value?.get(1)?.response?.body?.items?.item?.linemsg!!
                    tvDesc.text = removeHtmlTag(searchFragmentViewModel.getDuruData1.value?.get(1)?.response?.body?.items?.item?.themedesc!!)
                }
                3 -> {
                    tvTitle.text = searchFragmentViewModel.getDuruData1.value?.get(2)?.response?.body?.items?.item?.themeNm!!
                    tvLineMsg.text = searchFragmentViewModel.getDuruData1.value?.get(2)?.response?.body?.items?.item?.linemsg!!
                    tvDesc.text = removeHtmlTag(searchFragmentViewModel.getDuruData1.value?.get(2)?.response?.body?.items?.item?.themedesc!!)
                }
                4 -> {
                    tvTitle.text = searchFragmentViewModel.getDuruData1.value?.get(3)?.response?.body?.items?.item?.themeNm!!
                    tvLineMsg.text = searchFragmentViewModel.getDuruData1.value?.get(3)?.response?.body?.items?.item?.linemsg!!
                    tvDesc.text = removeHtmlTag(searchFragmentViewModel.getDuruData1.value?.get(3)?.response?.body?.items?.item?.themedesc!!)
                }
            }

            ivThumb.load("https://picsum.photos/200/300") {
                crossfade(true)
                placeholder(R.drawable.ic_launcher_foreground)
                transformations(CircleCropTransformation())
                memoryCachePolicy(CachePolicy.DISABLED)
            }

            btnWeb.setOnClickListener {
                val intent = Intent(context, WebViewActivity::class.java)
                intent.putExtra("get_recommend_title", tvTitle.text)
                startActivity(intent)
            }
        }
    }

    private fun removeHtmlTag(desc: String) = desc.replace("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "")
}