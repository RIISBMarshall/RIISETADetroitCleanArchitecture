package riis.etadetroit.domainlayer.interactor;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.widget.AdapterView;

import riis.etadetroit.datalayer.repository.Repository;
import riis.etadetroit.presentationlayer.view.RouteDetailsActivity;

public class OnClickSetupInteractor {
    private Context context;

    public OnClickSetupInteractor(Context context) {
        this.context = context;
    }

    public AdapterView.OnItemClickListener getRouteListClickListener(final String companyName, final Palette mPalette, final int defaultColor) {
        return new AdapterView.OnItemClickListener() {

            Repository repository = new Repository(context);
            Cursor routeCursor = repository.getRoutes(companyName);

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (routeCursor.moveToPosition(position)) {
                    Intent intent = new Intent(context, RouteDetailsActivity.class);
                    intent.putExtra(RouteDetailsActivity.EXTRA_ROUTE, routeCursor.getString(1));
                    intent.putExtra(RouteDetailsActivity.EXTRA_COLOR, mPalette.getDarkMutedColor(defaultColor));
                    context.startActivity(intent);
                }
            }
        };
    }
}
