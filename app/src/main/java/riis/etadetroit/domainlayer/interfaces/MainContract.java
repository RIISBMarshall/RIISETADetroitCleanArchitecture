package riis.etadetroit.domainlayer.interfaces;

import android.content.Context;

/**
 * Created by bmarshall on 2/6/17.
 */

public class MainContract {

    public interface MainView {
        void setUpRecyclerView();

        void setUpActionBar();

        void toggle();
    }

    public interface MainPresenter {
        int getCompanyListSize();

        String getCompanyName(int position);

        int getCompanyImageResourceId(Context context, int position);
    }
}
