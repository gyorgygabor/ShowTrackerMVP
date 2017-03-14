package com.cdev.showtracker.details

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.cdev.showtracker.BaseApplication
import com.cdev.showtracker.R
import com.cdev.showtracker.model.TvShow
import com.cdev.showtracker.model.TvShowVideo
import com.cdev.showtracker.util.loadUrl
import com.cdev.showtracker.util.snack
import kotlinx.android.synthetic.main.activity_details.*
import javax.inject.Inject

class DetailsActivity : AppCompatActivity(), DetailsContract.View {

    companion object{
        val TV_SHOW_ID_KEY :String = "tvShowId"
    }

    @Inject
    lateinit var presenter: DetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        DaggerDetailsComponent.builder()
                .tvShowRepositoryComponent(BaseApplication.tvShowRepositoryComponent)
                .detailsPresenterModule(DetailsPresenterModule()).build()
                .inject(this)

        presenter.attachView(this)
        presenter.loadDetails(intent.getIntExtra(TV_SHOW_ID_KEY, -1))

    }

    override fun showDetails(tvShow: TvShow) {
        backDropImageView.loadUrl(tvShow.backdropPath)
        mainToolbar.title = tvShow.name
        descriptionTextView.text = tvShow.overview
    }

    override fun showError(error: String?) {
        rootView.snack(error ?: getString(R.string.error_something_went_wrong))
    }

    override fun showVideo(tvShowVideo: TvShowVideo) {

       backDropImageView.setOnClickListener{}
    }

}
