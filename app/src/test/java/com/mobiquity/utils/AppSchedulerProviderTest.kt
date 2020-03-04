package com.mobiquity.utils

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.TestScheduler
import org.junit.Test

import org.junit.Assert.*

/**
 * Created by Mahdi Zare Tahghigh Doost on 3/4/2020.
 * SnappQ
 * mahdiZTD@gmail.com
 */
class AppSchedulerProviderTest(var testScheduler: TestScheduler):SchedulersProvider {

    override fun computation(): Scheduler {
        return testScheduler
    }

    override fun io(): Scheduler {
        return testScheduler
    }

    override fun ui(): Scheduler {
        return testScheduler
    }

}