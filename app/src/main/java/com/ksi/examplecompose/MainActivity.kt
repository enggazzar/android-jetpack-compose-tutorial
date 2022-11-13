package com.ksi.examplecompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity

import androidx.lifecycle.lifecycleScope

import kotlinx.coroutines.*
import java.util.Collections.list
import kotlin.system.measureTimeMillis
/*
function is sequence of execute instruction from here we need thread
***********
what distinguishes coroutines from thread?
1- executed within thread
2- coroutines are suspendable
3-they can switch their context
---------------
coroutine is light wight thread with useful functionality
-----------
assume there instruction tow places you can suspend worker and back to work also you can switch context to work
to second instruction place
-----------------
many coroutine not give out of memory but many thread give
-------------
 */
class MainActivity : ComponentActivity() {
    val Tag = "TestCoroutine"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(Tag, "hello from ")
        // funGloblscope()
        jobJoin()

    }

    fun funGloblscope() {
        //live as long our application does if finish his job will destroyed without waiting app destoryed

        //delay only suspend current coroutine not block all thread but sleep stop all
        //if main thread finish maian all thread canceled
        //delay is suspend function
        //susbend fuon only called from suspend function or inside coroutine function
        GlobalScope.launch {
            delay(3000L)
            Log.e(Tag, "hello from ${Thread.currentThread().name}")
            val ans1 = networkCall()
            val ans2 = networkCall2()
            //in same coroutine delay will added from to function then execute function
            Log.e(Tag, ans1)
            Log.e(Tag, ans2)
        }
        Log.e(Tag, "hello from ${Thread.currentThread().name}")
    }

    suspend fun networkCall(): String {
        delay(1000L)
        return "hello from 1"
    }

    suspend fun networkCall2(): String {
        delay(1000L)
        return "hello from 2"
    }

    /*
    dispatcher according to what should coroutine should do wh choose type
    1- main start coroutine in main thread useful with ui operation  because wh can change ui only from ui thread
    2-IO data operation -read write file or db- network -
    3- default calculation exampl 10000 element
    4- Unconfined will
     */
    fun dispatcher() {
        GlobalScope.launch(Dispatchers.Unconfined) {

        }
    }

    fun funRunCoroutineinSingleThread() {
        GlobalScope.launch(newSingleThreadContext("thread1")) {

        }
    }

    fun changeContext() {
        GlobalScope.launch(Dispatchers.IO) {
            //excuted in io thread
            val ans1 = networkCall()
            //change context to main thread to updtae ui
            withContext(Dispatchers.Main) {
                //now we in main thread we can update ui
            }
        }
    }

    fun runBlock() {
        //will block main thread if you not care about synchronize  used for test
        //only effect main thread
        Log.e(Tag, "before")
        runBlocking {
            Log.e(Tag, "start")
            delay(100L)
        }
        //will print after delay
        Log.e(Tag, "after run block")
    }

    fun jobJoin() {
        val job = GlobalScope.launch {
            repeat(5) {
                Log.e(Tag, "Still working")
                delay(1000L)
            }

        }
        runBlocking {
            job.join()
            //wait until job finished
            Log.e(Tag, "finished")
        }
    }

    fun jobCancel() {
        val job = GlobalScope.launch {
            repeat(5) {
                Log.e(Tag, "Still working")
                delay(1000L)
            }

        }
        runBlocking {
            delay(2000L)
            job.cancel()
            //wait until job finished
            Log.e(Tag, "finished")
        }
    }

    fun jobCancelCheckIsActive() {
        val job = GlobalScope.launch {
            for (i in 30.. 45){
                if(isActive){
                    //do  your function
                }
          //if we have function make calcaluation courotine will busy not lisitn to cancell
                //so we will check is coroutine is active
        }
        }
        runBlocking {
            delay(2000L)
            job.cancel()
            //wait until job finished
            Log.e(Tag, "finished")
        }
    }
    fun jobCancelWithTimeOut() {
        val job = GlobalScope.launch {
            //if function execution not finish before the time coroutine will cancel
            withTimeout(3000L){
                for (i in 30.. 45){

                }
            }

        }

    }
    //async to execute to suspend function in same time
    fun ayncExamaple() {
        val time= measureTimeMillis {
            GlobalScope.launch {
                //return deferred string
                val ans1=async{networkCall()}
                val ans2=async{networkCall2()}
                Log.e(Tag, ans1.await())
                Log.e(Tag, ans2.await())
            }
        }
        Log.e(Tag, "request talk $time")


    }
    fun lifeCycleCoroutine(){
        //work under this activity only
        /*
        implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.5.1'
      implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1"
         */
        lifecycleScope.launch{

        }
    }

}