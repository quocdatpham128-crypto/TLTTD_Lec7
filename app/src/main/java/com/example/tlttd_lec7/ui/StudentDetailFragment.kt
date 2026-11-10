package com.example.tlttd_lec7.ui // Chú ý package theo dự án của bạn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.example.tlttd_lec7.databinding.FragmentStudentDetailBinding

class StudentDetailFragment : Fragment() {
    private var _binding: FragmentStudentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Lắng nghe kết quả ngay trong onCreate() để sẵn sàng đón dữ liệu
        setFragmentResultListener("STUDENT_KEY") { _, bundle ->
            val id = bundle.getInt("ID")
            val name = bundle.getString("NAME")
            val className = bundle.getString("CLASS")
            val gpa = bundle.getDouble("GPA")

            binding.tvStudentDetail.text = """
                Mã số SV: $id
                Họ và tên: $name
                Lớp: $className
                Điểm GPA tích lũy: $gpa
            """.trimIndent()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, c: ViewGroup?, b: Bundle?): View {
        _binding = FragmentStudentDetailBinding.inflate(inflater, c, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // BẮT BUỘC: Giải phóng ViewBinding
    }
}