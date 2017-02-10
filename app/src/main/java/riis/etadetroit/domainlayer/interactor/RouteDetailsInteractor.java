package riis.etadetroit.domainlayer.interactor;

import android.content.Context;
import android.database.Cursor;

import riis.etadetroit.datalayer.repository.Repository;

public class RouteDetailsInteractor {
    private Context context;

    public RouteDetailsInteractor(Context context){
        this.context = context;
    }

    public Cursor getRouteDetails(String route){
        Repository repository = new Repository(context);
        return repository.getRouteDetails(route);
    }
}
