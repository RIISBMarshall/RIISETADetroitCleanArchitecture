package riis.etadetroit.domainlayer.interactor;

import android.content.Context;
import android.database.Cursor;

import riis.etadetroit.datalayer.repository.Repository;

public class RoutesInteractor {
    private Context context;

    public RoutesInteractor(Context context){
        this.context = context;
    }

    public Cursor getRoutes(String company){
        Repository repository = new Repository(context);
        return repository.getRoutes(company);
    }
}
