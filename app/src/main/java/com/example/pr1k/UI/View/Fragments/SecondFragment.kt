package com.example.pr1k.UI.View.Fragments

import android.Manifest
import android.graphics.BitmapFactory
import android.media.MediaScannerConnection
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.camera.core.ImageCapture
import androidx.fragment.app.Fragment
import com.example.pr1k.databinding.FragmentSecondBinding
import java.io.File
import java.io.FileOutputStream


@Suppress("DEPRECATION")
class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private var imageCapture: ImageCapture? = null
    private val FILENAME = "Date.txt"

    companion object {
        private const val TAG = "CameraXApp"
        private const val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS"
        val REQUIRED_PERMISSIONS =
            mutableListOf(
                Manifest.permission.CAMERA,
                Manifest.permission.RECORD_AUDIO
            ).apply {
                if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P) {
                    add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                }
            }.toTypedArray()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)

        binding.search.setOnClickListener {
            downloadImageAndSetInView(binding.image, binding.urlText.text.toString())

        }

        binding.download.setOnClickListener {
            downloadImageAndSave(binding.urlText.text.toString(), "1.jpg")
        }

        return binding.root
    }


    private fun downloadImageAndSetInView(imageView: ImageView, imageUrl: String) {
        Toast.makeText(
            requireContext(),
            "Please wait, it may take a few minutes...",
            Toast.LENGTH_SHORT
        ).show()

        AsyncTask.execute {
            try {
                val `in` = java.net.URL(imageUrl).openStream()
                val image = BitmapFactory.decodeStream(`in`)
                requireActivity().runOnUiThread {
                    imageView.setImageBitmap(image)
                }
            } catch (e: Exception) {
                Log.e("Error Message", e.message.toString())
                e.printStackTrace()
            }
        }
    }

    private fun downloadImageAndSave(imageUrl: String, fileName: String) {


        // Показать сообщение ожидания
        Toast.makeText(
            requireContext(),
            "Please wait, it may take a few minutes...",
            Toast.LENGTH_SHORT
        ).show()

        AsyncTask.execute {
            try {
                val input = java.net.URL(imageUrl).openStream()
                val outputDir =
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
                val outputFile = File(outputDir, fileName)

                // Создать выходной поток для сохранения изображения
                val outputStream = FileOutputStream(outputFile)

                // Скопировать данные из входного потока в выходной поток
                val buffer = ByteArray(4 * 1024)
                var bytesRead: Int
                while (input.read(buffer).also { bytesRead = it } != -1) {
                    outputStream.write(buffer, 0, bytesRead)
                }

                // Закрыть потоки
                input.close()
                outputStream.close()

                requireActivity().runOnUiThread {
                    // Обновить галерею, чтобы изображение было видно в приложениях для просмотра изображений
                    MediaScannerConnection.scanFile(
                        requireContext(),
                        arrayOf(outputFile.toString()),
                        null,
                        null
                    )

                    // Показать сообщение об успешном сохранении
                    Toast.makeText(
                        requireContext(),
                        "Image saved to ${outputFile.absolutePath}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } catch (e: Exception) {
                Log.e("Error Message", e.message.toString())
                e.printStackTrace()
            }
        }
    }
}

