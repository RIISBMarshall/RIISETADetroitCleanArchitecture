package riis.etadetroit.domainlayer.interactor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import riis.etadetroit.R;
import riis.etadetroit.presentationlayer.view.CompanyDetailsActivity;
import riis.etadetroit.presentationlayer.view.RouteDetailsActivity;

public class CallNextViewInteractor {

    private Context context;

    public CallNextViewInteractor(Context context) {
        this.context = context;
    }

    public void callNextView(View v, int position, Context mainActivityContext) {
        CompanyNameInteractor companyNameInteractor = new CompanyNameInteractor(context);
        if (companyNameInteractor.getCompanyName(position).equals(context.getString(R.string.people_mover))) {
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
