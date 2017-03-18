package com.cdev.showtracker.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View.VISIBLE
import com.cdev.showtracker.BaseApplication
import com.cdev.showtracker.R
import com.cdev.showtracker.model.ResultDetails
import com.cdev.showtracker.model.TvShow
import com.cdev.showtracker.util.loadUrl
import com.cdev.showtracker.util.snack
import kotlinx.android.synthetic.main.activity_details.*
import javax.inject.Inject

class DetailsActivity : AppCompatActivity(), DetailsContract.View {

    companion object {
        val KEY_TV_SHOW_ID: String = "tvShowId"
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
        presenter.loadDetails(intent.getIntExtra(KEY_TV_SHOW_ID, -1))
        presenter.loadTvShowVideo(intent.getIntExtra(KEY_TV_SHOW_ID, -1))

    }

    override fun showDetails(tvShow: TvShow) {
        backDropImageView.loadUrl(tvShow.backdropPath)
        mainToolbar.title = tvShow.name
        descriptionTextView.text = tvShow.overview
    }

    override fun showError(error: String?) {
        rootView.snack(error ?: getString(R.string.error_something_went_wrong))
    }


    override fun showVideo(tvShowVideoDetails: ResultDetails) {
        playImageView.visibility = VISIBLE
        backDropImageView.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + tvShowVideoDetails.key)))
        }
    }

    override fun onStop() {
        super.onStop()
        presenter.detachView()
    }
}


