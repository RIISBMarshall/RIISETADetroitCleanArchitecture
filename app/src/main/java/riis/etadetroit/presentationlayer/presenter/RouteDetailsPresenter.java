package riis.etadetroit.presentationlayer.presenter;

import android.content.Context;
import android.database.Cursor;

import riis.etadetroit.domainlayer.interactor.RouteDetailsInteractor;
import riis.etadetroit.domainlayer.interactor.RouteStopsInteractor;

public class RouteDetailsPresenter {
    private Context context;

    public RouteDetailsPresenter(Context context){
        this.context = context;
    }

    public Cursor getRouteDetails(String route) {
        RouteDetailsInteractor routeDetailsPresenter = new RouteDetailsInteractor(context);
        return routeDetailsPresenter.getRouteDetails(route);
    }

    public Cursor getRouteStops(String route_id) {
        RouteStopsInteractor routeStopsInteractor = new RouteStopsInteractor(context);
        return routeStopsInteractor.getRouteStops(route_id);
    }
}
