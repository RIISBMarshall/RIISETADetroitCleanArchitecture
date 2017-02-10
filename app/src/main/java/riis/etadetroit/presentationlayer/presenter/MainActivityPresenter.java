package riis.etadetroit.presentationlayer.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import riis.etadetroit.domainlayer.interactor.CompanyImageIDInteractor;
import riis.etadetroit.domainlayer.interactor.CompanyListSizeInteractor;
import riis.etadetroit.domainlayer.interactor.CompanyNameInteractor;
import riis.etadetroit.presentationlayer.view.CompanyDetailsActivity;
import riis.etadetroit.presentationlayer.view.RouteDetailsActivity;
import riis.etadetroit.R;


public class MainActivityPresenter {

    private Context context;

    public MainActivityPresenter(Context context) {
        this.context = context;
    }

    public int getCompanyListSize() {
        CompanyListSizeInteractor companyListSizeInteractor = new CompanyListSizeInteractor(context);
        return companyListSizeInteractor.getCompanyListSize();
    }

    public String getCompanyName(int position) {
        CompanyNameInteractor companyNameInteractor = new CompanyNameInteractor(context);
        return companyNameInteractor.getCompanyName(position);
    }

    public int getCompanyImageResourceId(int position) {
        CompanyImageIDInteractor companyImageIDInteractor = new CompanyImageIDInteractor(context);
        return companyImageIDInteractor.getCompanyImageResourceId(position);
    }

    public void callNextView(View v, int position, Context mainActivityContext) {
        if (getCompanyName(position).equals(context.getString(R.string.people_mover))) {
            Intent intent = new Intent(context, RouteDetailsActivity.class);
            intent.putExtra(RouteDetailsActivity.EXTRA_ROUTE, context.getString(R.string.people_mover));
            context.startActivity(intent);
        } else {
            Intent intent = new Intent(context, CompanyDetailsActivity.class);
            intent.putExtra(CompanyDetailsActivity.EXTRA_PARAM_ID, position);
            ImageView busImage = (ImageView) v.findViewById(R.id.busImage);
            LinearLayout busNameHolder = (LinearLayout) v.findViewById(R.id.busNameHolder);


            Pair<View, String> imagePair = Pair.create((View) busImage, "tImage");
            Pair<View, String> holderPair = Pair.create((View) busNameHolder, "tNameHolder");

            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mainActivityContext, imagePair, holderPair);
            ActivityCompat.startActivity((Activity) mainActivityContext, intent, options.toBundle());
        }
    }
}
