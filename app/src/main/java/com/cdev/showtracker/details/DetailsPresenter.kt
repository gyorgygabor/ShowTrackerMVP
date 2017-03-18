package com.cdev.showtracker.details

import com.cdev.showtracker.data.TvShowRepository
import com.cdev.showtracker.model.TvShow
import com.cdev.showtracker.model.TvShowVideo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

/**
 * Created by abraham on 3/12/2017.
 */
class DetailsPresenter @Inject constructor(private var repository: TvShowRepository) : DetailsContract.Presenter {

    private var view: DetailsContract.View? = null
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun attachView(view: DetailsContract.View) {
        this.view = view

    }

    override fun loadDetails(id: Int) {

        compositeDisposable.add(repository.getTvShowDetails(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<TvShow>() {
                    override fun onError(e: Throwable?) {
                        view?.showError(e?.message)
                    }

                    override fun onSuccess(value: TvShow?) {
                        value?.let { view?.showDetails(it) }
                    }
                }))
    }

    override fun loadTvShowVideo(id: Int) {

        compositeDisposable.add(repository.getTvShowVideos(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<TvShowVideo>() {
                    override fun onError(e: Throwable?) {
                        // do nothing
                    }

                    override fun onSuccess(value: TvShowVideo?) {
                        // TODO check crash
                        value?.result?.filter { it.type.equals("Trailer", ignoreCase = true) }?.first()?.let { view?.showVideo(it) }
                    }
                }))
    }

    override fun detachView() {
        view = null
        compositeDisposable.clear()
    }
}