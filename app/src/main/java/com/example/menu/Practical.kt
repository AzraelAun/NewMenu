package com.example.menu


import android.content.ClipData
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.view.*
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.menu.databinding.FragmentPracticalBinding
import kotlinx.android.synthetic.main.fragment_practical.*


/**
 * A simple [Fragment] subclass.
 */
class Practical : Fragment() {

    internal val initialCountDown: Long = 30000
    internal val countDownInterval: Long = 1000

    lateinit var thisView : ImageView

    data class Game(
        val bin: Int,
        val garbage: List<Int>)

    private val game: MutableList<Game> = mutableListOf(
        Game(bin = R.id.bin1,
            garbage = listOf(R.drawable.bandaid, R.drawable.chemical, R.drawable.cigarette,R.drawable.hairgel,
                R.drawable.injection,R.drawable.lightbulb, R.drawable.medicalglove,R.drawable.nailpolish,
                R.drawable.paint,R.drawable.battery,R.drawable.insecticide,R.drawable.makeup,R.drawable.thermometer)),
        Game(bin = R.id.bin2,
            garbage = listOf(R.drawable.apple,R.drawable.bread,R.drawable.cake,R.drawable.chilli,R.drawable.chocolate,
                R.drawable.corn,R.drawable.crab,R.drawable.dryleaf,R.drawable.eggshell,R.drawable.fishbone,R.drawable.shrimp,
                R.drawable.strawberry,R.drawable.tomatosauce,R.drawable.vegetable,R.drawable.watermelon)),
        Game(bin = R.id.bin3,
            garbage = listOf(R.drawable.basketball,R.drawable.bathtub,R.drawable.broom,R.drawable.chopstick,R.drawable.flowerpot,
                R.drawable.peanut,R.drawable.rooftiles,R.drawable.toiletbowl,R.drawable.toiletpaper,R.drawable.seashell,R.drawable.sponge,
                R.drawable.woodencomb)),
        Game(bin = R.id.bin4,
            garbage = listOf(R.drawable.cap,R.drawable.cloths,R.drawable.lockpad,R.drawable.cup,R.drawable.glassbottle,R.drawable.handbag,
                R.drawable.milkbox,R.drawable.mirror,R.drawable.plasticbottle,R.drawable.plasticcomb,R.drawable.shoe,R.drawable.tin,
                R.drawable.toys,R.drawable.toothpaste,R.drawable.safetypin))
    )

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var count : Int = 0
        val binding = DataBindingUtil.inflate<FragmentPracticalBinding>(inflater,
            R.layout.fragment_practical,container,false)

        val dragableImage : List<ImageView> = listOf(binding.garbage1, binding.garbage2,
            binding.garbage3, binding.garbage4, binding.garbage5, binding.garbage6, binding.garbage7, binding.garbage8)

        val dropTarget : List<View> = listOf(binding.bin1, binding.bin2,
            binding.bin3, binding.bin4)

        val listener = View.OnTouchListener(function = { view, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_MOVE) {
                view.y = motionEvent.rawY - view.height
                view.x = motionEvent.rawX - view.width/2
            }
            true
        })


        object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val timeLeft = millisUntilFinished / 1000
                timer_text.text = getString(R.string.timeLeft, timeLeft)
            }

            override fun onFinish() {
                gameFinished()
            }
        }.start()

       for(dropItem in dropTarget) {
                    dropItem.setOnDragListener{ v, event ->
                        // TODO Auto-generated method stub
                            for(garbage in game) {
                                for(item in garbage.garbage) {
                                    when (event.action) {
                                        DragEvent.ACTION_DRAG_STARTED -> {
                                        }

                                        DragEvent.ACTION_DRAG_EXITED -> {
                                        }

                                        DragEvent.ACTION_DRAG_ENTERED -> {
                                        }

                                        DragEvent.ACTION_DROP -> {

                                            if (v.id == garbage.bin && thisView.drawable.constantState == resources.getDrawable(item,null).constantState){
                                                if(count == 8) {
                                                   gameFinished()
                                                }
                                                else {
                                                    thisView.visibility = View.INVISIBLE
                                                    count++
                                                }
                                            }
                                        }
                                        DragEvent.ACTION_DRAG_ENDED -> {

                                        }
                                    }
                                }
                            }

                        true
                    }
       }

        for(item in dragableImage) {
            item.setOnTouchListener(listener)
            item.setOnTouchListener { v, arg1 ->

                // TODO Auto-generated method stub
                val data = ClipData.newPlainText("", "")
                val shadow = View.DragShadowBuilder(item)
                thisView = item
                v.startDragAndDrop(data, shadow, null, 0)
                false
            }
        }
        return binding.root
    }

    private fun gameFinished(){
        Toast.makeText(activity, "Practical has just finished", Toast.LENGTH_SHORT).show()
        val action = PracticalDirections.actionPracticalToCompletePractical()
        NavHostFragment.findNavController(this).navigate(action)
    }







}
