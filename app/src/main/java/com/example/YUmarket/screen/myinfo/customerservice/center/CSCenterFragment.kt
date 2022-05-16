package com.example.YUmarket.screen.myinfo.customerservice.center

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import com.example.YUmarket.R
import com.example.YUmarket.databinding.FragmentCsCenterBinding
import com.example.YUmarket.screen.base.BaseFragment
import com.example.YUmarket.screen.myinfo.Method
import com.example.YUmarket.screen.myinfo.customerservice.list.CSCategory

/**
 * @author HeeTae Heo(main),
 * Geonwoo Kim, Doyeop Kim, Namjin Jeong, Eunho Bae (sub)
 * @since
 * @throws
 * @description
 */

class CSCenterFragment : BaseFragment<FragmentCsCenterBinding>() {


    override fun getViewBinding(): FragmentCsCenterBinding =
        FragmentCsCenterBinding.inflate(layoutInflater)

    override fun observeData() {}

    override fun initViews() = with(binding) {
        super.initViews()


        binding.questionCenter.setOnClickListener {
            view?.let { it1 ->
                Navigation.findNavController(it1)
                    .navigate(CSCenterFragmentDirections.actionCSCenterFragmentToCSFragment())
            }

        }

        binding.centerNumber.setOnClickListener {
            permissionCheck_CallYU()
        }

        binding.pollution.setOnClickListener {
            permissionCheck_food()
        }

        binding.emailCenter.setOnClickListener {
            view?.let { it1 ->
                Navigation.findNavController(it1)
                    .navigate(R.id.action_CSCenterFragment_to_emailFragment)
            }
        }

        binding.back.setOnClickListener {
            backMove()

        }
    }


    private fun Marketcall() {
        val myuri = Uri.parse("tel:00011112222")
        var intent = Intent(Intent.ACTION_CALL, myuri)
        startActivity(intent)
    }

    private fun foodcall() {
        val myuri = Uri.parse("tel:1399")
        var intent = Intent(Intent.ACTION_CALL, myuri)
        startActivity(intent)
    }

    private fun callYU() {
        val items = "000-1111-2222"
        val alertDialog = AlertDialog.Builder(context)
            .setTitle("YU Market")
            .setMessage(items)
            .setPositiveButton("통화 걸기",
                DialogInterface.OnClickListener { dialog, id ->
                    Marketcall()
                })
            .setNegativeButton("통화 취소",
                DialogInterface.OnClickListener { dialog, id ->
                    Toast.makeText(context, "통화를 취소했습니다.", Toast.LENGTH_SHORT).show()
                })
            .show()

    }

    private fun foodSafecall() {
        val items = "1399"
        val alertDialog = AlertDialog.Builder(context)
            .setTitle("불량식품 신고")
            .setMessage(items)
            .setPositiveButton("통화 걸기",
                DialogInterface.OnClickListener { dialog, id ->
                    foodcall()
                })
            .setNegativeButton("통화 취소",
                DialogInterface.OnClickListener { dialog, id ->
                    Toast.makeText(context, "통화를 취소했습니다.", Toast.LENGTH_SHORT).show()
                })
            .show()

    }


    private fun permissionCheck_CallYU() {
        val callCheck =
            android.Manifest.permission.CALL_PHONE
        val permission =
            ContextCompat
                .checkSelfPermission(
                    binding.centerNumber.context,
                    android.Manifest.permission.CALL_PHONE
                )
        if (permission == PackageManager.PERMISSION_GRANTED) {
            callYU()
        } else {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(android.Manifest.permission.CALL_PHONE), 0
            )
            Toast.makeText(context, "권한에 동의되었습니다. 다시 버튼을 눌러주새요", Toast.LENGTH_SHORT).show()
        }

    }

    private fun permissionCheck_food() {
        val callCheck =
            android.Manifest.permission.CALL_PHONE
        val permission =
            ContextCompat
                .checkSelfPermission(
                    binding.centerNumber.context,
                    android.Manifest.permission.CALL_PHONE
                )
        if (permission == PackageManager.PERMISSION_GRANTED) {
            foodSafecall()
        } else {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(android.Manifest.permission.CALL_PHONE), 0
            )
            Toast.makeText(context, "권한에 동의되었습니다. 다시 버튼을 눌러주새요", Toast.LENGTH_SHORT).show()
        }

    }


    private fun backMove() {
        view?.let { it1 ->
            Navigation.findNavController(it1)
                .navigate(R.id.action_CSCenterFragment_to_myInfoFragment)
        }
        backStack()

    }

    companion object {
        const val TAG = "CSCenterFragment"

        fun newInstance(): CSCenterFragment {
            return CSCenterFragment().apply {

            }
        }
    }

    private fun backStack() {
        view?.let { it1 ->
            Navigation.findNavController(it1).popBackStack()
        }
    }


}


