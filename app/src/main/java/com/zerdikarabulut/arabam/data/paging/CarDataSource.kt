package com.zerdikarabulut.arabam.data.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.zerdikarabulut.arabam.data.local.dao.CarDAO
import com.zerdikarabulut.arabam.data.mock.Mock
import com.zerdikarabulut.arabam.data.model.CarResponse
import com.zerdikarabulut.arabam.data.network.APIService
import com.zerdikarabulut.arabam.util.State
import com.zerdikarabulut.arabam.util.toEntity
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class CarDataSource @Inject constructor(
    private val apiService: APIService,
    private val carDAO: CarDAO,
    private val compositeDisposable: CompositeDisposable
) : PageKeyedDataSource<Int, CarResponse>() {

    var state: MutableLiveData<State> = MutableLiveData()
    private var retryCompletable: Completable? = null

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, CarResponse>
    ) {
        updateState(State.LOADING)
        compositeDisposable.add(
            apiService.getData(
                0,
                params.requestedLoadSize,
                Mock.advertSort.sortType,
                Mock.advertSort.sortDirections,
                Mock.advertFilter.minYear,
                Mock.advertFilter.maxYear,
                Mock.advertFilter.category,
                Mock.advertFilter.minDate,
                Mock.advertFilter.maxDate
            ).subscribe(
                { response ->
                    updateState(State.SUCCESS)
                    callback.onResult(response, null, 10)
                    response.forEach {
                        carDAO.insert(it.toEntity())
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe()
                    }
                },
                {
                    updateState(State.ERROR)
                    setRetry(Action { loadInitial(params, callback) })
                }
            )
        )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, CarResponse>) {}

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, CarResponse>) {
        updateState(State.LOADING)
        Mock.requestSkip += 10
        compositeDisposable.add(
            apiService.getData(
                Mock.requestSkip,
                params.requestedLoadSize,
                Mock.advertSort.sortType,
                Mock.advertSort.sortDirections,
                Mock.advertFilter.minYear,
                Mock.advertFilter.maxYear,
                Mock.advertFilter.category,
                Mock.advertFilter.minDate,
                Mock.advertFilter.maxDate
            ).subscribe(
                { response ->
                    updateState(State.SUCCESS)
                    callback.onResult(response, Mock.requestSkip + 10)
                    response.forEach {
                        carDAO.insert(it.toEntity())
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe()
                    }
                },
                {
                    updateState(State.ERROR)
                    setRetry(Action { loadAfter(params, callback) })
                }
            )
        )
    }

    fun retry() {
        if (retryCompletable != null) {
            compositeDisposable.add(
                retryCompletable!!
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
            )
        }
    }

    private fun setRetry(action: Action?) {
        retryCompletable = if (action == null) null else Completable.fromAction(action)
    }

    private fun updateState(state: State) {
        this.state.postValue(state)
    }
}